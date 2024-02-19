package macc.controller;

import macc.entity.User;
import macc.service.BillingDataService;
import macc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/macc")
public class ShowUserRestController {

	@Autowired
	private UserService userService;
	@Autowired
	private BillingDataService billingDataService;
	
	@GetMapping("/home/showUser")
	public ModelAndView getHomePage( Model model, HttpSession session) {

		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if ("ADMIN".equals(loggedInUser.getRole())) {
			List<User> users = userService.getAllUsers();
			ModelAndView modelAndView = new ModelAndView("showUser");
			modelAndView.addObject("users", users);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("403");
			return modelAndView;
		}
		
		
	}
	
	@GetMapping("/getUserModal")
    @ResponseBody
    public User getUserModal(@RequestParam("userId") String userId) {

        User user = userService.getUserById(userId);
        return user;
        
    }
	
	@GetMapping("/getProjectList")
    @ResponseBody
    public List<Object[]> getProjectList(@RequestParam("userId") String userId) {

		List<Object[]> billingDatas = billingDataService.getDistinctSubscriptionIdAndNameByUserId(userId);

		return billingDatas;
    }
	
	
	
}
