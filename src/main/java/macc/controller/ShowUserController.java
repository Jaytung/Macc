package macc.controller;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import macc.entity.User;
import macc.service.BillingDataService;
import macc.service.UserService;

@Controller
@RequestMapping("/macc")
public class ShowUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BillingDataService billingDataService;

    @PostMapping("/update")
    @ResponseBody
    @Transactional
    public String updateUser(@RequestParam("userId") String userId, @RequestParam("password") String newPassword,
                             @RequestParam("email") String newEmail, @RequestParam("role") String newRole,
                             HttpSession session) {

        User user = userService.getUserById(userId);
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        // 更新使用者数据
        String encryptedPasswd = encrypt(newPassword);
        user.setPassword(encryptedPasswd);
        user.setEmail(newEmail);
        user.setRole(newRole);

        return "redirect:/macc/home/showUser/" + loggedInUser.getUserid();
    }

    @PostMapping("/delete")
    @ResponseBody
    @Transactional
    public String deleteUser(@RequestParam("userId") String userId, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        billingDataService.deleteUserProject(userId);
        userService.deleteUser(userId);
//		billingDataService.deleteUserProjectsByUserId(userId);

        return "redirect:/macc/home/showUser/" + loggedInUser.getUserid();
    }

    @PostMapping("/saveSelectedProjects")
    @ResponseBody
    @Transactional
    public String saveSelectedProjects(@RequestBody Map<String, Object> requestData) {
        String userId = (String) requestData.get("userId");
        List<Map<String, Object>> selectedProjects = (List<Map<String, Object>>) requestData.get("selectedProjects");

        if (userId != null) {
            for (Map<String, Object> projectData : selectedProjects) {
                String projectName = (String) projectData.get("projectName");
                int connectionStatus = (int) projectData.get("connectionStatus");
//                System.out.println(userId + "," + projectName + "," + connectionStatus);
                billingDataService.updateUserProjectsByUserId(userId, projectName, connectionStatus);
            }

            return "保存成功！";
        } else {
            return "无效的用户ID";
        }
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
