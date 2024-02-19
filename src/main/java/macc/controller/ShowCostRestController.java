package macc.controller;

import macc.entity.User;
import macc.service.BillingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/macc")
public class ShowCostRestController {
	@Autowired	
	private BillingDataService billingDataService;
	
	@GetMapping("/home/showCost")
	public ModelAndView getAllUsersData(Model model, HttpSession session ,User user) {
		List<Object[]> billingDatas = new ArrayList<Object[]>();
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if ("ADMIN".equals(loggedInUser.getRole())) {
			billingDatas = billingDataService.getMonthlyCostDataGrouped();
		}else {
			billingDatas = billingDataService.getMonthlyCostDataGroupedForSubscription(loggedInUser.getUserid());
			
		}
//        model.addAttribute("users",billingDatas);	
		ModelAndView modelAndView = new ModelAndView("showCost");
		modelAndView.addObject("users", billingDatas);
		return modelAndView;
	}
	
	@GetMapping("/homeByUser/showCost")
	public ModelAndView getAllUsersData2(Model model, HttpSession session ,User user) {
		List<Object[]> billingDatas = new ArrayList<Object[]>();
		User loggedInUser = (User) session.getAttribute("loggedInUser"); 
		if ("ADMIN".equals(loggedInUser.getRole())) {
			billingDatas = billingDataService.getMonthlyCostDataGrouped();
		}else {
			billingDatas = billingDataService.getMonthlyCostDataGroupedForSubscription(loggedInUser.getUserid());
			
		}
//        model.addAttribute("users",billingDatas);
		ModelAndView modelAndView = new ModelAndView("showCost");
		modelAndView.addObject("users", billingDatas);
		return modelAndView;
	}
	
	@GetMapping("/getCoatDataByDate")
    @ResponseBody
    public List<Object[]> handleAjaxRequest(
        @RequestParam("month") String month,
        HttpSession session ,User user
    ) {
    	
    	List<Object[]> billingDatas = new ArrayList<Object[]>();
    	User loggedInUser = (User) session.getAttribute("loggedInUser"); 
    	if ("ADMIN".equals(loggedInUser.getRole())) {
    		if(month.equals("13")) { 
    			billingDatas = billingDataService.getMonthlyCostDataGrouped();
	        } else {
	        	billingDatas = billingDataService.getMonthlyCostDataGroupedByDate(month);
	        
	        }
		}else {
			
			if(month.equals("13")) {
				billingDatas = billingDataService.getMonthlyCostDataGroupedForSubscription(loggedInUser.getUserid());
	        } else {
	        	billingDatas = billingDataService.getMonthlyCostDataGroupedByDateForSubscription(month,loggedInUser.getUserid());
	        
	        }
			
		}
		return billingDatas;
        
    }
	

	
	
}
