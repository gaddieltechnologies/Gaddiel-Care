package org.gaddiel.model;

import org.junit.Test;

import org.gaddiel.dao.MemberDao;
import org.gaddiel.form.MainForm;
import org.gaddiel.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractSystemUsersTest.
 */
@ContextConfiguration(locations={"AbstractSystemUsersTest-context.xml"})
public class AbstractSystemUsersTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	/** The member dao. */
	@Autowired
	 protected MemberDao memberDao;
	 
 	/** The memberservice. */
 	@Autowired
	 protected MemberService memberservice;
	
	 /**
 	 * Sample test.
 	 */
 	@Test
	 public void sampleTest(){
	 String logindetails="admin"+","+"admin";
	 MainForm mainforn=memberservice.validateLogin(logindetails);
	 MainForm mainform=new MainForm();
	 //mainform=memberservice.validateLogin(logindetails);

	   
	 }

}

