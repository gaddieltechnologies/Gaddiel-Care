package org.gaddiel.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.MultiHashMap;
import org.apache.log4j.Logger;
import org.gaddiel.form.ChurchAddressPopup;
import org.gaddiel.form.ChurchAddressSubForm;
import org.gaddiel.form.ChurchConfigPopupForm;
import org.gaddiel.form.ChurchConfigurationForm;
import org.gaddiel.form.ChurchContactsPopup;
import org.gaddiel.form.ChurchContactsSubForm;
import org.gaddiel.form.ChurchPrefCustomForm;
import org.gaddiel.form.ChurchPrefPopupForm;
import org.gaddiel.form.ChurchPreferencesForm;
import org.gaddiel.form.CustomLookupsForm;
import org.gaddiel.form.FamilypopupForm;
import org.gaddiel.form.Lookups;
import org.gaddiel.form.MainForm;
import org.gaddiel.form.SystemLookupsForm;
import org.gaddiel.model.ChurchActivityAddresses;
import org.gaddiel.model.ChurchAddressContacts;
import org.gaddiel.model.ChurchConfiguration;
import org.gaddiel.model.SystemLookupValues;
import org.gaddiel.service.MemberService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


// TODO: Auto-generated Javadoc
/**
 * The Class ChurchConfigController.
 */
@Controller
public class ChurchConfigController {
	
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(MemberController.class);
	
	/** The memberservice. */
	@Autowired
	private MemberService memberservice;
	

	/**
	 * Testurls1.
	 *
	 * @param model the model
	 * @param churchConfigurationForm the church configuration form
	 * @param request the request
	 * @param map the map
	 * @param churchConfigurationForm1 the church configuration form1
	 * @return the string
	 */
	@RequestMapping("/ChurchConfiguration")
	   public String testurls1(Map model, @Valid ChurchConfigurationForm churchConfigurationForm, HttpServletRequest request, ModelMap map, @ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1)
	   {
		HttpSession session=request.getSession();
		
		String str=(String) session.getAttribute("username");
	    //MemberForm memberForm  = new MemberForm();
	   // map.put("memberlist",memberservice.country());
	    //System.out.println("CONTROLLER List size state"+memberservice.country().size());
	    map.put("memberlist1", memberservice.state());
	    List address=new ArrayList();
	    List church=new ArrayList();
	    churchConfigurationForm=memberservice.getaddress();
	    church=memberservice.getchurchtypelist("church");
	    map.put("churchList", church);
	    map.put("currencyList", memberservice.currency());
	     List addressmode=new ArrayList();
	    addressmode=memberservice.getaddressmode();
	    map.put("addressMode", addressmode);
	   
	    List contactmode=new ArrayList();
	  //  churchConfigurationForm=memberservice.getcontacts(address);
	    List secondlist=new ArrayList();
	    
	    List<ChurchPreferencesForm> churchPreferences= new ArrayList<ChurchPreferencesForm>();
	   System.out.println("-----------------------Entering Before The Church Preferences Controller-----------------------");
	    ChurchPreferencesForm churchPreferencesForm;
	    churchPreferencesForm=memberservice.getpreferencesvalue();
	    

	    List preferlist=new ArrayList();
	    preferlist=churchPreferencesForm.getPreferencesList();
	    churchConfigurationForm.setChurchpreferencesSubForm(preferlist);
	   	List list=memberservice.getaddnewpreflist();
		 map.put("newlist",list);
	     System.out.println("--------------Entering After The Church Preferences Controller--------------------------");
   	 
	     System.out.println("-----------------------Entering Before The Church Preferences Controller-----------------------");
	     ChurchPrefCustomForm churchPrefCustomForm;
	     churchPrefCustomForm=memberservice.getcustompreferencesvalue();
		    

		    List prefercustomlist=new ArrayList();
		    prefercustomlist=churchPrefCustomForm.getPreferencesList();
		    churchConfigurationForm.setChurchprefcustomSubForm(prefercustomlist);
		   	List customlist=memberservice.getaddnewcustompreflist();
			 map.put("newcustomlist",customlist);
		     System.out.println("--------------Entering After The Church Preferences Controller--------------------------");
	     
	     System.out.println("--------------Entering Before The Church Address & Contacts Controller--------------------------");
	     List addresslist=new ArrayList();
	     ChurchAddressSubForm churchAddressSubForm=new ChurchAddressSubForm();
	     churchConfigurationForm=memberservice.getaddress(churchAddressSubForm,churchConfigurationForm);
	     addresslist=churchConfigurationForm.getChurchAddressSubForm();
	     churchConfigurationForm.setChurchAddressSubForm(addresslist);
	     System.out.println("------------addresslist----------------"+addresslist.toString());
	     
	 	if(churchConfigurationForm1.getDispatch()!=null && churchConfigurationForm1.getDispatch().equals("churchupdate"))
		{
			map.put("currencyList", memberservice.currency());
		addressmode=new ArrayList();
			    addressmode=memberservice.getaddressmode();
			    map.put("addressMode", addressmode);
			
			System.out.println("<-----------In controller in CHURCH UPDATE------>");
			memberservice.getdetails(churchConfigurationForm1,str);	
			churchConfigurationForm1=memberservice.getaddress();
			  return "redirect:ChurchConfiguration";
		
		}
	    
	     map.put("churchConfigurationForm", churchConfigurationForm);
	     System.out.println("--------------Entering After The Church Address & Contacts Controller--------------------------");
	     System.out.println(" <------Inside Church Config Controller --------->");
	     return "ChurchConfiguration";
	   }

