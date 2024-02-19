package macc.controller;

import macc.entity.Billingdata;
import macc.service.BillingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/macc")
public class ShowCostController {

    @Autowired
    private BillingDataService billingDataService;

    @GetMapping("/showDataDetails")
    public String handlePostRequest(@RequestParam("frequency") String frequency, @RequestParam("month") String month, @RequestParam("pricingModel") String pricingModel, @RequestParam("subscriptionName") String subscriptionName, Model model) {


        List<Billingdata> billingDatas = billingDataService.getCostDataByDetails(frequency, month, pricingModel, subscriptionName);

        model.addAttribute("users", billingDatas);
        //System.out.println(billingDatas);
        // Return the view name for the details page (e.g., "showDataDetails")
        return "showDataDetails";
    }


}
