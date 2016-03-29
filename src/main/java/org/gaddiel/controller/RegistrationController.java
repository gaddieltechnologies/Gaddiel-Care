package org.gaddiel.controller;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;

import org.gaddiel.form.BaptismForm;
import org.gaddiel.form.BaptismPopupAddForm;
import org.gaddiel.form.ChurchAddressSubForm;
import org.gaddiel.form.ChurchConfigurationForm;
import org.gaddiel.form.CollectionRegistersForm;
import org.gaddiel.form.CollectionRegistersSubForm;
import org.gaddiel.form.ConfirmationForm;
import org.gaddiel.form.ConfirmationPopupAddForm;
import org.gaddiel.form.ContributionSchedulesForm;
import org.gaddiel.form.ContributionSchedulesSubForm;
import org.gaddiel.form.DeathPopupAddForm;
import org.gaddiel.form.FamilypopupForm;
import org.gaddiel.form.MarriagePopupAddForm;
import org.gaddiel.form.SubscriptionPopupAddForm;

import org.gaddiel.form.DeathForm;

import org.gaddiel.form.MainForm;
import org.gaddiel.form.MarriageForm;

import org.gaddiel.form.SubscriptionForm;
import org.gaddiel.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
// TODO: Auto-generated Javadoc
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("RegistrationController")
public class RegistrationController {

	public java.util.List<java.lang.Object> categorylist = new ArrayList();
	private static final Logger logger = Logger.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberservice;
	
