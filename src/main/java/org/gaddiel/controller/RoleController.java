package org.gaddiel.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.gaddiel.form.ChurchConfigurationForm;
import org.gaddiel.form.ChurchPrefPopupForm;
import org.gaddiel.form.Lookups;
import org.gaddiel.form.MainForm;
import org.gaddiel.form.RoleForm;
import org.gaddiel.form.RoleUserForm;
import org.gaddiel.form.UserAssignmentForm;
import org.gaddiel.form.UserAssignmentSubForm;
import org.gaddiel.form.UserRoleForm;
import org.gaddiel.model.SystemRoles;
import org.gaddiel.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController
{
	private static final Logger logger = Logger.getLogger(RoleController.class);
	@Autowired
	private MemberService memberservice;
	
	@RequestMapping("/rolesprivileges")
	public String  roleprivilege(HttpServletRequest request,Map model,Map<String ,Object> SystemSubscriberFunctions,@Valid RoleForm functionname,BindingResult result,Map map,@ModelAttribute(value="roleForm")RoleForm roleForm1)
		{
		     HttpSession session=request.getSession();
		     String username=(String)session.getAttribute("username");
			 List sysRoles=memberservice.getroleslist();
			 System.out.println(" <------Inside URL Roles1--------->");
			 RoleForm roleForm=new RoleForm();
			 List privilages=new ArrayList();
			 roleForm1.setUsername(username);
	   	     System.out.println(" dispatch---->"+roleForm1.getDispatch());
		   	  if(roleForm1.getDispatch()==null || roleForm1.getDispatch().equals("null"))
		   	  {
		   		privilages=memberservice.getpriviligeslist(roleForm1);
		   	    roleForm1.setLookups2(privilages);
		   	  }
		   	  if(roleForm1.getDispatch()!=null && roleForm1.getDispatch().equals("submit"))
		   	  {
		   		privilages=memberservice.getpriviligeslist(roleForm1);
		   	    roleForm1.setLookups2(privilages);
		   	  }
	   	     if(roleForm1.getDispatch()!=null && roleForm1.getDispatch().equals("save"))
	   	     {
	   	    	roleForm1=memberservice.saverolelist(roleForm1);
	   	    	
	   	     }
			 System.out.println(" <------Inside URL Roles2--------->"+privilages.size());
			
			 map.put("rolelist", sysRoles);
			 map.put("roleForm", roleForm1);
			 return "rolesprivileges";
		  }
	
	@RequestMapping("/Roles")
	public String usern(UserAssignmentSubForm userAssignmentSubForm,UserAssignmentForm userAssignmentForm,HttpServletRequest request,Map model,ModelMap map,@ModelAttribute(value="UserAssignmentForm")UserAssignmentForm userAssignmentForm1)
		{
		try{
 			
			HttpSession session=request.getSession();
 			List userlist=new ArrayList();
 			 userAssignmentForm.setSessionId(session.getId());
 			System.out.println("--THE DISPATCH VALUE---"+userAssignmentForm1.getDispatch());
			   if(userAssignmentForm1.getDispatch()!=null && userAssignmentForm1.getDispatch().equals("search"))
		   	     {
				   userAssignmentSubForm=memberservice.getuserlist(userAssignmentForm); 
				   userlist=userAssignmentSubForm.getMemberList();
					System.out.println(" userlist----->"+userlist.size());
			    	BeanUtils.copyProperties(userAssignmentForm, userAssignmentSubForm);
				   userAssignmentForm.setListofUser(userlist);
		   	     }
					
			   else if(userAssignmentForm1.getDispatch()!=null && (userAssignmentForm1.getDispatch().equals("next") || userAssignmentForm1.getDispatch().equals("prev")))
		     	{
		     		System.out.println("<---- Inside the  next --->");
		    		int traverse=0;
		    		
		     		if(userAssignmentForm1.getDispatch().equals("next"))
		     		{
		     			System.out.println("----THE PAGE NO----------"+userAssignmentForm1.getPageNo());
		     		     traverse=userAssignmentForm1.getPageNo()+1;
		     		    userAssignmentForm1.setDispatch("next");
		     		}else if(userAssignmentForm1.getDispatch().equals("prev"))
		     		{
		     			 traverse=userAssignmentForm1.getPageNo()-1;
		     			userAssignmentForm1.setDispatch("prev");
		     		}
		       		userAssignmentForm.setPageNo(traverse);
		   
		     		userAssignmentSubForm=memberservice.getcustomTempList(userAssignmentForm);	
		     		userlist=userAssignmentSubForm.getMemberList();
		            	System.out.println(" lookups----->"+userlist.size());
		             	userAssignmentForm.setListofUser(userlist);
		               	session.setAttribute("userlist", userlist);
		               	BeanUtils.copyProperties(userAssignmentForm, userAssignmentSubForm);
		              	userAssignmentForm.setDispatch("next");
		            	
		     	}
			   else
			   {
					List sysRoles=memberservice.getnewroleslist();
		 			map.put("newRoleList", sysRoles);
				   userAssignmentSubForm=memberservice.getuserlist(userAssignmentForm);
					userlist=userAssignmentSubForm.getMemberList();
					System.out.println("THE USERLIST SIZE----->"+userlist.size());
		        	session.setAttribute("userlist", userlist);
		          	BeanUtils.copyProperties(userAssignmentForm, userAssignmentSubForm);
		          	System.out.println(" <------Inside URL Role Controller User Name2--------->"+userlist.size());
					userAssignmentForm.setListofUser(userlist);
			   }
		}catch(Exception e)
		{
			e.printStackTrace();
			 System.out.println(" <------Controller in setroles --------->");
		}
		
		map.put("userAssignmentForm", userAssignmentForm);
 			return "Roles";
		}
	


	
	
/*
	@RequestMapping("/Roles")
	public String roleuser(HttpServletRequest request,Map model,ModelMap map,@ModelAttribute(value="roleUserForm")RoleUserForm roleUserForm)
		{
		try{
 			HttpSession session=request.getSession();
 			RoleUserForm roleUserForm1=new RoleUserForm();
 			roleUserForm1=roleUserForm;
 			List rolelist=new ArrayList();
 		
 		
 			List sysRoles=memberservice.getroleslist();
 			map.put("selectroles", sysRoles);
 			
 			List sysUser=memberservice.getuserlist();
 			map.put("selectuname", sysUser);
 		
 			
 			System.out.println(" roleUserForm1.getDispatch()--------->"+roleUserForm1.getDispatch());
 			if(roleUserForm1.getDispatch()==null || roleUserForm1.getDispatch().equals("") || roleUserForm1.getDispatch().equals("edit"))
 			{
 				System.out.println(" <------Inside URL Role Controller User Name--------->");
 				roleUserForm=memberservice.getuserlist(roleUserForm);
 			
 				System.out.println(" <------Inside URL Role Controller User Name2--------->");
 				System.out.println(" <------Inside URL Rolesuser1--------->");
 				
 				roleUserForm=memberservice.getuserrolelist(roleUserForm);
 				rolelist=roleUserForm.getRolelist();
 	 				 			
 	 			System.out.println(" <------Inside URL Rolesuserlist--------->");
 	 			roleUserForm.setRolelist(rolelist);
 	 			
 	 			if(roleUserForm1.getDispatch()!=null && roleUserForm1.getDispatch().equals("edit"))
 	 			 roleUserForm1.setDispatch("edit");
 			}
 		           
        if(roleUserForm1.getDispatch()!=null && roleUserForm1.getDispatch().equals("search"))
            {  
	        	System.out.println("<----search values --->");
				memberservice.getuserrolelist(roleUserForm);
	        }
        
        else if(roleUserForm1.getDispatch()!=null && roleUserForm1.getDispatch().equals("save"))
          {
        	System.out.println("<-----Save the Row------->");
        	roleUserForm1=memberservice.setrole(roleUserForm1);
        	rolelist=roleUserForm1.getRolelist();
        	session.setAttribute("rolelist", rolelist);
        	roleUserForm1.setRolelist(rolelist);
        	
          }
        
        else if(roleUserForm1.getDispatch()!=null && roleUserForm1.getDispatch().equals("create"))
        {
        	roleUserForm=memberservice.getuserrolelist(roleUserForm);
	 		rolelist=roleUserForm.getRolelist();
	 		System.out.println(" <------Inside URL Rolesuserlist--------->");
	 		roleUserForm.setRolelist(rolelist);
        	System.out.println("<----create new row------> ");
        	
        	rolelist=rolelist;
        	    	UserRoleForm userRoleForm=new UserRoleForm();
        	userRoleForm.setSelectbox("");
        	userRoleForm.setRoleName("");
        	userRoleForm.setSdate("");
        	userRoleForm.setEdate("");
        	userRoleForm.setFlag("");
        	rolelist.add(userRoleForm);
        	roleUserForm.setRolelist(rolelist);
        	roleUserForm.setDispatch("create");
        	      	
        }
        map.put("roleUserForm", roleUserForm);
		}catch(Exception e)
		{
			e.printStackTrace();
			 System.out.println(" <------Controller in setroles --------->");
		}
		
		return "Roles";
		}
	*/	
	@RequestMapping(value="/Roles/rolelist",method=RequestMethod.POST)
	public @ResponseBody List list1(HttpServletRequest request, @Valid ChurchPrefPopupForm churchPrefPopupForm, Map model, ModelMap map,
			@ModelAttribute(value = "churchConfigurationForm")ChurchConfigurationForm  churchConfigurationForm1) throws java.lang.Exception {
		List sysRoles=memberservice.getroleslist();
		map.put("selectroles", sysRoles);
		System.out.println("----------THE LIST SIZE---------"+sysRoles.size());
		return sysRoles;
	}
	
	@RequestMapping(value="/Roles/save", method=RequestMethod.POST)
	public String saveuserrole(HttpServletRequest request,Map model,ModelMap map,@RequestParam("saverole") String id,
			@ModelAttribute(value = "roleUserForm")RoleUserForm  roleUserForm,UserAssignmentSubForm userAssignmentSubForm,
			UserAssignmentForm userAssignmentForm) throws Exception
	{
		HttpSession session=request.getSession();
		String str=(String) session.getAttribute("username");
		String Description=null;
		String Startdate=null;
		String endDate=null;
		String checkbox=null;
		
		System.out.println(" id---->"+id);
		String[] val=id.split(",");
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

		 memberservice.inlinesave(val[0].toString(), val[1].toString(),val[2].toString(), Description, Startdate, endDate, checkbox, str, roleUserForm);

		return "Roles";
	}
	@RequestMapping(value="/Roles/newsave", method=RequestMethod.POST)
	public String newuserrole(HttpServletRequest request,Map model,ModelMap map,@RequestParam("newsaverole") String id,
			@ModelAttribute(value = "roleUserForm")RoleUserForm  roleUserForm,UserAssignmentSubForm userAssignmentSubForm,
			UserAssignmentForm userAssignmentForm) throws Exception
	{
		HttpSession session=request.getSession();
		 userAssignmentForm.setSessionId(session.getId());
		String str=(String) session.getAttribute("username");
		String Description=null;
		String Startdate=null;
		String checkbox=null;
		
		System.out.println(" id---->"+id);
		String[] val=id.split(",");
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
				checkbox=val[i];
			}
		}

		roleUserForm= memberservice.newinlinesave(val[0].toString(), val[1].toString(), Description, Startdate, checkbox, str, roleUserForm);
		 usern(userAssignmentSubForm,userAssignmentForm,request,model,map,userAssignmentForm);
		return "Roles";
	}
	@RequestMapping(value="/Roles/delete", method=RequestMethod.GET)
	public String deluserrole(HttpServletRequest request,Map model,ModelMap map,@RequestParam("deleteId") String id,
			@ModelAttribute(value = "userAssignmentForm")UserAssignmentForm userAssignmentForm) throws Exception
	{
		UserAssignmentSubForm userAssignmentSubForm=new UserAssignmentSubForm();
			System.out.println("---------------IN DELETE FUNCTION-----");	
			System.out.println(" id---->"+id);
			String num[]=id.split(",");
			int userid=Integer.parseInt(num[1].toString());
			int roleassignid=Integer.parseInt(num[2].toString());
			memberservice.deluserrole(userid,roleassignid);	
			usern(userAssignmentSubForm,userAssignmentForm,request,model,map,userAssignmentForm);
			return "redirect:Roles";
	}
	
	

	
}
