package macc.controller;

import macc.entity.Billingdata;
import macc.entity.User;
import macc.service.BillingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
@RestController
@RequestMapping("/macc")
public class ShowDataRestController {
	
	@Autowired
	private BillingDataService billingDataService;
	
	
	@GetMapping("/home/showData")
	public ModelAndView getAllUsers(Model model,HttpSession session ) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if ("ADMIN".equals(loggedInUser.getRole())) {
			List<Billingdata> billingDatas = billingDataService.getAllBillingData();
//	        model.addAttribute("users",billingDatas);
			ModelAndView modelAndView = new ModelAndView("showData");
			modelAndView.addObject("users", billingDatas);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("403");
			return modelAndView;
		}
		
	}
	
	
//	表單編輯
	@GetMapping("/getDataModal")
	@ResponseBody
	public List<Billingdata> getDataModal(@RequestParam Long userId, Model model, HttpSession session) {

		List<Billingdata> billingDatas = billingDataService.getBillingDataById(userId);
		return billingDatas;
	}
	
	
//	
//	
//	
//	@PostMapping("/updateDataModel")
//	@ResponseBody
//	@Transactional
//    public ResponseEntity<String> updateDataModel(@RequestParam Map<String, Object> newData) {
//		//System.out.print(newData);
//		for (Entry<String, Object> entry : newData.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            System.out.println("Key: " + key + ", Value: " + value);
//        }
////		billingDataService.updateEntityFields(newData);	
//
//        return ResponseEntity.ok().build();
//    }
	
	
	
}
