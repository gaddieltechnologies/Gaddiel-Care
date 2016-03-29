package org.gaddiel.controller;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import org.gaddiel.form.CustomLookupsForm;
import org.gaddiel.form.FamilyLandingForm;
import org.gaddiel.form.FamilypopupForm;
import org.gaddiel.form.Lookups;
import org.gaddiel.form.MainForm;
import org.gaddiel.form.MemberpopupForm;
import org.gaddiel.form.SubscriptionPaidForm;
import org.gaddiel.form.SubscriptionPlanForm;
import org.gaddiel.model.Userprivilege;
import org.gaddiel.service.MemberService;
import org.gaddiel.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
// TODO: Auto-generated Javadoc
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * The Class LookupsController.
 *
 * @generated
 */
@Controller("FamilyDetailsController")
public class FamilyDetailsController {
	
	/** The categorylist. */
	public java.util.List<java.lang.Object> categorylist = new ArrayList();
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(MemberController.class);
	
	/** The memberservice. */
	@Autowired
	private MemberService memberservice;

	/**
	 * Custom lookup index.
	 *
	 * @param customLookupsForm the custom lookups form
	 * @param request the request
	 * @param member the member
	 * @param model the model
	 * @param map the map
	 * @param mainForm1 the main form1
	 * @return the string
	 */
		/**
	 * 
	 */
	@RequestMapping("/familylanding")
	public String  testurl(FamilyLandingForm familyLandingForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "familLanding")FamilyLandingForm familyLandingForm1)
	{
		System.out.println("---------------IN LAnding CONTROLLER------------");
		
		System.out.println("--------------familyLandingForm1.getAddnewrow()-------------"+familyLandingForm1.getAddnewrow());
		System.out.println("--------------familyLandingForm.getAddnewrow()-------------"+familyLandingForm.getAddnewrow());
		if(familyLandingForm1.getAddnewrow()!=null && familyLandingForm1.getAddnewrow().equals("yes"))
		{
			System.out.println("-----------IN ADDNEW ----------------");
			map.put("familLanding", familyLandingForm1);
			System.out.println("--------------familyLandingForm1.getAddnewrow()-------------"+familyLandingForm1.getAddnewrow());
			return "redirect:familylanding";
		}
		map.put("familLanding", familyLandingForm);
		return "familylanding";
		
	}
	
	@RequestMapping("/familylanding/familypopup")
	public String  testurl1(FamilypopupForm familypopupForm, SubscriptionPlanForm subscriptionPlanForm,HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "familyPopup")FamilypopupForm familypopupForm1) throws ParseException
	{
		
		System.out.println("---------------IN Family CONTROLLER------------");

		
		map.put("familyPopup", familypopupForm);
		return "Familypopup";
	}
	@RequestMapping("/familylanding/memberpopup")
	public String  testurl2(FamilyLandingForm familyLandingForm, MemberpopupForm memberpopupForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "memberPopup")MemberpopupForm memberpopupForm1)
	{
		System.out.println("---------------IN MEMBER CONTROLLER------------");
		System.out.println("-------------THE DISPATCH VALUE-----"+memberpopupForm1.getDispatch());
		if(memberpopupForm1.getDispatch()!=null && memberpopupForm1.getDispatch().equals("save"))
		{
			familyLandingForm.setAddnewrow("yes");
			testurl(familyLandingForm, request, model, map, familyLandingForm);
		}
		map.put("memberPopup", memberpopupForm);
		return "memberpopup";
	}
	@RequestMapping("/familylanding/familyedit")
	public String  testurl3(FamilypopupForm familypopupForm,SubscriptionPlanForm subscriptionPlanForm,SubscriptionPaidForm subscriptionPaidForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "familyPopup")FamilypopupForm familypopupForm1) throws ParseException
	{
		HttpSession session=request.getSession();
			String str=(String) session.getAttribute("username");
		
		System.out.println("---------------IN Family edit CONTROLLER------------");
		subscriptionPlanForm.setFamilyId(1);
		familypopupForm=memberservice.getsubscriptionlist(subscriptionPlanForm,familypopupForm);
		List planlist=familypopupForm.getSubscriptionPlanForm();
		familypopupForm.setSubscriptionPlanForm(planlist);
		subscriptionPaidForm.setFamilyId(1);
		familypopupForm=memberservice.getsubscriptionpaidlist(subscriptionPaidForm,familypopupForm);
		List paidlist=familypopupForm.getSubscriptionPlanForm();
		familypopupForm.setSubscriptionPlanForm(paidlist);
		HashMap Userinfo=(HashMap) session.getAttribute("userprivillege");
		Userprivilege Userprivilege=(Userprivilege) Userinfo.get("FAMILY EDIT");
		        	if( Userprivilege != null )
		        	{	
		         	Converter.roleprivilleges(session, Userprivilege);
		        	}
		
		map.put("familyedit", familypopupForm);
		return "familyedit";
	}
	
	
	@RequestMapping(value="/familylanding/familyedit/save" , method=RequestMethod.POST)
	public String savelookups( @RequestParam(value="saveid1") String saveid,FamilypopupForm familypopupForm, HttpServletRequest request, Map model, ModelMap map,
			@ModelAttribute(value = "familyedit")FamilypopupForm  familypopupForm1) throws Exception
			{
		HttpSession session=request.getSession();
		String str=(String) session.getAttribute("username");
		String paidupto=null;
		String Startdate=null;
		String endDate=null;
		String checkbox=null;
		
		System.out.println(" id---->"+saveid);
		String[] val=saveid.split(",");
		System.out.println("-------------------THE LENGTH OF VALUE----"+val.length);
		for(int i=0; i<val.length; i++)
		{
			System.out.println("THE "+i+"th POSITION VALUE"+val[i]);
			
			if(i==1 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				paidupto=val[i];
			}
			else if(i==2 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				Startdate=val[i];
			}
			else if(i==3 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				endDate=val[i];
			}
			else if(i==4 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				checkbox=val[i];
			}
		}
		memberservice.savesubscriptionlist(val[0].toString(), Startdate, endDate, paidupto, checkbox, str, familypopupForm);
		
		
				return "familyedit";
			}
	@RequestMapping(value="/familylanding/familyedit/newsave" , method=RequestMethod.POST)
	public String savenewlookups( @RequestParam(value="newsaveid1") String saveid,FamilypopupForm familypopupForm, HttpServletRequest request, Map model, ModelMap map,
			@ModelAttribute(value = "familyedit")FamilypopupForm  familypopupForm1) throws Exception
			{
		
		HttpSession session=request.getSession();
		String str=(String) session.getAttribute("username");
		String amount=null;
		String startdate=null;
	
		String enddate=null;
		String paidupto=null;
		System.out.println("----------IN NEW SAVE--------------");
		System.out.println(" id---->"+saveid);
		String[] val=saveid.split(",");
		System.out.println("-------------------THE LENGTH OF VALUE----"+val.length);
		for(int i=0; i<val.length; i++)
		{
			System.out.println("THE "+i+"th POSITION VALUE"+val[i]);
			
			if(i==1 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				amount=val[i];
			}
			else if(i==2 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				startdate=val[i];
			}
			else if(i==3 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				enddate=val[i];
			}
			else if(i==4 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				paidupto=val[i];
			}
		
		}
		System.out.println("----------THE RECEIPT NO---------"+val[0]);
		System.out.println("----------THE AMOUNT--------"+val[1]);
		memberservice.savenewsubscriptionlist(val[0].toString(),amount,startdate,enddate,paidupto, str, familypopupForm);
		return "familyedit";
			}
	
	@RequestMapping("/familylanding/memberedit")
	public String  testurl4(MemberpopupForm memberpopupForm, HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "memberPopup")MemberpopupForm memberpopupForm1)
	{
		
		System.out.println("---------------IN Family edit CONTROLLER------------");
		map.put("memberedit", memberpopupForm);
		return "memberedit";
	}
}
