package org.gaddiel.controller;

import java.awt.Color;
import java.io.ByteArrayOutputStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;



import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.gaddiel.form.ChurchConfigPopupForm;
import org.gaddiel.form.CustomLookupsForm;
import org.gaddiel.form.Lookups;
import org.gaddiel.form.MainForm;
import org.gaddiel.form.SystemLookupsForm;

import org.gaddiel.form.LookupspopupForm;

import org.gaddiel.report.Exporter;
import org.gaddiel.report.ReportLayout;
import org.gaddiel.report.Writer;

import org.gaddiel.service.MemberService;
import org.gaddiel.util.Converter;
import org.gaddiel.model.Userprivilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.AutoText;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.ImageBanner;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Transparency;

// TODO: Auto-generated Javadoc
/**
 * The Class LookupsController.
 *
 * @generated
 */
@Controller("LookupsController")
public class LookupsController {
	
	/** The categorylist. */
	public java.util.List<java.lang.Object> categorylist = new ArrayList();
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(LookupsController.class);
	
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
	@RequestMapping("/customLookups")
	public String  customLookupIndex(CustomLookupsForm customLookupsForm, HttpServletRequest request, MainForm member, Map model, ModelMap map, @ModelAttribute(value = "mainForm1")CustomLookupsForm mainForm1)
	{
		String forwardpage="customLookups"; 
		try{
			HttpSession session=request.getSession();
			
			String str=(String) session.getAttribute("username");
		
		List<Lookups> lookups = new ArrayList<Lookups>();
		
		Lookups lookupValues;
	
		mainForm1.setSessionId(session.getId());
		List customlist=memberservice.getcustomlookupsvalue();
		System.out.println("---The Category Value---"+customlist.size());
		System.out.println("---The Category Value---"+customlist);
		session.setAttribute("baselookups", categorylist);
		
		System.out.println(" SEssion id in controller ---------------->"+session.getId());
    	System.out.println("-------THE DISPATCH VALUE-------------"+mainForm1.getDispatch());
		if(mainForm1.getDispatch()!=null && mainForm1.getDispatch().equals("view"))
    	{      
			mainForm1.setAddnewflag("0");
			mainForm1.setClearsearch("1");
			mainForm1.setHidesearch("0");
			if(mainForm1.getAdvancedhidesearch()!=null && mainForm1.getAdvancedhidesearch().equals("0"))
    		{
    			mainForm1.setAdvancedhidesearch("0");
    		}
    		else if(mainForm1.getAdvancedhidesearch()!=null  && mainForm1.getAdvancedhidesearch().equals("1"))
    		{
    			mainForm1.setAdvancedhidesearch("1");
    		}
			
    		System.out.println("<---- Inside the  view --->");
    		System.out.println(" list value ---->"+mainForm1.getCustomcategoryType());
    		String listvalue=mainForm1.getCustomcategoryType();
    		System.out.println(" Type value ---->"+mainForm1.getLabel());
    		lookupValues=memberservice.getviewList(mainForm1);	
        	lookups=lookupValues.getMemberList();
        	System.out.println(" lookups----->"+lookups.size());
        	session.setAttribute("lookuplist", lookups);
        	if(lookups.size()==0)
        	{
        		mainForm1.setRecordList("No Record Found");
        	}
        	System.out.println("-----THE RECORD LIST VALUE--------"+mainForm1.getRecordList());
        	BeanUtils.copyProperties(mainForm1, lookupValues);
        	mainForm1.setLookups(lookups);
        	mainForm1.setCustomcategoryType(listvalue);
        	forwardpage="customLookups";
     
     	}
		else if(mainForm1.getDispatch()!=null && mainForm1.getDispatch().equals("update")){
    		System.out.println("<---- Inside the  update --->");
    		mainForm1.setAddnewflag("0");
    		mainForm1.setClearsearch("0");
    		mainForm1.setHidesearch("0");
    		if(mainForm1.getCustomlookssearch()==null){	
    			lookupValues=memberservice.getviewList(mainForm1);	
    			lookups=lookupValues.getMemberList();
    			mainForm1.setLookups(lookups);
    		}
    		else{
    			memberservice.getcustomlookslist(mainForm1);
    		}
    		
    		mainForm1.setDispatch("update");
        	forwardpage="customLookups";
    		
    	}else if(mainForm1.getDispatch()!=null && mainForm1.getDispatch().equals("save")){
    		System.out.println("<---- Inside the  save --->");
    		mainForm1.setAddnewflag("0");
    		mainForm1.setClearsearch("1");
    		mainForm1.setHidesearch("0");
    		mainForm1.setAdvancedhidesearch("0");
    		mainForm1 =memberservice.savelookups(mainForm1, str);
    		
    		lookupValues=memberservice.getviewList(mainForm1);	
    	
        	lookups=lookupValues.getMemberList();
        	System.out.println(" lookups----->"+lookups.size());
        	session.setAttribute("lookuplist", lookups);
        	mainForm1.setLookups(lookups);
        	forwardpage="customLookups";
        	
    	}
    	else if(mainForm1.getDispatch()!=null && mainForm1.getDispatch().equals("search"))
		        
      	{  mainForm1.setHidesearch("0");
    		mainForm1.setAddnewflag("0");
    		mainForm1.setClearsearch("0");
    		mainForm1.setAdvancedhidesearch("0");
    		String msg = null;
    		String listvalue=mainForm1.getCustomcategoryType();
    		System.out.println("<----search values --->");
    		lookupValues=memberservice.getcustomlookslist(mainForm1);
    		lookups=lookupValues.getMemberList();
        	System.out.println(" lookups----->"+lookups.size());
        	session.setAttribute("lookuplist", lookups);
        	if(lookups.size()==0)
        	{
        		mainForm1.setRecordList("No Record Found");
        	}
        	System.out.println("-----THE RECORD LIST VALUE--------"+mainForm1.getRecordList());
        	BeanUtils.copyProperties(mainForm1, lookupValues);
        	mainForm1.setLookups(lookups);
        	mainForm1.setCustomcategoryType(listvalue);
    		mainForm1.setDispatch("search");
    					
	        }
    	else if(mainForm1.getDispatch()!=null && mainForm1.getDispatch().equals("advancedsearch"))
	        
      	{ 
    		mainForm1.setHidesearch("1");
    		mainForm1.setAddnewflag("1");
    		mainForm1.setClearsearch("0");
    		mainForm1.setAdvancedhidesearch("1");
    		
    		String msg = null;
    		String listvalue=mainForm1.getCustomcategoryType();
    		System.out.println("<----search values Code --->"+mainForm1.getSearchCode());
    		System.out.println("<----search values Description--->"+mainForm1.getSearchDescription());
    		lookupValues=memberservice.getadvancedsearchcustomlookslist(mainForm1);
    		lookups=lookupValues.getMemberList();
        	System.out.println(" lookups----->"+lookups.size());
        	session.setAttribute("lookuplist", lookups);
        	if(lookups.size()==0)
        	{
        		mainForm1.setRecordList("No Record Found");
        	}
        	BeanUtils.copyProperties(mainForm1, lookupValues);
        	mainForm1.setLookups(lookups);
        	mainForm1.setCustomcategoryType(listvalue);
    		mainForm1.setDispatch("advancedsearch");
           }
    	else if(mainForm1.getDispatch()!=null && mainForm1.getDispatch().equals("addnew"))
    	{
    		
    		System.out.println("<---- Inside the  addnew --->");
    		List lookuplist=(List) session.getAttribute("lookuplist");
    		mainForm1.setAddnewflag("1");
    		mainForm1.setClearsearch("0");
        	lookups=lookuplist;
        	lookupValues=new Lookups();
        	lookupValues.setCheckbox("1");
        	lookupValues.setCategoryName("");
        	lookupValues.setCustomcategoryType("");
        	lookupValues.setCategoryCode("");
        	lookups.add(lookupValues);
			mainForm1.setLookups(lookups);
			mainForm1.setDispatch("addnew");
        	forwardpage="customLookups";
    	}
    	else if(mainForm1.getDispatch()!=null && (mainForm1.getDispatch().equals("next") || mainForm1.getDispatch().equals("prev")))
     	{
     		System.out.println("<---- Inside the  next --->");
     		System.out.println("__________IN NEXT CONTROLS_________"+mainForm1.getHidesearch());
     		if(mainForm1.getAdvancedhidesearch()!=null && mainForm1.getHidesearch().equals("0"))
    		{
    			mainForm1.setHidesearch("0");
    		}
    		else if(mainForm1.getAdvancedhidesearch()!=null && mainForm1.getHidesearch().equals("1"))
    		{
    			mainForm1.setHidesearch("1");
    		}
     		System.out.println("__________IN NEXT CONTROLS_________"+mainForm1.getAdvancedhidesearch());
     		if(mainForm1.getAdvancedhidesearch()!=null && mainForm1.getAdvancedhidesearch().equals("0"))
    		{
    			mainForm1.setAdvancedhidesearch("0");
    		}
    		else if(mainForm1.getAdvancedhidesearch()!=null && mainForm1.getAdvancedhidesearch().equals("1"))
    		{
    			mainForm1.setAdvancedhidesearch("1");
    		}
     		
     		
     		int traverse=0;
     		if(mainForm1.getDispatch().equals("next"))
     		{
     		     traverse=mainForm1.getPageNo()+1;
     		    mainForm1.setDispatch("next");
     		}else if(mainForm1.getDispatch().equals("prev"))
     		{
     			 traverse=mainForm1.getPageNo()-1;
     			mainForm1.setDispatch("prev");
     		}
     		mainForm1.setPageNo(traverse);
     		lookupValues=memberservice.getcustomTempList(mainForm1);	
            	lookups=lookupValues.getMemberList();
            	System.out.println(" lookups----->"+lookups.size());
               	session.setAttribute("lookuplist", lookups);
               	String listvalue=mainForm1.getCustomcategoryType();
               	System.out.println("THE LIST VALUE"+mainForm1.getCustomcategoryType());
               	BeanUtils.copyProperties(mainForm1, lookupValues);
               	          	
            	mainForm1.setLookups(lookups);
            	mainForm1.setCustomcategoryType(listvalue);
            	
            	forwardpage="customLookups";
     	       	mainForm1.setDispatch("next");
            	forwardpage="customLookups";
     	}
		model.put("mainForm1", mainForm1);
		System.out.println(" catgory list ---> "+categorylist.isEmpty());
    	if(categorylist.isEmpty())
    	{
    	categorylist=(List) session.getAttribute("baselookups");
    	System.out.println(" Inside if condition -------->"+customlist.size());
    	model.put("categorylist", lookups);	
    	model.put("categoryNamelist", customlist);
    	}else
    	{
    	model.put("categorylist", lookups);
    	model.put("categoryNamelist", customlist);
    	System.out.println(" Inside else condition -------->"+customlist.size());
    	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	return forwardpage;
	}

	/**
	 * Deletelookups.
	 *
	 * @param customLookupsForm the custom lookups form
	 * @param member the member
	 * @param request the request
	 * @param model the model
	 * @param map the map
	 * @param id the id
	 * @param mainForm1 the main form1
	 * @return the string
	 */
	
	
	@RequestMapping("/customLookups/popup")
	public String popup(HttpServletRequest request, @Valid LookupspopupForm lookupspopupForm, Map model, ModelMap map, 
			@ModelAttribute(value = "mainForm1")CustomLookupsForm  mainForm1, @ModelAttribute(value = "lookupsPopup")LookupspopupForm  lookupspopupForm1) throws java.lang.Exception {
		System.out.println("<--------------INSIDE THE SYSTEM LOOKUPS POPUP------------>");
		map.put("lookupsPopup", lookupspopupForm);
		HttpSession session=request.getSession();
		String str=(String) session.getAttribute("username");
		Lookups LookupValues;
     	/* Load category type */
     	System.out.println("---------THE DISPATCH VALUE----------"+lookupspopupForm1.getDispatch());
		if(lookupspopupForm1.getDispatch()!=null && lookupspopupForm1.getDispatch().equals("save"))
		{
			System.out.println("---------IN Dispatch THE DISPATCH VALUE----------");
			mainForm1=memberservice.addnewsave(str, mainForm1, lookupspopupForm1);
		mainForm1.setDispatch("view");
		
		}
		return "customlookupspopup";
	}
          

	

@RequestMapping(value="/customLookups/delete" , method=RequestMethod.GET)
public String deletelookups(CustomLookupsForm customLookupsForm, MainForm member, HttpServletRequest request, Map model, ModelMap map, @RequestParam("categoryid") String id,
@ModelAttribute(value="mainForm1")CustomLookupsForm  mainForm1)
{
//String id =(String)request.getAttribute("categoryid");
		String categoryType=(String) request.getAttribute("categorytype");
		System.out.println(" id---->"+id);
		
		String value=id+","+categoryType;
		System.out.println(" Category Type ------------>"+categoryType);
		List lookups=new ArrayList();
		HttpSession session=request.getSession();
		List list=memberservice.deletelookups(value);	
		lookups=list;
		String[] val=id.split("=");
		System.out.println("THE ID VALUE"+val[0].toString());
		System.out.println("THE CATEGORY VALUE"+val[1].toString());
		String value1[]=val[0].split(",");
		mainForm1.setCustomcategoryType(value1[0].toString());
		mainForm1.setDispatch("view");
		customLookupIndex(customLookupsForm, request, member, model, map, mainForm1);
		return "customLookups";
}

@RequestMapping(value="/customLookups/save" , method=RequestMethod.POST)
public String savecustomlookups( @RequestParam(value="saveid1") String saveid1, HttpServletRequest request, CustomLookupsForm customLookupsForm, MainForm member, Map model, ModelMap map,
		@ModelAttribute(value = "mainForm1")CustomLookupsForm  mainForm1) throws Exception
		{
	HttpSession session=request.getSession();
	String str=(String) session.getAttribute("username");
	String Description=null;
	String Startdate=null;
	String endDate=null;
	String checkbox=null;
	
	System.out.println(" id---->"+saveid1);
	String[] val=saveid1.split(",");
	System.out.println("-------------------THE LENGTH OF VALUE----"+val.length);
	Lookups	lookups=new Lookups();
	for(int i=0; i<val.length; i++)
	{
		System.out.println("THE "+i+"th POSITION VALUE"+val[i]);
		
		if(i==3 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			Description=val[i];
		}
		else if(i==4 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			Startdate=val[i];
		}
		else if(i==5 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			endDate=val[i];
		}
		else if(i==6 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			checkbox=val[i];
		}
	}
	
	
		mainForm1=memberservice.savecustominline(val[1].toString(),  val[2].toString(), Description, Startdate, endDate, checkbox, str);
		System.out.println("---IN CATEGORY VALUE IN CONTROLLER--"+val[0].toString());
		mainForm1.setLookups(null);
		mainForm1.setCustomcategoryType(val[0].toString());
		mainForm1.setDispatch("view");
		customLookupIndex(customLookupsForm, request, member, model, map, mainForm1);
		return "customLookups";
		}
	
	
@RequestMapping(value="/customLookups/newsave" , method=RequestMethod.POST)
public String addcustomlookups( @RequestParam(value="newsaveid") String saveid1, HttpServletRequest request, CustomLookupsForm customLookupsForm, MainForm member, Map model, ModelMap map,
		@ModelAttribute(value = "mainForm1")CustomLookupsForm  mainForm1) throws Exception
		{
	HttpSession session=request.getSession();
	String str=(String) session.getAttribute("username");
	String Description=null;
	String Startdate=null;
	String endDate=null;
	String checkbox=null;
	mainForm1.setLastpage("0");
	System.out.println(" id---->"+saveid1);
	String[] val=saveid1.split(",");
	System.out.println("-------------------THE LENGTH OF VALUE----"+val.length);
	Lookups	lookups=new Lookups();
	for(int i=0; i<val.length; i++)
	{
		System.out.println("THE "+i+"th POSITION VALUE"+val[i]);
		
		if(i==3 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			Description=val[i];
		}
		else if(i==4 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			Startdate=val[i];
		}
		else if(i==5 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			endDate=val[i];
		}
		else if(i==6 && val[i].length()!=0)
		{
			System.out.println("THE LENGTH"+val[i].length());
			checkbox=val[i];
		}
	}
	
	
	mainForm1=memberservice.customlinesave(val[0].toString(), val[1].toString(),  val[2].toString(), Description, Startdate, endDate, checkbox, str, mainForm1);
	System.out.println("---IN CATEGORY VALUE IN CONTROLLER--"+val[0].toString());
	mainForm1.setLookups(null);
	mainForm1.setCustomcategoryType(val[0].toString());
	mainForm1.setDispatch("view");
	mainForm1.setLastpage("1");
	customLookupIndex(customLookupsForm, request, member, model, map, mainForm1);

	return "customLookups";
		}
	

	
	
//----------------------------------------------------------SYSTEM LOOKUPS---------------------------------------------------------------------------------------------------	
	
	/**
 * Testurl.
 *
 * @param request the request
 * @param model the model
 * @param map the map
 * @param mainForm the main form
 * @return the string
 */
@RequestMapping("/systemLookups")
            	public String  testurl(HttpServletRequest request, Map model, ModelMap map, @ModelAttribute(value = "mainForm")MainForm  mainForm)            	  	  {	     String forwardpage="systemLookups"; 
 		try{
 			HttpSession session=request.getSession();
 			String str=(String) session.getAttribute("username");
 		   	List<SystemLookupsForm> lookups = new ArrayList<SystemLookupsForm>();
         	List categorylist=new ArrayList();
         	List categoryValue=new ArrayList();
         	//MainForm mainForm=new MainForm();
         	SystemLookupsForm systemLookupValues;
         	mainForm.setSessionId(session.getId());
         	/* Load category type */
         	systemLookupValues=memberservice.getlookupsvalue();
            	categorylist=systemLookupValues.getCategoryTypeList();
            	session.setAttribute("baselookups", categorylist);
            	
            	System.out.println(" SEssion id in controller ---------------->"+session.getId());
            	System.out.println("-------THE DISPATCH VALUE-------------"+mainForm.getDispatch());
         	if(mainForm.getDispatch()!=null && mainForm.getDispatch().equals("view"))
         	{            	
         		System.out.println("<---- Inside the  view --->");
         		mainForm.setAddnewflag("0");
         		mainForm.setClearsearch("1");
         		mainForm.setHidesearch("0");
         		if(mainForm.getAdvancedhidesearch()!=null  && mainForm.getAdvancedhidesearch().equals("0"))
        		{
        			mainForm.setAdvancedhidesearch("0");
        		}
        		else if(mainForm.getAdvancedhidesearch()!=null  && mainForm.getAdvancedhidesearch().equals("1"))
        		{
        			mainForm.setAdvancedhidesearch("1");
        		}
         		
         		System.out.println(" list value ---->"+mainForm.getCategotyType());
	            	systemLookupValues=memberservice.getSystemviewList(mainForm);	
	            	lookups=systemLookupValues.getMemberList();
	            	System.out.println(" lookups----->"+lookups.size());
	               	session.setAttribute("lookuplist", lookups);
	               	if(lookups.size()==0)
	            	{
	            		mainForm.setRecordList("No Record Found");
	            	}
	            	System.out.println("-----THE RECORD LIST VALUE--------"+mainForm.getRecordList());
	               	BeanUtils.copyProperties(mainForm, systemLookupValues);
	            	mainForm.setLookups(lookups);
	            	        	forwardpage="systemLookups";
	            	
         	}else if(mainForm.getDispatch()!=null && mainForm.getDispatch().equals("update")){
         		System.out.println("<---- Inside the  update --->");
         		mainForm.setAddnewflag("0");
         		mainForm.setClearsearch("0");
         		if(mainForm.getSystemlookssearch()==null){	
         			systemLookupValues=memberservice.getSystemviewList(mainForm);
         			lookups=systemLookupValues.getMemberList();
             		mainForm.setLookups(lookups);
         		}	
         		else{
         			memberservice.getSystemlookslist(mainForm);
         		}
        		
	            	mainForm.setDispatch("update");
	            	
	            	forwardpage="systemLookups";
         		
         	}else if(mainForm.getDispatch()!=null && mainForm.getDispatch().equals("save")){
         		System.out.println("<---- Inside the  save --->");
         		mainForm.setAddnewflag("0");
         		mainForm.setClearsearch("1");
         		mainForm=memberservice.saveSystemlookups(mainForm, str);
         		systemLookupValues=memberservice.getSystemviewList(mainForm);
         		lookups=systemLookupValues.getMemberList();
            	System.out.println(" lookups----->"+lookups.size());
            	session.setAttribute("lookuplist", lookups);
            	mainForm.setLookups(lookups);
	            	forwardpage="systemLookups";
	            	
         	}
        	else if(mainForm.getDispatch()!=null && mainForm.getDispatch().equals("search"))
		        
	          	{  
        		    mainForm.setClearsearch("0");
	        		mainForm.setAddnewflag("0");
	        		mainForm.setHidesearch("0");
	        		mainForm.setAdvancedhidesearch("0");
	        		
    	        	System.out.println("<----search values --->");
    	        	systemLookupValues=memberservice.getSystemlookslist(mainForm);
    	        	lookups=systemLookupValues.getMemberList();
                	System.out.println(" lookups----->"+lookups.size());
                   	session.setAttribute("lookuplist", lookups);
                   	if(lookups.size()==0)
                	{
                		mainForm.setRecordList("No Record Found");
                	}
                	System.out.println("-----THE RECORD LIST VALUE--------"+mainForm.getRecordList());
                   	BeanUtils.copyProperties(mainForm, systemLookupValues);
                	mainForm.setLookups(lookups);
    				mainForm.setDispatch("search");
    				forwardpage="systemLookups";
    	        }
        	else if(mainForm.getDispatch()!=null && mainForm.getDispatch().equals("advancedsearch"))
		    {
        		mainForm.setClearsearch("0");
        		mainForm.setAddnewflag("1");
        		mainForm.setHidesearch("1");
        		mainForm.setAdvancedhidesearch("1");
        		
    	       	System.out.println("<----search values --->");
    			System.out.println("<----search values Code --->"+mainForm.getSearchCode());
        		System.out.println("<----search values Description--->"+mainForm.getSearchDescription());
        		systemLookupValues=memberservice.getadvancedsearchsystemlookslist(mainForm);
        		lookups=systemLookupValues.getMemberList();
            	System.out.println(" lookups----->"+lookups.size());
               	session.setAttribute("lookuplist", lookups);
               	if(lookups.size()==0)
            	{
            		mainForm.setRecordList("No Record Found");
            	}
            	System.out.println("-----THE RECORD LIST VALUE--------"+mainForm.getRecordList());
               	BeanUtils.copyProperties(mainForm, systemLookupValues);
            	mainForm.setLookups(lookups);
        		mainForm.setDispatch("advancedsearch");
    			forwardpage="systemLookups";
    	    }
         	else if(mainForm.getDispatch()!=null && mainForm.getDispatch().equals("saveaddnew"))
         	{
         		System.out.println("<---- Inside the  addnew --->");
         		System.out.println("THE NEW CODE"+mainForm.getNewcode());
         		System.out.println("THE NEW NAME"+mainForm.getNewname());
         		mainForm.setHidesearch("0");
         		mainForm.setAdvancedhidesearch("0");
         		mainForm.setDispatch("view");
         		forwardpage="systemLookups";
         	}else if(mainForm.getDispatch()!=null && (mainForm.getDispatch().equals("next") || mainForm.getDispatch().equals("prev")))
         	{
         		
         		if(mainForm.getAdvancedhidesearch()!=null && mainForm.getHidesearch().equals("1"))
        		{
        			mainForm.setHidesearch("0");
        		}
        		else
        		{
        			mainForm.setHidesearch("1");
        		}
         		if(mainForm.getAdvancedhidesearch()!=null && mainForm.getAdvancedhidesearch().equals("0"))
        		{
        			mainForm.setAdvancedhidesearch("0");
        		}
        		else if(mainForm.getAdvancedhidesearch()!=null && mainForm.getAdvancedhidesearch().equals("1"))
        		{
        			mainForm.setAdvancedhidesearch("1");
        		}
         		
         		
         		System.out.println("<---- Inside the  next --->");
         		int traverse=0;
         		if(mainForm.getDispatch().equals("next"))
         		{
         		     traverse=mainForm.getPageNo()+1;
         		    mainForm.setDispatch("next");
         		}else if(mainForm.getDispatch().equals("prev"))
         		{
         			 traverse=mainForm.getPageNo()-1;
         			mainForm.setDispatch("prev");
         		}
         		mainForm.setPageNo(traverse);
         		    systemLookupValues=memberservice.getTempList(mainForm);	
	            	lookups=systemLookupValues.getMemberList();
	            	System.out.println(" lookups----->"+lookups.size());
	               	session.setAttribute("lookuplist", lookups);
	            	mainForm.setLookups(lookups);
	            	BeanUtils.copyProperties(mainForm, systemLookupValues);
	            	forwardpage="systemLookups";
         	       	mainForm.setDispatch("next");
	            	forwardpage="systemLookups";
         	}
         	System.out.println(" -----------------------------start-----------------------------------------------------");
        	HashMap Userinfo=(HashMap) session.getAttribute("userprivillege");
Userprivilege Userprivilege=(Userprivilege) Userinfo.get("SYSTEM LOOKUPS");
        	if( Userprivilege != null )
        	{	
         	Converter.roleprivilleges(session, Userprivilege);
        	}
        	System.out.println(" ---------------------------------end-------------------------------------------------");
         	model.put("mainForm", mainForm);
         	System.out.println(" catgory list ---> "+categorylist.isEmpty());
         	if(categorylist.isEmpty())
         	{
         	categorylist=(List) session.getAttribute("baselookups");
         	System.out.println(" Inside if condition -------->"+categorylist.size());
         	model.put("categorylist", categorylist);	
         	}else
         	{
         	model.put("categorylist", categorylist);
         	System.out.println(" Inside else condition -------->"+categorylist.size());
         	}
 	
 		}catch(Exception e)
 		{
 			e.printStackTrace();
 			 System.out.println(" <------Controller catch temLookups --------->");
 		}
 	   return forwardpage;            	  }
	
	/**
	 * Deletelookups.
	 *
	 * @param request the request
	 * @param model the model
	 * @param map the map
	 * @param id the id
	 * @param mainForm the main form
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping(value="/systemLookups/delete" , method=RequestMethod.GET)
	public String deletelookups(HttpServletRequest request, Map model, ModelMap map, @RequestParam("categoryid") String id,
			@ModelAttribute(value = "mainForm")MainForm  mainForm) throws Exception
	{
		//String id =(String)request.getAttribute("categoryid");
		String categoryType=(String) request.getAttribute("categorytype");
		System.out.println(" id---->"+id);
		String[] val=id.split("=");
		System.out.println("THE ID VALUE"+val[0].toString());
		System.out.println("THE CATEGORY VALUE"+val[1].toString());
		String value=id+","+categoryType;
		System.out.println(" Category Type ------------>"+categoryType);
		List lookups=new ArrayList();
		HttpSession session=request.getSession();
		List list=memberservice.deleteSystemlookups(value);	
		lookups=list;
		mainForm.setCategotyType(val[1].toString());
		mainForm.setDispatch("view");
		testurl(request, model, map, mainForm);
		return "systemLookups";
	}
	
	
	@RequestMapping(value="/systemLookups/save" , method=RequestMethod.POST)
	public String savelookups( @RequestParam(value="saveid") String saveid, HttpServletRequest request, Map model, ModelMap map,
			@ModelAttribute(value = "mainForm")MainForm  mainForm1) throws Exception
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
			
			if(i==3 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				Description=val[i];
			}
			else if(i==4 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				Startdate=val[i];
			}
			else if(i==5 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				endDate=val[i];
			}
			else if(i==6 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				checkbox=val[i];
			}
		}
		
		
		mainForm1=memberservice.saveinline(val[1].toString(),  val[2].toString(), Description, Startdate, endDate, checkbox, str);
		System.out.println("---IN CATEGORY VALUE IN CONTROLLER--"+val[0].toString());
		mainForm1.setLookups(null);
		mainForm1.setCategotyType(val[0].toString());
		mainForm1.setDispatch("view");
		testurl(request, model, map, mainForm1);	
		return "systemLookups";
			}
	
	
	@RequestMapping(value="/systemLookups/newsave" , method=RequestMethod.POST)
	public String savenewlookups( @RequestParam(value="newsaveid") String saveid, HttpServletRequest request, Map model, ModelMap map,
			@ModelAttribute(value = "mainForm")MainForm  mainForm1) throws Exception
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
			
			if(i==3 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				Description=val[i];
			}
			else if(i==4 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				Startdate=val[i];
			}
			else if(i==5 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				endDate=val[i];
			}
			else if(i==6 && val[i].length()!=0)
			{
				System.out.println("THE LENGTH"+val[i].length());
				checkbox=val[i];
			}
		}
		
		
		mainForm1=memberservice.systemlinesave(val[0].toString(), val[1].toString(),  val[2].toString(), Description, Startdate, endDate, checkbox, str, mainForm1);
		System.out.println("---IN CATEGORY VALUE IN CONTROLLER--"+val[0].toString());
		mainForm1.setLookups(null);
		mainForm1.setCategotyType(val[0].toString());
		mainForm1.setDispatch("view");
		
		testurl(request, model, map, mainForm1);	
		return "systemLookups";
			}
	
	}
	
	
	
	
