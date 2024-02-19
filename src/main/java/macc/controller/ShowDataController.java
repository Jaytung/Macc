package macc.controller;

import macc.service.BillingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/macc")
public class ShowDataController {
	@Autowired
	private BillingDataService billingDataService;
	
	@PostMapping("/deleteData")
	@ResponseBody
	@Transactional
	public String deleteData(@RequestParam("Id") Long Id, HttpSession session) {
//		System.out.println(Id);
		billingDataService.deleteUserProjectsByUserId(Id);
		return "redirect:/macc/home/showData" ;
	}
	
	
}
