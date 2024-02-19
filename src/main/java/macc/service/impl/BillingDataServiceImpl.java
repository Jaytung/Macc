package macc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import macc.dao.BillingDataRepository;
import macc.entity.Billingdata;
import macc.entity.User;
import macc.service.BillingDataService;
@Service
public class BillingDataServiceImpl implements BillingDataService{

	private BillingDataRepository billingDataRepository;
	
	@Autowired
    public BillingDataServiceImpl( BillingDataRepository billingDataRepository) {

        this.billingDataRepository = billingDataRepository;
    }
    
	@Override
	public List<Billingdata> getAllBillingData() {
		return  billingDataRepository.findAllBillingData();
	}
	
	@Override
	public List<Object[]> getMonthlyCostDataGrouped() {
        return billingDataRepository.getMonthlyCostDataGrouped();
	}
	
	@Override
	public List<Object[]> getMonthlyCostDataGroupedByDate(String Month) {
        return billingDataRepository.getMonthlyCostDataGroupedByDate(Month);
    }
	
	@Override
	public List<Object[]> getMonthlyCostDataGroupedForSubscription(String subscriptionName) {
		return  billingDataRepository.getMonthlyCostDataGroupedBySubscriptionForUser(subscriptionName);
	}

	@Override
	public List<Object[]> getDistinctSubscriptionIdAndNameByUserId(String userid) {
		
		return billingDataRepository.findDistinctSubscriptionIdAndNameByUserId(userid);
	}

	@Override
	public void updateUserProjectsByUserId(String userid, String subscriptionId, int connectionStatus) {
		if(connectionStatus == 1) {
			
			billingDataRepository.insertUserProjectByUserId(userid,subscriptionId);
		
		}
		else {
			billingDataRepository.deleteUserProjectByUserId(userid,subscriptionId);
		}
	}

	@Override
	public void deleteUserProject(String userId) {
		billingDataRepository.deleteUserProjectsById(userId);
	}

	@Override
	public List<Billingdata> getBillingDataById(Long id) {
		return  billingDataRepository.findBillingDataById(id);
	}


	@Override
	public void deleteUserProjectsByUserId(Long id) {
		billingDataRepository.deletebillingDataById(id);
	}

	@Override
	public List<Object[]> getMonthlyCostDataGroupedByDateForSubscription(String Month, String userid) {
		return  billingDataRepository.getMonthlyCostDataGroupedByDateForSubscription(Month,userid);
	}

	@Override
	public List<Billingdata> getCostDataByDetails(String frequency, String month, String pricingModel,
			String subscriptionName) {
			
		return billingDataRepository.findCostDataByDetails(frequency,month,pricingModel,subscriptionName);
	}

	

	

	
}