	/**
	 * Testurlsubmit.
	 *
	 * @param model the model
	 * @param churchConfigurationForm the church configuration form
	 * @param request the request
	 * @param map the map
	 * @param churchConfigurationForm1 the church configuration form1
	 * @param churchContactsSubForm the church contacts sub form
	 * @return the string
	 * @throws ParseException the parse exception
	 */
	@RequestMapping(value="/ChurchConfiguration/submit", method=RequestMethod.POST)
	   public String testurlsubmit(Map model, @Valid ChurchConfigurationForm churchConfigurationForm, HttpServletRequest request, ModelMap map, @ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1, ChurchContactsSubForm churchContactsSubForm) throws ParseException
	{
		if(churchConfigurationForm1.getDispatch()!=null && churchConfigurationForm1.getDispatch().equals("churchupdate"))
		{
			map.put("currencyList", memberservice.currency());
			   List addressmode=new ArrayList();
			    addressmode=memberservice.getaddressmode();
			    map.put("addressMode", addressmode);
			
			System.out.println("<-----------In controller in CHURCH UPDATE------>");
			//memberservice.getdetails(churchConfigurationForm1);	
			testurls1(model, churchConfigurationForm1, request, map, churchConfigurationForm1);
		
		}
		if(churchConfigurationForm1.getDispatch()!=null && churchConfigurationForm1.getDispatch().equals("update"))
		{
			 List addressmode=new ArrayList();
			    addressmode=memberservice.getaddressmode();
			    map.put("addressMode", addressmode);
			
			System.out.println("<-----------In controller in UPDATE------>");
			System.out.println( " Form value -->"+churchConfigurationForm1.getAddress());
			String s=churchConfigurationForm1.getAddress();
			 memberservice.getUpdateElements(churchConfigurationForm1);
		
			
			
		}
		if(churchConfigurationForm1.getDispatch()!=null && churchConfigurationForm1.getDispatch().equals("save"))
		{
			   List addressmode=new ArrayList();
			    addressmode=memberservice.getaddressmode();
			    map.put("addressMode", addressmode);
			System.out.println("<-----------In controller in Save------>");
			System.out.println( " Form value -->"+churchConfigurationForm1.getAddress());
			
			String s=churchConfigurationForm1.getAddress();

				
			System.out.println( "churchConfigurationForm.getAddressId() -->"+churchConfigurationForm.getAddressId());
			 System.out.println( "churchConfigurationForm1.getAddressId() -->"+churchConfigurationForm.getAddressId());
				memberservice.savecontacts(churchConfigurationForm, churchContactsSubForm);
				
					 
			 System.out.println("<-----------In controller in AFTER Save------>");
			
		}
		
		if(churchConfigurationForm1.getDispatch()!=null && churchConfigurationForm1.getDispatch().equals("delete"))
		{
			List addressmode=new ArrayList();
		    addressmode=memberservice.getaddressmode();
		    map.put("addressMode", addressmode);
			
			System.out.println( "IN DELETE getAddress Form value -->"+churchConfigurationForm1.getAddress());
			System.out.println( "IN DELETE AddressMode Form value -->"+churchConfigurationForm1.getAddressMode());
			System.out.println( "IN DELETE AddressId Form value -->"+churchConfigurationForm1.getAddressId());
			
			String memberdetails= memberservice.deleteMemberElements(churchConfigurationForm1);
			String memberdetails1= memberservice.deleteMemberElements1(churchConfigurationForm1);
			
		}
		return "ChurchConfiguration";
	}
	
