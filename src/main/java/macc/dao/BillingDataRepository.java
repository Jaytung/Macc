package macc.dao;

import macc.entity.Billingdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillingDataRepository extends JpaRepository<Billingdata, String> {

	@Query(value = "SELECT * FROM BillingData", nativeQuery = true)
	List<Billingdata> findAllBillingData();

	@Query(value = "SELECT * FROM BillingData WHERE ID = :userId", nativeQuery = true)
	List<Billingdata> findBillingDataById(Long userId);

	@Query(value = "SELECT Frequency, PricingModel, SubscriptionName, MONTH(Date) AS Month, SUM(Quantity * UnitPrice) AS TotalCost FROM BillingData GROUP BY Frequency, PricingModel, SubscriptionName, MONTH(Date) ORDER BY Frequency, PricingModel, SubscriptionName, MONTH(Date)", nativeQuery = true)
	List<Object[]> getMonthlyCostDataGrouped();

	@Query(value = "SELECT Frequency, PricingModel, SubscriptionName, MONTH(Date) AS Month, SUM(Quantity * UnitPrice) AS TotalCost FROM BillingData WHERE MONTH(Date) = :Month GROUP BY Frequency, PricingModel, SubscriptionName, MONTH(Date) ORDER BY Frequency, PricingModel, SubscriptionName, MONTH(Date)", nativeQuery = true)
	List<Object[]> getMonthlyCostDataGroupedByDate(@Param("Month") String Month);


	@Modifying
	@Query(value = "SELECT bd.Frequency, bd.PricingModel, bd.SubscriptionName, MONTH(bd.Date) AS Month, SUM(bd.Quantity * bd.UnitPrice) AS TotalCost "
			+ "FROM BillingData bd " + "JOIN User_Projects up ON bd.SubscriptionId = up.Subscription_Id "
			+ "WHERE up.user_Id = :userId AND MONTH(bd.Date) = :Month "
			+ "GROUP BY bd.Frequency, bd.PricingModel, bd.SubscriptionName, MONTH(bd.Date) "
			+ "ORDER BY bd.Frequency, bd.PricingModel, bd.SubscriptionName, MONTH(bd.Date)", nativeQuery = true)
	List<Object[]> getMonthlyCostDataGroupedByDateForSubscription(@Param("Month") String Month,@Param("userId") String userId);

	
	@Modifying
	@Query(value = "SELECT bd.Frequency, bd.PricingModel, bd.SubscriptionName, MONTH(bd.Date) AS Month, SUM(bd.Quantity * bd.UnitPrice) AS TotalCost "
			+ "FROM BillingData bd " + "JOIN User_Projects up ON bd.SubscriptionId = up.Subscription_Id "
			+ "WHERE up.user_Id = :userId "
			+ "GROUP BY bd.Frequency, bd.PricingModel, bd.SubscriptionName, MONTH(bd.Date) "
			+ "ORDER BY bd.Frequency, bd.PricingModel, bd.SubscriptionName, MONTH(bd.Date)", nativeQuery = true)
	List<Object[]> getMonthlyCostDataGroupedBySubscriptionForUser(@Param("userId") String userId);

	@Query(value = "SELECT DISTINCT  SubscriptionName ,SubscriptionId FROM BillingData", nativeQuery = true)
	List<Object[]> findDistinctSubscriptionIdAndName();

	@Query(value = "SELECT DISTINCT bd.SubscriptionName, bd.SubscriptionId, "
			+ "CASE WHEN up.user_Id IS NOT NULL THEN '1' ELSE '0' END AS ConnectionStatus " + "FROM BillingData bd "
			+ "LEFT JOIN User_Projects up ON bd.SubscriptionId = up.Subscription_Id AND up.user_Id = :userId", nativeQuery = true)
	List<Object[]> findDistinctSubscriptionIdAndNameByUserId(String userId);

	@Modifying
	@Query(value = "SELECT * FROM BillingData WHERE ID = :id", nativeQuery = true)
	List<Billingdata> findBillingdataById(Long id);

	@Modifying
	@Query(value = "DELETE FROM BillingData WHERE ID = :Id", nativeQuery = true)
	void deletebillingDataById(Long Id);

	@Modifying
	@Query(value = "INSERT INTO User_Projects (user_Id, Subscription_Id) VALUES (:userId, :subscriptionId)", nativeQuery = true)
	void insertUserProjectByUserId(String userId, String subscriptionId);

	@Modifying
	@Query(value = "DELETE FROM User_Projects WHERE user_Id = :userId AND subscription_Id = :subscriptionId", nativeQuery = true)
	void deleteUserProjectByUserId(String userId, String subscriptionId);

	@Modifying
	@Query(value = "DELETE FROM User_Projects WHERE user_Id = :userId", nativeQuery = true)
	void deleteUserProjectsById(String userId);

	@Query(value = "SELECT * FROM BillingData WHERE Frequency = :frequency AND MONTH(Date) = :month AND PricingModel = :pricingModel AND SubscriptionName = :subscriptionName", nativeQuery = true)
	List<Billingdata> findCostDataByDetails(@Param("frequency") String frequency,@Param("month") String month, @Param("pricingModel") String pricingModel, @Param("subscriptionName") String subscriptionName);


//    SELECT p.*
//    FROM BillingData p
//    INNER JOIN User_Projects up ON p.SubscriptionId = up.Subscription_Id
//    WHERE up.user_Id = '002';

	

}
