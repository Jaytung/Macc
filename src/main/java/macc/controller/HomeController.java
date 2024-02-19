package macc.controller;

import macc.entity.User;
import macc.service.BillingDataService;
import macc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

@Controller
@RequestMapping("/macc")
public class HomeController {

    private UserService userService;
    private BillingDataService billingDataService;

    @Autowired
    public HomeController(UserService userService, BillingDataService billingDataService) {
        super();
        this.userService = userService;
        this.billingDataService = billingDataService;
    }

    @GetMapping("/homeByUser/{userid}")
    public String getHomeByUserPage(@PathVariable String userid, Model model, HttpSession session) {

        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/macc/login"; // 重定向到登入畫面
        }
        User users = userService.getUserById(userid);
        if (users != null) {

            if ("ADMIN".equals(loggedInUser.getRole())) {
                return "home";
            }
            model.addAttribute("users", users);
            return "homeByUser";
        } else {
            return "404";
        }

    }

    @GetMapping("/home/{userid}")
    public String getHomePage(@PathVariable String userid, Model model, HttpSession session) {
        // System.out.println(userid);
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/macc/login"; // 重定向到登入畫面
        }
        User users = userService.getUserById(loggedInUser.getUserid());

        if (users != null) {
            boolean isFirstLogin = users.getFirstlogin() == 1;
            model.addAttribute("users", users);

            if ("ADMIN".equals(loggedInUser.getRole())) {
                return "home";
            }

            model.addAttribute("users", users);
            return "home";
        } else {
            return "404";
        }

    }

    @PostMapping("/updateUserPasswd")
    @ResponseBody
    @Transactional
    public String updateUserPasswd(@RequestParam("userId") String userId, @RequestParam("password") String newPassword,
                                   HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        User findUser = userService.getUserById(userId);

        String encryptedInputPasswd = encrypt(newPassword);
        if (encryptedInputPasswd.equals(findUser.getPassword())) {

            return "same";
        } else {
            findUser.setFirstlogin(1);
            findUser.setPassword(encryptedInputPasswd);
            userService.updateUserLogin(findUser);

        }

        return "success";

    }


    private static final String AES_SECRET_KEY = "1234567890987654";

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
