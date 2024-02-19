package macc.service;

import macc.entity.Billingdata;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BillingDataService {
	
	List<Billingdata> getAllBillingData();
	
	List<Object[]> getMonthlyCostDataGrouped() ;

	
	List<Object[]> getMonthlyCostDataGroupedForSubscription(String subscriptionName);
	
	List<Object[]> getMonthlyCostDataGroupedByDateForSubscription(String Month, String userid);
	
	
	List<Object[]> getDistinctSubscriptionIdAndNameByUserId(String userid);
	
	
	List<Object[]> getMonthlyCostDataGroupedByDate(String Month);

	
	void updateUserProjectsByUserId(String userid , String subscriptionId ,int connectionStatus);

	void deleteUserProject(String userId);
	
	List<Billingdata> getBillingDataById(Long id);

	
//	void updateEntityFields(Long id, Map<String,Object> mp);

	void deleteUserProjectsByUserId(Long id);

	List<Billingdata> getCostDataByDetails(String frequency, String month, String pricingModel, String subscriptionName);

	}