	@RequestMapping("Collectionregisters")
	public String  testurl12(CollectionRegistersForm collectionRegistersForm,CollectionRegistersSubForm collectionRegistersSubForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "collectionRegisters")CollectionRegistersForm collectionRegistersForm1) throws ParseException
	{
		List modelist=new ArrayList();
		System.out.println("---------------IN Collectionregisters CONTROLLER------------");
		collectionRegistersSubForm.setFamilyId(1);
		modelist=memberservice.modelist();
		map.put("newModeList", modelist);
		collectionRegistersForm=memberservice.getcollectionregister(collectionRegistersSubForm,collectionRegistersForm);
		List collectionlist=collectionRegistersForm.getCollectionRegistersSubForm();
		collectionRegistersForm.setCollectionRegistersSubForm(collectionlist);
		map.put("collectionRegisters", collectionRegistersForm);
		return "Collectionregisters";
	}
	@RequestMapping(value="/Collectionregisters/newsave",method=RequestMethod.POST)
	public String  newsave(@RequestParam(value="newsavecoll") String saveid,CollectionRegistersForm collectionRegistersForm,CollectionRegistersSubForm collectionRegistersSubForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "collectionRegisters")CollectionRegistersForm collectionRegistersForm1) throws ParseException
	{
		HttpSession session=request.getSession();
		String str=(String) session.getAttribute("username");
		
		String familyid=null;
		String modepay=null;
		String amount=null;
		String receiptno=null;
		String receiptdate=null;
		String paidupto=null;
		System.out.println("----------IN NEW SAVE--------------");
		System.out.println(" id---->"+saveid);
		String[] val=saveid.split(",");
		System.out.println("-------------------THE LENGTH OF VALUE----"+val.length);
		for(int i=0; i<val.length; i++)
		{
			System.out.println("THE "+i+"th POSITION VALUE"+val[i]);
			if(i==0 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				familyid=val[i];
			}
			if(i==1 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				modepay=val[i];
			}
			else if(i==2 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				amount=val[i];
			}
			else if(i==3 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				receiptno=val[i];
			}
			else if(i==4 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				receiptdate=val[i];
			}
			else if(i==5 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				paidupto=val[i];
			}
		
		}
		memberservice.savenewcollection(familyid,modepay,amount,receiptno,receiptdate,paidupto,str,collectionRegistersForm);
		
		return "Collectionregisters";
	}
	
	
	@RequestMapping(value="/Collectionregisters/view",method=RequestMethod.POST)
	public @ResponseBody List getdue(HttpServletRequest request, @Valid CollectionRegistersForm collectionRegistersForm,@Valid ChurchAddressSubForm churchAddressSubForm, Map model, ModelMap map, @RequestParam("contactid") int id,
			@ModelAttribute(value = "collectionRegisters")CollectionRegistersForm  collectionRegistersForm1) throws java.lang.Exception {
		System.out.println("---PREFER title---"+id);
		List contactlist = new ArrayList();
		return contactlist;
	}
	
	
	
	
	

	@RequestMapping("Contributionschedules")
	public String  testurl13(ContributionSchedulesForm contributionSchedulesForm,ContributionSchedulesSubForm contributionSchedulesSubForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "contributionSchedules")ContributionSchedulesForm ContributionSchedulesForm1) throws ParseException
	{
		List modelist=new ArrayList();
		System.out.println("---------------IN Collectionregisters CONTROLLER------------");

		contributionSchedulesForm=memberservice.getcollectionschedule(contributionSchedulesSubForm,contributionSchedulesForm);
		List collectionlist=contributionSchedulesForm.getContributionSchedulesSubForm();
		contributionSchedulesForm.setContributionSchedulesSubForm(collectionlist);
		map.put("contributionSchedules", contributionSchedulesForm);
	List collectionType=new ArrayList();
	List collectionFrequencyList=new ArrayList();
	List Duelist=new ArrayList();
	
	collectionType=memberservice.collectiontype();
	map.put("collectionTypeList",collectionType);
	
	collectionFrequencyList=memberservice.collectionfreq();
	map.put("collectionFrequencyList",collectionFrequencyList);
	
	Duelist=memberservice.duelist();
	map.put("duelist", Duelist);
	
		return "Contributionschedules";
	}
	
	@RequestMapping("/ContributionSchedule/call")
	public @ResponseBody List  testurl17(@RequestParam(value="list") String val,ContributionSchedulesForm contributionSchedulesForm,ContributionSchedulesSubForm contributionSchedulesSubForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "contributionSchedules")ContributionSchedulesForm ContributionSchedulesForm1) throws ParseException
	{
		System.out.println("-----LIST VALUE NAME ----"+val);
		
		List collectionDueList=new ArrayList();
		collectionDueList=memberservice.collectiondue(val);
		System.out.println(""+collectionDueList.size());
		return collectionDueList;
	}

	@RequestMapping("/ContributionSchedule/newsave")
	public String  testurl14(@RequestParam(value="conscid") String saveid,ContributionSchedulesForm contributionSchedulesForm,ContributionSchedulesSubForm contributionSchedulesSubForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "contributionSchedules")ContributionSchedulesForm ContributionSchedulesForm1) throws ParseException
	{
		HttpSession session=request.getSession();
		String str=(String) session.getAttribute("username");
		
		System.out.println(" id---->"+saveid);
		String[] val=saveid.split(",");
		System.out.println("-------------------THE LENGTH OF VALUE----"+val.length);
		
		String amount=null;
		String collectiontype=null;
		String Collectionfreq=null;
		String CollectionDuedays=null;
		String CollectionDuedate=null;
		String Startdate=null;
		String endDate=null;
		String checkbox=null;
		
		
		for(int i=0; i<val.length; i++)
		{
			System.out.println("THE "+i+"th POSITION VALUE"+val[i]);
			
			if(i==0 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				amount=val[i];
			}
			else if(i==1 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				collectiontype=val[i];
			}
			else if(i==2 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				Collectionfreq=val[i];
			}
			else if(i==3 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				CollectionDuedays=val[i];
			}
			else if(i==4 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				CollectionDuedate=val[i];
			}
			else if(i==5 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				Startdate=val[i];
			}
			else if(i==6 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				endDate=val[i];
			}
			else if(i==7 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				checkbox=val[i];
			}
		}
		memberservice.savenewcontributionlist(amount, collectiontype, Collectionfreq, CollectionDuedays,CollectionDuedate, Startdate,endDate, checkbox,str, ContributionSchedulesForm1);
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("Baptism")
	public String  testurl1(BaptismForm baptismForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "Baptism")BaptismForm baptismForm1)
	{
		
		System.out.println("---------------IN Baptism CONTROLLER------------");
		map.put("Baptism", baptismForm);
		return "Baptism";
	}
	
	@RequestMapping("/Baptism/BaptismPopupAdd")
	public String  testurl2(BaptismPopupAddForm baptismPopupAddForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "BaptismPopupAdd")BaptismPopupAddForm baptismPopupAddForm1)
	{
		
		System.out.println("---------------IN Baptism add CONTROLLER------------");
		map.put("BaptismPopupAdd", baptismPopupAddForm);
		return "BaptismPopupAdd";
	}
	
	@RequestMapping("/Baptism/BaptismPopupEdit")
	public String  testurl3(BaptismPopupAddForm baptismPopupAddForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "BaptismPopupEdit")BaptismPopupAddForm baptismPopupAddForm1)
	{
		
		System.out.println("---------------IN Baptism edit CONTROLLER------------");
		map.put("BaptismPopupEdit", baptismPopupAddForm);
		return "BaptismPopupEdit";
	}
		
	@RequestMapping("Confirmation")
	public String  testurl1(ConfirmationForm confirmationForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "Confirmation")ConfirmationForm confirmationForm1)
	{
		
		System.out.println("---------------IN Confirmation CONTROLLER------------");
		map.put("Confirmation", confirmationForm);
		return "Confirmation";
	}
	
	@RequestMapping("/Confirmation/ConfirmationPopupAdd")
	public String  testurl2(ConfirmationPopupAddForm confirmationPopupAddForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "ConfirmationPopupAdd")ConfirmationPopupAddForm confirmationPopupAddForm1)
	{
		
		System.out.println("---------------IN Confirmation add CONTROLLER------------");
		map.put("ConfirmationPopupAdd", confirmationPopupAddForm);
		return "ConfirmationPopupAdd";
	}
	@RequestMapping("/Confirmation/ConfirmationPopupEdit")
	public String  testurl3(ConfirmationPopupAddForm confirmationPopupAddForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "ConfirmationPopupEdit")ConfirmationPopupAddForm confirmationPopupAddForm1)
	{
		
		System.out.println("---------------IN Confirmation edit CONTROLLER------------");
		map.put("ConfirmationPopupEdit", confirmationPopupAddForm);
		return "ConfirmationPopupEdit";
	}
	@RequestMapping("Death")
	public String  testurl1(DeathForm deathForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "Death")DeathForm deathForm1)
	{
		
		System.out.println("---------------IN Death CONTROLLER------------");
		map.put("Death", deathForm);
		return "Death";
	}
	
	@RequestMapping("/Death/DeathPopupAdd")
	public String  testurl2(DeathPopupAddForm deathPopupAddForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "DeathPopupAdd")DeathPopupAddForm deathPopupAddForm1)
	{
		
		System.out.println("---------------IN Death add CONTROLLER------------");
		map.put("DeathPopupAdd", deathPopupAddForm);
		return "DeathPopupAdd";
	}
	@RequestMapping("/Death/DeathPopupEdit")
	public String  testurl3(DeathPopupAddForm deathPopupAddForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "DeathPopupEdit")DeathPopupAddForm deathPopupAddForm1)
	{
		
		System.out.println("---------------IN Death edit CONTROLLER------------");
		map.put("DeathPopupEdit", deathPopupAddForm);
		return "DeathPopupEdit";
	}

	@RequestMapping("Marriage")
	public String  testurl1(MarriageForm marriageForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "Marriage")MarriageForm marriageForm1)
	{
		
		System.out.println("---------------IN Marriage CONTROLLER------------");
		map.put("Marriage", marriageForm);
		return "Marriage";
	}
	
	@RequestMapping("/Marriage/MarriagePopupAdd")
	public String  testurl2(MarriagePopupAddForm marriagePopupAddForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "MarriagePopupAdd")MarriagePopupAddForm marriagePopupAddForm1)
	{
		
		System.out.println("---------------IN Marriage add CONTROLLER------------");
		map.put("MarriagePopupAdd", marriagePopupAddForm);
		return "MarriagePopupAdd";
	}
	@RequestMapping("/Marriage/MarriagePopupEdit")
	public String  testurl3(MarriagePopupAddForm marriagePopupAddForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "MarriagePopupEdit")MarriagePopupAddForm marriagePopupAddForm1)
	{
		
		System.out.println("---------------IN Marriage Edit CONTROLLER------------");
		map.put("MarriagePopupEdit", marriagePopupAddForm);
		return "MarriagePopupEdit";
	}
	
	@RequestMapping("Subscription")
	public String  testurl1(SubscriptionForm subscriptionForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "Subscription")SubscriptionForm subscriptionForm1)
	{
		
		System.out.println("---------------IN Subscription CONTROLLER------------");
		map.put("Subscription", subscriptionForm);
		return "Subscription";
	}
	@RequestMapping("/Subscription/SubscriptionPopupAdd")
	public String  testurl2(SubscriptionPopupAddForm subscriptionPopupAddForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "SubscriptionPopupAdd")SubscriptionPopupAddForm subscriptionPopupAddForm1)
	{
		
		System.out.println("---------------IN Subscription add CONTROLLER------------");
		map.put("SubscriptionPopupAdd", subscriptionPopupAddForm);
		return "SubscriptionPopupAdd";
	}
	@RequestMapping("/Subscription/SubscriptionPopupEdit")
	public String  testurl3(SubscriptionPopupAddForm subscriptionPopupAddForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "SubscriptionPopupEdit")SubscriptionPopupAddForm subscriptionPopupAddForm1)
	{
		
		System.out.println("---------------IN Subscription edit CONTROLLER------------");
		map.put("SubscriptionPopupEdit", subscriptionPopupAddForm);
		return "SubscriptionPopupEdit";
	}
	@RequestMapping("underconstruction")
	public String  testurl4(SubscriptionPopupAddForm subscriptionPopupAddForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "SubscriptionPopupEdit")SubscriptionPopupAddForm subscriptionPopupAddForm1)
	{
		
		System.out.println("---------------IN Subscription edit CONTROLLER------------");
		map.put("underconstruction", subscriptionPopupAddForm);
		return "underConstruction";
	}
	
	
}