	/**
	 * Popup.
	 *
	 * @param request the request
	 * @param churchConfigPopupForm the church config popup form
	 * @param model the model
	 * @param map the map
	 * @param mainForm1 the main form1
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping("/ChurchConfiguration/popup")
	public String popup(HttpServletRequest request, @Valid ChurchConfigPopupForm churchConfigPopupForm, Map model, ModelMap map, @ModelAttribute(value = "churchConfigPopup")ChurchConfigPopupForm  mainForm1) throws java.lang.Exception {
		System.out.println("<--------------INSIDE THE CHURCH CONFIGURATION POPUP------------>");
		List existinglooksinchurch=memberservice.existingLookupsinchurch();
		map.put("existinglooksinchurch", existinglooksinchurch);
		
		List existinglooks=memberservice.existingLookups(existinglooksinchurch);
		map.put("existinglooks", existinglooks);
		
		if(churchConfigPopupForm.getDispatch()!=null && churchConfigPopupForm.getDispatch().equals("save"))
		{
		System.out.println("--churchConfigPopupForm---looks in church Dispatch Value:"+churchConfigPopupForm.getDispatch());
	
		memberservice.saveexistingLookupsinchurch(churchConfigPopupForm, existinglooksinchurch);
		}
		
		map.put("churchConfigPopup", churchConfigPopupForm);
		return "ChurchConfigPopup";
	}
	
	/**
	 * Prefpopup.
	 *
	 * @param request the request
	 * @param churchPrefPopupForm the church pref popup form
	 * @param model the model
	 * @param map the map
	 * @param churchPreferencesForm the church preferences form
	 * @param name the name
	 * @param churchConfigurationForm1 the church configuration form1
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping("/ChurchConfiguration/preferences/popup")
	public String prefpopup(HttpServletRequest request, @Valid ChurchPrefPopupForm churchPrefPopupForm, Map model, ModelMap map, ChurchPreferencesForm churchPreferencesForm, @RequestParam("preferencesname") String name,
			@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1) throws java.lang.Exception {
		System.out.println("<--------------INSIDE THE CHURCH PREF FORM POPUP------------>");
		String PreferencesName=(String) request.getAttribute("preferencesname");
		System.out.println(" id---->"+name);
		Object[] obj=name.split(",");
		System.out.println("THE 1 VALUE"+obj[0].toString());
		System.out.println("THE 1 VALUE"+obj[1].toString());
		String Str1=obj[0].toString();
		String Str2=obj[1].toString();
		List preflist=memberservice.getpopuplist(Str1);
		map.put("prefvaluesname", preflist);
		map.put("churchPrefPopup", churchPrefPopupForm);
		
		if(churchPrefPopupForm.getDispatch()!=null && churchPrefPopupForm.getDispatch().equals("saveprefvalue"))
		{
		System.out.println("--churchPrefPopupForm---looks in church Dispatch Value:"+churchPrefPopupForm.getDispatch());
		System.out.println("--churchPrefPopupForm---looks in church Dispatch Value:"+churchPrefPopupForm.getPrefvalues().get(0));
		String name1=churchPrefPopupForm.getPrefvalues().get(0).toString();
		churchPreferencesForm=memberservice.getpreferencesvalue();
		System.out.println("VALUE POP UP CONTROLLER"+churchPreferencesForm.getPreferencesList());
		churchPreferencesForm=memberservice.saveprefvalues(name1, Str2, churchPreferencesForm);
		map.put("churchConfigurationForm", churchPreferencesForm);
		System.out.println("--The Value ENtered :");
		request.setAttribute("preferencesname", name);
		}
		
		return "ChurchPrefPopup";
	}	
	
	/**
	 * Prefdelete.
	 *
	 * @param request the request
	 * @param churchPrefPopupForm the church pref popup form
	 * @param model the model
	 * @param map the map
	 * @param id the id
	 * @param churchConfigurationForm1 the church configuration form1
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping("/ChurchConfiguration/preferences/delete")
	public String prefdelete(HttpServletRequest request, @Valid ChurchPrefPopupForm churchPrefPopupForm, Map model, ModelMap map, @RequestParam("preferId") String id,
			@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1) throws java.lang.Exception {
		System.out.println("---PREFER ID---"+id);
		Object[] obj=id.split(",");
		System.out.println("THE 1 VALUE"+obj[0].toString());
		Object[] obj1=id.split("=");
		System.out.println("THE 2 VALUE"+obj1[1].toString());
		String name=(String) request.getAttribute("prefername");
		String Value=id;
		String str=obj[0].toString();
		String str1=obj1[1].toString();
		memberservice.deletepreferences(str, str1);	
		System.out.println("THE VALUE HAS BEEN DELETED:");
		
		testurls1(model, churchConfigurationForm1, request, map, churchConfigurationForm1);
		System.out.println("THE MAPPED VALUE");
		
		return "ChurchConfiguration";
	}
	
	@RequestMapping("/ChurchConfiguration/custompreferences/delete")
	public String customprefdelete(HttpServletRequest request, @Valid ChurchPrefPopupForm churchPrefPopupForm, Map model, ModelMap map, @RequestParam("prefercustomId") String id,
			@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1) throws java.lang.Exception {
		System.out.println("---PREFER ID---"+id);
		Object[] obj=id.split(",");
		System.out.println("THE 1 VALUE"+obj[0].toString());
		Object[] obj1=id.split("=");
		System.out.println("THE 2 VALUE"+obj1[1].toString());
		String name=(String) request.getAttribute("prefername");
		String Value=id;
		String str=obj[0].toString();
		String str1=obj1[1].toString();
		memberservice.deletecustompreferences(str, str1);	
		System.out.println("THE VALUE HAS BEEN DELETED:");
		
		testurls1(model, churchConfigurationForm1, request, map, churchConfigurationForm1);
		System.out.println("THE MAPPED VALUE");
		
		return "ChurchConfiguration";
	}
	

	
	
/*	@RequestMapping(value="/ChurchConfiguration/update",method=RequestMethod.POST)
	   public String testurls(Map model,@Valid ChurchConfigurationForm churchConfigurationForm,HttpServletRequest request,ModelMap map,@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1)
	{

		  List addressmode=new ArrayList();
		    addressmode=memberservice.getaddressmode();
		    map.put("addressMode",addressmode);
		
		System.out.println("<-----------In controller in UPDATE------>");
		System.out.println( " Form value -->"+churchConfigurationForm1.getAddress());
		String s=churchConfigurationForm1.getAddress();
		ChurchActivityAddresses memberdetails= memberservice.getUpdateElements(churchConfigurationForm1);
		
		StringBuffer sb = new StringBuffer();
		sb.append(memberdetails.getDoorNumber());
		sb.append(",");
		sb.append(memberdetails.getBuilidingName());
		sb.append(",");
		sb.append(memberdetails.getArea());
		String detail=sb.toString();
			
		churchConfigurationForm.setDoorNo(detail);
		churchConfigurationForm.setDistrict(memberdetails.getDistrict());
		churchConfigurationForm.setCity(memberdetails.getCity());
		churchConfigurationForm.setState(memberdetails.getStateLocation());
		churchConfigurationForm.setCountry(memberdetails.getCountry());
		churchConfigurationForm.setPostCode(memberdetails.getPostalCode());
		churchConfigurationForm.setAddressId(memberdetails.getAddressId());
	
		map.put("ChurchActivityAddresses", churchConfigurationForm1);
		
		 List<ChurchContactsSubForm> contactlist = new ArrayList<ChurchContactsSubForm>();
		    
		    ChurchContactsSubForm churchContactsSubForm=new ChurchContactsSubForm();
		    ChurchContactsSubForm contacts;
		    contacts=memberservice.getcontacts(churchContactsSubForm,churchConfigurationForm);
		    contactlist=contacts.getContactList();
		    System.out.println("------------contactlist----------------"+contactlist.toString());
		    churchConfigurationForm.setChurchContactsSubForm(contactlist);
		
		map.put("ChurchAddressContacts", churchConfigurationForm1);
		
		return "ChurchConfiguration";
		
	
	}
	@RequestMapping(value="/ChurchConfiguration/save",method=RequestMethod.POST)
	   public String testurls11(Map model,@Valid ChurchConfigurationForm churchConfigurationForm,HttpServletRequest request,ModelMap map,@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1,ChurchContactsSubForm churchContactsSubForm ) throws Exception
	{
		
		   List addressmode=new ArrayList();
		    addressmode=memberservice.getaddressmode();
		    map.put("addressMode",addressmode);
		System.out.println("<-----------In controller in Save------>");
		System.out.println( " Form value -->"+churchConfigurationForm1.getAddress());
		
		String s=churchConfigurationForm1.getAddress();
		churchConfigurationForm=memberservice.setaddress(churchConfigurationForm1);
			// TODO Auto-generated catch block
		System.out.println( "churchConfigurationForm.getAddressId() -->"+churchConfigurationForm.getAddressId());
		 System.out.println( "churchConfigurationForm1.getAddressId() -->"+churchConfigurationForm.getAddressId());
			memberservice.savecontacts(churchConfigurationForm,churchContactsSubForm);
				// TODO Auto-generated catch block
		
		
		 
		 System.out.println("<-----------In controller in AFTER Save------>");
		
		return "ChurchConfiguration";
		
	
	}
	@RequestMapping(value="/ChurchConfiguration/delete" ,method=RequestMethod.POST)
	public String  listMember3(Map model,@Valid ChurchConfigurationForm churchConfigurationForm,HttpServletRequest request,ModelMap map,@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1,ChurchContactsSubForm churchContactsSubForm )
	{
		List addressmode=new ArrayList();
	    addressmode=memberservice.getaddressmode();
	    map.put("addressMode",addressmode);
		
		System.out.println( "IN DELETE getAddress Form value -->"+churchConfigurationForm1.getAddress());
		System.out.println( "IN DELETE AddressMode Form value -->"+churchConfigurationForm1.getAddressMode());
		System.out.println( "IN DELETE AddressId Form value -->"+churchConfigurationForm1.getAddressId());
		
		String memberdetails= memberservice.deleteMemberElements(churchConfigurationForm1);
		String memberdetails1= memberservice.deleteMemberElements1(churchConfigurationForm1);
		return "ChurchConfiguration";
		
	}
	*/
	
