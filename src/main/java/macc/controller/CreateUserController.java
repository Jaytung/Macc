package macc.controller;

import macc.entity.User;
import macc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

@Controller
@RequestMapping("/macc")
public class CreateUserController {
    @Autowired
    private UserService userService;

    @GetMapping("/home/createUser")
    public String getcreateUserPage(Model model, HttpSession session) {

        User loggedInUser = (User) session.getAttribute("loggedInUser");
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/create")
    @Transactional
    public String createUser(@ModelAttribute("user") User user, Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (userService.getUserId(user.getUserid())) {
            model.addAttribute("errorCreate", "帳號已被註冊");
            return "createUser";
        } else {
            String encryptedPasswd = encrypt(user.getPassword());
            user.setPassword(encryptedPasswd);
            userService.saveUser(user);

        }
        return "redirect:/macc/home/showUser";
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
