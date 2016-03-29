package org.gaddiel.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.gaddiel.form.MainForm;
import org.gaddiel.model.SystemRolePrivileges;
import org.gaddiel.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.SimpleFormController;


// TODO: Auto-generated Javadoc
/**
 * The Class MemberController.
 */
@Controller

public class MemberController extends SimpleFormController {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(MemberController.class);
	
	/** The memberservice. */
	@Autowired
	private MemberService memberservice;
	
	/**
	 * Show form.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/index")
	public String showForm(HttpServletRequest request, Map model)
	{
		HttpSession session=request.getSession();
		MainForm myform= new MainForm();
		model.put("myform", myform);
		 session.removeAttribute("DELETE");
		 session.removeAttribute("INSERT");
		 session.removeAttribute("UPDATE");
		 session.removeAttribute("READ");
		 session.removeAttribute("REPORT");
		 session.removeAttribute("userprivillege");
		return "index";
	}
	
	/**
	 * List member.
	 *
	 * @param model the model
	 * @param request the request
	 * @param memberlist the memberlist
	 * @param member the member
	 * @param result the result
	 * @param map the map
	 * @return the string
	 */
	@RequestMapping(value="/login")
	public String  listMember(Map model, HttpServletRequest request, Map<String , Object> memberlist, @Valid MainForm member, BindingResult result, 
			ModelMap map,@RequestParam("flag") String flag)
	{
		HttpSession session=request.getSession();		
		logger.debug("Received request to show all persons");
		String returnval="";
		try
		{
		System.out.println(" flag --------->"+flag);
		if(flag!=null && flag.equals("false"))
		{
			logger.info("result.hasErrors()-----> "+result.hasErrors()+"- \tUsername in form->"+member.getUserName()+"\t"+member.getPassword());
			String username=member.getUserName();
			session.setAttribute("username", username);
			if(result.hasErrors())
			{
				returnval= "index";
			}
			String logindetails=member.getUserName().trim()+","+member.getPassword().trim();
			MainForm mainForm=memberservice.validateLogin(logindetails);
			System.out.println(" last updated date -------------->"+mainForm.getLastlogin());
	    	boolean validate=mainForm.isValidate();
	    	map.put("myform", mainForm);
	    	session.setAttribute("username", mainForm.getUserName());
	    	session.setAttribute("lastlogin", mainForm.getLastlogin());
	    	session.setAttribute("userprivillege", mainForm.getUserInfo());
	    	session.setAttribute("lastfailed", mainForm.getLastFailedLogin());
	    	if(validate)
			{
	    		returnval= "Ex1";
			}else 
			{
				returnval= "redirect:index";	
			}
		}else if(flag!=null && flag.equals("true"))
		{
			returnval= "Ex1";
		}
		}catch(Exception e)
		{
			returnval= "redirect:index";	
		}
		  return returnval;
		
	}
	
	/**
	 * Testurls.
	 *
	 * @param model the model
	 * @param memberlist the memberlist
	 * @param member the member
	 * @param result the result
	 * @param map the map
	 * @return the string
	 */
	@RequestMapping("/testurl")
	public String   testurls(Map model, Map<String , Object> memberlist, @Valid MainForm member, BindingResult result, ModelMap map)
	 	  {
	//	map.put("memberlist", memberservice.getmemberlist());
	   MainForm myform  = new MainForm();
	   map.put("member", myform);
	   System.out.println(" <------Inside URL --------->");
	   return "Ex12";
	  }
	
	/**
	 * Testurls.
	 *
	 * @param model the model
	 * @param srp the srp
	 * @param request the request
	 * @param map the map
	 * @return the string
	 */
	@RequestMapping("/SysRolePrivileges")
	public String   testurls(Map model, @Valid SystemRolePrivileges srp, HttpServletRequest request, ModelMap map)
	 	  {
		
		  map.put("SysRolePrivileges", srp);
	   SystemRolePrivileges SysRolePrivileges = new SystemRolePrivileges();
	   map.put("srp", SysRolePrivileges);
	   System.out.println(" <------Inside URL SystemRolePrivileges --------->");
	   return "SysRolePrivileges";
	  }
	
	
	

	//@RequestMapping(value="/edit" ,method=RequestMethod.POST)
	
	
	/**
	 * Directpage.
	 *
	 * @param model the model
	 * @param memberlist the memberlist
	 * @param member the member
	 * @param result the result
	 * @param map the map
	 * @return the string
	 */
	@RequestMapping(value="/churchconfig" , method=RequestMethod.POST)
	public String  directpage(Map model, Map<String , Object> memberlist, @Valid MainForm member, BindingResult result, ModelMap map)
	{
		System.out.println(" ------> In church configuration");
	 return"Ex12";
	}
		
}