	/**
 * Contactdelete.
 *
 * @param request the request
 * @param churchPrefPopupForm the church pref popup form
 * @param model the model
 * @param map the map
 * @param title the title
 * @param churchConfigurationForm1 the church configuration form1
 * @return the string
 * @throws Exception the exception
 */


@RequestMapping(value="/ChurchConfiguration/contacts/view",method=RequestMethod.POST)
public @ResponseBody List getcontact(HttpServletRequest request, @Valid ChurchConfigurationForm churchConfigurationForm,@Valid ChurchAddressSubForm churchAddressSubForm, Map model, ModelMap map, @RequestParam("contactid") int id,
		@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1) throws java.lang.Exception {
	System.out.println("---PREFER title---"+id);
	
	
	churchAddressSubForm.setAddressId1(id);
	List contactlist = new ArrayList();
	ChurchContactsSubForm churchContactsSubForm=new ChurchContactsSubForm();
	churchConfigurationForm=memberservice.getcontacts(churchAddressSubForm,churchContactsSubForm,churchConfigurationForm1);
	contactlist=churchConfigurationForm.getChurchContactsSubForm();
	System.out.println("------------contactlist----------------"+contactlist.toString());
	System.out.println("------------contactlist----------------"+contactlist.size());
	return contactlist;
}
@RequestMapping("/ChurchConfiguration/addresspopup")
public String  addresspop(ChurchAddressPopup churchAddressPopup, HttpServletRequest request, Map model, ModelMap map, 
		@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1, @ModelAttribute(value = "churchAddressPopup")ChurchAddressPopup churchAddressPopup1)throws java.lang.Exception
{
	List countries=new ArrayList();
	List states=new ArrayList();
	System.out.println("---------------ID VALUE------------");
	countries=memberservice.getpopuplist("country");
	states=memberservice.getpopuplist("states");
	map.put("countryList",countries);
	map.put("stateList",states);
	map.put("churchAddressPopup", churchAddressPopup);
	return "Churchaddresspop";
}

@RequestMapping(value="/ChurchPreferences/edit")
public String  editpop( @RequestParam("val") int val, HttpServletRequest request, Map model,ChurchAddressPopup churchAddressPopup, ModelMap map,
		@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1,	@ModelAttribute(value = "churchAddressPopup")ChurchAddressPopup churchAddressPopup1)throws java.lang.Exception
{
	
	System.out.println("---------------ID VALUE in Edit------------"+val);
	List countries=new ArrayList();
	List states=new ArrayList();
	churchAddressPopup=memberservice.editaddresspopup(churchAddressPopup,val);
	countries=memberservice.getpopuplist("country");
	states=memberservice.getpopuplist("states");
	map.put("countryList",countries);
	map.put("stateList",states);
	map.put("churchAddressPopup", churchAddressPopup);
	return "Churchaddresspop";
}


@RequestMapping(value="/ChurchPreferences/save",method=RequestMethod.POST)
public String  savepop(  HttpServletRequest request, Map model, ModelMap map,
		@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1,@ModelAttribute(value = "churchAddressPopup")ChurchAddressPopup churchAddressPopup1)throws java.lang.Exception
{
	HttpSession session=request.getSession();
	
	String str=(String) session.getAttribute("username");
	System.out.println("---------------ID VALUE in SAVE------------");
	churchAddressPopup1=memberservice.saveaddress(churchAddressPopup1,str);
	testurls1(model, churchConfigurationForm1, request, map, churchConfigurationForm1);
	return "Churchaddresspop";
}




@RequestMapping(value="/ChurchConfiguration/address/delete")
public  String deleteaddress(@RequestParam("id1") int id1,HttpServletRequest request, @Valid ChurchConfigurationForm churchConfigurationForm, Map model, ModelMap map,
		@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1) throws java.lang.Exception {
	System.out.println("---PREFER LIST---"+id1);
	//List list=memberservice.getaddnewnamelist(listtype);
	churchConfigurationForm=memberservice.deleteaddress(churchConfigurationForm,id1);
	testurls1(model, churchConfigurationForm1, request, map, churchConfigurationForm);
	return "ChurchConfiguration";
}

@RequestMapping(value="/ChurchConfiguration/contact/delete")
public  String deletecontact(@RequestParam("contactd") String contactd,HttpServletRequest request, @Valid ChurchConfigurationForm churchConfigurationForm, Map model, ModelMap map,
		@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1) throws java.lang.Exception {
	System.out.println("---PREFER LIST---"+contactd);
	String name[]=contactd.split(",");
	int id=Integer.parseInt(name[0].toString());
	//List list=memberservice.getaddnewnamelist(listtype);
	//churchConfigurationForm=memberservice.deleteaddress(churchConfigurationForm,id1);
	memberservice.deletecontacts(id);
	testurls1(model, churchConfigurationForm1, request, map, churchConfigurationForm);
	return "ChurchConfiguration";
}



@RequestMapping(value="/ChurchConfiguration/contact/edit")
public  String editcontact(@RequestParam("contacte") String contacte,HttpServletRequest request, @Valid ChurchContactsPopup churchContactsPopup, @Valid ChurchConfigurationForm churchConfigurationForm, Map model, ModelMap map,
		@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1,@ModelAttribute(value = "churchContactsPopup")ChurchContactsPopup churchContactsPopup1) throws java.lang.Exception {
	System.out.println("---PREFER LIST---"+contacte);
	String name[]=contacte.split(",");
	int id=Integer.parseInt(name[0].toString());
	churchContactsPopup=memberservice.editcontacts(id);

	List contactlist=new ArrayList();
	contactlist=memberservice.getcustomlist(2);
	map.put("contactTitleList",contactlist);
	
	churchContactsPopup.setAddressId(Integer.parseInt(name[1].toString()));
	System.out.println("---ADDRESS ID-"+churchContactsPopup.getAddressId());
	map.put("churchContactsPopup", churchContactsPopup);
	System.out.println("---ADDRESS ID-"+churchContactsPopup.getContactId());
	churchContactsPopup1.setContactId(id);
	churchContactsPopup1.setAddressId(Integer.parseInt(name[1].toString()));
	System.out.println("---ADDRESS ID-"+churchContactsPopup1.getAddressId());
	System.out.println("---CONTACT ID-"+churchContactsPopup1.getContactId());
	return "Churchcontactspop";
}


@RequestMapping(value="/ChurchConfiguration/contact/save")
public String  savecontactpop(  HttpServletRequest request, Map model, ModelMap map, @Valid ChurchContactsPopup churchContactsPopup,  @Valid ChurchAddressSubForm churchAddressSubForm,
		@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1,@ModelAttribute(value = "churchContactsPopup")ChurchContactsPopup churchContactsPopup1)throws java.lang.Exception
{
	HttpSession session=request.getSession();
	
	String str=(String) session.getAttribute("username");
	
	map.put("churchContactsPopup", churchContactsPopup);
	System.out.println("---------------ID VALUE in SAVE------------"+churchContactsPopup.getAddressId());
	System.out.println("---------------ID VALUE in SAVE------------"+churchContactsPopup.getContactId());
	System.out.println("---------------ID VALUE in SAVE------------"+churchContactsPopup1.getContactId());
	System.out.println("---------------ID VALUE in SAVE------------"+churchContactsPopup1.getAddressId());
	System.out.println("---------------ID VALUE in SAVE------------"+churchContactsPopup1.getContactTitle());
	System.out.println("---------------ID VALUE in SAVE------------"+churchContactsPopup1.getDescription());
	int addid=churchContactsPopup.getAddressId();
	churchContactsPopup1=memberservice.savecontacts(churchContactsPopup1,addid,str);

	testurls1(model, churchConfigurationForm1, request, map, churchConfigurationForm1);
	return "ChurchConfiguration";
}





@RequestMapping("/ChurchConfiguration/contactspopup")
public String  contactspopup(@RequestParam("contactadd") String contactadd,ChurchContactsPopup churchContactsPopup,ChurchAddressSubForm churchAddressSubForm, HttpServletRequest request, Map model, ModelMap map,@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1, @ModelAttribute(value = "churchContactsPopup")ChurchContactsPopup churchContactsPopup1)
{

	int id=Integer.parseInt(contactadd.toString());
	churchContactsPopup.setAddressId(id);
	System.out.println("---------------IN Family CONTROLLER------------"+churchContactsPopup.getAddressId());
	List contactlist=new ArrayList();
	contactlist=memberservice.getcustomlist(2);
	map.put("contactTitleList",contactlist);
	map.put("churchContactsPopup", churchContactsPopup);
	return "Churchcontactspop";
}

@RequestMapping(value="/ChurchConfiguration/prefaddnew",method=RequestMethod.POST)
public @ResponseBody List list1(@RequestParam(value="list") String listtype,HttpServletRequest request, @Valid ChurchPrefPopupForm churchPrefPopupForm, Map model, ModelMap map,
		@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1) throws java.lang.Exception {
	System.out.println("---PREFER LIST---"+listtype);
	List list=memberservice.getaddnewnamelist(listtype);
	System.out.println("----------THE LIST SIZE---------"+list.size());
	
	return list;
}


@RequestMapping(value="/ChurchConfiguration/customprefaddnew",method=RequestMethod.POST)
public @ResponseBody List list2(@RequestParam(value="clist") String listtype,HttpServletRequest request, @Valid ChurchPrefPopupForm churchPrefPopupForm, Map model, ModelMap map,
		@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1) throws java.lang.Exception {
	System.out.println("---PREFER LIST---"+listtype);
	List list=memberservice.getcustomaddnewnamelist(listtype);
	System.out.println("----------THE LIST SIZE---------"+list.size());
	
	return list;
}


@RequestMapping(value="/ChurchPreferences/newsave" , method=RequestMethod.POST)
public String savenewlookups( @RequestParam(value="newsaveid") String saveid, HttpServletRequest request, Map model, ModelMap map,
		@Valid ChurchConfigurationForm churchConfigurationForm,	@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1) throws Exception
		{
	HttpSession session=request.getSession();
	String str=(String) session.getAttribute("username");
	String Description=null;
	String Startdate=null;
	String endDate=null;
	String checkbox=null;
	
	System.out.println(" id---->"+saveid);
	String[] val=saveid.split(",");
	System.out.println("-------------------THE LENGTH OF VALUE----"+val.length);
	Lookups	lookups=new Lookups();
	for(int i=0; i<val.length; i++)
	{
		System.out.println("THE "+i+"th POSITION VALUE"+val[i]);
		
		if(i==2 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			Description=val[i];
		}
		else if(i==3 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			Startdate=val[i];
		}
		else if(i==4 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			endDate=val[i];
		}
		else if(i==5 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			checkbox=val[i];
		}
	}
	
	
	churchConfigurationForm1=memberservice.newlinesave(val[0].toString(), val[1].toString(), Description, Startdate, endDate, checkbox, str, churchConfigurationForm1);
	testurls1(model, churchConfigurationForm1, request, map, churchConfigurationForm);
	return "ChurchConfiguration";
		}


@RequestMapping(value="/ChurchPreferences/custom/newsave" , method=RequestMethod.POST)
public String savenewcustomlookups( @RequestParam(value="customid") String saveid, HttpServletRequest request, Map model, ModelMap map,
		@Valid ChurchConfigurationForm churchConfigurationForm,	@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1) throws Exception
		{
	HttpSession session=request.getSession();
	String str=(String) session.getAttribute("username");
	String Description=null;
	String Startdate=null;
	String endDate=null;
	String checkbox=null;
	
	System.out.println(" id---->"+saveid);
	String[] val=saveid.split(",");
	System.out.println("-------------------THE LENGTH OF VALUE----"+val.length);
	Lookups	lookups=new Lookups();
	for(int i=0; i<val.length; i++)
	{
		System.out.println("THE "+i+"th POSITION VALUE"+val[i]);
		
		if(i==2 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			Description=val[i];
		}
		else if(i==3 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			Startdate=val[i];
		}
		else if(i==4 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			endDate=val[i];
		}
		else if(i==5 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			checkbox=val[i];
		}
	}
	
	
	churchConfigurationForm1=memberservice.customnewlinesave(val[0].toString(), val[1].toString(), Description, Startdate, endDate, checkbox, str, churchConfigurationForm1);
	
	return "ChurchConfiguration";
		}

	
	/**
	 * Ajaxccall.
	 *
	 * @param addressType the address type
	 * @param churchConfigurationForm2 the church configuration form2
	 * @param map the map
	 * @param churchConfigurationForm the church configuration form
	 * @param churchConfigurationForm1 the church configuration form1
	 * @return the list
	 */
	@RequestMapping(value="/ChurchConfiguration/contact", method=RequestMethod.POST)
	   public @ResponseBody List  ajaxccall(@RequestParam(value="addressType") String addressType, ChurchContactsSubForm churchContactsSubForm, ChurchConfigurationForm  churchConfigurationForm2, ModelMap map, @ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm, @ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1)
	
	{
		ModelAndView mav = new ModelAndView();
	    List contactlist=new ArrayList();
		System.out.println(" Inside the ajax call ---->"+addressType);
	    ChurchContactsSubForm contacts;
	    churchConfigurationForm.setAddressId(Integer.parseInt(addressType));
	   // contacts=memberservice.getcontacts(churchContactsSubForm, churchConfigurationForm);
	   // contactlist=contacts.getContactList();
	    //mav.addObject("churchConfigurationForm", churchConfigurationForm1);
	    System.out.println("-----------THE CONTACT LIST SIZE---------"+contactlist.size());
		return contactlist;
	}
	

	
}
