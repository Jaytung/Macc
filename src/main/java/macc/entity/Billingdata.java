	
	package macc.entity;

	import javax.persistence.*;


    

	@Entity
	@Table(name = "Billingdata")
	public class Billingdata {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;
	    @Column(name = "billingaccountid")
	    private String billingaccountid;

	    @Column(name = "billingaccountname")
	    private String billingaccountname;

	    @Column(name = "billingperiodstartdate")
	    private String billingperiodstartdate;

	    @Column(name = "billingperiodenddate")
	    private String billingperiodenddate;

	    @Column(name = "billingprofileid")
	    private String billingprofileid;

	    @Column(name = "billingprofilename")
	    private String billingprofilename;

	    @Column(name = "accountownerid")
	    private String accountownerid;

	    @Column(name = "accountname")
	    private String accountname;

	    @Column(name = "subscriptionid")
	    private String subscriptionid;

	    @Column(name = "subscriptionname")
	    private String subscriptionname;

	    @Column(name = "date")
	    private String date;

	    @Column(name = "product")
	    private String product;

	    @Column(name = "partnumber")
	    private String partnumber;

	    @Column(name = "meterid")
	    private String meterid;

	    @Column(name = "servicefamily")
	    private String servicefamily;

	    @Column(name = "metercategory")
	    private String metercategory;

	    @Column(name = "metersubcategory")
	    private String metersubcategory;

	    @Column(name = "meterregion")
	    private String meterregion;

	    @Column(name = "metername")
	    private String metername;

	    @Column(name = "quantity")
	    private Double quantity;

	    @Column(name = "effectiveprice")
	    private Double effectiveprice;

	    @Column(name = "cost")
	    private Double cost;

	    @Column(name = "unitprice")
	    private Double unitprice;

	    @Column(name = "allcost")
	    private Double allcost;

	    @Column(name = "billingcurrency")
	    private String billingcurrency;

	    @Column(name = "resourcelocation")
	    private String resourcelocation;

	    @Column(name = "availabilityzone")
	    private String availabilityzone;

	    @Column(name = "consumedservice")
	    private String consumedservice;

	    @Column(name = "resourceid")
	    private String resourceid;

	    @Column(name = "resourcename")
	    private String resourcename;

	    @Column(name = "serviceinfo1")
	    private String serviceinfo1;

	    @Column(name = "serviceinfo2")
	    private String serviceinfo2;

	    @Column(name = "additionalinfo", columnDefinition = "TEXT", length = 2000)
	    private String additionalinfo;
	    
	    @Column(name = "tags", length = 2000)
	    private String tags;

	    @Column(name = "invoicesectionid")
	    private String invoicesectionid;

	    @Column(name = "invoicesection")
	    private String invoicesection;

	    @Column(name = "costcenter")
	    private String costcenter;

	    @Column(name = "unitofmeasure")
	    private String unitofmeasure;

	    @Column(name = "resourcegroup")
	    private String resourcegroup;

	    @Column(name = "reservationid")
	    private String reservationid;

	    @Column(name = "reservationname")
	    private String reservationname;

	    @Column(name = "productorderid")
	    private String productorderid;

	    @Column(name = "productordername")
	    private String productordername;

	    @Column(name = "offerid")
	    private String offerid;

	    @Column(name = "isazurecrediteligible")
	    private String isazurecrediteligible;

	    @Column(name = "term")
	    private Double term;

	    @Column(name = "publishername")
	    private String publishername;

	    @Column(name = "planname")
	    private String planname;

	    @Column(name = "chargetype")
	    private String chargetype;

	    @Column(name = "frequency")
	    private String frequency;

	    @Column(name = "publishertype")
	    private String publishertype;

	    @Column(name = "paygprice")
	    private Double paygprice;

	    @Column(name = "pricingmodel")
	    private String pricingmodel;

	    @Column(name = "costallocationrulename")
	    private String costallocationrulename;

	    @Column(name = "benefitid")
	    private String benefitid;

	    @Column(name = "benefitname")
	    private String benefitname;

	   
	    public Billingdata() {
	    }


		public Billingdata(int id ,String billingaccountid, String billingaccountname, String billingperiodstartdate,
				String billingperiodenddate, String billingprofileid, String billingprofilename, String accountownerid,
				String accountname, String subscriptionid, String subscriptionname, String date, String product,
				String partnumber, String meterid, String servicefamily, String metercategory, String metersubcategory,
				String meterregion, String metername, Double quantity, Double effectiveprice, Double cost,
				Double unitprice, Double allcost, String billingcurrency, String resourcelocation,
				String availabilityzone, String consumedservice, String resourceid, String resourcename,
				String serviceinfo1, String serviceinfo2, String additionalinfo, String tags, String invoicesectionid,
				String invoicesection, String costcenter, String unitofmeasure, String resourcegroup,
				String reservationid, String reservationname, String productorderid, String productordername,
				String offerid, String isazurecrediteligible, Double term, String publishername, String planname,
				String chargetype, String frequency, String publishertype, Double paygprice, String pricingmodel,
				String costallocationrulename, String benefitid, String benefitname) {
			super();
			this.id = id;
			this.billingaccountid = billingaccountid;
			this.billingaccountname = billingaccountname;
			this.billingperiodstartdate = billingperiodstartdate;
			this.billingperiodenddate = billingperiodenddate;
			this.billingprofileid = billingprofileid;
			this.billingprofilename = billingprofilename;
			this.accountownerid = accountownerid;
			this.accountname = accountname;
			this.subscriptionid = subscriptionid;
			this.subscriptionname = subscriptionname;
			this.date = date;
			this.product = product;
			this.partnumber = partnumber;
			this.meterid = meterid;
			this.servicefamily = servicefamily;
			this.metercategory = metercategory;
			this.metersubcategory = metersubcategory;
			this.meterregion = meterregion;
			this.metername = metername;
			this.quantity = quantity;
			this.effectiveprice = effectiveprice;
			this.cost = cost;
			this.unitprice = unitprice;
			this.allcost = allcost;
			this.billingcurrency = billingcurrency;
			this.resourcelocation = resourcelocation;
			this.availabilityzone = availabilityzone;
			this.consumedservice = consumedservice;
			this.resourceid = resourceid;
			this.resourcename = resourcename;
			this.serviceinfo1 = serviceinfo1;
			this.serviceinfo2 = serviceinfo2;
			this.additionalinfo = additionalinfo;
			this.tags = tags;
			this.invoicesectionid = invoicesectionid;
			this.invoicesection = invoicesection;
			this.costcenter = costcenter;
			this.unitofmeasure = unitofmeasure;
			this.resourcegroup = resourcegroup;
			this.reservationid = reservationid;
			this.reservationname = reservationname;
			this.productorderid = productorderid;
			this.productordername = productordername;
			this.offerid = offerid;
			this.isazurecrediteligible = isazurecrediteligible;
			this.term = term;
			this.publishername = publishername;
			this.planname = planname;
			this.chargetype = chargetype;
			this.frequency = frequency;
			this.publishertype = publishertype;
			this.paygprice = paygprice;
			this.pricingmodel = pricingmodel;
			this.costallocationrulename = costallocationrulename;
			this.benefitid = benefitid;
			this.benefitname = benefitname;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getBillingaccountid() {
			return billingaccountid;
		}


		public void setBillingaccountid(String billingaccountid) {
			this.billingaccountid = billingaccountid;
		}


		public String getBillingaccountname() {
			return billingaccountname;
		}


		public void setBillingaccountname(String billingaccountname) {
			this.billingaccountname = billingaccountname;
		}


		public String getBillingperiodstartdate() {
			return billingperiodstartdate;
		}


		public void setBillingperiodstartdate(String billingperiodstartdate) {
			this.billingperiodstartdate = billingperiodstartdate;
		}


		public String getBillingperiodenddate() {
			return billingperiodenddate;
		}


		public void setBillingperiodenddate(String billingperiodenddate) {
			this.billingperiodenddate = billingperiodenddate;
		}


		public String getBillingprofileid() {
			return billingprofileid;
		}


		public void setBillingprofileid(String billingprofileid) {
			this.billingprofileid = billingprofileid;
		}


		public String getBillingprofilename() {
			return billingprofilename;
		}


		public void setBillingprofilename(String billingprofilename) {
			this.billingprofilename = billingprofilename;
		}


		public String getAccountownerid() {
			return accountownerid;
		}


		public void setAccountownerid(String accountownerid) {
			this.accountownerid = accountownerid;
		}


		public String getAccountname() {
			return accountname;
		}


		public void setAccountname(String accountname) {
			this.accountname = accountname;
		}


		public String getSubscriptionid() {
			return subscriptionid;
		}


		public void setSubscriptionid(String subscriptionid) {
			this.subscriptionid = subscriptionid;
		}


		public String getSubscriptionname() {
			return subscriptionname;
		}


		public void setSubscriptionname(String subscriptionname) {
			this.subscriptionname = subscriptionname;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		public String getProduct() {
			return product;
		}


		public void setProduct(String product) {
			this.product = product;
		}


		public String getPartnumber() {
			return partnumber;
		}


		public void setPartnumber(String partnumber) {
			this.partnumber = partnumber;
		}


		public String getMeterid() {
			return meterid;
		}


		public void setMeterid(String meterid) {
			this.meterid = meterid;
		}


		public String getServicefamily() {
			return servicefamily;
		}


		public void setServicefamily(String servicefamily) {
			this.servicefamily = servicefamily;
		}


		public String getMetercategory() {
			return metercategory;
		}


		public void setMetercategory(String metercategory) {
			this.metercategory = metercategory;
		}


		public String getMetersubcategory() {
			return metersubcategory;
		}


		public void setMetersubcategory(String metersubcategory) {
			this.metersubcategory = metersubcategory;
		}


		public String getMeterregion() {
			return meterregion;
		}


		public void setMeterregion(String meterregion) {
			this.meterregion = meterregion;
		}


		public String getMetername() {
			return metername;
		}


		public void setMetername(String metername) {
			this.metername = metername;
		}


		public Double getQuantity() {
			return quantity;
		}


		public void setQuantity(Double quantity) {
			this.quantity = quantity;
		}


		public Double getEffectiveprice() {
			return effectiveprice;
		}


		public void setEffectiveprice(Double effectiveprice) {
			this.effectiveprice = effectiveprice;
		}


		public Double getCost() {
			return cost;
		}


		public void setCost(Double cost) {
			this.cost = cost;
		}


		public Double getUnitprice() {
			return unitprice;
		}


		public void setUnitprice(Double unitprice) {
			this.unitprice = unitprice;
		}


		public Double getAllcost() {
			return allcost;
		}


		public void setAllcost(Double allcost) {
			this.allcost = allcost;
		}


		public String getBillingcurrency() {
			return billingcurrency;
		}


		public void setBillingcurrency(String billingcurrency) {
			this.billingcurrency = billingcurrency;
		}


		public String getResourcelocation() {
			return resourcelocation;
		}


		public void setResourcelocation(String resourcelocation) {
			this.resourcelocation = resourcelocation;
		}


		public String getAvailabilityzone() {
			return availabilityzone;
		}


		public void setAvailabilityzone(String availabilityzone) {
			this.availabilityzone = availabilityzone;
		}


		public String getConsumedservice() {
			return consumedservice;
		}


		public void setConsumedservice(String consumedservice) {
			this.consumedservice = consumedservice;
		}


		public String getResourceid() {
			return resourceid;
		}


		public void setResourceid(String resourceid) {
			this.resourceid = resourceid;
		}


		public String getResourcename() {
			return resourcename;
		}


		public void setResourcename(String resourcename) {
			this.resourcename = resourcename;
		}


		public String getServiceinfo1() {
			return serviceinfo1;
		}


		public void setServiceinfo1(String serviceinfo1) {
			this.serviceinfo1 = serviceinfo1;
		}


		public String getServiceinfo2() {
			return serviceinfo2;
		}


		public void setServiceinfo2(String serviceinfo2) {
			this.serviceinfo2 = serviceinfo2;
		}


		public String getAdditionalinfo() {
			return additionalinfo;
		}


		public void setAdditionalinfo(String additionalinfo) {
			this.additionalinfo = additionalinfo;
		}


		public String getTags() {
			return tags;
		}


		public void setTags(String tags) {
			this.tags = tags;
		}


		public String getInvoicesectionid() {
			return invoicesectionid;
		}


		public void setInvoicesectionid(String invoicesectionid) {
			this.invoicesectionid = invoicesectionid;
		}


		public String getInvoicesection() {
			return invoicesection;
		}


		public void setInvoicesection(String invoicesection) {
			this.invoicesection = invoicesection;
		}


		public String getCostcenter() {
			return costcenter;
		}


		public void setCostcenter(String costcenter) {
			this.costcenter = costcenter;
		}


		public String getUnitofmeasure() {
			return unitofmeasure;
		}


		public void setUnitofmeasure(String unitofmeasure) {
			this.unitofmeasure = unitofmeasure;
		}


		public String getResourcegroup() {
			return resourcegroup;
		}


		public void setResourcegroup(String resourcegroup) {
			this.resourcegroup = resourcegroup;
		}


		public String getReservationid() {
			return reservationid;
		}


		public void setReservationid(String reservationid) {
			this.reservationid = reservationid;
		}


		public String getReservationname() {
			return reservationname;
		}


		public void setReservationname(String reservationname) {
			this.reservationname = reservationname;
		}


		public String getProductorderid() {
			return productorderid;
		}


		public void setProductorderid(String productorderid) {
			this.productorderid = productorderid;
		}


		public String getProductordername() {
			return productordername;
		}


		public void setProductordername(String productordername) {
			this.productordername = productordername;
		}


		public String getOfferid() {
			return offerid;
		}


		public void setOfferid(String offerid) {
			this.offerid = offerid;
		}


		public String getIsazurecrediteligible() {
			return isazurecrediteligible;
		}


		public void setIsazurecrediteligible(String isazurecrediteligible) {
			this.isazurecrediteligible = isazurecrediteligible;
		}


		public Double getTerm() {
			return term;
		}


		public void setTerm(Double term) {
			this.term = term;
		}


		public String getPublishername() {
			return publishername;
		}


		public void setPublishername(String publishername) {
			this.publishername = publishername;
		}


		public String getPlanname() {
			return planname;
		}


		public void setPlanname(String planname) {
			this.planname = planname;
		}


		public String getChargetype() {
			return chargetype;
		}


		public void setChargetype(String chargetype) {
			this.chargetype = chargetype;
		}


		public String getFrequency() {
			return frequency;
		}


		public void setFrequency(String frequency) {
			this.frequency = frequency;
		}


		public String getPublishertype() {
			return publishertype;
		}


		public void setPublishertype(String publishertype) {
			this.publishertype = publishertype;
		}


		public Double getPaygprice() {
			return paygprice;
		}


		public void setPaygprice(Double paygprice) {
			this.paygprice = paygprice;
		}


		public String getPricingmodel() {
			return pricingmodel;
		}


		public void setPricingmodel(String pricingmodel) {
			this.pricingmodel = pricingmodel;
		}


		public String getCostallocationrulename() {
			return costallocationrulename;
		}


		public void setCostallocationrulename(String costallocationrulename) {
			this.costallocationrulename = costallocationrulename;
		}


		public String getBenefitid() {
			return benefitid;
		}


		public void setBenefitid(String benefitid) {
			this.benefitid = benefitid;
		}


		public String getBenefitname() {
			return benefitname;
		}


		public void setBenefitname(String benefitname) {
			this.benefitname = benefitname;
		}


		@Override
		public String toString() {
			return "BillingData [billingaccountid=" + billingaccountid + ", billingaccountname=" + billingaccountname
					+ ", billingperiodstartdate=" + billingperiodstartdate + ", billingperiodenddate="
					+ billingperiodenddate + ", billingprofileid=" + billingprofileid + ", billingprofilename="
					+ billingprofilename + ", accountownerid=" + accountownerid + ", accountname=" + accountname
					+ ", subscriptionid=" + subscriptionid + ", subscriptionname=" + subscriptionname + ", date=" + date
					+ ", product=" + product + ", partnumber=" + partnumber + ", meterid=" + meterid
					+ ", servicefamily=" + servicefamily + ", metercategory=" + metercategory + ", metersubcategory="
					+ metersubcategory + ", meterregion=" + meterregion + ", metername=" + metername + ", quantity="
					+ quantity + ", effectiveprice=" + effectiveprice + ", cost=" + cost + ", unitprice=" + unitprice
					+ ", allcost=" + allcost + ", billingcurrency=" + billingcurrency + ", resourcelocation="
					+ resourcelocation + ", availabilityzone=" + availabilityzone + ", consumedservice="
					+ consumedservice + ", resourceid=" + resourceid + ", resourcename=" + resourcename
					+ ", serviceinfo1=" + serviceinfo1 + ", serviceinfo2=" + serviceinfo2 + ", additionalinfo="
					+ additionalinfo + ", tags=" + tags + ", invoicesectionid=" + invoicesectionid + ", invoicesection="
					+ invoicesection + ", costcenter=" + costcenter + ", unitofmeasure=" + unitofmeasure
					+ ", resourcegroup=" + resourcegroup + ", reservationid=" + reservationid + ", reservationname="
					+ reservationname + ", productorderid=" + productorderid + ", productordername=" + productordername
					+ ", offerid=" + offerid + ", isazurecrediteligible=" + isazurecrediteligible + ", term=" + term
					+ ", publishername=" + publishername + ", planname=" + planname + ", chargetype=" + chargetype
					+ ", frequency=" + frequency + ", publishertype=" + publishertype + ", paygprice=" + paygprice
					+ ", pricingmodel=" + pricingmodel + ", costallocationrulename=" + costallocationrulename
					+ ", benefitid=" + benefitid + ", benefitname=" + benefitname + "]";
		}
		
	    
	
	}
	