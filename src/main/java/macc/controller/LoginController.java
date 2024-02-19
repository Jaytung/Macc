package macc.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import macc.entity.User;
import macc.service.BillingDataService;
import macc.service.UserService;
import java.security.Key;

@Controller
@RequestMapping("/macc")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private BillingDataService billingDataService;

	private static final String AES_SECRET_KEY = "1234567890987654";

	@GetMapping("/login")
	public String getLoginPage(Model model) {
		
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
		
		User findUser = userService.getUserById(user.getUserid());
//		System.out.println("session" + findUser.getRole());
		// System.out.println("findUser:" +findUser);
		// System.out.println("passwd: "+user.getPassword());
		if (findUser != null) {
			String encryptedInputPasswd = encrypt(user.getPassword()); // 對使用者輸入的密碼進行加密
			// System.out.println("encryptedInputPasswd: "+encryptedInputPasswd);
			if (encryptedInputPasswd.equals(findUser.getPassword())) {
//	    String redirectUrl = userService.handleRole(findUser, session);
//	    System.out.println("redirectUrl:"+redirectUrl);
//	             return redirectUrl;
				session.setAttribute("loggedInUser", findUser); // 将用户保存到会话中
				if ("ADMIN".equals(findUser.getRole())) {
					return "redirect:/macc/home/" + findUser.getUserid();
				} else {
					return "redirect:/macc/homeByUser/" + findUser.getUserid();
				}
				//return "redirect:/macc/home/" + findUser.getUserid();
			} else {
				model.addAttribute("errorMessage", "帳號或密碼錯誤");
				return "login";
			}
		} else {
			model.addAttribute("errorMessage", "帳號或密碼為空");
			return "login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
	    // 清除session数据
	    session.invalidate();
	    // 提供成功註銷的消息
	    model.addAttribute("logoutMessage", "您已成功注销");
	    // 重定向到登路頁或應用主頁
	    return "redirect:/macc/login";
	}

	private String encrypt(String data) {
		try {
			Key key = new SecretKeySpec(AES_SECRET_KEY.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
			return Base64.getEncoder().encodeToString(encryptedBytes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
