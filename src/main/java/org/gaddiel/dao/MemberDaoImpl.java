/*
 * 
 */
package org.gaddiel.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.MultiHashMap;
import org.apache.struts2.ServletActionContext;
import org.gaddiel.form.ChurchAddressPopup;
import org.gaddiel.form.ChurchAddressSubForm;
import org.gaddiel.form.ChurchConfigPopupForm;
import org.gaddiel.form.ChurchConfigurationForm;
import org.gaddiel.form.ChurchContactsPopup;
import org.gaddiel.form.ChurchContactsSubForm;
import org.gaddiel.form.ChurchPrefCustomForm;
import org.gaddiel.form.ChurchPreferencesForm;
import org.gaddiel.form.CollectionRegistersForm;
import org.gaddiel.form.CollectionRegistersSubForm;
import org.gaddiel.form.ContributionSchedulesForm;
import org.gaddiel.form.ContributionSchedulesSubForm;
import org.gaddiel.form.CustomLookupsForm;
import org.gaddiel.form.FamilypopupForm;
import org.gaddiel.form.Lookups;
import org.gaddiel.form.MainForm;
import org.gaddiel.form.RoleForm;
import org.gaddiel.form.RoleForm2;
import org.gaddiel.form.RoleUserForm;
import org.gaddiel.form.SubscriptionPaidForm;
import org.gaddiel.form.SubscriptionPlanForm;
import org.gaddiel.form.SystemLookupsForm;

import org.gaddiel.form.UserAssignmentForm;
import org.gaddiel.form.UserAssignmentSubForm;

import org.gaddiel.form.LookupspopupForm;
import org.gaddiel.form.UserRoleForm;
import org.gaddiel.model.ChurchActivityAddresses;
import org.gaddiel.model.ChurchAddressContacts;
import org.gaddiel.model.ChurchConfiguration;
import org.gaddiel.model.ChurchPreferences;
import org.gaddiel.model.CollectionsRegister;
import org.gaddiel.model.ContributionSchedules;
import org.gaddiel.model.CustomLookupCategories;
import org.gaddiel.model.CustomLookupValues;
import org.gaddiel.model.Family;
import org.gaddiel.model.SubscriptionPlan;
import org.gaddiel.model.SystemLookupValues;
import org.gaddiel.model.SystemRolePrivileges;
import org.gaddiel.model.SystemRoles;
import org.gaddiel.model.SystemUserRoleAssignments;

import org.gaddiel.model.SystemUsers;
import org.gaddiel.model.TempPagination;
import org.gaddiel.util.Converter;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.gaddiel.model.Userprivilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.core.io.Resource;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberDaoImpl.
 */
@Repository
public class MemberDaoImpl  extends BaseDaoImpl implements MemberDao{
/** The session factory. */
@Autowired
private SessionFactory sessionFactory;
/** The hibernate template. */
private HibernateTemplate hibernateTemplate;

//@Qualifier("queryProperties")
//private Properties queryProperties;

ResourceBundle rb = ResourceBundle.getBundle("query");


/**
* Member dao impl.
*
* @param sessionFactory the session factory
*/
@Autowired
public MemberDaoImpl(SessionFactory sessionFactory) {
this.hibernateTemplate = new HibernateTemplate(sessionFactory);
}
/* (non-Javadoc)
* @see org.gaddiel.dao.MemberDao#existingLookups(java.util.List)
*/
public List existingLookups(List churchlookups) {
List list = hibernateTemplate.find(" select systemLookupValueId from ChurchPreferences ");
List<String> functionlist = new ArrayList();
List<Integer> list2 = new ArrayList();
int obj;
for (int i = 0; i < list.size(); i++) {
obj = (Integer) list.get(i);
list2.add(obj);
System.out.println("----------Object Value Id" + list2);
}
if (list2.size() == 0) {
functionlist.add(null);
} else {
Integer [] ids = list2.toArray(new Integer[list2.size()]);
 System.out.println("----------Value Id" + ids[0]);
for (int i = 0; i < list.size(); i++) {
List list1=hibernateTemplate.find("  select distinct systemLookupCategory from SystemLookupValues where systemLookupValueId='"+ids[i]+"'");
functionlist.addAll(list1);
}
}
System.out.println("---The Name---" + functionlist.toString());
String [] idname = functionlist.toArray(new String[functionlist.size()]);
System.out.println("---The IDName---" + idname);
for (int i = 0; i < functionlist.size(); i++) {
System.out.println("---The INLOOP IDName---" + idname[i]);
}
List list1 = hibernateTemplate.find("  select distinct systemLookupCategory from SystemLookupValues where systemLookupCategory not in("+Converter.StringArrayToString(idname)+")");
System.out.println("-------THE LOOKUP CATEGORY SIZE" + list1.size());
return list1;
}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#existingLookupsinchurch()
	 */
public List existingLookupsinchurch() {
List list = hibernateTemplate.find(" select systemLookupValueId from ChurchPreferences ");
List total = new ArrayList();
System.out.println("---------churchPreferences list ---;" + list.size());
for (int i = 0; i < list.size(); i++) {
int obj = (Integer) list.get(i);
List list1=hibernateTemplate.find(" select systemLookupCategory  from SystemLookupValues where systemLookupValueId='"+obj+"' ");
total.add(list1);
}
System.out.println("---------total-----------" + total.size());
return total;
}
	
/* (non-Javadoc)
 * @see org.gaddiel.dao.MemberDao#getpopuplist(java.lang.String)
 */
public List getpopuplist(String name) {
List list = hibernateTemplate.find(" select systemLookupValue  from SystemLookupValues where systemLookupCategory='"+name+"' and systemLookupValue not in ('select') ");
return list;
}

public List getcustomlist(int name) {
List list = hibernateTemplate.find(" select customLookupValue  from CustomLookupValues where customLookupCategoryId='"+name+"'");
return list;
}




public List getchurchtypelist(String name) {
List list1=new ArrayList();
ChurchConfigurationForm churchConfigurationForm=new ChurchConfigurationForm();
try{
List list = hibernateTemplate.find(" from SystemLookupValues where systemLookupCategory='"+name+"' and systemLookupValue not in ('select') ");
for(int i=0;i<list.size();i++)
{

	SystemLookupValues systemLookupValues=(SystemLookupValues)list.get(i);
	churchConfigurationForm=new ChurchConfigurationForm();
	churchConfigurationForm.setChurchTypeId(systemLookupValues.getSystemLookupValueId()==null ?null:Integer.parseInt(systemLookupValues.getSystemLookupValueId().toString()));
	churchConfigurationForm.setChurchTypeValue(systemLookupValues.getSystemLookupValue()==null?"":systemLookupValues.getSystemLookupValue());
	list1.add(churchConfigurationForm);
}}catch(Exception e)
{
	e.printStackTrace();
}
return list1;
}


public List getaddnewpreflist() {
List categorylist=new ArrayList();	
List prelist=hibernateTemplate.find("select sys.systemLookupCategory from ChurchPreferences cp,SystemLookupValues sys where cp.systemLookupValueId=sys.systemLookupValueId ");
String queryString="";
for(int i=0;i<prelist.size();i++)
{
	Object obj1=(Object)prelist.get(i);
	String add;
	add="'"+obj1.toString()+"'";
	if(i!=0)
	{	
	queryString=queryString+','+add;
	}	
	else
	{	
		queryString=add;
	}	
}

List list = hibernateTemplate.find("  select distinct  systemLookupCategory  from SystemLookupValues where systemLookupCategory not in("+queryString+") ");
return list;
}


public List getaddnewcustompreflist() {

/*List prelist=hibernateTemplate.find("select cus.customLookupValueId from ChurchPreferences cp,CustomLookupValues cus where cp.customLookupValueId=cus.customLookupValueId ");
String queryString="";
for(int i=0;i<prelist.size();i++)
{
	Object obj1=(Object)prelist.get(i);
	String add;
	add="'"+obj1.toString()+"'";
	if(i!=0)
	{	
	queryString=queryString+','+add;
	}	
	else
	{	
		queryString=add;
	}	
}
System.out.println("---THE LIST OF IDS----"+queryString);

List list = hibernateTemplate.find("  select distinct  customLookupCategoryId  from CustomLookupValues where customLookupValueId  in("+queryString+") ");
System.out.println("---THE LIST OF IDS----"+list);
String RoleId=list.toString();
RoleId=RoleId.replace('[',' ');
RoleId=RoleId.replace(']',' ');
RoleId=RoleId.trim();
*/
List categorylist=hibernateTemplate.find("  select distinct  customLookupCategory  from CustomLookupCategories ");

return categorylist;
}


public List getaddnewnamelist(String name) {
List list1=new ArrayList();
ChurchConfigurationForm churchConfigurationForm=new ChurchConfigurationForm();
try{
List list = hibernateTemplate.find(" from SystemLookupValues where systemLookupCategory='"+name+"' and systemLookupValue not in ('select') ");
for(int i=0;i<list.size();i++)
{

	SystemLookupValues systemLookupValues=(SystemLookupValues)list.get(i);
	churchConfigurationForm=new ChurchConfigurationForm();
	churchConfigurationForm.setId(systemLookupValues.getSystemLookupValueId()==null ?"":systemLookupValues.getSystemLookupValueId().toString());
	churchConfigurationForm.setValue(systemLookupValues.getSystemLookupValue()==null?"":systemLookupValues.getSystemLookupValue());
	list1.add(churchConfigurationForm);
}}catch(Exception e)
{
	e.printStackTrace();
}
return list1;
}

public List getcustomaddnewnamelist(String name) {
List list1=new ArrayList();
ChurchConfigurationForm churchConfigurationForm=new ChurchConfigurationForm();
try{
	List list = hibernateTemplate.find("select customLookupCategoryId from CustomLookupCategories where customLookupCategory='"+name+"'");	
	String CID=list.toString();
	CID=CID.replace('[',' ');
	CID=CID.replace(']',' ');
	CID=CID.trim();
List clist = hibernateTemplate.find(" from CustomLookupValues where customLookupCategoryId='"+CID+"'");
for(int i=0;i<clist.size();i++)
{

	CustomLookupValues customLookupValues=(CustomLookupValues)clist.get(i);
	churchConfigurationForm=new ChurchConfigurationForm();
	churchConfigurationForm.setCustomid(customLookupValues.getCustomLookupValueId()==null ?"":customLookupValues.getCustomLookupValueId().toString());
	churchConfigurationForm.setCustomvalue(customLookupValues.getCustomLookupValue()==null?"":customLookupValues.getCustomLookupValue());
	list1.add(churchConfigurationForm);
}}catch(Exception e)
{
	e.printStackTrace();
}
return list1;
}



/* (Javadoc)
* @see org.gaddiel.dao.MemberDao#saveprefvalues(java.lang.String, java.lang.String, org.gaddiel.form.ChurchPreferencesForm)
*/
/* (non-Javadoc)
 * @see org.gaddiel.dao.MemberDao#saveprefvalues(java.lang.String, java.lang.String, org.gaddiel.form.ChurchPreferencesForm)
 */
public ChurchPreferencesForm saveprefvalues(String name,String str1,ChurchPreferencesForm churchPreferencesForm)
{
name = name.trim();
List<Object> list = hibernateTemplate.find(" select distinct systemLookupValueId,systemLookupCategory from SystemLookupValues where systemLookupValue='" + name + "'");
Object[] obj = (Object[]) list.get(0);
String obj1 = obj[0].toString();
obj1 = obj1.replace('[', ' ');
obj1 = obj1.replace(']', ' ');
obj1 = obj1.trim();
int id = Integer.parseInt(obj1);
String obj2 = obj[1].toString();
obj2 = obj2.replace('[', ' ');
obj2 = obj2.replace(']', ' ');
obj2 = obj2.trim();
String strDate = "12-02-2012";
Date now = null;
try {
now = Converter.StringtoDateforDB(strDate);
} catch (ParseException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
List systemlist=hibernateTemplate.find(" select distinct systemLookupValueId from SystemLookupValues where systemLookupCategory='"+obj2+"' and systemLookupValue='"+str1+"'");
String obj3 = systemlist.get(0).toString();
obj3 = obj3.replace('[', ' ');
obj3 = obj3.replace(']', ' ');
obj3 = obj3.trim();
int idname = Integer.parseInt(obj3);
List list1=hibernateTemplate.find(" from ChurchPreferences where systemLookupValueId='"+idname+"'");
ChurchPreferences churchPreferences = (ChurchPreferences) list1.get(0);
churchPreferences.setSystemLookupValueId(id);
churchPreferences.setChurchId(1);
churchPreferences.setStartDate(now);
churchPreferences.setEndDate(now);
churchPreferences.setCreatedDate(now);
churchPreferences.setLastUpdatedDate(now);
hibernateTemplate.saveOrUpdate(churchPreferences);
		return churchPreferencesForm;
	}
	
/* (non-Javadoc)
* @see org.gaddiel.dao.MemberDao#deletepreferences(java.lang.String, java.lang.String)
*/
public ChurchPreferences  deletepreferences(String Value, String name)
{
System.out.println("THE VALUE AND NAME"+Value+"" +name);
List remaininglist = new ArrayList();
List list=hibernateTemplate.find("select systemLookupValueId  from SystemLookupValues where systemLookupCategory='"+Value+"' and systemLookupValue='"+name+"'");
Object id = (Object) list.get(0);
System.out.println("The value" + Integer.parseInt(id.toString()));
List list1=hibernateTemplate.find("from ChurchPreferences where systemLookupValueId='"+Integer.parseInt(id.toString())+"'");
ChurchPreferences  churchPreferences = (ChurchPreferences) list1.get(0);
hibernateTemplate.delete(churchPreferences);
return churchPreferences;
}
	
public ChurchPreferences  deletecustompreferences(String Value, String name)
{
System.out.println("THE VALUE AND NAME"+Value+"" +name);
List remaininglist = new ArrayList();
List list2=hibernateTemplate.find("select customLookupCategoryId  from CustomLookupCategories where customLookupCategory='"+Value+"' ");
Value=list2.toString();
Value=Value.replace('[',' ');
Value=Value.replace(']',' ');
Value=Value.trim();
List list=hibernateTemplate.find("select customLookupValueId  from CustomLookupValues where customLookupCategoryId='"+Value+"' and customLookupValue='"+name+"'");
Object id = (Object) list.get(0);
System.out.println("The value" + Integer.parseInt(id.toString()));
List list1=hibernateTemplate.find("from ChurchPreferences where customLookupValueId='"+Integer.parseInt(id.toString())+"'");
ChurchPreferences  churchPreferences = (ChurchPreferences) list1.get(0);
hibernateTemplate.delete(churchPreferences);
return churchPreferences;
}

/* (non-Javadoc)
* @see org.gaddiel.dao.MemberDao#saveexistingLookupsinchurch(org.gaddiel.form.ChurchConfigPopupForm, java.util.List)
*/
public ChurchPreferences saveexistingLookupsinchurch(ChurchConfigPopupForm churchConfigPopupForm, List existinglooksinchurch) 
{
List id = new ArrayList();
List namelist = new ArrayList();
HashMap map = new HashMap();
String obj1 = null;
for(int i=0; i<existinglooksinchurch.size(); i++)
{	
obj1=existinglooksinchurch.get(i).toString();
obj1=obj1.replace('[', ' ');
obj1=obj1.replace(']', ' ');
obj1=obj1.trim();
List key=hibernateTemplate.find("select distinct systemLookupValueId from SystemLookupValues where systemLookupCategory='"+obj1+"' and systemLookupValue='Select'");
System.out.println("KEY VALUES"+key);
System.out.println("The Value of String:"+key);
String key1=key.toString();
key1=key1.replace('[', ' ');
key1=key1.replace(']', ' ');
System.out.println("THE VALUE AFTER REPLACE:"+key1);
key1=key1.trim();
int id1=Integer.parseInt(key1);
map.put(id1, obj1);
System.out.println("MAP VALUE:"+map);
}
System.out.println("THE VALUE OF SELECTED ITEM:"+churchConfigPopupForm.getSelectto().size());
System.out.println("MAP VALUE:"+map);
for(int j=0; j<churchConfigPopupForm.getSelectto().size(); j++)
{
System.out.println("MAP VALUE----of Contains Selected value"+map.containsValue(churchConfigPopupForm.getSelectto().get(j)));
if(map.containsValue(churchConfigPopupForm.getSelectto().get(j))==true)
{
System.out.println("THE VALUE ALREADY EXISTS SAVE CANT BE DONE:");
} else {
System.out.println("THE VALUE IN ELSE PART:"+churchConfigPopupForm.getSelectto().get(j));
System.out.println("THE MAP VALUE OF SELECTED LIST:"+map.get(churchConfigPopupForm.getSelectto().get(j)));
String str=churchConfigPopupForm.getSelectto().get(j).toString();
List list=hibernateTemplate.find(" select distinct systemLookupValueId from SystemLookupValues where systemLookupCategory='"+str+"' and systemLookupValue='Select'");
				id.add(list);	
			}
		}
System.out.println("The Id List:"+id);
		System.out.println("The Id List Size:"+id.size());
		System.out.println("churchConfigPopupForm.getSelectto().size()"+churchConfigPopupForm.getSelectto().size());
	
		 String strDate = "12-02-2012";
			Date now = null;
			try {
				now=Converter.StringtoDateforDB(strDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		ChurchPreferences churchPreferences=new ChurchPreferences();
		for(int i=0; i<id.size(); i++)
		{
		String obj=id.get(i).toString();
		String[] obj2=obj.split(",");
		for(int j=0; j<obj2.length; j++)
		{
			
			System.out.println("The Value of String:"+obj2[j]);
			String obj3=obj2[j];
			System.out.println("--THE VALE OF INTIAL--"+obj3.charAt(0));
			String obj4=obj3.replace('[', ' ');
			System.out.println("THE VALUE AFTER REPLACE:"+obj4);
			obj4=obj4.replace(']', ' ');
			System.out.println("THE VALUE AFTER REPLACE:"+obj4);
			obj4=obj4.trim();
			int id1=Integer.parseInt(obj4);
		churchPreferences.setSystemLookupValueId(id1);
		churchPreferences.setChurchId(1);
		churchPreferences.setStartDate(now);
		churchPreferences.setEndDate(now);
		churchPreferences.setCreatedDate(now);
		churchPreferences.setLastUpdatedDate(now);
		hibernateTemplate.saveOrUpdate(churchPreferences);
		}
		
	
		}
		System.out.println("The Data Has been Successfully Entered:");
		return churchPreferences;
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getroleslist()
	 */
	public List getroleslist() {
		// TODO Auto-generated method stub
		List sysRoles=new ArrayList();
		
		try
		{
		
		List sysRoleslist=hibernateTemplate.find(" select roleId,roleName from SystemRoles ");
		for(int i=0; i<sysRoleslist.size(); i++)
		{
			Object[] obj=(Object[]) sysRoleslist.get(i);
			RoleForm roleForm=new RoleForm();
			roleForm.setRoleId(obj[0].toString());
			roleForm.setRoleName(obj[1].toString());
			//SystemRoles roleForm=(SystemRoles)sysRoles.get(i);
			sysRoles.add(roleForm);
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sysRoles;
	}
	public List getnewroleslist() {
		List sysRoleslist=hibernateTemplate.find(" select roleName from SystemRoles ");
		return sysRoleslist;
	}
	
	public List getusernamelist() {
		// TODO Auto-generated method stub
		List sysUser=new ArrayList();
		
		try
		{
		
		List sysUserlist=hibernateTemplate.find(" select userId,userName from SystemUsers ");
		for(int i=0; i<sysUserlist.size(); i++)
		{
			Object[] obj=(Object[]) sysUserlist.get(i);
			UserAssignmentForm userAssignmentForm1=new UserAssignmentForm();
			userAssignmentForm1.setUserId(obj[0].toString());
			userAssignmentForm1.setUserName(obj[1].toString());
			
			sysUser.add(userAssignmentForm1);
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sysUser;
	}
	
	public UserAssignmentSubForm getuserlist(UserAssignmentForm userAssignmentForm)throws Exception {
		// TODO Auto-generated method stub
		List listofUser=new ArrayList();
		
	
		System.out.println("-----THE SEARCH VALUE-----"+userAssignmentForm.getSearchUser());
		String searchstring=userAssignmentForm.getSearchUser();
		List sysUserlist=new ArrayList();
		UserAssignmentSubForm sysUser=new UserAssignmentSubForm();
		
		String viewlist="";
		
	
		
		if(searchstring!=null && searchstring!="")
		{
		searchstring=searchstring+"%";
		sysUserlist=hibernateTemplate.find("select userId,userName,roleId,lastActivityDesc,startDate,enabledFlag from SystemUsers where deleteFlag not in('D') and userName like '"+searchstring+"' ");
		}
		else
	
		{
			viewlist="select userId,userName,roleId,lastActivityDesc,startDate,enabledFlag from SystemUsers where deleteFlag not in('D')";
			if(userAssignmentForm.getSortValue()!=null && userAssignmentForm.getSortValue().equals("sortasc"))
			{
				viewlist=viewlist+" order by userName asc";
			}else if(userAssignmentForm.getSortValue()!=null && userAssignmentForm.getSortValue().equals("sortdes"))
			{
				viewlist=viewlist+" order by userName desc";
			}
			sysUserlist=hibernateTemplate.find(viewlist);
			
		System.out.println(" ---userrolelist DaoImpl  2 ---->");
		}
		for(int i=0; i<sysUserlist.size(); i++)
		{
			System.out.println(" ---userlist DaoImpl 3-1---->");
			Object[] obj=(Object[])sysUserlist.get(i);
			sysUser=new UserAssignmentSubForm();
			Object uId=(Object)obj[0];
			sysUser.setUserId(uId.toString());
			System.out.println("UserId--->>"+uId);
			sysUser.setUserName(obj[1].toString());
			System.out.println("UserName--->>"+obj[1]);
			List roleidlist=hibernateTemplate.find("select roleName from SystemRoles where roleId='"+obj[2]+"'");
			String RoleId=roleidlist.toString();
			RoleId=RoleId.replace('[',' ');
			RoleId=RoleId.replace(']',' ');
			RoleId=RoleId.trim();
			sysUser.setRoleId(RoleId);
			System.out.println("RoleID--->>"+roleidlist.toString());
			sysUser.setLastActivityDesc(obj[3]==null?"":obj[3].toString());
			System.out.println("Desc--->>"+obj[3]);
			sysUser.setStartDate(obj[4]==null || obj.equals("null")?"":Converter.FormatDate(obj[4].toString()));
			System.out.println("Sdate--->>"+obj[4]);
			sysUser.setEnabledFlag(obj[5].toString());
			System.out.println("Eflag--->>"+obj[5]);
			List roleassignlist=hibernateTemplate.find("select roleAssignmentId from SystemUserRoleAssignments where  userId='"+uId+"' and endDate is null  and deleteFlag not in('D')");
			String RoleAssignMents=roleassignlist.toString();
			RoleAssignMents=RoleAssignMents.replace('[',' ');
			RoleAssignMents=RoleAssignMents.replace(']',' ');
			RoleAssignMents=RoleAssignMents.trim();
			sysUser.setRoleAssignMents(RoleAssignMents);
			System.out.println("ROLES ASSIGNMENTS--->>"+RoleAssignMents);
			listofUser.add(sysUser);
		}
		System.out.println(" ---userlist DaoImpl 4---->"+listofUser.size());
		sysUser.setMemberList(listofUser);
        System.out.println(" lookuplist size-------------> "+listofUser.size());
		System.out.println(" <-------------------------BLOB SAVE STARTS------------------------------------->");
		System.out.println(" Session Id--------------->"+userAssignmentForm.getSessionId());
		ByteArrayInputStream bytearrayinputstream1 =saveBLOB(listofUser);
		if(userAssignmentForm.getDispatch()==null)
			userAssignmentForm.setDispatch("view");
		if(!userAssignmentForm.getDispatch().equals("report")){			
		List pagelist =hibernateTemplate.find(" from TempPagination where sessionId='"+userAssignmentForm.getSessionId()+"'");
		if(pagelist!=null && pagelist.size()>0)
		{
			TempPagination tempPagination=(TempPagination)pagelist.get(0);
			tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream1));
			tempPagination.setSessionId(userAssignmentForm.getSessionId());
			hibernateTemplate.saveOrUpdate(tempPagination);
			hibernateTemplate.flush();
		}
		else
		{
			TempPagination tempPagination=new TempPagination();
			tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream1));
			tempPagination.setSessionId(userAssignmentForm.getSessionId());
			hibernateTemplate.saveOrUpdate(tempPagination);
			hibernateTemplate.flush();
		}
		System.out.println(" <----------------------------------BLOB SAVED ------------------------------------->");
		return paginationmethod(userAssignmentForm);
		}else
		return sysUser;
	}
	
	
public UserAssignmentSubForm paginationmethod(UserAssignmentForm userAssignmentForm) throws IOException, SQLException, ClassNotFoundException{
		
		List paginationList = new ArrayList(); 
		UserAssignmentSubForm userAssignmentSubForm=new UserAssignmentSubForm();
		List list =hibernateTemplate.find(" from TempPagination where sessionId='"+userAssignmentForm.getSessionId()+"'");
		TempPagination tempPagination=(TempPagination)list.get(0);
		ObjectInputStream stream = new ObjectInputStream(tempPagination.getTempVal().getBinaryStream());//where tempObj.getBlobDetails() returns the java.sql.Blob object
		paginationList = (List) stream.readObject();
		System.out.println(" paginationList-------------->"+paginationList.size());
		int pagesize=10;
		int totallist=paginationList.size();
		int start=0,end=0;
		int pageno=1;
		
	         end = ((pageno-1)*pagesize)+pagesize;  
	
		
		if(end>=totallist){
            end = totallist;
            userAssignmentSubForm.setLastPage(true);
            System.out.println(" End insidec value-->"+end);
           }else{
        	   userAssignmentSubForm.setLastPage(false);
           }
			
		System.out.println(" End value ----------->"+end);
		int total=paginationList.size();
		System.out.println(" total value ----------->"+total);
		userAssignmentSubForm.setMemberList(paginationList.subList(start, end));
		userAssignmentSubForm.setPageNo(pageno);
		userAssignmentSubForm.setStart(start+1);
		userAssignmentSubForm.setEnd(end);
		userAssignmentSubForm.setTotal(total);
		userAssignmentSubForm.setFirstPage(true);
		if(userAssignmentForm.getLastpage()!=null && userAssignmentForm.getLastpage().equals("1"))
		{
			 end = totallist;
			 userAssignmentSubForm.setLastPage(true);
		}			
		return userAssignmentSubForm;
	}



public UserAssignmentSubForm getcustomTempList(UserAssignmentForm getuserTempList) throws IOException, SQLException {
	
	// TODO Auto-generated method stub
	List paginationList = new ArrayList(); 
	UserAssignmentSubForm userAssignmentSubForm=new UserAssignmentSubForm();
	List list =hibernateTemplate.find(" from TempPagination where sessionId='"+getuserTempList.getSessionId()+"'");
	TempPagination tempPagination=(TempPagination)list.get(0);
	ObjectInputStream stream = new ObjectInputStream(tempPagination.getTempVal().getBinaryStream());
	try {
		paginationList = (List) stream.readObject();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(" paginationList-------------->"+paginationList.size());
	System.out.println(" getTempList.getEnd();----------------->"+getuserTempList.getEnd());
	System.out.println(" page No======>"+getuserTempList.getPageNo());
	int pagesize=10,end=0;
	int pageno=getuserTempList.getPageNo();
	int totallist=paginationList.size();
	int start=0;
	//if(totallist >= pagesize){
         end = ((pageno-1)*pagesize)+pagesize;  
	//}
	if(pageno!=1){
           start= ((pageno-1)*pagesize);        
           userAssignmentSubForm.setFirstPage(false);
        }else{           
        	userAssignmentSubForm.setFirstPage(true);            
        }
        
        if(start == 0){
        	userAssignmentSubForm.setFirstPage(true); 
        	userAssignmentSubForm.setStart(start+1);
        }else
        {
        	userAssignmentSubForm.setStart(start);
        }
        
	if(end>=totallist){
       end = totallist;
       userAssignmentSubForm.setLastPage(true);
      }else{
    	  userAssignmentSubForm.setLastPage(false);
      }
	System.out.println(" end-------------->"+end);
				System.out.println(" Last page ------------> "+userAssignmentSubForm.isLastPage());
				System.out.println(" first page ------------> "+userAssignmentSubForm.isFirstPage());
	int total=paginationList.size();
	
	userAssignmentSubForm.setMemberList(paginationList.subList(start, end));

	
	userAssignmentSubForm.setPageNo(pageno);
	
	
	userAssignmentSubForm.setEnd(end);
	userAssignmentSubForm.setTotal(total);
	
	return userAssignmentSubForm;
}

	
	
	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#setrole(org.gaddiel.form.RoleUserForm)
	 */
	@Transactional 
	public RoleUserForm setrole(RoleUserForm roleUserForm) throws Exception{
		System.out.println(" <------------inside the setrole --------------->");
		try
		{
			List role1=roleUserForm.getRolelist();
			
			List list=hibernateTemplate.find(" from SystemRoles ");
			System.out.println("<----list----->"+list.size());
			System.out.println(" role1 list size----->"+role1.size());
			HashMap multimap=new HashMap();
			for(int i=0;i<role1.size();i++)
			{
				
				UserRoleForm userRoleForm=(UserRoleForm)role1.get(i); 
				System.out.println(" Id value -------------->"+userRoleForm.getRoleId());
				String Id=userRoleForm.getRoleId();
				System.out.println(" selectbox value----->"+userRoleForm.getSelectbox());	
				if(userRoleForm.getSelectbox()!=null && userRoleForm.getSelectbox().equals("1")){
				
					if(userRoleForm.getRoleId().equals("") || userRoleForm.getRoleId()==null || userRoleForm.getRoleId().equals("null"))
					{
						List precedence=hibernateTemplate.find(" select max(rolePrecedence) from SystemRoles");
					    Object obj=(Object)precedence.get(0);
					    
					    
						SystemRoles systemRoles =new SystemRoles();
						
						System.out.println("roleid----->>"+userRoleForm.getRoleId());
						systemRoles.setRoleName(userRoleForm.getRoleName());
						System.out.println(" sdate--------->"+userRoleForm.getSdate());
						System.out.println(" edate--------->"+userRoleForm.getEdate());
						systemRoles.setStartDate(Converter.StringtoDateforDB(userRoleForm.getSdate()));
						systemRoles.setEndDate(Converter.StringtoDateforDB(userRoleForm.getEdate()));
						if(userRoleForm.getFlag()!=null)
						systemRoles.setEnabledFlag(userRoleForm.getFlag());
						int precedenceval=Integer.parseInt(obj.toString());
						systemRoles.setRolePrecedence(precedenceval+1);
						systemRoles.setCreatedDate(new Date());
						systemRoles.setLastUpdatedDate(new Date());
						
						hibernateTemplate.saveOrUpdate(systemRoles);
					}
					
				}
				multimap.put(Id, userRoleForm);
			}
		
			System.out.println(" multimap size----->"+multimap.size()+"\t multimap value --/>"+multimap);
			for(int k=0;k<list.size();k++)
			{
				SystemRoles systemRoles1=(SystemRoles) list.get(k);
				UserRoleForm userRoleForm2=(UserRoleForm)multimap.get(systemRoles1.getRoleId().toString());
				System.out.println("---------roleUserForm2--->"+userRoleForm2.getSelectbox());
				System.out.println("------(multimap.containsKey(systemRoles1.getRoleId())--------> "+multimap.containsKey(systemRoles1.getRoleId().toString()));;
				if(userRoleForm2.getSelectbox()!=null && userRoleForm2.getSelectbox().equals("1") && multimap.containsKey(systemRoles1.getRoleId().toString()))
				{
					systemRoles1.setRoleName(userRoleForm2.getRoleName());
					systemRoles1.setStartDate(userRoleForm2.getSdate()==null?new Date():Converter.StringtoDateforDB(userRoleForm2.getSdate()));
				    systemRoles1.setEndDate(userRoleForm2.getEdate()==null?new Date():Converter.StringtoDateforDB(userRoleForm2.getEdate()));
				    System.out.println(" Enabled flag------------>"+userRoleForm2.getFlag()+"------");
					//systemRoles1.setEnabledFlag(userRoleForm2.getFlag()==null || userRoleForm2.getFlag().equals("null")?"":userRoleForm2.getFlag());
					hibernateTemplate.saveOrUpdate(systemRoles1);
				}
			}
			System.out.println("<------- after save the roleusers --------->");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return roleUserForm;
	}
	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#deluserrole(java.lang.String)
	 */
	@Transactional	
	public UserAssignmentForm deluserrole(int id,int roleid) {
		// TODO Auto-generated method stub
		UserAssignmentForm userAssignmentForm=new UserAssignmentForm();
		List remaininglist=new ArrayList();
		List list=hibernateTemplate.find("from SystemUsers where userId='"+id+"'");
		SystemUsers systemUsers=(SystemUsers)list.get(0);
		systemUsers.setDeleteFlag("D");
		systemUsers.setEndDate(new Date());
		hibernateTemplate.saveOrUpdate(systemUsers);
		List list1=hibernateTemplate.find("from SystemUserRoleAssignments where roleAssignmentId='"+roleid+"'");
		SystemUserRoleAssignments systemUserRoleAssignments=(SystemUserRoleAssignments)list1.get(0);
		systemUserRoleAssignments.setDeleteFlag("D");
		systemUserRoleAssignments.setEndDate(new Date());
		hibernateTemplate.saveOrUpdate(systemUserRoleAssignments);
		
		return userAssignmentForm;
	}
    	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#editrole(org.gaddiel.form.RoleUserForm)
	 */
	@Transactional 
	public SystemRoles editrole(RoleUserForm roleUserForm) {
		// TODO Auto-generated method stub
		System.out.println("<---selected edit in daoimpl---->");
		String roleName=roleUserForm.getRoleId();
		System.out.println("-----Role name------"+roleName);
		List list=hibernateTemplate.find("select roleName,startDate,endDate,enabledFlag from SystemRoles where roleId='"+Integer.parseInt(roleName)+"'");
		//List row=hibernateTemplate.find("from systemRoles where roleId='"+roleName+"'");
		SystemRoles systemRoles=(SystemRoles)list.get(0);
		System.out.println("<----after select the list--->");
		return systemRoles;
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getuserrolelist(org.gaddiel.form.RoleUserForm)
	 */
	@Transactional 
	public RoleUserForm getuserrolelist(RoleUserForm roleUserForm)throws Exception {
		// TODO Auto-generated method stub
		List userrole=new ArrayList();
		List list=new ArrayList();
		System.out.println(" ---userrolelist DaoImpl  1 ---->");
		UserRoleForm roleUser=new UserRoleForm();
		String searchval=roleUserForm.getRoleNameSearch();
		if(searchval!=null && searchval!="")
		{
		searchval=searchval+"%";
		list=hibernateTemplate.find("select roleId,roleName,startDate,endDate,enabledFlag from SystemRoles where roleName like'"+searchval+"'");
		}
		else
	
		{
		list=hibernateTemplate.find("select roleId,roleName,startDate,endDate,enabledFlag from SystemRoles");
		System.out.println(" ---userrolelist DaoImpl  2 ---->");
		}
		for(int i=0;i<list.size();i++)
		{
			System.out.println(" ---userrolelist DaoImpl 3---->");
			Object[] obj=(Object[])list.get(i);
			roleUser=new UserRoleForm();
			Object rId=(Object)obj[0];
			roleUser.setRoleId(rId.toString());
			System.out.println("RoleId--->>"+rId);
			roleUser.setRoleName(obj[1].toString());
			System.out.println(" RoleName --->"+obj[1]);
			roleUser.setSdate(obj[2]==null || obj.equals("null")?"":Converter.FormatDate(obj[2].toString()));
			System.out.println(" Sdate --->"+obj[2]);
			roleUser.setEdate(obj[3]==null || obj.equals("null")?"":Converter.FormatDate(obj[3].toString()));
			System.out.println(" Edate --->"+obj[3]);
			roleUser.setFlag("1");
			userrole.add(roleUser);
			
		}
		System.out.println(" ---userrolelist DaoImpl 4---->"+userrole.size());
		roleUserForm.setRolelist(userrole);
		
		return roleUserForm;
	}


	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getpriviligeslist()
	 */
	public List getpriviligeslist() {
		// TODO Auto-generated method stub
		List privilages=new ArrayList();
		try
		{
		
		List list=hibernateTemplate.find("select subfunc.functionName,rolepri.insertFlag,rolepri.updateFlag,rolepri.deleteFlag,rolepri.readFlag,rolepri.rolePrivilgeId,rolepri.subscriberFunctionId from SystemRolePrivileges rolepri,SystemSubscriberFunctions subfunc where rolepri.roleId='4' and subfunc.subscriberFunctionId=rolepri.subscriberFunctionId");
		
		RoleForm2 ss=new RoleForm2();
		for(int i=0; i<list.size(); i++)
		{
			Object[] obj=(Object[]) list.get(i);
			ss=new RoleForm2();
			
			ss.setFunctionName(obj[0].toString());
			ss.setInsertFlag(obj[1].toString());
			ss.setUpdateFlag(obj[2].toString());
			ss.setReadFlag(obj[3].toString());
			ss.setDeleteFlag(obj[4].toString());
			//ss.setSubscriberFunctionId(obj[5].toString());
			privilages.add(ss);
			
			/*privilages.add(obj[0].toString());
			privilages.add(obj[1].toString());
			privilages.add(obj[2].toString());
			privilages.add(obj[3].toString());
			privilages.add(obj[4].toString());
			*/
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return privilages;
	}

	  /* (non-Javadoc)
  	 * @see org.gaddiel.dao.MemberDao#savelookups2(org.gaddiel.form.RoleForm)
  	 */
  	@Transactional 
	public String savelookups2(RoleForm roleForm) throws Exception{
		  // TODO Auto-generated method stub
		  System.out.println(" <------------inside the Role hibernate --------------->");
		  try
		  {
		  List rolelist=roleForm.getLookups2();
		                
		  List list =hibernateTemplate.find("select subfunc.functionName,rolepri.insertFlag,rolepri.updateFlag,rolepri.deleteFlag,rolepri.readFlag,rolepri.rolePrivilgeId,rolepri.subscriberFunctionId from SystemRolePrivileges rolepri,SystemSubscriberFunctions subfunc where rolepri.roleId='4' and subfunc.subscriberFunctionId=rolepri.subscriberFunctionId");
		  
		  HashMap multimap=new HashMap();
		  for(int i=0; i<rolelist.size(); i++)
		  {
		   RoleForm2 roleForm2=(RoleForm2) rolelist.get(i);
		   String id= roleForm2.getRolePrivilgeId();
		   if
		    (roleForm2.getReadFlag()!=null && roleForm2.getReadFlag().equals(id)){
		    multimap.put(id, roleForm2);
		   }
		  }
		   for(int k=0; k<list.size(); k++){
			SystemRolePrivileges systemRolePrivileges=(SystemRolePrivileges) list.get(k);
			RoleForm2 roleForm1=(RoleForm2) multimap.get(systemRolePrivileges.getRolePrivilgeId().toString());
		    if(multimap.containsKey(systemRolePrivileges.getRolePrivilgeId().toString()) )
		    {
		    //systemRolePrivileges.setSystemLookupValue(RoleForm.getFunctionName()==null?null:""); 
		    systemRolePrivileges.setRolePrivilgeId(roleForm1.getRolePrivilgeId()==null || roleForm1.getRolePrivilgeId().equals("")?null:Integer.parseInt(roleForm1.getRolePrivilgeId()));
		     hibernateTemplate.saveOrUpdate(systemRolePrivileges);
		    }
		  
		   }
		  } catch(Exception e)
		  {
			   e.printStackTrace();
			  }
			  return "";
	  }
		 
    /* (non-Javadoc)
     * @see org.gaddiel.dao.MemberDao#ValidateLogin(java.lang.String)
     */
    @Transactional 
    public MainForm validateLogin(String username){
		// TODO Auto-generated method stub
    	MainForm mainForm=new MainForm();
    	Date currentdate=new Date();
		
    	try
    	{
			String Userdata[]=username.split(",");
			System.out.println(" USername-->"+username);
			SystemUsers systemUsers=new SystemUsers();
			SystemUsers systemUsers1=new SystemUsers();
		
		List list1=hibernateTemplate.find("  from SystemUsers where userName='"+Userdata[0]+"' and userPassword='"+Userdata[1]+"' ");
		List failedlist=hibernateTemplate.find("  from SystemUsers where userName='"+Userdata[0]+"' ");
		System.out.println(" list size--- >"+list1.size());
		
		if(list1!=null && list1.size()>0)
		{
			
			   systemUsers=(SystemUsers)list1.get(0);
				String pass=systemUsers.getUserPassword();
				String name= systemUsers.getUserName();
				mainForm.setLastlogin(systemUsers.getLastUpdatedDate()==null?"":Converter.FormatTimestamp(systemUsers.getLastUpdatedDate().toString()));
				mainForm.setLastFailedLogin(systemUsers.getLastFailedLoginDate()==null?"":Converter.FormatTimestamp(systemUsers.getLastFailedLoginDate().toString()));
			
					if(pass.equals(Userdata[1]) && name.equals(Userdata[0]))
					{
					systemUsers.setLastUpdatedDate(currentdate);
					hibernateTemplate.saveOrUpdate(systemUsers);
					mainForm.setValidate(true);
					mainForm.setUserName(name);
					}
			
			HashMap userinfo=new HashMap();
			List list =hibernateTemplate.find(" select roles.subscriberFunctionId,func.functionName,roles.readFlag,roles.updateFlag,roles.deleteFlag,roles.insertFlag,roles.reportFlg  " +
					                           " from SystemUserRoleAssignments assign,SystemRolePrivileges roles,SystemSubscriberFunctions func  " +
					                           " where assign.roleId=roles.roleId and roles.subscriberFunctionId=func.subscriberFunctionId and assign.userId='"+systemUsers.getUserId()+"'");
			System.out.println(" List size---------->"+list.size());
			
			 if(list!=null)
			 {
				 for(int i=0;i<list.size();i++)
				 {
					 Object[] obj=(Object[])list.get(i);
					 Userprivilege userprivilege=new Userprivilege();
					 userprivilege.setFunctionId(obj[0].toString());
					 userprivilege.setFunctionname(obj[1].toString());
					 userprivilege.setReadflag(obj[2]==null?"0":obj[2].toString());
					 userprivilege.setUpdateflag(obj[3]==null?"0":obj[3].toString());
					 userprivilege.setDeleteflag(obj[4]==null?"0":obj[4].toString());
					 userprivilege.setInsertflag(obj[5]==null?"0":obj[5].toString());
					 userprivilege.setReportflag(obj[6]==null?"0":obj[6].toString());
					 userinfo.put(obj[1].toString(), userprivilege);
					
				 }
			 }
			 mainForm.setUserInfo(userinfo);
			
		}
		
		if( list1.size()==0 && failedlist!=null && failedlist.size()>0)
		{
			
			systemUsers1=(SystemUsers)failedlist.get(0);
			mainForm.setLastlogin(systemUsers.getLastUpdatedDate()==null?"":Converter.FormatTimestamp(systemUsers1.getLastUpdatedDate().toString()));
			mainForm.setLastFailedLogin(systemUsers1.getLastFailedLoginDate()==null?"":Converter.FormatTimestamp(systemUsers1.getLastFailedLoginDate().toString()));
			if(!systemUsers1.getUserPassword().equals(Userdata[1]) && systemUsers1.getUserName().equals(Userdata[0]))
			{
				mainForm.setValidate(false);
				mainForm.setUserName(systemUsers1.getUserName());
				systemUsers1.setLastFailedLoginDate(currentdate);
				hibernateTemplate.saveOrUpdate(systemUsers1);
			
			}
			
		}
		
		return mainForm;
		
    	}catch(Exception e)
    	{
    		
    		e.printStackTrace();
    		return mainForm;
    	}
	}

  

	/**
	 * Gets the lookupsvalue1.
	 *
	 * @return the lookupsvalue1
	 */
		
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getaddnewcustomlookupsvalue()
	 */
	public Lookups getaddnewcustomlookupsvalue() {
		List lookuplist=new ArrayList();
		List categorylist=new ArrayList();
		Lookups lookupsValue=new Lookups();
		System.out.println("<------------- Inside the getlookupsvalue ---------> ");
		try{
				
			
				List list=hibernateTemplate.find("select systemLookupCategory,systemLookupValue,systemLookupCode from SystemLookupValues where systemLookupCategory='FUNCTION' ");
				for(int i=0; i<list.size(); i++)
				{
					Object[] obj=(Object[]) list.get(i);
					lookupsValue=new Lookups();
					lookupsValue.setCategoryName(obj[0].toString());
					lookupsValue.setCustomcategoryType(obj[1].toString());
					lookupsValue.setCategoryCode(obj[2].toString());
					lookuplist.add(lookupsValue);
				}
				lookupsValue.setMemberList(lookuplist);
				Lookups lookupsValue1;
				List list1=hibernateTemplate.find("select systemLookupCategory,systemLookupValue,systemLookupCode from SystemLookupValues where systemLookupCategory='FUNCTION' ");
				for(int i=0; i<list1.size(); i++)
				{
					Object[] obj=(Object[]) list1.get(i);
					lookupsValue1=new Lookups();
					lookupsValue1.setCategoryName(obj[0].toString());
					lookupsValue1.setCustomcategoryType(obj[1].toString());
					lookupsValue1.setCategoryCode(obj[2].toString());
					categorylist.add(lookupsValue1);
				}
				lookupsValue.setCategoryTypeList(categorylist);
				System.out.println(" lookuplist--------->"+lookuplist.size());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
				return lookupsValue;
	}	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getaddressmode()
	 */
	public List getaddressmode() {
				System.out.println("<------------- Inside the getlookupsvalue ---------> ");
		List list=hibernateTemplate.find(" from ChurchActivityAddresses");
		
			System.out.println("------------------"+list.size());
			return list;
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getaddress()
	 */
	public ChurchConfigurationForm getaddress() {
		List addresslist=new ArrayList();
		ChurchConfigurationForm churchConfigurationForm=new ChurchConfigurationForm();
		System.out.println("<------------- Inside the Address List---------> ");
		
		List list1=hibernateTemplate.find(" from ChurchConfiguration ");
		System.out.println("------------------"+list1.size());
		ChurchConfiguration churchConfiguration=(ChurchConfiguration) list1.get(0);
			churchConfigurationForm.setChurchId(churchConfiguration.getChurchId());
			List list=hibernateTemplate.find("select systemLookupValue from SystemLookupValues where systemLookupValueId='"+churchConfiguration.getSysChurchLvId()+"' ");
			String churchTypeView=list.toString();
			churchTypeView=churchTypeView.replace('[',' ');
			churchTypeView=churchTypeView.replace(']',' ');
			churchTypeView=churchTypeView.trim();
			churchConfigurationForm.setChurchTypeView(churchTypeView);
			churchConfigurationForm.setChurchType(churchConfiguration.getSysChurchLvId().toString());
			churchConfigurationForm.setChurchName(churchConfiguration.getChurchName());
			churchConfigurationForm.setChurchMotto(churchConfiguration.getChurchMotto());
			churchConfigurationForm.setChurchPatron(churchConfiguration.getChurchPatron());
			churchConfigurationForm.setDescription(churchConfiguration.getDescription());
			churchConfigurationForm.setRemarks(churchConfiguration.getRemarks());
			churchConfigurationForm.setChurchTheme(churchConfiguration.getChurchTheme());
			
		
		return churchConfigurationForm;

	}
	
	public ChurchConfigurationForm getaddress(ChurchAddressSubForm churchAddressSubForm, ChurchConfigurationForm churchConfigurationForm)
	{
		
		try {	
		List addresslist=new ArrayList();
		List list=hibernateTemplate.find(" from ChurchActivityAddresses ");
		System.out.println("------------------"+list.size());
		
		for(int i=0; i<list.size(); i++)
		{
		ChurchActivityAddresses churchActivityAddresses=(ChurchActivityAddresses) list.get(i);
		ChurchAddressSubForm churchAddressSubForm1=new ChurchAddressSubForm();
		
		churchAddressSubForm1.setsNo(i+1);
		churchAddressSubForm1.setAddressTitle(churchActivityAddresses.getAddressTitle());
		churchAddressSubForm1.setDoorNo(churchActivityAddresses.getDoorNumber());
		churchAddressSubForm1.setBuildingName(churchActivityAddresses.getBuilidingName());
		churchAddressSubForm1.setStreetName(churchActivityAddresses.getStreetName());
		churchAddressSubForm1.setArea(churchActivityAddresses.getArea());
		churchAddressSubForm1.setDistrict(churchActivityAddresses.getDistrict());
		churchAddressSubForm1.setCity(churchActivityAddresses.getCity());
		churchAddressSubForm1.setState(churchActivityAddresses.getStateLocation());
		churchAddressSubForm1.setCountry(churchActivityAddresses.getCountry());
		churchAddressSubForm1.setPostZone(churchActivityAddresses.getPostalZone());
		churchAddressSubForm1.setPostCode(churchActivityAddresses.getPostalCode());
		churchAddressSubForm1.setStartDate(churchActivityAddresses.getStartDate()==null?"":Converter.FormatDate(churchActivityAddresses.getStartDate().toString()));
		churchAddressSubForm1.setEndDate(churchActivityAddresses.getEndDate()==null?"":Converter.FormatDate(churchActivityAddresses.getEndDate().toString()));
		churchAddressSubForm1.setAddressId(churchActivityAddresses.getAddressId());
		addresslist.add(churchAddressSubForm1);
		}
		churchConfigurationForm.setChurchAddressSubForm(addresslist);
		System.out.println(" AddressList--------->"+addresslist.size());
		System.out.println(" AddressList--------->"+addresslist);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return churchConfigurationForm;
	}
	
	
	public ChurchConfigurationForm getcontacts(ChurchAddressSubForm churchAddressSubForm,ChurchContactsSubForm churchContactsSubForm, ChurchConfigurationForm churchConfigurationForm){
		List lookuplist=new ArrayList();
		System.out.println("<------------- Inside the getContactsvalue ---------> ");
		int value=churchAddressSubForm.getAddressId1();
		System.out.println("------------IN DAO IMPL--------"+value);
		ChurchContactsSubForm churchContactsSubForm1=new ChurchContactsSubForm();
		List list1=hibernateTemplate.find(" from ChurchAddressContacts where addressId='"+value+"'");
		System.out.println("------------------"+list1.size());
		for(int i=0; i<list1.size(); i++)
		{
			try {
		ChurchAddressContacts churchAddressContacts=(ChurchAddressContacts) list1.get(i);
		 churchContactsSubForm1=new ChurchContactsSubForm();
		 churchContactsSubForm1.setContactId(churchAddressContacts.getContactId());
		churchContactsSubForm1.setContactTitle(churchAddressContacts.getContactTitle());
		churchContactsSubForm1.setContactValue(churchAddressContacts.getContactValue());
		churchContactsSubForm1.setDescription(churchAddressContacts.getDescription()==null?null:churchAddressContacts.getDescription());
		churchContactsSubForm1.setStartDate(churchAddressContacts.getStartDate()==null?"":Converter.FormatDate(churchAddressContacts.getStartDate().toString()));
		churchContactsSubForm1.setEndDate(churchAddressContacts.getEndDate()==null?"":Converter.FormatDate(churchAddressContacts.getEndDate().toString()));
		lookuplist.add(churchContactsSubForm1);
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}		
		churchConfigurationForm.setChurchContactsSubForm(lookuplist);
		System.out.println(" ContactList--------->"+lookuplist.size());
		
		return churchConfigurationForm;
	
	}
	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#deletecontacts(java.lang.String, java.lang.String)
	 */
	public ChurchAddressContacts  deletecontacts(int id)
	{

		List remaininglist=new ArrayList();
		List list1=hibernateTemplate.find("from ChurchAddressContacts where contactId='"+id+"'");
		ChurchAddressContacts  churchAddressContacts =(ChurchAddressContacts) list1.get(0);
		hibernateTemplate.delete(churchAddressContacts);
		return churchAddressContacts;
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getcontacts(org.gaddiel.form.ChurchContactsSubForm, org.gaddiel.form.ChurchConfigurationForm)
	 */
	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#currency()
	 */
	public List currency() {
		// TODO Auto-generated method stub
		
		List currency=hibernateTemplate.find("select systemLookupValue from SystemLookupValues where systemLookupCategory='CURRENCY' ");
				
		System.out.println("DAO List size currency"+currency.size());
		return currency;
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#state()
	 */
	public List state() {
		// TODO Auto-generated method stub
		
		List memberlist1=new ArrayList();
		memberlist1.add("AP");
		memberlist1.add("TN");
		memberlist1.add("KA");
		System.out.println("DAO List size state"+memberlist1.size());
		return memberlist1;
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getfetchList(java.lang.String)
	 */
	public List<Object> getfetchList(String categoryType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getdetails(org.gaddiel.form.ChurchConfigurationForm)
	 */
	public ChurchConfiguration getdetails(ChurchConfigurationForm churchConfigurationForm,String str) {
		// TODO Auto-generated method stub
		List contactlist=new ArrayList();
		
	
		
		
		int value1=churchConfigurationForm.getChurchId();
		System.out.println("------------IN DAO IMPL--------"+value1);
		List list=hibernateTemplate.find(" from ChurchConfiguration where churchId='"+value1+"'");
		System.out.println("------------------"+list.size());
		
		ChurchConfiguration churchConfiguration=(ChurchConfiguration) list.get(0);
		
		
		churchConfiguration.setChurchName(churchConfigurationForm.getChurchName());
		System.out.println("-------CHURCH ID VAL----------"+churchConfigurationForm.getChurchTypeId());
		System.out.println("-------CHURCH VALUE----------"+churchConfigurationForm.getChurchType());
		churchConfiguration.setSysChurchLvId(Integer.parseInt(churchConfigurationForm.getChurchType()));
		churchConfiguration.setChurchPatron(churchConfigurationForm.getChurchPatron());
		churchConfiguration.setChurchMotto(churchConfigurationForm.getChurchMotto());
		churchConfiguration.setChurchTheme(churchConfigurationForm.getChurchTheme());
		churchConfiguration.setDescription(churchConfigurationForm.getDescription());
		churchConfiguration.setRemarks(churchConfigurationForm.getRemarks());
		churchConfiguration.setLastUpdatedBy(str);
		churchConfiguration.setLastUpdatedDate(new Date());
		hibernateTemplate.saveOrUpdate(churchConfiguration);
		
		/*for(int i=0;i<list1.size();i++)
		{
			Object[] obj=(Object[])list1.get(i);
			contactlist.add(obj[0].toString());
			member1.setContactTitle((obj[0].toString()));
			contactlist.add(obj[1].toString());
			member1.setContactTitle(obj[1].toString());
	}*/
		System.out.println(" list--------->"+contactlist.size());	
		return churchConfiguration;
	
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getcontacts(java.lang.String)
	 */
	public ChurchContactsPopup editcontacts(int id) throws ParseException {
		// TODO Auto-generated method stub
		List contactlist=new ArrayList();
		ChurchContactsPopup churchContactsPopup=new ChurchContactsPopup();
		
		List list1=hibernateTemplate.find(" from ChurchAddressContacts where contactId='"+id+"'");
		System.out.println("------------------"+list1.size());
		  for(int i=0; i<list1.size(); i++)	
		  {
			  ChurchAddressContacts churchAddressContacts=(ChurchAddressContacts) list1.get(i);
			churchContactsPopup.setContactTitle(churchAddressContacts.getContactTitle());
		System.out.println("----------CONTACT TITLE IN DAO IMPL"+churchContactsPopup.getContactTitle());
		churchContactsPopup.setContactValue(churchAddressContacts.getContactValue());
		churchContactsPopup.setDescription(churchAddressContacts.getDescription());
		churchContactsPopup.setStartDate(churchAddressContacts.getStartDate()==null?"":Converter.FormatDate(churchAddressContacts.getStartDate().toString()));
		churchContactsPopup.setEndDate(churchAddressContacts.getStartDate()==null?"":Converter.FormatDate(churchAddressContacts.getStartDate().toString()));
		churchContactsPopup.setContactId(id);
	
		
		  }
		System.out.println(" list--------->"+contactlist.size());	
		return churchContactsPopup;
	
	}
	
	public ChurchConfigurationForm newlinesave(String var, String var1, String var2, String var3, String var4, String checkbox, String str, ChurchConfigurationForm churchConfigurationForm) throws ParseException 
	{
		ChurchPreferencesForm churchPreferencesForm;
		List prelist=churchConfigurationForm.getChurchpreferencesSubForm();
		
		
		
		System.out.println("----IN DAO IMPL----");
		String categoryval=null;
		List categorylist=new ArrayList();
	
		List list2=hibernateTemplate.find(" select sys.systemLookupCategory from ChurchPreferences cp,SystemLookupValues sys where cp.systemLookupValueId=sys.systemLookupValueId  ");
		for(int i=0;i<list2.size();i++)
		{
			Object obj1=(Object)list2.get(i);
			categorylist.add(obj1);
		}
		System.out.println(categorylist);
		
		List list1=hibernateTemplate.find(" select systemLookupCategory from SystemLookupValues where systemLookupValueId='"+var1+"' ");
		System.out.println("----LIST SIZE----"+list1.size());
		Object obj=(Object)list1.get(0);
		categoryval=obj.toString();
		System.out.println(categoryval);

	if(categorylist.contains(categoryval))
	{
		System.out.println("THE VAL IS PRESENT"+categoryval);
		List list3=hibernateTemplate.find(" select systemLookupValueId from SystemLookupValues where systemLookupCategory='"+categoryval+"'  ");
	       for (int i=0; i< list3.size(); i++)
           {
	    	   Object object3=(Object)list3.get(i);
	    	   int id=Integer.parseInt(object3.toString());
	    	   List list4=hibernateTemplate.find(" from ChurchPreferences where systemLookupValueId='"+id+"'  ");
	    		if(list4.size()!=0)
	    		{
	    			ChurchPreferences churchPreferences=(ChurchPreferences)list4.get(0);
	    			churchPreferences.setSystemLookupValueId(Integer.parseInt(var1));
	    			churchPreferences.setDescription(var2);
	    			churchPreferences.setEnabledFlag(checkbox);
	    			churchPreferences.setStartDate(var3==null?null:Converter.StringtoDateforDB(var3));
	    			churchPreferences.setEndDate(var4==null?null:Converter.StringtoDateforDB(var4));
	    			hibernateTemplate.saveOrUpdate(churchPreferences);
	    		}
	        
           }
	
	}
	else
	{
		ChurchPreferences churchPreferences=new ChurchPreferences();
		churchPreferences.setChurchId(1);
		churchPreferences.setSystemLookupValueId(Integer.parseInt(var1));
		churchPreferences.setDescription(var2);
		churchPreferences.setStartDate(var3==null?null:Converter.StringtoDateforDB(var3));
		churchPreferences.setEndDate(var4==null?null:Converter.StringtoDateforDB(var4));
		churchPreferences.setEnabledFlag(checkbox);
		churchPreferences.setCreatedBy(str);
		churchPreferences.setCreatedDate(new Date());
		churchPreferences.setLastUpdatedBy(str);
		churchPreferences.setLastUpdatedDate(new Date());
		hibernateTemplate.saveOrUpdate(churchPreferences);
	}
	return churchConfigurationForm;
	}
	
	public ChurchConfigurationForm customnewlinesave(String var, String var1, String var2, String var3, String var4, String checkbox, String str, ChurchConfigurationForm churchConfigurationForm) throws ParseException 
	{
		ChurchPreferencesForm churchPreferencesForm;
		List prelist=churchConfigurationForm.getChurchpreferencesSubForm();
		
		
		
		System.out.println("----IN DAO IMPL----");
		String categoryval=null;
		List categorylist=new ArrayList();
	
		List list2=hibernateTemplate.find(" select sys.customLookupCategoryId from ChurchPreferences cp,CustomLookupValues sys where cp.customLookupValueId=sys.customLookupValueId  ");
		for(int i=0;i<list2.size();i++)
		{
			Object obj1=(Object)list2.get(i);
			categorylist.add(obj1);
		}
		System.out.println(categorylist);
		String cc=categorylist.toString();
		cc=cc.replace('[',' ');
		cc=cc.replace(']',' ');
		cc=cc.trim();
		List list1=hibernateTemplate.find(" select customLookupValueId from CustomLookupValues where customLookupCategoryId not in ('"+cc+"')");
		System.out.println("----LIST SIZE----"+list1.size());
		Object obj=(Object)list1.get(0);
		categoryval=obj.toString();
		System.out.println(categoryval);

	if(categorylist.contains(categoryval))
	{
		List list4=new ArrayList();
		System.out.println("THE VAL IS PRESENT"+categoryval);
		List list3=hibernateTemplate.find(" select customLookupCategoryId from CustomLookupCategories where customLookupCategory='"+categoryval+"'  ");
		   for (int i=0; i< list3.size(); i++)
           {
	    	   Object object3=(Object)list3.get(i);
	    	   int id=Integer.parseInt(object3.toString());
	    	   list4=hibernateTemplate.find(" select customLookupValueId from CustomLookupValues where customLookupCategoryId='"+id+"'  ");
           }  	
	       for (int i=0; i< list4.size(); i++)
           {
	    	   Object object3=(Object)list4.get(i);
	    	   int id=Integer.parseInt(object3.toString());
	    	   List list5=hibernateTemplate.find(" from ChurchPreferences where customLookupValueId='"+id+"'  ");
	    		if(list5.size()!=0)
	    		{
	    			ChurchPreferences churchPreferences=(ChurchPreferences)list4.get(0);
	    			churchPreferences.setCustomLookupValueId(Integer.parseInt(var1));
	    			churchPreferences.setDescription(var2);
	    			churchPreferences.setEnabledFlag(checkbox);
	    			churchPreferences.setStartDate(var3==null?null:Converter.StringtoDateforDB(var3));
	    			churchPreferences.setEndDate(var4==null?null:Converter.StringtoDateforDB(var4));
	    			hibernateTemplate.saveOrUpdate(churchPreferences);
	    		}
	        
           }
	
	}
	else
	{
		ChurchPreferences churchPreferences=new ChurchPreferences();
		churchPreferences.setChurchId(1);
		churchPreferences.setCustomLookupValueId(Integer.parseInt(var1));
		churchPreferences.setDescription(var2);
		churchPreferences.setStartDate(var3==null?null:Converter.StringtoDateforDB(var3));
		churchPreferences.setEndDate(var4==null?null:Converter.StringtoDateforDB(var4));
		churchPreferences.setEnabledFlag(checkbox);
		churchPreferences.setCreatedBy(str);
		churchPreferences.setCreatedDate(new Date());
		churchPreferences.setLastUpdatedBy(str);
		churchPreferences.setLastUpdatedDate(new Date());
		hibernateTemplate.saveOrUpdate(churchPreferences);
	}

	
		/*for(int i=0;i<list1.size();i++)
		{
		System.out.println("THE VALUE"+i);
		obj
		System.out.println("THE CATEGORY VALUE"+obj[1].toString());
		categoryval.add(obj[1].toString());
		System.out.println("-----IN DAO CATEGORY WISE------------");
		}
		System.out.println("THE CATEGORY LEN"+categoryval);
		String hb = null;
		String ab;
		System.out.println("THE CATEGORY LEN"+categoryval.size());
		for(int i=0;i<categoryval.size();i++)
		{
			System.out.println("THE CATEGORY VALUE"+categoryval.get(i));
			ab="and systemLookupCategory not in("+categoryval.get(i)+")";
			hb=ab;
		}
		System.out.println("----hb---"+hb);
		
		List list2=hibernateTemplate.find("select  systemLookupValueId from SystemLookupValues where systemLookupValueId='"+var1+"' ");
		if(list2.size()==0)
		{
			ChurchPreferences churchPreferences=(ChurchPreferences)list2.get(0);
			churchPreferences.setSystemLookupValueId(Integer.parseInt(list2.toString()));
			churchPreferences.setDescription(var2);
			churchPreferences.setStartDate(var3==null?null:Converter.StringtoDateforDB(var3));
			churchPreferences.setEndDate(var4==null?null:Converter.StringtoDateforDB(var4));
			hibernateTemplate.saveOrUpdate(churchPreferences);
		}
		else
		{
	
		ChurchPreferences churchPreferences=new ChurchPreferences();
		churchPreferences.setChurchId(1);
		churchPreferences.setSystemLookupValueId(Integer.parseInt(var1));
		churchPreferences.setDescription(var2);
		churchPreferences.setStartDate(var3==null?null:Converter.StringtoDateforDB(var3));
		churchPreferences.setEndDate(var4==null?null:Converter.StringtoDateforDB(var4));
		churchPreferences.setEnabledFlag(checkbox);
		churchPreferences.setCreatedBy(str);
		churchPreferences.setCreatedDate(new Date());
		churchPreferences.setLastUpdatedBy(str);
		churchPreferences.setLastUpdatedDate(new Date());
		hibernateTemplate.saveOrUpdate(churchPreferences);
			*/
		
		return churchConfigurationForm;
	}
	
	

	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getUpdateElements(org.gaddiel.form.ChurchConfigurationForm)
	 */
	public ChurchActivityAddresses getUpdateElements(ChurchConfigurationForm churchConfigurationForm) throws ParseException
	{
		System.out.println("");
		String value=(churchConfigurationForm.getAddress());
		System.out.println("------------IN DAO IMPL--------"+value);
		List list=hibernateTemplate.find("from ChurchActivityAddresses where addressId='"+value+"'");
		ChurchActivityAddresses churchActivityAddresses=(ChurchActivityAddresses) list.get(0);

		       
		churchActivityAddresses.setChurchId(1);
		churchActivityAddresses.setCustomAddressTypeLvId(1);
	churchActivityAddresses.setCreatedDate(new Date());
	churchActivityAddresses.setLastUpdatedDate(new Date());
		       
	String sample=churchConfigurationForm.getTotalAddress();	
	
	//String sample = "Sucess-need-continous-effort";
	String subStr[];
	System.out.println("EXAMLES OF SPLITTING STRING");
	System.out.println("");

	//Defining delimiter '-' and splitting string at '-'
	System.out.println("Splitting string at ','");
	String delimiter = ",";
	subStr = sample.split(delimiter);
	for (int i = 0; i < subStr.length; i++)
	{	
	System.out.println(subStr[i]);
	}
		churchActivityAddresses.setDoorNumber(subStr[0]);
		System.out.println("Splitting string at ','"+subStr[0]);
		churchActivityAddresses.setBuilidingName(subStr[1]);
		System.out.println("Splitting string at ','"+subStr[1]);
		churchActivityAddresses.setStreetName(subStr[2]);
		System.out.println("Splitting string at ','"+subStr[2]);
		
		churchActivityAddresses.setArea(churchConfigurationForm.getArea());
		churchActivityAddresses.setCity(churchConfigurationForm.getCity());
		churchActivityAddresses.setDistrict(churchConfigurationForm.getDistrict());
		churchActivityAddresses.setStateLocation(churchConfigurationForm.getState());
		churchActivityAddresses.setPostalZone(churchConfigurationForm.getPostalZone());
		churchActivityAddresses.setPostalCode(churchConfigurationForm.getPostCode());
		churchActivityAddresses.setCountry(churchConfigurationForm.getCountry());
		
		hibernateTemplate.saveOrUpdate(churchActivityAddresses);
		
		return churchActivityAddresses;
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getUpdateElements1(org.gaddiel.form.ChurchConfigurationForm, org.gaddiel.form.ChurchContactsSubForm)
	 */
	public ChurchConfigurationForm deleteaddress(ChurchConfigurationForm churchConfigurationForm,int id)
	{
		
		System.out.println("");
		List list1=hibernateTemplate.find("from ChurchAddressContacts where addressId='"+id+"'");
		  for(int i=0; i<list1.size(); i++)	
		  {
			  ChurchAddressContacts churchAddressContacts=(ChurchAddressContacts) list1.get(i);
				hibernateTemplate.delete(churchAddressContacts);
		  }
		
		List list=hibernateTemplate.find("from ChurchActivityAddresses where addressId='"+id+"'");
		ChurchActivityAddresses churchActivityAddresses=(ChurchActivityAddresses) list.get(0);
		hibernateTemplate.delete(churchActivityAddresses);
			
		return churchConfigurationForm;
	}
	
	
	public ChurchAddressPopup editaddresspopup(ChurchAddressPopup churchAddressPopup, int id)throws ParseException
	{
		
		System.out.println("");
		
		List list=hibernateTemplate.find("from ChurchActivityAddresses where addressId='"+id+"'");
		ChurchActivityAddresses churchActivityAddresses=(ChurchActivityAddresses) list.get(0);
		churchAddressPopup.setAddressId(churchActivityAddresses.getAddressId());
		churchAddressPopup.setAddressTitle(churchActivityAddresses.getAddressTitle());
		churchAddressPopup.setDoorNo(churchActivityAddresses.getDoorNumber());
		churchAddressPopup.setFloorNo(churchActivityAddresses.getFloorNumber());
		churchAddressPopup.setBuildingName(churchActivityAddresses.getBuilidingName());
		churchAddressPopup.setStreetName(churchActivityAddresses.getStreetName());
		churchAddressPopup.setArea(churchActivityAddresses.getArea());
		churchAddressPopup.setPostalZone(churchActivityAddresses.getPostalZone());
		churchAddressPopup.setCity(churchActivityAddresses.getCity());
		churchAddressPopup.setDistrict(churchActivityAddresses.getDistrict());
		churchAddressPopup.setState(churchActivityAddresses.getStateLocation());
		churchAddressPopup.setCountry(churchActivityAddresses.getCountry());
		churchAddressPopup.setPostalCode(churchActivityAddresses.getPostalCode());
		churchAddressPopup.setStartDate( churchActivityAddresses.getStartDate()==null?"":Converter.FormatDate(churchActivityAddresses.getStartDate().toString()));
		churchAddressPopup.setEndDate( churchActivityAddresses.getEndDate()==null?"":Converter.FormatDate(churchActivityAddresses.getEndDate().toString()));
			
		return churchAddressPopup;
	}
	
	/*public ChurchConfigurationForm getcontacts(String address) {
		// TODO Auto-generated method stub
		List contactlist=new ArrayList();
		ChurchConfigurationForm member1=new ChurchConfigurationForm();
		String value=((List) member1.getAddressMode()).get(0).toString();
		System.out.println("------------IN DAO IMPL--------"+value);
		List list1=hibernateTemplate.find("select contactTitle,contactValue from ChurchAddressContacts where addressId='"+Integer.parseInt(address)+"'");
		System.out.println("------------------"+list1.size());
		for(int i=0;i<list1.size();i++)
		{
			Object[] obj=(Object[])list1.get(i);
			contactlist.add(obj[0].toString());
			member1.setContactTitle((obj[0].toString()));
			contactlist.add(obj[1].toString());
			member1.setContactTitle(obj[1].toString());
	}
		System.out.println(" list--------->"+contactlist.size());	
		return contactlist;
	}
*/
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#setaddress(org.gaddiel.form.ChurchConfigurationForm)
	 */
	public ChurchAddressPopup saveaddress(ChurchAddressPopup churchAddressPopup,String str) throws ParseException {
		// TODO Auto-generated method stub
		List addresslist=new ArrayList();
			    
	int id=churchAddressPopup.getAddressId();	
	List list=hibernateTemplate.find("from ChurchActivityAddresses where addressId='"+id+"'");
		if(list.size()!=0)
		{
			List list1=hibernateTemplate.find("from ChurchActivityAddresses where addressId='"+id+"'");
			ChurchActivityAddresses churchActivityAddresses=(ChurchActivityAddresses) list.get(0);
		
			churchActivityAddresses.setAddressTitle(churchAddressPopup.getAddressTitle());
			System.out.println("-----------------churchActivityAddresses.getAddressTitle-------------"+churchActivityAddresses.getAddressTitle());
			churchActivityAddresses.setDoorNumber(churchAddressPopup.getDoorNo());
			churchActivityAddresses.setFloorNumber(churchAddressPopup.getFloorNo());
			churchActivityAddresses.setBuilidingName(churchAddressPopup.getBuildingName());
			churchActivityAddresses.setStreetName(churchAddressPopup.getStreetName());
			churchActivityAddresses.setArea(churchAddressPopup.getArea());
			churchActivityAddresses.setCity(churchAddressPopup.getCity());
			churchActivityAddresses.setDistrict(churchAddressPopup.getDistrict());
			churchActivityAddresses.setStateLocation(churchAddressPopup.getState());
			System.out.println("-----------------churchActivityAddresses.getStateLocation-------------"+churchActivityAddresses.getStateLocation());
			churchActivityAddresses.setPostalZone(churchAddressPopup.getPostalZone());
			churchActivityAddresses.setCountry(churchAddressPopup.getCountry());
			churchActivityAddresses.setPostalCode(churchAddressPopup.getPostalCode());
			churchActivityAddresses.setStartDate(churchAddressPopup.getStartDate().length()==0?null:Converter.StringtoDateforDB(churchAddressPopup.getStartDate().toString()));
			churchActivityAddresses.setEndDate(churchAddressPopup.getEndDate().length()==0?null:Converter.StringtoDateforDB(churchAddressPopup.getEndDate().toString()));
			churchActivityAddresses.setLastUpdatedBy(str);
			churchActivityAddresses.setLastUpdatedDate(new Date());
			hibernateTemplate.saveOrUpdate(churchActivityAddresses);
		}
		
		else{
		
		 ChurchActivityAddresses	churchActivityAddresses	=new ChurchActivityAddresses();
		   
		churchActivityAddresses.setChurchId(1);
		churchActivityAddresses.setCustomAddressTypeLvId(1);
		churchActivityAddresses.setCreatedDate(new Date());
		churchActivityAddresses.setLastUpdatedDate(new Date());
		churchActivityAddresses.setAddressTitle(churchAddressPopup.getAddressTitle());
		churchActivityAddresses.setDoorNumber(churchAddressPopup.getDoorNo());
		churchActivityAddresses.setFloorNumber(churchAddressPopup.getFloorNo());
		churchActivityAddresses.setBuilidingName(churchAddressPopup.getBuildingName());
		churchActivityAddresses.setStreetName(churchAddressPopup.getStreetName());
		churchActivityAddresses.setArea(churchAddressPopup.getArea());
		churchActivityAddresses.setCity(churchAddressPopup.getCity());
		churchActivityAddresses.setDistrict(churchAddressPopup.getDistrict());
		churchActivityAddresses.setStateLocation(churchAddressPopup.getState());
		churchActivityAddresses.setPostalZone(churchAddressPopup.getPostalZone());
		churchActivityAddresses.setCountry(churchAddressPopup.getCountry());
		churchActivityAddresses.setPostalCode(churchAddressPopup.getPostalCode());
		churchActivityAddresses.setStartDate(churchAddressPopup.getStartDate().length()==0?null:Converter.StringtoDateforDB(churchAddressPopup.getStartDate().toString()));
		churchActivityAddresses.setEndDate(churchAddressPopup.getEndDate().length()==0?null:Converter.StringtoDateforDB(churchAddressPopup.getEndDate().toString()));
		churchActivityAddresses.setLastUpdatedBy(str);
		churchActivityAddresses.setLastUpdatedDate(new Date());
		churchActivityAddresses.setCreatedBy(str);
		churchActivityAddresses.setCreatedDate(new Date());
		hibernateTemplate.saveOrUpdate(churchActivityAddresses);
		
		
		churchAddressPopup.setAddressId(Integer.parseInt(churchActivityAddresses.getAddressId().toString()));
		System.out.println("--IN DAO IMPL CHURCH ADDRESSID-----"+churchAddressPopup.getAddressId());
		}
		
		
		
		return churchAddressPopup;
	
	}
	
	public ChurchContactsPopup savecontacts(ChurchContactsPopup churchContactsPopup,int addid,String str) throws ParseException {
		// TODO Auto-generated method stub
		List addresslist=new ArrayList();
			    
	int id=churchContactsPopup.getContactId();	
	List list=hibernateTemplate.find("from ChurchAddressContacts where contactId='"+id+"'");
		if(list.size()!=0)
		{
			List list1=hibernateTemplate.find("from ChurchAddressContacts where contactId='"+id+"'");
			ChurchAddressContacts churchAddressContacts=(ChurchAddressContacts) list.get(0);
		
			churchAddressContacts.setContactTitle(churchContactsPopup.getContactTitle());
			churchAddressContacts.setContactValue(churchContactsPopup.getContactValue());
			churchAddressContacts.setDescription(churchContactsPopup.getDescription());
			churchAddressContacts.setLastUpdatedBy(str);
			churchAddressContacts.setLastUpdatedDate(new Date());
			churchAddressContacts.setStartDate(churchContactsPopup.getStartDate().length()==0?null:Converter.StringtoDateforDB(churchContactsPopup.getStartDate().toString()));
			churchAddressContacts.setEndDate(churchContactsPopup.getEndDate().length()==0?null:Converter.StringtoDateforDB(churchContactsPopup.getEndDate().toString()));
		
			hibernateTemplate.saveOrUpdate(churchAddressContacts);
		}
		
		else{
		
			ChurchAddressContacts	churchAddressContacts	=new ChurchAddressContacts();
		   
		churchAddressContacts.setCustomContactTypeLvId(2);
		churchAddressContacts.setAddressId(addid);
		churchAddressContacts.setContactId(null);
		churchAddressContacts.setCreatedDate(new Date());
		churchAddressContacts.setLastUpdatedBy(str);
		churchAddressContacts.setCreatedBy(str);
		churchAddressContacts.setLastUpdatedDate(new Date());
		churchAddressContacts.setContactTitle(churchContactsPopup.getContactTitle());
		churchAddressContacts.setContactValue(churchContactsPopup.getContactValue());
		churchAddressContacts.setDescription(churchContactsPopup.getDescription());
		churchAddressContacts.setStartDate(churchContactsPopup.getStartDate().length()==0?null:Converter.StringtoDateforDB(churchContactsPopup.getStartDate().toString()));
		churchAddressContacts.setEndDate(churchContactsPopup.getEndDate().length()==0?null:Converter.StringtoDateforDB(churchContactsPopup.getEndDate().toString()));
		hibernateTemplate.saveOrUpdate(churchAddressContacts);
		
		
		churchContactsPopup.setContactId(churchAddressContacts.getContactId());
		System.out.println("--IN DAO IMPL CHURCH CONTACTID-----"+churchContactsPopup.getContactId());
		}
		
		
		
		return churchContactsPopup;
	
	}
	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#savecontacts(org.gaddiel.form.ChurchConfigurationForm, org.gaddiel.form.ChurchContactsSubForm)
	 */
	public String savecontacts(ChurchConfigurationForm churchConfigurationForm, ChurchContactsSubForm churchContactsSubForm)throws ParseException{  
	System.out.println(" <------------inside the hibernate --------------->");
	
	
	System.out.println(" <------------INSIDE SAVE CONTACTS ADDRESS--------------->"+churchConfigurationForm.getAddressId());
	
	 	
	ChurchAddressContacts churchAddressContacts	=new ChurchAddressContacts();
	
	

	 List lookup=churchConfigurationForm.getChurchContactsSubForm();
	  for(int i=0; i<lookup.size(); i++)	
	  {
		  churchContactsSubForm=new ChurchContactsSubForm();
		  churchContactsSubForm=(ChurchContactsSubForm) lookup.get(i);
		  churchAddressContacts=new ChurchAddressContacts();  
		  
		churchAddressContacts.setContactTitle(churchContactsSubForm.getContactTitle());
		System.out.println("--LIST OF CONTACT TITLE----"+churchContactsSubForm.getContactTitle());
		
		churchAddressContacts.setContactValue(churchContactsSubForm.getAddContactValue());
		churchAddressContacts.setAddressId(churchConfigurationForm.getAddressId());
		churchAddressContacts.setCustomContactTypeLvId(2);
		churchAddressContacts.setCreatedDate(new Date());
		churchAddressContacts.setLastUpdatedDate(new Date());
		hibernateTemplate.saveOrUpdate(churchAddressContacts);
	  }
	
	
			  return "ChurchConfiguration";
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#deleteMemberElements(org.gaddiel.form.ChurchConfigurationForm)
	 */
	public String deleteMemberElements(ChurchConfigurationForm churchConfigurationForm)
	{
		String value=churchConfigurationForm.getAddress();
		System.out.println("---------IN DELETE MODULE-----------"+value);
		
		List list1=hibernateTemplate.find(" from ChurchAddressContacts where addressId='"+value+"'");
		for(int i=0; i<list1.size(); i++)
		{
		ChurchAddressContacts churchAddressContacts=(ChurchAddressContacts) list1.get(i);
		hibernateTemplate.delete(churchAddressContacts);
		}
	
		hibernateTemplate.flush();
		hibernateTemplate.getFlushMode();
		System.out.println(" DEleted from the table ");
			
	
		
		return "got deleted ";
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#deleteMemberElements1(org.gaddiel.form.ChurchConfigurationForm)
	 */
	public String deleteMemberElements1(ChurchConfigurationForm churchConfigurationForm)
	{
		String value=churchConfigurationForm.getAddress();
		System.out.println("---------IN DELETE MODULE-----------"+value);
		
		List list=hibernateTemplate.find(" from ChurchActivityAddresses where addressId='"+value+"'");
		ChurchActivityAddresses churchActivityAddresses=(ChurchActivityAddresses) list.get(0);
		hibernateTemplate.delete(churchActivityAddresses);
		hibernateTemplate.flush();
		
		return "got deleted ";
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getpreferencesvalue()
	 */
	public ChurchPreferencesForm getpreferencesvalue() {
		List preferlist=new ArrayList();
		List entryName=new ArrayList();	
		List entryList=new ArrayList();
		List valuelist=new ArrayList();
		MultiHashMap hp=new MultiHashMap();
		ModelMap map;
		ChurchPreferencesForm churchPreferencesForm=new ChurchPreferencesForm();
		System.out.println("<------------- Inside the getlookupsvalue ---------> ");
		try{
				List list=hibernateTemplate.find(" select systemLookupValueId,description,enabledFlag,startDate,endDate from ChurchPreferences where customLookupValueId is null ");
				System.out.println("---------churchPreferences list ---;"+list.size());
				for(int i=0; i<list.size(); i++)
				{
					Object[] obj=(Object[]) list.get(i);
				
					System.out.println("---------Value----;"+Integer.parseInt(obj[0].toString()));
					int value=Integer.parseInt(obj[0].toString());
					List list1=hibernateTemplate.find("select  systemLookupValueId,systemLookupCategory,systemLookupValue from SystemLookupValues where systemLookupValueId='"+value+"'");
					for(int j=0; j<list1.size(); j++)
					{
					Object[] obj1=(Object[]) list1.get(j);
					churchPreferencesForm=new ChurchPreferencesForm();
					churchPreferencesForm.setPreferId(Integer.parseInt(obj1[0].toString()));
					churchPreferencesForm.setPreferencesName(obj1[1].toString());
					churchPreferencesForm.setPreferencesValue(obj1[2].toString());
					churchPreferencesForm.setCategoryValue(obj1[1].toString());
					}
					churchPreferencesForm.setDescription(obj[1]==null?null:obj[1].toString());
					churchPreferencesForm.setCheckBox(obj[2]==null?null:obj[2].toString());
					churchPreferencesForm.setStartDate(obj[3]==null?null:Converter.FormatDate(obj[3].toString()));
					churchPreferencesForm.setEndDate(obj[4]==null?null:Converter.FormatDate(obj[4].toString()));
				
					preferlist.add(churchPreferencesForm);
					}
				churchPreferencesForm.setPreferencesList(preferlist);
				System.out.println(" lookuplist--------->"+preferlist.size());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
				return churchPreferencesForm;
				}	
	
	
	
	public ChurchPrefCustomForm getcustompreferencesvalue() {
		List preferlist=new ArrayList();
		List entryName=new ArrayList();	
		List entryList=new ArrayList();
		List valuelist=new ArrayList();
		MultiHashMap hp=new MultiHashMap();
		ModelMap map;
		ChurchPrefCustomForm churchPrefCustomForm=new ChurchPrefCustomForm();
		System.out.println("<------------- Inside the getCustomPrefvalue ---------> ");
		try{
				List list=hibernateTemplate.find(" select customLookupValueId,description,enabledFlag,startDate,endDate from ChurchPreferences where systemLookupValueId is null ");
				System.out.println("---------churchPreferences list ---;"+list.size());
				for(int i=0; i<list.size(); i++)
				{
					Object[] obj=(Object[]) list.get(i);
				
					System.out.println("---------Value----;"+Integer.parseInt(obj[0].toString()));
					int value=Integer.parseInt(obj[0].toString());
					List list1=hibernateTemplate.find("select  customLookupValueId,customLookupCategoryId,customLookupValue from CustomLookupValues where customLookupValueId='"+value+"'");
					for(int j=0; j<list1.size(); j++)
					{
					Object[] obj1=(Object[]) list1.get(j);
					churchPrefCustomForm=new ChurchPrefCustomForm();
					churchPrefCustomForm.setPreferId(Integer.parseInt(obj1[0].toString()));
					List list2=hibernateTemplate.find("select  customLookupCategory from CustomLookupCategories where customLookupCategoryId='"+obj1[1].toString()+"'");
					String categoryName=list2.toString();
					categoryName=categoryName.replace('[',' ');
					categoryName=categoryName.replace(']',' ');
					categoryName=categoryName.trim();
					churchPrefCustomForm.setPreferencesName(categoryName);
					churchPrefCustomForm.setPreferencesValue(obj1[2].toString());
					churchPrefCustomForm.setCategoryValue(categoryName);
					}
					churchPrefCustomForm.setDescription(obj[1]==null?null:obj[1].toString());
					churchPrefCustomForm.setCheckBox(obj[2]==null?null:obj[2].toString());
					churchPrefCustomForm.setStartDate(obj[3]==null?null:Converter.FormatDate(obj[3].toString()));
					churchPrefCustomForm.setEndDate(obj[4]==null?null:Converter.FormatDate(obj[4].toString()));
				
					preferlist.add(churchPrefCustomForm);
					}
				churchPrefCustomForm.setPreferencesList(preferlist);
				System.out.println(" lookuplist--------->"+preferlist.size());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
				return churchPrefCustomForm;
				}
	
//--------------------------------------custom lookups form---------------------------------------------------	
	/* (non-Javadoc)
 * @see org.gaddiel.dao.MemberDao#getcustomlookupsvalue()
 */
public List getcustomlookupsvalue() {
		List lookuplist=new ArrayList();
		Lookups lookupsValue=new Lookups();
		List categoryNameList=new ArrayList();
		CustomLookupsForm customLookupsForm=new CustomLookupsForm();
		System.out.println("<------------- Inside the getlookupsvalue ---------> ");
		try{
			System.out.println(" <----------------------------------------------------------------------------------->");
			Lookups lookupsValue1;
				List list2=hibernateTemplate.find(" from  CustomLookupCategories ");
				for(int i=0; i<list2.size(); i++)
				{
					CustomLookupCategories customLookupCategories=(CustomLookupCategories) list2.get(i);
					customLookupsForm = new CustomLookupsForm();
					System.out.println(" obj[0].toString()--->"+customLookupCategories.getCustomLookupCategoryId());
					customLookupsForm.setValue(customLookupCategories.getCustomLookupCategoryId().toString());
					customLookupsForm.setLabel(customLookupCategories.getCustomLookupCategory());
					lookuplist.add(customLookupsForm);
				}
				
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
				return lookuplist;
				}	
	
	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getviewList(org.gaddiel.form.CustomLookupsForm)
	 */
	public Lookups getviewList(CustomLookupsForm mainForm1) throws Exception{
		// TODO Auto-generated method stub
		List lookuplist=new ArrayList();
		System.out.println(" ---Lookups name ---->"+mainForm1.getCustomcategoryType());
		Lookups lookupsValue=new Lookups();
		String viewlist="";
		viewlist="select customLookupValueId,customLookupCode,customLookupValue,description,enabledFlag,startDate,endDate from CustomLookupValues where customLookupCategoryId='"+mainForm1.getCustomcategoryType()+"'";
		if(mainForm1.getSortValue()!=null && mainForm1.getSortValue().equals("sortasc"))
		{
			viewlist=viewlist+" order by customLookupValue asc";
		}else if(mainForm1.getSortValue()!=null && mainForm1.getSortValue().equals("sortdes"))
		{
			viewlist=viewlist+" order by customLookupValue desc";
		}
		List list=hibernateTemplate.find(viewlist);
		for(int i=0; i<list.size(); i++)
		{
			Object[] obj=(Object[]) list.get(i);
			lookupsValue=new Lookups();
			//String sno=new Integer(i+1).toString();
			lookupsValue.setCategoryTypeId(obj[0].toString());
			lookupsValue.setCategoryCode(obj[1]==null?"":obj[1].toString());
			lookupsValue.setCategoryName(obj[2].toString());
			lookupsValue.setDescription(obj[3]==null?null:obj[3].toString());
			lookupsValue.setEnabledFlag(obj[4]==null?"0":obj[4].toString());
			System.out.println(" Enabled flag in view  --->"+obj[4]);
			lookupsValue.setStartDate(obj[5]==null?"":Converter.FormatDate(obj[5].toString()));
			lookupsValue.setEndDate(obj[6]==null?"":Converter.FormatDate(obj[6].toString()));
			lookupsValue.setCheckbox("1");
			lookupsValue.setsNo(new Integer(i+1).toString());
			lookuplist.add(lookupsValue);
		}
        lookupsValue.setMemberList(lookuplist);
        System.out.println(" lookuplist size-------------> "+lookuplist.size());
		System.out.println(" <-------------------------BLOB SAVE STARTS------------------------------------->");
		System.out.println(" Session Id--------------->"+mainForm1.getSessionId());
		ByteArrayInputStream bytearrayinputstream1 =saveBLOB(lookuplist);
		if(mainForm1.getDispatch()!=null && !mainForm1.getDispatch().equals("report")){			
		List pagelist =hibernateTemplate.find(" from TempPagination where sessionId='"+mainForm1.getSessionId()+"'");
		if(pagelist!=null && pagelist.size()>0)
		{
			TempPagination tempPagination=(TempPagination)pagelist.get(0);
			tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream1));
			tempPagination.setSessionId(mainForm1.getSessionId());
			hibernateTemplate.saveOrUpdate(tempPagination);
			hibernateTemplate.flush();
		}
		else
		{
			TempPagination tempPagination=new TempPagination();
			tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream1));
			tempPagination.setSessionId(mainForm1.getSessionId());
			hibernateTemplate.saveOrUpdate(tempPagination);
			hibernateTemplate.flush();
		}
		System.out.println(" <----------------------------------BLOB SAVED ------------------------------------->");
		return paginationmethod(mainForm1);
		}else
		return lookupsValue;
		
	}

	
public Lookups paginationmethod(CustomLookupsForm mainForm1) throws IOException, SQLException, ClassNotFoundException{
		
		List paginationList = new ArrayList(); 
		Lookups lookupsValue=new Lookups();
		List list =hibernateTemplate.find(" from TempPagination where sessionId='"+mainForm1.getSessionId()+"'");
		TempPagination tempPagination=(TempPagination)list.get(0);
		ObjectInputStream stream = new ObjectInputStream(tempPagination.getTempVal().getBinaryStream());//where tempObj.getBlobDetails() returns the java.sql.Blob object
		paginationList = (List) stream.readObject();
		System.out.println(" paginationList-------------->"+paginationList.size());
		//String page=rb.getString("pagination.pagesize");
		String page = null;
		
		//List list11 =hibernateTemplate.find("  select sys.customLookupCategoryId from ChurchPreferences cp,CustomLookupValues sys where cp.customLookupValueId=sys.customLookupValueId ");
		List list11 =hibernateTemplate.find("select customLookupCategoryId from CustomLookupCategories where customLookupCategory='CUSTOM PAGESIZE'");
		String id=list11.toString();
		id=id.replace('[',' ');
		id=id.replace(']',' ');
		id=id.trim();
		List list22= hibernateTemplate.find("select customLookupValueId from CustomLookupValues where customLookupCategoryId='"+id+"'");
		for(int k=0;k<list22.size();k++)
		{
		List list23=hibernateTemplate.find("from ChurchPreferences where customLookupValueId='"+list22.get(k)+"'");
		if(list23.size()!=0)
		{
			List list24= hibernateTemplate.find("select customLookupValue from CustomLookupValues where customLookupValueId='"+list22.get(k)+"'");
			page=list24.get(0).toString();
		}
		}
		int pagesize=Integer.parseInt(page);
		int totallist=paginationList.size();
		int start=0,end=0;
		int pageno=1;
		
	         end = ((pageno-1)*pagesize)+pagesize;  
	
		
		if(end>=totallist){
            end = totallist;
            lookupsValue.setLastPage(true);
            System.out.println(" End insidec value-->"+end);
           }else{
        	   lookupsValue.setLastPage(false);
           }
			
		System.out.println(" End value ----------->"+end);
		int total=paginationList.size();
		System.out.println(" total value ----------->"+total);
		lookupsValue.setMemberList(paginationList.subList(start, end));
		lookupsValue.setPageNo(pageno);
		lookupsValue.setStart(start+1);
		lookupsValue.setEnd(end);
		lookupsValue.setTotal(total);
		lookupsValue.setFirstPage(true);
		if(mainForm1.getLastpage()!=null && mainForm1.getLastpage().equals("1"))
		{
			 end = totallist;
			 lookupsValue.setLastPage(true);
		}			
		return lookupsValue;
	}



public Lookups getcustomTempList(CustomLookupsForm getcustomTempList) throws IOException, SQLException {
	
	// TODO Auto-generated method stub
	List paginationList = new ArrayList(); 
	Lookups lookupsValue=new Lookups();
	List list =hibernateTemplate.find(" from TempPagination where sessionId='"+getcustomTempList.getSessionId()+"'");
	TempPagination tempPagination=(TempPagination)list.get(0);
	ObjectInputStream stream = new ObjectInputStream(tempPagination.getTempVal().getBinaryStream());
	try {
		paginationList = (List) stream.readObject();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(" paginationList-------------->"+paginationList.size());
	System.out.println(" getTempList.getEnd();----------------->"+getcustomTempList.getEnd());
	System.out.println(" page No======>"+getcustomTempList.getPageNo());
	int end=0;
	String page=rb.getString("pagination.pagesize");
	
	int pagesize=Integer.parseInt(page);
	int pageno=getcustomTempList.getPageNo();
	int totallist=paginationList.size();
	int start=0;
	
         end = ((pageno-1)*pagesize)+pagesize;  
	
	if(pageno!=1){
           start= ((pageno-1)*pagesize);        
           lookupsValue.setFirstPage(false);
        }else{           
        	lookupsValue.setFirstPage(true);            
        }
        
        if(start == 0){
        	lookupsValue.setFirstPage(true); 
        	lookupsValue.setStart(start+1);
        }else
        {
        	lookupsValue.setStart(start);
        }
        
	if(end>=totallist){
       end = totallist;
       lookupsValue.setLastPage(true);
      }else{
    	  lookupsValue.setLastPage(false);
      }
	System.out.println(" end-------------->"+end);
				System.out.println(" Last page ------------> "+lookupsValue.isLastPage());
				System.out.println(" first page ------------> "+lookupsValue.isFirstPage());
	int total=paginationList.size();
	
	lookupsValue.setMemberList(paginationList.subList(start, end));

	
	lookupsValue.setPageNo(pageno);
	
	
	lookupsValue.setEnd(end);
	lookupsValue.setTotal(total);
	
	return lookupsValue;
}

	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#savelookups(org.gaddiel.form.CustomLookupsForm, java.lang.String)
	 */
	public CustomLookupsForm savelookups(CustomLookupsForm mainForm1, String str) throws Exception{
		// TODO Auto-generated method stub
		System.out.println(" <------------inside the hibernate --------------->");
		
		try
		{
		
		List lookup=mainForm1.getLookups();
		List list =hibernateTemplate.find(" from CustomLookupValues where customLookupCategoryId='"+mainForm1.getCustomcategoryType()+"'");
		System.out.println(" lookup list size----->"+lookup.size());
		HashMap multimap=new HashMap();
		for(int i=0; i<lookup.size(); i++)
		{
			Lookups lookupsForm=(Lookups) lookup.get(i);
			System.out.println(" Id value -------------->"+lookupsForm.getCategoryTypeId()+"****************");
			String id1=lookupsForm.getCategoryTypeId();
			System.out.println(" Checkbox value----->"+lookupsForm.getCheckbox());
			if(lookupsForm.getCheckbox()!=null)
			{
							
				if(lookupsForm.getCategoryTypeId().equals("") || lookupsForm.getCategoryTypeId()==null || lookupsForm.getCategoryTypeId().equals("null"))
				{
					System.out.println(" Inside the checkbox ");
					CustomLookupValues customLookupValues=new CustomLookupValues();
					String dem=mainForm1.getCustomcategoryType().toString();
					int id=Integer.parseInt(dem);
					customLookupValues.setCustomLookupCategoryId(id);
					customLookupValues.setCustomLookupValueId(null);
					customLookupValues.setCreatedDate(new Date());
					customLookupValues.setLastUpdatedDate(new Date());
					customLookupValues.setCustomLookupCode(lookupsForm.getCategoryCode().toUpperCase());
					customLookupValues.setCustomLookupValue(lookupsForm.getCategoryName().toUpperCase());
					System.out.println(" eNABLED FLAG ------------->"+lookupsForm.getEnabledFlag());
					customLookupValues.setEnabledFlag(lookupsForm.getEnabledFlag()==null?"0":lookupsForm.getEnabledFlag());
					customLookupValues.setDescription(lookupsForm.getDescription());
					customLookupValues.setLastUpdatedBy(str);
					customLookupValues.setCreatedBy(str);
					customLookupValues.setStartDate(lookupsForm.getStartDate().length()==0?null:Converter.StringtoDateforDB(lookupsForm.getStartDate()));
					customLookupValues.setEndDate(lookupsForm.getEndDate().length()==0?null:Converter.StringtoDateforDB(lookupsForm.getEndDate()));
					hibernateTemplate.saveOrUpdate(customLookupValues);
					
				}
			multimap.put(id1, lookupsForm);
			
			}
		}
		
		System.out.println(" multimap size----->"+multimap.size()+"\t multimap value --/>"+multimap);
		for(int k=0; k<list.size(); k++)
		{
		
			CustomLookupValues customLookupValues=(CustomLookupValues) list.get(k);
			Lookups lookupsForm=(Lookups) multimap.get(customLookupValues.getCustomLookupValueId().toString());
			
			System.out.println("------multimap.containsKey(systemLookupValues.getSystemLookupValueId().toString())--------> "+multimap.containsKey(customLookupValues.getCustomLookupValueId())+"-\t-"+multimap.containsKey(" ")+ "\t-->"+multimap.containsKey(null));
			if(multimap.containsKey(customLookupValues.getCustomLookupValueId().toString()) || (multimap.containsKey(" ")) || (multimap.containsKey(null)))
			{
		        System.out.println(" systemLookupsForm.getCategoryType()------------>"+lookupsForm.getCategoryName()+"\t --->"+lookupsForm.getCategoryCode());
		        customLookupValues.setCustomLookupCode(lookupsForm.getCategoryCode()==null?"":lookupsForm.getCategoryCode().toUpperCase());
		        customLookupValues.setCustomLookupValue(lookupsForm.getCategoryName()==null?null:lookupsForm.getCategoryName().toUpperCase());	
		        System.out.println(" systemLookupsForm.getEnabledFlag() IN UPDATE ------>"+lookupsForm.getEnabledFlag());
				customLookupValues.setEnabledFlag(lookupsForm.getEnabledFlag()==null?"0":lookupsForm.getEnabledFlag());
				customLookupValues.setDescription(lookupsForm.getDescription());
				customLookupValues.setLastUpdatedBy(str);
				customLookupValues.setLastUpdatedDate(new Date());
				customLookupValues.setStartDate(lookupsForm.getStartDate().length()==0?null:Converter.StringtoDateforDB(lookupsForm.getStartDate()));
				customLookupValues.setEndDate(lookupsForm.getEndDate().length()==0?null:Converter.StringtoDateforDB(lookupsForm.getEndDate()));
				hibernateTemplate.saveOrUpdate(customLookupValues);
				System.out.println("<------- after save --------->");			
			}
		}
		/*------------------------------------ Add New ------------------------------------------------------------------------*/
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return mainForm1;
		
	}

	public CustomLookupsForm customlinesave(String var, String var1, String var2, String var3, String var4, String var5, String checkbox, String str, CustomLookupsForm mainForm1) throws ParseException 
	{
		
		System.out.println("----IN DAO IMPL----");
	
		CustomLookupValues customLookupValues=new CustomLookupValues();
	
	
		customLookupValues.setCustomLookupCode(var1.toUpperCase());
		customLookupValues.setCustomLookupValueId(null);
		customLookupValues.setCustomLookupCategoryId(Integer.parseInt(var.toString()));
		customLookupValues.setCustomLookupValue(var2.toUpperCase());
		customLookupValues.setDescription(var3==null?null:var3);
		customLookupValues.setStartDate(var4==null?null:Converter.StringtoDateforDB(var4));
		customLookupValues.setEndDate(var5==null?null:Converter.StringtoDateforDB(var5));
		customLookupValues.setLastUpdatedDate(new Date());
		customLookupValues.setEnabledFlag(checkbox==null?null:checkbox);
		customLookupValues.setLastUpdatedBy(str);
		customLookupValues.setCreatedBy(str);
		customLookupValues.setCreatedDate(new Date());
		hibernateTemplate.saveOrUpdate(customLookupValues);
		return mainForm1;
	}
	
	
	
	public CustomLookupsForm savecustominline(String var, String var1, String var2, String var3, String var4, String checkbox, String str) throws ParseException
	{
		CustomLookupsForm mainForm1 = new CustomLookupsForm();
		System.out.println("----IN DAO IMPL----");
		List list1=hibernateTemplate.find("from CustomLookupValues where customLookupValueId='"+var+"'");
		CustomLookupValues customLookupValues=(CustomLookupValues) list1.get(0);
		customLookupValues.setCustomLookupValue(var1.toUpperCase());
		customLookupValues.setDescription(var2==null?null:var2);
		customLookupValues.setStartDate(var3==null?null:Converter.StringtoDateforDB(var3));
		customLookupValues.setEndDate(var4==null?null:Converter.StringtoDateforDB(var4));
		customLookupValues.setLastUpdatedDate(new Date());
		customLookupValues.setEnabledFlag(checkbox);
		customLookupValues.setLastUpdatedBy(str);
		hibernateTemplate.saveOrUpdate(customLookupValues);
		return mainForm1;
	}
	

	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#deletelookups(java.lang.String)
	 */
	public List deletelookups(String value) {
		// TODO Auto-generated method stub
		List remaininglist=new ArrayList();
		String id[]=value.split(",");
	System.out.println("---ID VALUE---"+id[0]);
	System.out.println("---NAME VALUE---"+id[1].toString());
	String name[]=id[1].toString().split("=");
	System.out.println("---NAME VALUE---"+name[1]);
		List list=hibernateTemplate.find("from CustomLookupValues where customLookupCategoryId='"+id[0]+"' and customLookupValue='"+name[1]+"' ");
		CustomLookupValues customLookupValues=(CustomLookupValues) list.get(0);
		hibernateTemplate.delete(customLookupValues);
		CustomLookupsForm form=new CustomLookupsForm();
		form.setCustomcategoryType(id[1]);
		Lookups lookupsValue=new Lookups();
		try {
			lookupsValue = getviewList(form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		remaininglist=lookupsValue.getMemberList();
		return remaininglist;
	}	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getcustomlookslist(org.gaddiel.form.CustomLookupsForm)
	 */
	public Lookups getcustomlookslist(CustomLookupsForm customLookupsForm)throws Exception {
		// TODO Auto-generated method stub
		List customlist=new ArrayList();
		List list=new ArrayList();
		Lookups lookupsForm2=new Lookups();
		String searchval1=customLookupsForm.getCustomlookssearch();
		String category1=customLookupsForm.getCategoryName(); 
		if(searchval1!=null && searchval1!="")
		{
		searchval1=searchval1+"%";
		list=hibernateTemplate.find("select customLookupCode,customLookupValue,startDate,endDate,description,customLookupValueId,enabledFlag from CustomLookupValues where customLookupCategoryId='"+customLookupsForm.getCustomcategoryType()+"' and customLookupValue like'"+searchval1+"'");
		}
		else
		{
		list=hibernateTemplate.find("select customLookupCode,customLookupValue,startDate,endDate,description,customLookupValueId,enabledFlag from CustomLookupValues where customLookupCategoryId='"+customLookupsForm.getCustomcategoryType()+"' ");
		System.out.println(" ---customlist DaoImpl  2 ---->");
		}
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(" ---customlist DaoImpl 3---->");
			Object[] obj=(Object[]) list.get(i);
			lookupsForm2=new Lookups();
			lookupsForm2.setCategoryCode(obj[0].toString());
			System.out.println("CategoryCode--->>"+obj[0].toString());
			lookupsForm2.setCategoryName(obj[1].toString());
			System.out.println("CategoryName --->"+obj[1].toString());
			lookupsForm2.setStartDate(obj[2]==null || obj[2].equals("null")?"":Converter.FormatDate(obj[2].toString()));
			System.out.println(" Start date --->"+obj[2]);
			lookupsForm2.setEndDate(obj[3]==null || obj[3].equals("null")?"":Converter.FormatDate(obj[3].toString()));
			System.out.println(" End date --->"+obj[3]);
			lookupsForm2.setDescription(obj[4]==null||obj[4].equals("null")?"":obj[4].toString());
			System.out.println("description --->"+obj[4]);
			lookupsForm2.setCategoryTypeId(obj[5].toString());
			System.out.println("Category Type Id --->"+obj[5].toString());
			lookupsForm2.setEnabledFlag(obj[6].toString());
			customlist.add(lookupsForm2);
			
		}
		System.out.println(" ---customlist DaoImpl 4---->"+customlist.size());
		lookupsForm2.setMemberList(customlist);
	        System.out.println(" lookuplist size-------------> "+customlist.size());
			System.out.println(" <-------------------------BLOB SAVE STARTS------------------------------------->");
			System.out.println(" Session Id--------------->"+customLookupsForm.getSessionId());
			ByteArrayInputStream bytearrayinputstream1 =saveBLOB(customlist);
			if(customLookupsForm.getDispatch()!=null && !customLookupsForm.getDispatch().equals("report")){			
			List pagelist =hibernateTemplate.find(" from TempPagination where sessionId='"+customLookupsForm.getSessionId()+"'");
			if(pagelist!=null && pagelist.size()>0)
			{
				TempPagination tempPagination=(TempPagination)pagelist.get(0);
				tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream1));
				tempPagination.setSessionId(customLookupsForm.getSessionId());
				hibernateTemplate.saveOrUpdate(tempPagination);
				hibernateTemplate.flush();
			}
			else
			{
				TempPagination tempPagination=new TempPagination();
				tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream1));
				tempPagination.setSessionId(customLookupsForm.getSessionId());
				hibernateTemplate.saveOrUpdate(tempPagination);
				hibernateTemplate.flush();
			}
			System.out.println(" <----------------------------------BLOB SAVED ------------------------------------->");
			return paginationmethod(customLookupsForm);
			}else
			return lookupsForm2;
			
	}
	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getaddnewcustomlookslist(org.gaddiel.form.CustomLookupsForm)
	 */
	public Lookups getadvancedsearchcustomlookslist(CustomLookupsForm customLookupsForm)throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------THE SEARCH CODE VALUE------"+customLookupsForm.getSearchCode());
		System.out.println("----------THE SEARCH DESCRIPTION VALUE----"+customLookupsForm.getSearchDescription());
		
		
		List customlist1=new ArrayList();
		List list1=new ArrayList();
		System.out.println(" ---customlist DaoImpl  1 ---->");
		Lookups lookupsForm1=new Lookups();
		String searchval=customLookupsForm.getSearchCode();
		String searchval1=customLookupsForm.getSearchDescription();
		String searchval2=customLookupsForm.getSearchValue();
		System.out.println("----searchval .size----"+searchval.length());
		System.out.println("----searchval1 .size----"+searchval1.length());
		System.out.println("----searchval2 .size----"+searchval2.length());
		int search[]={searchval.length(),searchval1.length(),searchval2.length()};
		
		
		
		String queryString="";
		queryString="select customLookupCode,customLookupValue,startDate,endDate,description,customLookupValueId,enabledFlag from CustomLookupValues where customLookupCategoryId='"+customLookupsForm.getCustomcategoryType()+"'";
	
		for(int i=0; i<search.length; i++)
		{
			if(i==0)
			{
				if(searchval.length()!=0)
				{
					System.out.println("----------THE First search code VALUE----");
					searchval="and customLookupCode like'"+searchval+"%'";
					queryString=queryString+searchval;
				}
					
			}
			else if(i==1)
			{
				if(searchval1.length()!=0)
				{
					System.out.println("----------IN Second search decription VALUE----");
					searchval1="and description like'"+searchval1+"%'";
					queryString=queryString+searchval1;
				}
			}
			else if(i==2)
			{
				if(searchval2.length()!=0)
				{
					System.out.println("----------THE third search VALUE----");
					searchval2="and customLookupValue like'"+searchval2+"%'";
					queryString=queryString+searchval2;
				}
			}
		}
		list1=hibernateTemplate.find(queryString);
		for(int i=0; i<list1.size(); i++)
		{
			System.out.println(" ---customlist DaoImpl 3---->");
			Object[] obj=(Object[]) list1.get(i);
			lookupsForm1=new Lookups();
			lookupsForm1.setCategoryCode(obj[0].toString());
			System.out.println("CategoryCode--->>"+obj[0].toString());
			lookupsForm1.setCategoryName(obj[1].toString());
			System.out.println("CategoryName --->"+obj[1].toString());
			lookupsForm1.setStartDate(obj[2]==null || obj[2].equals("null")?"":Converter.FormatDate(obj[2].toString()));
			System.out.println(" Start date --->"+obj[2]);
			lookupsForm1.setEndDate(obj[3]==null || obj[3].equals("null")?"":Converter.FormatDate(obj[3].toString()));
			System.out.println(" End date --->"+obj[3]);
			lookupsForm1.setDescription(obj[4]==null||obj[4].equals("null")?"":obj[4].toString());
			System.out.println("description --->"+obj[4]);
			lookupsForm1.setCategoryTypeId(obj[5].toString());
			System.out.println("Category Type Id --->"+obj[5].toString());
			lookupsForm1.setEnabledFlag(obj[6].toString());
			customlist1.add(lookupsForm1);
			
		}
		System.out.println(" ---customlist DaoImpl 4---->"+customlist1.size());
		lookupsForm1.setMemberList(customlist1);
        System.out.println(" lookuplist size-------------> "+customlist1.size());
		System.out.println(" <-------------------------BLOB SAVE STARTS------------------------------------->");
		System.out.println(" Session Id--------------->"+customLookupsForm.getSessionId());
		ByteArrayInputStream bytearrayinputstream1 =saveBLOB(customlist1);
		if(customLookupsForm.getDispatch()!=null && !customLookupsForm.getDispatch().equals("report")){			
		List pagelist =hibernateTemplate.find(" from TempPagination where sessionId='"+customLookupsForm.getSessionId()+"'");
		if(pagelist!=null && pagelist.size()>0)
		{
			TempPagination tempPagination=(TempPagination)pagelist.get(0);
			tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream1));
			tempPagination.setSessionId(customLookupsForm.getSessionId());
			hibernateTemplate.saveOrUpdate(tempPagination);
			hibernateTemplate.flush();
		}
		else
		{
			TempPagination tempPagination=new TempPagination();
			tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream1));
			tempPagination.setSessionId(customLookupsForm.getSessionId());
			hibernateTemplate.saveOrUpdate(tempPagination);
			hibernateTemplate.flush();
		}
		System.out.println(" <----------------------------------BLOB SAVED ------------------------------------->");
		return paginationmethod(customLookupsForm);
		}else
		return lookupsForm1;
	
	}
	
	
//-------------------------------------------------------------System lookups--------------------------------------------------
	/* (non-Javadoc)
 * @see org.gaddiel.dao.MemberDao#getlookupsvalue()
 */
public SystemLookupsForm getlookupsvalue() {
		List lookuplist=new ArrayList();
		List categorylist=new ArrayList();
		SystemLookupsForm systemLookupsValue=new SystemLookupsForm();
		System.out.println("<------------- Inside the getlookupsvalue ---------> ");
		try{
			/*ApplicationContext appContext = 
			    	   new ClassPathXmlApplicationContext(new String[] {"member-servlet.xml"});
			Resource resource = appContext.getResource("file:c:\\testing.txt");*/
				SystemLookupsForm systemLookupsValue1;
				String syslookupslist= rb.getString("syslookupslist.query");
				System.out.println(" syslookupslist-------------->"+syslookupslist);
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				Query syslookupQuery = session.createQuery(syslookupslist);
				System.out.println(" syslookupQuery------------------>"+syslookupQuery);
		       				//List list1=hibernateTemplate.find(" select distinct systemLookupCategory from SystemLookupValues ");
				int list1=syslookupQuery.list().size();
				System.out.println(" size of list ---------------->"+list1);
				for(int i=0;i<list1; i++)
				{
					Object obj=(Object)syslookupQuery.list().get(i);
					systemLookupsValue1=new SystemLookupsForm();
					systemLookupsValue1.setCategoryType(obj.toString());
					categorylist.add(obj.toString());
				}
				systemLookupsValue.setCategoryTypeList(categorylist);
				System.out.println(" lookuplist--------->"+systemLookupsValue.getCategoryTypeList().size());
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		 
				return systemLookupsValue;
				}	
	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getSystemviewList(org.gaddiel.form.MainForm)
	 */
	public SystemLookupsForm getSystemviewList(MainForm mainForm1) throws Exception{
		// TODO Auto-generated method stub
		List lookuplist=new ArrayList();
		System.out.println(" ---Lookups name ---->"+mainForm1.getCategotyType());
		SystemLookupsForm systemLookupsValue=new SystemLookupsForm();
		String viewlist="";
		
		viewlist="select systemLookupCategory,systemLookupValue,systemLookupCode,systemLookupValueId,description,enabledFlag,startDate,endDate from SystemLookupValues where systemLookupCategory='"+mainForm1.getCategotyType()+"' and systemLookupValue not in('select') ";
		if(mainForm1.getSortValue()!=null && mainForm1.getSortValue().equals("sortasc"))
		{
			viewlist=viewlist+" order by systemLookupValue asc";
		}else if(mainForm1.getSortValue()!=null && mainForm1.getSortValue().equals("sortdes"))
		{
			viewlist=viewlist+" order by systemLookupValue desc";
		}
		List list=hibernateTemplate.find(viewlist);
		for(int i=0; i<list.size(); i++)
		{
			Object[] obj=(Object[]) list.get(i);
			systemLookupsValue=new SystemLookupsForm();
			systemLookupsValue.setCategoryName(obj[0].toString());
			systemLookupsValue.setCategoryType(obj[1].toString());
			systemLookupsValue.setCategoryCode(obj[2]==null?"":obj[2].toString());
			systemLookupsValue.setCategoryId(obj[3].toString());
			systemLookupsValue.setDescription(obj[4]==null || obj[4]==""?null:obj[4].toString());
			systemLookupsValue.setEnabledFlag(obj[5]==null?"0":obj[5].toString());
			systemLookupsValue.setStartDate(obj[6]==null?"":Converter.FormatDate(obj[6].toString()));
			systemLookupsValue.setEndDate(obj[7]==null?"":Converter.FormatDate(obj[7].toString()));
			systemLookupsValue.setsNo(new Integer(i+1).toString());
			lookuplist.add(systemLookupsValue);
		}
		
		systemLookupsValue.setMemberList(lookuplist);
		System.out.println(" lookuplist size-------------> "+lookuplist.size());
		if(mainForm1.getDispatch()!=null && !mainForm1.getDispatch().equals("report")){
		System.out.println(" <-------------------------BLOB SAVE STARTS------------------------------------->");
		System.out.println(" Session Id--------------->"+mainForm1.getSessionId());
		ByteArrayInputStream bytearrayinputstream =saveBLOB(lookuplist);
		List pagelist =hibernateTemplate.find(" from TempPagination where sessionId='"+mainForm1.getSessionId()+"'");
		if(pagelist!=null && pagelist.size()>0)
		{
			TempPagination tempPagination=(TempPagination)pagelist.get(0);
			tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream));
			tempPagination.setSessionId(mainForm1.getSessionId());
			hibernateTemplate.saveOrUpdate(tempPagination);
			hibernateTemplate.flush();
		}
		else
		{
			TempPagination tempPagination=new TempPagination();
			tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream));
			tempPagination.setSessionId(mainForm1.getSessionId());
			hibernateTemplate.saveOrUpdate(tempPagination);
			hibernateTemplate.flush();
		}
		System.out.println(" <----------------------------------BLOB SAVED ------------------------------------->");
		
		return paginationmethod(mainForm1);
		}else
		return systemLookupsValue;
	}

	public SystemLookupsForm paginationmethod(MainForm mainForm1) throws IOException, SQLException, ClassNotFoundException{
		
		List paginationList = new ArrayList(); 
		SystemLookupsForm systemLookupsValue=new SystemLookupsForm();
		List list =hibernateTemplate.find(" from TempPagination where sessionId='"+mainForm1.getSessionId()+"'");
		TempPagination tempPagination=(TempPagination)list.get(0);
		ObjectInputStream stream = new ObjectInputStream(tempPagination.getTempVal().getBinaryStream());//where tempObj.getBlobDetails() returns the java.sql.Blob object
		paginationList = (List) stream.readObject();
		System.out.println(" paginationList-------------->"+paginationList.size());
		String page= rb.getString("pagination.pagesize");

		int pagesize=Integer.parseInt(page);
		int totallist=paginationList.size();
		int start=0,end=0;
		int pageno=1;
		
	         end = ((pageno-1)*pagesize)+pagesize;  
	
		
		if(end>=totallist){
            end = totallist;
            systemLookupsValue.setLastPage(true);
            System.out.println(" End insidec value-->"+end);
           }else{
        	   systemLookupsValue.setLastPage(false);
           }
			
		System.out.println(" End value ----------->"+end);
		int total=paginationList.size();
		System.out.println(" total value ----------->"+total);
		systemLookupsValue.setMemberList(paginationList.subList(start, end));
		systemLookupsValue.setPageNo(pageno);
		systemLookupsValue.setStart(start+1);
		systemLookupsValue.setEnd(end);
		systemLookupsValue.setTotal(total);
		systemLookupsValue.setFirstPage(true);
					
		return systemLookupsValue;
	}
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#saveSystemlookups(org.gaddiel.form.MainForm, java.lang.String)
	 */
	
	public SystemLookupsForm getTempList(MainForm getTempList) throws IOException, SQLException {
		
		// TODO Auto-generated method stub
		List paginationList = new ArrayList(); 
		SystemLookupsForm systemLookupsValue=new SystemLookupsForm();
		List list =hibernateTemplate.find(" from TempPagination where sessionId='"+getTempList.getSessionId()+"'");
		TempPagination tempPagination=(TempPagination)list.get(0);
		ObjectInputStream stream = new ObjectInputStream(tempPagination.getTempVal().getBinaryStream());
		try {
			paginationList = (List) stream.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" paginationList-------------->"+paginationList.size());
		System.out.println(" getTempList.getEnd();----------------->"+getTempList.getEnd());
		System.out.println(" page No======>"+getTempList.getPageNo());
		int end=0;
		String page= rb.getString("pagination.pagesize");
		int pagesize=Integer.parseInt(page);
		int pageno=getTempList.getPageNo();
		int totallist=paginationList.size();
		int start=0;
		//if(totallist >= pagesize){
	         end = ((pageno-1)*pagesize)+pagesize;  
		//}
		if(pageno!=1){
	           start= ((pageno-1)*pagesize);        
	           systemLookupsValue.setFirstPage(false);
	        }else{           
	        	systemLookupsValue.setFirstPage(true);            
	        }
	        
	        if(start == 0){
	        	systemLookupsValue.setFirstPage(true); 
	        	systemLookupsValue.setStart(start+1);
	        }else
	        {
	        	systemLookupsValue.setStart(start);
	        }
	        
		if(end>=totallist){
           end = totallist;
           systemLookupsValue.setLastPage(true);
          }else{
       	   systemLookupsValue.setLastPage(false);
          }
		System.out.println(" end-------------->"+end);
					System.out.println(" Last page ------------> "+systemLookupsValue.isLastPage());
					System.out.println(" first page ------------> "+systemLookupsValue.isFirstPage());
		int total=paginationList.size();
		
		systemLookupsValue.setMemberList(paginationList.subList(start, end));
		systemLookupsValue.setPageNo(pageno);
		
		
		systemLookupsValue.setEnd(end);
		systemLookupsValue.setTotal(total);
		
		return systemLookupsValue;
	}
	
	
	
	public MainForm saveSystemlookups(MainForm mainForm, String str) throws Exception{
		// TODO Auto-generated method stub
		System.out.println(" <------------inside the hibernate --------------->");
		SystemLookupsForm systemLookupsForm = new SystemLookupsForm();
		try
		{
		List lookup=mainForm.getLookups();
		List list =hibernateTemplate.find(" from SystemLookupValues where systemLookupCategory='"+mainForm.getCategotyType()+"' ");
		System.out.println(" lookup list size----->"+lookup.size());
		HashMap multimap=new HashMap();
		for(int i=0; i<lookup.size(); i++)
		{
			systemLookupsForm=(SystemLookupsForm) lookup.get(i);
			System.out.println(" Id value -------------->"+systemLookupsForm.getCategoryId()+"****************");
			String id1=systemLookupsForm.getCategoryId();
			System.out.println(" Checkbox value----->"+systemLookupsForm.getCheckBox1());
			if(systemLookupsForm.getCheckBox1()!=null)
			{
							
				if(systemLookupsForm.getCategoryId().equals("") || systemLookupsForm.getCategoryId()==null || systemLookupsForm.getCategoryId().equals("null"))
				{
					List precedence=hibernateTemplate.find(" select max(systemLookupPrecedence) from SystemLookupValues where systemLookupCategory='"+mainForm.getCategotyType()+"' ");
					Object obj=(Object) precedence.get(0);
								
					System.out.println(" Inside the checkbox ");
					SystemLookupValues systemLookupValues1=new SystemLookupValues();
					systemLookupValues1.setSystemLookupValue(systemLookupsForm.getCategoryType().toUpperCase());
					systemLookupValues1.setSystemLookupValueId(null);
					systemLookupValues1.setCreatedDate(new Date());
					systemLookupValues1.setLastUpdatedDate(new Date());
					systemLookupValues1.setSystemLookupCategory(mainForm.getCategotyType());
					systemLookupValues1.setSystemLookupCode(systemLookupsForm.getCategoryCode().toUpperCase());
					systemLookupValues1.setEnabledFlag(systemLookupsForm.getEnabledFlag()==null?"0":systemLookupsForm.getEnabledFlag());
					int precedenceval=Integer.parseInt(obj.toString());
					systemLookupValues1.setSystemLookupPrecedence(precedenceval+1);
					systemLookupValues1.setDescription(systemLookupsForm.getDescription());
					systemLookupValues1.setLastUpdatedBy(str);
					systemLookupValues1.setCreatedBy(str);
					systemLookupValues1.setStartDate(systemLookupsForm.getStartDate().length()==0?null:Converter.StringtoDateforDB(systemLookupsForm.getStartDate()));
					systemLookupValues1.setEndDate(systemLookupsForm.getEndDate().length()==0?null:Converter.StringtoDateforDB(systemLookupsForm.getEndDate()));
					hibernateTemplate.saveOrUpdate(systemLookupValues1);
					
				}
			multimap.put(id1, systemLookupsForm);
			
			}
		}
		
		System.out.println(" multimap size----->"+multimap.size()+"\t multimap value --/>"+multimap);
		for(int k=0; k<list.size(); k++)
		{
		
			SystemLookupValues systemLookupValues=(SystemLookupValues) list.get(k);
			systemLookupsForm=(SystemLookupsForm) multimap.get(systemLookupValues.getSystemLookupValueId().toString());
			System.out.println("------multimap.containsKey(systemLookupValues.getSystemLookupValueId().toString())--------> "+multimap.containsKey(" ")+ "\t-->"+multimap.containsKey(null));
			if(multimap.containsKey(systemLookupValues.getSystemLookupValueId().toString()) || (multimap.containsKey(" ")) || (multimap.containsKey(null)))
			{
		        System.out.println(" systemLookupsForm.getCategoryType()------------>"+systemLookupsForm.getCategoryType()+"\t --->"+systemLookupsForm.getCategoryId());
		        
				systemLookupValues.setSystemLookupValue(systemLookupsForm.getCategoryType()==null?null:systemLookupsForm.getCategoryType().toUpperCase());	
				systemLookupValues.setSystemLookupValueId(systemLookupsForm.getCategoryId()==null || systemLookupsForm.getCategoryId().equals("")?null:Integer.parseInt(systemLookupsForm.getCategoryId()));
				systemLookupValues.setSystemLookupCode(systemLookupsForm.getCategoryCode()==null?"":systemLookupsForm.getCategoryCode().toUpperCase());
				System.out.println(" systemLookupsForm.getEnabledFlag() IN UPDATE ------>"+systemLookupsForm.getEnabledFlag().isEmpty());
				systemLookupValues.setEnabledFlag(systemLookupsForm.getEnabledFlag()==null?"0":systemLookupsForm.getEnabledFlag());
				systemLookupValues.setLastUpdatedBy(str);
				systemLookupValues.setLastUpdatedDate(new Date());
				systemLookupValues.setDescription(systemLookupsForm.getDescription()==null?"":systemLookupsForm.getDescription());
				systemLookupValues.setStartDate(systemLookupsForm.getStartDate().length()==0?null:Converter.StringtoDateforDB(systemLookupsForm.getStartDate()));
				systemLookupValues.setEndDate(systemLookupsForm.getEndDate().length()==0?null:Converter.StringtoDateforDB(systemLookupsForm.getEndDate()));
				
				
				hibernateTemplate.saveOrUpdate(systemLookupValues);
				System.out.println("<------- after save --------->");
				
			}
		
		}
		/*------------------------------------ Add New ------------------------------------------------------------------------*/
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return mainForm;
		
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#deleteSystemlookups(java.lang.String)
	 */
	public List deleteSystemlookups(String value) {
		// TODO Auto-generated method stub
		List remaininglist=new ArrayList();
		String id[]=value.split(",");
		List list=hibernateTemplate.find(" from SystemLookupValues where systemLookupValueId='"+id[0]+"' ");
		SystemLookupValues systemLookupValues=(SystemLookupValues) list.get(0);
		hibernateTemplate.delete(systemLookupValues);
		MainForm form=new MainForm();
		form.setCategotyType(id[1]);
		System.out.println(" ---Lookups name ---->"+form.getCategotyType());
		Object name=form.getCategotyType();
		String idname=name.toString();
		String[] real=idname.split("=");
		return remaininglist;
	}	
	

	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getSystemlookslist(org.gaddiel.form.MainForm)
	 */
	public SystemLookupsForm getSystemlookslist(MainForm mainForm)throws Exception {
		List searchresultlist=new ArrayList();
		List looklist=new ArrayList();
		SystemLookupsForm syslookupsForm=new SystemLookupsForm();
		String searchvallooks=mainForm.getSystemlookssearch();
		String category=mainForm.getCategotyType(); 
		System.out.println("THE CATEGORY NAME IN SEARCH:"+category);
		if(searchvallooks!=null && searchvallooks!="")
		{
		searchvallooks=searchvallooks+"%";
		looklist=hibernateTemplate.find("select systemLookupCode,systemLookupValue,startDate,endDate,description,systemLookupValueId,enabledFlag from SystemLookupValues where systemLookupCategory='"+category+"'and systemLookupValue not in('select') and systemLookupValue like'"+searchvallooks+"'");
		}
		else
		{
			looklist=hibernateTemplate.find("select systemLookupCode,systemLookupValue,startDate,endDate,description,systemLookupValueId,enabledFlag from SystemLookupValues where systemLookupCategory='"+category+"' and systemLookupValue not in('select') ");
		System.out.println(" ---customlist DaoImpl  2 ---->");
		}
		for(int i=0; i<looklist.size(); i++)
		{
			System.out.println(" ---customlist DaoImpl 3---->");
			Object[] obj=(Object[]) looklist.get(i);
			syslookupsForm=new SystemLookupsForm();
			syslookupsForm.setCategoryCode(obj[0].toString());
			System.out.println("CategoryCode--->>"+obj[0].toString());
			syslookupsForm.setCategoryType(obj[1].toString());
			System.out.println("categoryType --->"+obj[1].toString());
			syslookupsForm.setStartDate(obj[2]==null || obj.equals("null")?"":Converter.FormatDate(obj[2].toString()));
			System.out.println(" Start date --->"+obj[2]);
			syslookupsForm.setEndDate(obj[3]==null || obj.equals("null")?"":Converter.FormatDate(obj[3].toString()));
			System.out.println(" End date --->"+obj[3]);
			syslookupsForm.setDescription(obj[4]==null || obj[4].equals("null")?"":obj[4].toString());
			System.out.println(" Description --->"+obj[4]);
			syslookupsForm.setCategoryId(obj[5].toString());
			System.out.println(" Category Id --->"+obj[5]);
			syslookupsForm.setEnabledFlag(obj[6]==null || obj[6].equals("null")?"":obj[6].toString());
			searchresultlist.add(syslookupsForm);
			
		}
		System.out.println(" ---customlist DaoImpl 4---->"+searchresultlist.size());
		System.out.println(" lookuplist size-------------> "+searchresultlist.size());
		syslookupsForm.setMemberList(searchresultlist);
		if(mainForm.getDispatch()!=null && !mainForm.getDispatch().equals("report")){
		System.out.println(" <-------------------------BLOB SAVE STARTS------------------------------------->");
		System.out.println(" Session Id--------------->"+mainForm.getSessionId());
		ByteArrayInputStream bytearrayinputstream =saveBLOB(searchresultlist);
		List pagelist =hibernateTemplate.find(" from TempPagination where sessionId='"+mainForm.getSessionId()+"'");
		if(pagelist!=null && pagelist.size()>0)
		{
			TempPagination tempPagination=(TempPagination)pagelist.get(0);
			tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream));
			tempPagination.setSessionId(mainForm.getSessionId());
			hibernateTemplate.saveOrUpdate(tempPagination);
			hibernateTemplate.flush();
		}
		else
		{
			TempPagination tempPagination=new TempPagination();
			tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream));
			tempPagination.setSessionId(mainForm.getSessionId());
			hibernateTemplate.saveOrUpdate(tempPagination);
			hibernateTemplate.flush();
		}
		System.out.println(" <----------------------------------BLOB SAVED ------------------------------------->");
		
		return paginationmethod(mainForm);
		}else
				
		return syslookupsForm;
	}
	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#getaddnewSystemlookslist(org.gaddiel.form.MainForm)
	 */

	public SystemLookupsForm getadvancedsearchsystemlookslist(MainForm mainForm)throws Exception
	{// TODO Auto-generated method stub
		
		System.out.println("--------THE SEARCH CODE VALUE------"+mainForm.getSearchCode());
		System.out.println("----------THE SEARCH DESCRIPTION VALUE----"+mainForm.getSearchDescription());
		
		
		List systemlist1=new ArrayList();
		List list1=new ArrayList();
		System.out.println(" ---systemlist DaoImpl  1 ---->");
		SystemLookupsForm syslookupsForm=new SystemLookupsForm();
		String category=mainForm.getCategotyType(); 
		String searchval=mainForm.getSearchCode();
		String searchval1=mainForm.getSearchDescription();
		String searchval2=mainForm.getSearchValue();
		
		System.out.println("----searchval .size----"+searchval.length());
		System.out.println("----searchval1 .size----"+searchval1.length());
		System.out.println("----searchval2 .size----"+searchval2.length());
		int search[]={searchval.length(),searchval1.length(),searchval2.length()};
		
		String queryString="";
		queryString="select systemLookupCode,systemLookupValue,startDate,endDate,description,systemLookupValueId,enabledFlag from SystemLookupValues where systemLookupCategory='"+category+"' and systemLookupValue not in('select')";
	
		for(int i=0; i<search.length; i++)
		{
			if(i==0)
			{
				if(searchval.length()!=0)
				{
					System.out.println("----------THE First search code VALUE----");
					searchval="and systemLookupCode like'"+searchval+"%'";
					queryString=queryString+searchval;
				}
					
			}
			else if(i==1)
			{
				if(searchval1.length()!=0)
				{
					System.out.println("----------IN Second search decription VALUE----");
					searchval1="and description like'"+searchval1+"%'";
					queryString=queryString+searchval1;
				}
			}
			else if(i==2)
			{
				if(searchval2.length()!=0)
				{
					System.out.println("----------THE third search VALUE----");
					searchval2="and systemLookupValue like'"+searchval2+"%'";
					queryString=queryString+searchval2;
				}
			}
		}

		list1=hibernateTemplate.find(queryString);
		for(int i=0; i<list1.size(); i++)
		{
			Object[] obj=(Object[]) list1.get(i);
			syslookupsForm=new SystemLookupsForm();
			syslookupsForm.setCategoryCode(obj[0].toString());
			System.out.println("CategoryCode--->>"+obj[0].toString());
			syslookupsForm.setCategoryType(obj[1].toString());
			System.out.println("categoryType --->"+obj[1].toString());
			syslookupsForm.setStartDate(obj[2]==null || obj.equals("null")?"":Converter.FormatDate(obj[2].toString()));
			System.out.println(" Start date --->"+obj[2]);
			syslookupsForm.setEndDate(obj[3]==null || obj.equals("null")?"":Converter.FormatDate(obj[3].toString()));
			System.out.println(" End date --->"+obj[3]);
			syslookupsForm.setDescription(obj[4]==null || obj[4].equals("null")?"":obj[4].toString());
			System.out.println(" Description --->"+obj[4]);
			syslookupsForm.setCategoryId(obj[5].toString());
			System.out.println(" Category Id --->"+obj[5]);
			syslookupsForm.setEnabledFlag(obj[6]==null || obj[6].equals("null")?"":obj[6].toString());
			systemlist1.add(syslookupsForm);
			
		}
		System.out.println(" ---customlist DaoImpl 4---->"+systemlist1.size());
		System.out.println(" lookuplist size-------------> "+systemlist1.size());
		syslookupsForm.setMemberList(systemlist1);
		if(mainForm.getDispatch()!=null && !mainForm.getDispatch().equals("report")){
		System.out.println(" <-------------------------BLOB SAVE STARTS------------------------------------->");
		System.out.println(" Session Id--------------->"+mainForm.getSessionId());
		ByteArrayInputStream bytearrayinputstream =saveBLOB(systemlist1);
		List pagelist =hibernateTemplate.find(" from TempPagination where sessionId='"+mainForm.getSessionId()+"'");
		if(pagelist!=null && pagelist.size()>0)
		{
			TempPagination tempPagination=(TempPagination)pagelist.get(0);
			tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream));
			tempPagination.setSessionId(mainForm.getSessionId());
			hibernateTemplate.saveOrUpdate(tempPagination);
			hibernateTemplate.flush();
		}
		else
		{
			TempPagination tempPagination=new TempPagination();
			tempPagination.setTempVal(Hibernate.createBlob(bytearrayinputstream));
			tempPagination.setSessionId(mainForm.getSessionId());
			hibernateTemplate.saveOrUpdate(tempPagination);
			hibernateTemplate.flush();
		}
		System.out.println(" <----------------------------------BLOB SAVED ------------------------------------->");
		
		return paginationmethod(mainForm);
		}else
				
		return syslookupsForm;
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.dao.MemberDao#addrole(org.gaddiel.form.RoleUserForm)
	 */
	public String addrole(RoleUserForm roleuser) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	public List getpriviligeslist(RoleForm roleForm1) {
		// TODO Auto-generated method stub
		List privilages=new ArrayList();
		try
		{
	    List list=new ArrayList();
		String roleid=roleForm1.getRoles();
		System.out.println(" roleid ---->"+roleid);
		if(roleid!=null && !roleid.equals("0"))
		{
		list=hibernateTemplate.find("select subfunc.functionName,rolepri.insertFlag,rolepri.updateFlag,rolepri.deleteFlag,rolepri.readFlag,rolepri.reportFlg,rolepri.rolePrivilgeId,rolepri.subscriberFunctionId,rolepri.roleId from SystemRolePrivileges rolepri,SystemSubscriberFunctions subfunc where rolepri.roleId='"+roleid+"'" +
				                    " and subfunc.subscriberFunctionId=rolepri.subscriberFunctionId");
		}
		else
		{
		list=hibernateTemplate.find("select subfunc.functionName,rolepri.insertFlag,rolepri.updateFlag,rolepri.deleteFlag,rolepri.readFlag,rolepri.reportFlg,rolepri.rolePrivilgeId,rolepri.subscriberFunctionId,rolepri.roleId from SystemRolePrivileges rolepri,SystemSubscriberFunctions subfunc where rolepri.roleId='4' " +
										" and subfunc.subscriberFunctionId=rolepri.subscriberFunctionId");
		}
		
		RoleForm2 roleForm=new RoleForm2();
		for(int i=0; i<list.size(); i++)
		{
			Object[] obj=(Object[]) list.get(i);
			roleForm=new RoleForm2();
			
			roleForm.setFunctionName(obj[0].toString());
			roleForm.setInsertFlag(obj[1]==null?"":obj[1].toString());
			roleForm.setUpdateFlag(obj[2]==null?"":obj[2].toString());
			roleForm.setReadFlag(obj[4]==null?"":obj[4].toString());
			roleForm.setDeleteFlag(obj[3]==null?"":obj[3].toString());
			roleForm.setReportFlag(obj[5]==null?"":obj[5].toString());
			roleForm.setSubscriberFunctionId(obj[7]==null?"":obj[7].toString());
			roleForm.setRoleId(obj[8].toString());
			privilages.add(roleForm);
			
		}
		//roleForm1.setRoles(roleForm1.getRoles());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return privilages;
	}
	public RoleForm saverolelist(RoleForm roleForm) {
		// TODO Auto-generated method stub
		
		try
		{
			List role1=roleForm.getLookups2();
			
			List list=hibernateTemplate.find(" from SystemRolePrivileges where roleId='"+roleForm.getRoles()+"'");
			HashMap rolelist=new HashMap();
			if(list!=null && list.size()>0)
			{
				for(int i=0; i<list.size(); i++)
				{
					SystemRolePrivileges SystemRolePrivileges=(SystemRolePrivileges) list.get(i);
					rolelist.put(SystemRolePrivileges.getSubscriberFunctionId(), SystemRolePrivileges);
				}
			}
			System.out.println("<----list----->"+list.size());
			System.out.println(" role1 list size----->"+role1.size());
			HashMap multimap=new HashMap();
			for(int i=0; i<role1.size(); i++)
			{
				
				RoleForm2 roleForm2=(RoleForm2) role1.get(i); 
				System.out.println(" Id value -------------->"+roleForm2.getSubscriberFunctionId());
				int Id=Integer.parseInt(roleForm2.getSubscriberFunctionId());
				System.out.println(" selectbox value----->"+roleForm2.getSelectbox());	
			//	if(roleForm2.getSelectbox()!=null && roleForm2.getSelectbox().equals("1")){
				System.out.println(" !rolelist.containsKey(Integer.parseInt(roleForm2.getSubscriberFunctionId())------ "+!rolelist.containsKey(Integer.parseInt(roleForm2.getSubscriberFunctionId())));
					if(rolelist==null || !rolelist.containsKey(Integer.parseInt(roleForm2.getSubscriberFunctionId())))
					{
						SystemRolePrivileges systemRolePrivileges =new SystemRolePrivileges();
						System.out.println("roleid----->>"+systemRolePrivileges.getRoleId());
						systemRolePrivileges.setSubscriberFunctionId(Integer.parseInt(roleForm2.getSubscriberFunctionId()));
						System.out.println(" Insert flag--------->"+roleForm2.getInsertFlag());
						systemRolePrivileges.setInsertFlag(roleForm2.getInsertFlag()==null?"0":roleForm2.getInsertFlag());
						System.out.println(" updated flag--------->"+roleForm2.getUpdateFlag());
						systemRolePrivileges.setUpdateFlag(roleForm2.getUpdateFlag()==null?"0":roleForm2.getUpdateFlag());
						System.out.println(" delete flag--------->"+roleForm2.getDeleteFlag());
						systemRolePrivileges.setDeleteFlag(roleForm2.getDeleteFlag()==null?"0":roleForm2.getDeleteFlag());
						System.out.println(" report flag--------->"+roleForm2.getReportFlag());
						systemRolePrivileges.setReportFlg(roleForm2.getReportFlag()==null?"0":roleForm2.getReportFlag());
						systemRolePrivileges.setReadFlag(roleForm2.getReadFlag()==null?"0":roleForm2.getReadFlag());
						systemRolePrivileges.setCreatedDate(new Date());
						systemRolePrivileges.setLastUpdatedDate(new Date());
						systemRolePrivileges.setCreatedBy(roleForm.getUsername());
						systemRolePrivileges.setRoleId(Integer.parseInt(roleForm.getRoles()));
						hibernateTemplate.saveOrUpdate(systemRolePrivileges);
					}
					
				//}
				multimap.put(Id, roleForm2);
			}
		
			System.out.println(" multimap size----->"+multimap.size()+"\t multimap value --/>"+multimap);
			for(int k=0; k<list.size(); k++)
			{
				SystemRolePrivileges systemRolePrivileges=(SystemRolePrivileges) list.get(k);
				RoleForm2 roleForm2=(RoleForm2) multimap.get(systemRolePrivileges.getSubscriberFunctionId());
				System.out.println("---------roleUserForm2--->"+roleForm2.getSelectbox());
				System.out.println("------(multimap.containsKey(systemRoles1.getRoleId())--------> "+multimap.containsKey(systemRolePrivileges.getSubscriberFunctionId()));;
				if(multimap.containsKey(systemRolePrivileges.getSubscriberFunctionId()))
				{
					System.out.println(" <---------------------------------------------- Inside Update ------------------------------------------------------>");
					System.out.println(" update insert flag----------------->"+roleForm2.getInsertFlag());
					systemRolePrivileges.setInsertFlag(roleForm2.getInsertFlag()==null?"0":roleForm2.getInsertFlag());
					System.out.println("update Delete flag------------->"+roleForm2.getDeleteFlag());
					systemRolePrivileges.setDeleteFlag(roleForm2.getDeleteFlag()==null?"0":roleForm2.getDeleteFlag());
					System.out.println(" update  Report flag------------->"+roleForm2.getReportFlag());
					systemRolePrivileges.setReportFlg(roleForm2.getReportFlag()==null?"0":roleForm2.getReportFlag());
					System.out.println(" update  Read flag------------->"+roleForm2.getReadFlag());
					systemRolePrivileges.setReadFlag(roleForm2.getReadFlag()==null?"0":roleForm2.getReadFlag());
					systemRolePrivileges.setUpdateFlag(roleForm2.getUpdateFlag()==null?"0":roleForm2.getUpdateFlag());
					systemRolePrivileges.setLastUpdatedDate(new Date());
					systemRolePrivileges.setLastUpdatedBy(roleForm.getUsername());
					//systemRolePrivileges.setRoleId(Integer.parseInt(roleForm.getRoles()));
					hibernateTemplate.saveOrUpdate(systemRolePrivileges);
				}
			}
			System.out.println("<------- after save the roleusers --------->");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			List privilleges=getpriviligeslist(roleForm);
			roleForm.setLookups2(privilleges);
				return roleForm;
	}
	public MainForm saveinline(String var, String var1, String var2, String var3, String var4, String checkbox, String str) throws ParseException
	{
		MainForm mainForm = new MainForm();
		System.out.println("----IN DAO IMPL----");
		List list1=hibernateTemplate.find("from SystemLookupValues where systemLookupValueId='"+var+"'");
		SystemLookupValues systemLookupValues=(SystemLookupValues) list1.get(0);
		systemLookupValues.setSystemLookupValue(var1.toUpperCase());
		systemLookupValues.setDescription(var2==null?null:var2);
		systemLookupValues.setStartDate(var3==null?null:Converter.StringtoDateforDB(var3));
		systemLookupValues.setEndDate(var4==null?null:Converter.StringtoDateforDB(var4));
		systemLookupValues.setLastUpdatedDate(new Date());
		systemLookupValues.setEnabledFlag(checkbox);
		systemLookupValues.setLastUpdatedBy(str);
		hibernateTemplate.saveOrUpdate(systemLookupValues);
		return mainForm;
	}

	
	
	
	
	public MainForm systemlinesave(String var, String var1, String var2, String var3, String var4, String var5, String checkbox, String str, MainForm mainForm1) throws ParseException 
	{
		
		System.out.println("----IN DAO IMPL----");
		List precedence=hibernateTemplate.find(" select max(systemLookupPrecedence) from SystemLookupValues where systemLookupCategory='"+var+"' ");
		Object obj=(Object) precedence.get(0);
		SystemLookupValues systemLookupValues=new SystemLookupValues();
		systemLookupValues.setSystemLookupCategory(var.toString());
		System.out.println("--------DROP DOWN VALUE---------"+mainForm1.getCategotyType());
		systemLookupValues.setSystemLookupCode(var1.toUpperCase());
		systemLookupValues.setSystemLookupValueId(null);
		systemLookupValues.setSystemLookupValue(var2.toUpperCase());

		int precedenceval=Integer.parseInt(obj.toString());
		systemLookupValues.setSystemLookupPrecedence(precedenceval+1);
		systemLookupValues.setDescription(var3==null?null:var3);
		systemLookupValues.setStartDate(var4==null?null:Converter.StringtoDateforDB(var4));
		systemLookupValues.setEndDate(var5==null?null:Converter.StringtoDateforDB(var5));
		systemLookupValues.setLastUpdatedDate(new Date());
		systemLookupValues.setEnabledFlag(mainForm1.getNewcheckbox()==null?null:mainForm1.getNewcheckbox());
		systemLookupValues.setLastUpdatedBy(str);
		systemLookupValues.setCreatedBy(str);
		systemLookupValues.setCreatedDate(new Date());
		hibernateTemplate.saveOrUpdate(systemLookupValues);
		return mainForm1;
	}
	



	
	public CustomLookupsForm addnewsave(String str,CustomLookupsForm  mainForm1, LookupspopupForm systemlookupspopupForm) throws ParseException 
	{			
		System.out.println("----IN DAO IMPL----");
		CustomLookupCategories customLookupCategories=new CustomLookupCategories();
		customLookupCategories.setCustomLookupCategory(systemlookupspopupForm.getCategoryName().toUpperCase());
		customLookupCategories.setCustomLookupCategoryId(null);
		customLookupCategories.setCreatedDate(new Date());
		customLookupCategories.setLastUpdatedDate(new Date());
		System.out.println(" systemlookupspopupForm.getEnabledFlag()----------------------->"+systemlookupspopupForm.getEnabledFlag());
		customLookupCategories.setEnabledFlag(systemlookupspopupForm.getEnabledFlag()==null || systemlookupspopupForm.getEnabledFlag().equals("null")?"0":systemlookupspopupForm.getEnabledFlag());
		customLookupCategories.setDescription(systemlookupspopupForm.getDescription());
		customLookupCategories.setLastUpdatedBy(str);
		customLookupCategories.setCreatedBy(str);
		customLookupCategories.setStartDate(systemlookupspopupForm.getStartDate().length()==0?null:Converter.StringtoDateforDB(systemlookupspopupForm.getStartDate()));
		customLookupCategories.setEndDate(systemlookupspopupForm.getEndDate().length()==0?null:Converter.StringtoDateforDB(systemlookupspopupForm.getEndDate()));
		hibernateTemplate.saveOrUpdate(customLookupCategories);
		return mainForm1;
	}
	public RoleUserForm getuserlist(RoleUserForm roleUserForm) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public List getuserlist() {
		// TODO Auto-generated method stub
		return null;
	}


	public RoleUserForm inlinesave(String var, String var1, String var2, String var3, String var4,String roleassignmentid,String checkbox, String str, RoleUserForm roleUserForm) throws ParseException 
	{
		
	try{	
	System.out.println("----IN DAO IMPL----");
		List list2=hibernateTemplate.find("from SystemUsers where userId='"+var+"'");
		SystemUsers systemUsers=(SystemUsers) list2.get(0);
		int roleid=Integer.parseInt(var2);
		systemUsers.setUserName(var1);
		systemUsers.setRoleId(roleid);
		systemUsers.setLastActivityDesc(var3);
		systemUsers.setStartDate(var4==null?null:Converter.StringtoDateforDB(var4));
		systemUsers.setEnabledFlag(checkbox);
		systemUsers.setLastUpdatedBy(str);
		systemUsers.setLastUpdatedDate(new Date());
		hibernateTemplate.saveOrUpdate(systemUsers);

		

		
		System.out.println("----IN DAO IMPL----");
		List list1=hibernateTemplate.find("from SystemUserRoleAssignments where userId='"+var+"' and endDate is null and roleAssignmentId='"+roleassignmentid+"'");
		SystemUserRoleAssignments systemUserRoleAssignments=(SystemUserRoleAssignments) list1.get(0);
		systemUserRoleAssignments.setEndDate(new Date());
		systemUserRoleAssignments.setLastUpdatedBy(str);
		systemUserRoleAssignments.setLastUpdatedDate(new Date());
		hibernateTemplate.saveOrUpdate(systemUserRoleAssignments);
		
		SystemUserRoleAssignments systemUserRoleAssignments1 = new SystemUserRoleAssignments();
		int userid=Integer.parseInt(var);
		systemUserRoleAssignments1.setUserId(userid);
		systemUserRoleAssignments1.setRoleId(roleid);
		systemUserRoleAssignments1.setStartDate(new Date());
		systemUserRoleAssignments1.setCreatedBy(str);
		systemUserRoleAssignments1.setCreatedDate(new Date());
		systemUserRoleAssignments1.setLastUpdatedBy(str);
		systemUserRoleAssignments1.setDeleteFlag("N");
		systemUserRoleAssignments1.setLastUpdatedDate(new Date());
		hibernateTemplate.saveOrUpdate(systemUserRoleAssignments1);

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return roleUserForm;
	}


	public RoleUserForm newinlinesave(String var, String var1, String var2,String var3,String checkbox, String str, RoleUserForm roleUserForm) throws ParseException 
	{
		
	try{	
	System.out.println("----IN DAO IMPL----");
	List subscribelist=hibernateTemplate.find("select subscriberId from SystemUsers where userName='"+str+"'");
	String subscribe=subscribelist.get(0).toString();
	subscribe=subscribe.replace('[',' ');
	subscribe=subscribe.replace(']',' ');
	subscribe=subscribe.trim();
	int subscriberId=Integer.parseInt(subscribe);
		SystemUsers systemUsers=new SystemUsers();
		systemUsers.setUserName(var);
		systemUsers.setSubscriberId(subscriberId);
		systemUsers.setLastActivityDesc(var2);
		systemUsers.setStartDate(var3==null?null:Converter.StringtoDateforDB(var3));
		systemUsers.setEnabledFlag(checkbox);
		systemUsers.setLastUpdatedBy(str);
		systemUsers.setCreatedDate(new Date());
		systemUsers.setUserPassword("user");
		systemUsers.setEncryptedPassword("user123");
		List list1=hibernateTemplate.find("select roleId from SystemRoles where roleName='"+var1+"'");
		String role=list1.toString();
		role=role.replace('[',' ');
		role=role.replace(']',' ');
		role=role.trim();
		int roleid=Integer.parseInt(role);
		systemUsers.setRoleId(roleid);
		systemUsers.setDeleteFlag("N");
		systemUsers.setLastUpdatedDate(new Date());
		systemUsers.setLastFailedLoginDate(new Date());
		hibernateTemplate.saveOrUpdate(systemUsers);
		System.out.println("----USER ID-----"+systemUsers.getUserId());
				
		SystemUserRoleAssignments systemUserRoleAssignments1 = new SystemUserRoleAssignments();
		systemUserRoleAssignments1.setUserId(systemUsers.getUserId());
		List list=hibernateTemplate.find("select roleId from SystemRoles where roleName='"+var1+"'");
		String role1=list.toString();
		role1=role1.replace('[',' ');
		role1=role1.replace(']',' ');
		role1=role1.trim();
		int roleid1=Integer.parseInt(role1);
		systemUserRoleAssignments1.setRoleId(roleid1);
		systemUserRoleAssignments1.setStartDate(new Date());
		systemUserRoleAssignments1.setCreatedBy(str);
		systemUserRoleAssignments1.setCreatedDate(new Date());
		systemUserRoleAssignments1.setLastUpdatedBy(str);
		systemUserRoleAssignments1.setDeleteFlag("N");
		systemUserRoleAssignments1.setLastUpdatedDate(new Date());
		hibernateTemplate.saveOrUpdate(systemUserRoleAssignments1);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return roleUserForm;
	}

	public FamilypopupForm getsubscriptionlist(SubscriptionPlanForm subscriptionPlanForm,FamilypopupForm familypopupForm) throws ParseException {
		// TODO Auto-generated method stub
		List planform=new ArrayList();
int id=subscriptionPlanForm.getFamilyId();
List list=hibernateTemplate.find("from SubscriptionPlan where familyId='"+id+"'");
		for(int i=0; i<list.size(); i++)
		{
			SubscriptionPlan subscriptionPlan=(SubscriptionPlan)list.get(i);
			subscriptionPlanForm=new SubscriptionPlanForm();
			subscriptionPlanForm.setSubscriptionAmount(subscriptionPlan.getSubsAmount());
			subscriptionPlanForm.setStartDate(subscriptionPlan.getStartDate()==null?"":Converter.FormatDate(subscriptionPlan.getStartDate().toString()));
			subscriptionPlanForm.setEndDate(subscriptionPlan.getEndDate()==null?"":Converter.FormatDate(subscriptionPlan.getEndDate().toString()));
			subscriptionPlanForm.setEnabledFlag(subscriptionPlan.getEnabledFlag());
			subscriptionPlanForm.setPlanId(subscriptionPlan.getSubsPlanId());
			subscriptionPlanForm.setFamilyId(subscriptionPlan.getFamilyId());
			planform.add(subscriptionPlanForm);
			
		}
		//roleForm1.setRoles(roleForm1.getRoles());
		familypopupForm.setSubscriptionPlanForm(planform);
		return familypopupForm;
	}
	

	public FamilypopupForm savesubscriptionlist(String var1,String var2,String var3,String var4,String var5,String str,FamilypopupForm familypopupForm) throws ParseException {
		// TODO Auto-generated method stub
		List planform=new ArrayList();

List list=hibernateTemplate.find("from SubscriptionPlan where subsPlanId='"+var1+"'");
			SubscriptionPlan subscriptionPlan=(SubscriptionPlan)list.get(0);
			subscriptionPlan.setEnabledFlag(var5);
			subscriptionPlan.setEndDate(var3==null?null:Converter.StringtoDateforDB(var3));
			subscriptionPlan.setStartDate(var2==null?null:Converter.StringtoDateforDB(var2));
			subscriptionPlan.setLastUpdatedDate(new Date());
			subscriptionPlan.setLastUpdatedBy(str);
			hibernateTemplate.saveOrUpdate(subscriptionPlan);
			
List list1=hibernateTemplate.find("from Family where familyId='"+subscriptionPlan.getFamilyId()+"'");
Family family=(Family)list1.get(0);
family.setSubscriptionPaidUptoDate(var4==null?null:Converter.StringtoDateforDB(var4));
hibernateTemplate.saveOrUpdate(family);

			return familypopupForm;
		}

	public FamilypopupForm savenewsubscriptionlist(String var1,String var2,String var3,String var4,String var5,String str,FamilypopupForm familypopupForm) throws ParseException {
		// TODO Auto-generated method stub

		System.out.println("first"+var1);
		System.out.println("second"+var2);
		System.out.println("third"+var3);
		System.out.println("fourth"+var4);
		System.out.println("fifth"+var5);
		
try{

		SubscriptionPlan subscriptionPlan=new SubscriptionPlan();
		subscriptionPlan.setFamilyId(Integer.parseInt(var1));
		subscriptionPlan.setSubsAmount(Integer.parseInt(var2));
		subscriptionPlan.setStartDate(var3==null?null:Converter.StringtoDateforDB(var3));
		subscriptionPlan.setEndDate(var4==null?null:Converter.StringtoDateforDB(var4));
		subscriptionPlan.setCreatedBy(str);
		subscriptionPlan.setCreatedDate(new Date());
		subscriptionPlan.setLastUpdatedDate(new Date());
		subscriptionPlan.setLastUpdatedBy(str);
		hibernateTemplate.saveOrUpdate(subscriptionPlan);
		
		List list1=hibernateTemplate.find("from Family where familyId='"+subscriptionPlan.getFamilyId()+"'");
		Family family=(Family)list1.get(0);
		family.setSubscriptionPaidUptoDate(var5==null?null:Converter.StringtoDateforDB(var5));
		hibernateTemplate.saveOrUpdate(family);
}
catch(Exception e)
{
	e.printStackTrace();
}
		return familypopupForm;
	}
	
	
	
	
	public FamilypopupForm getsubscriptionpaidlist(SubscriptionPaidForm subscriptionPaidForm,FamilypopupForm familypopupForm) throws ParseException {
		// TODO Auto-generated method stub
		List paidform=new ArrayList();
int id=subscriptionPaidForm.getFamilyId();
List list=hibernateTemplate.find("from CollectionsRegister where familyId='"+id+"'");
		for(int i=0; i<list.size(); i++)
		{
			CollectionsRegister collectionsRegister=(CollectionsRegister)list.get(i);
			subscriptionPaidForm=new SubscriptionPaidForm();
			subscriptionPaidForm.setReceiptNo(collectionsRegister.getReceiptNumber());
			subscriptionPaidForm.setReceiptDate(collectionsRegister.getReceiptDate()==null?"":Converter.FormatDate(collectionsRegister.getReceiptDate().toString()));
			subscriptionPaidForm.setAmount(collectionsRegister.getCollectionAmt());
			int idc=collectionsRegister.getCustlvPaymentModeId();
			List list1=hibernateTemplate.find("select customLookupValue from CustomLookupValues where customLookupValueId='"+idc+"'");
			String modeofpay=list1.toString();
			modeofpay=modeofpay.replace('[',' ');
			modeofpay=modeofpay.replace(']',' ');
			modeofpay=modeofpay.trim();
			subscriptionPaidForm.setModeOfPayment(modeofpay);
			paidform.add(subscriptionPaidForm);
			
		}
		//roleForm1.setRoles(roleForm1.getRoles());
		familypopupForm.setSubscriptionPaidForm(paidform);
		return familypopupForm;
	}
	public CollectionRegistersForm getcollectionregister(CollectionRegistersSubForm collectionRegistersSubForm,CollectionRegistersForm collectionRegistersForm) throws ParseException {
		// TODO Auto-generated method stub
		List paidform=new ArrayList();
int id=collectionRegistersSubForm.getFamilyId();
//SELECT last_updated_date,collection_id FROM collections_register  where FAMILY_ID='2' HAVING max(last_updated_date);
// select max(systemLookupPrecedence)
//collectionsRegister.getFamilyId()
	/*List list22=hibernateTemplate.find("select max(lastUpdatedDate) from CollectionsRegister where familyId='"+list21.get(j)+"'");
	System.out.println("--------COLLECTION REGISTER---------"+list22);	
	String lastdate=list22.toString();
	lastdate=lastdate.replace('[',' ');
	lastdate=lastdate.replace(']',' ');
	lastdate=lastdate.trim();
	List list23=hibernateTemplate.find("select collectionId  from CollectionsRegister where lastUpdatedDate='"+lastdate+"'");
	String collid=list23.toString();
	collid=collid.replace('[',' ');
	collid=collid.replace(']',' ');
	collid=collid.trim();*/
	List list=hibernateTemplate.find("from CollectionsRegister");
for(int i=0;i<list.size();i++)	
	{	
	CollectionsRegister collectionsRegister=(CollectionsRegister)list.get(i);
		collectionRegistersSubForm=new CollectionRegistersSubForm();
		collectionRegistersSubForm.setReceiptNo(collectionsRegister.getReceiptNumber());
		collectionRegistersSubForm.setReceiptDate(collectionsRegister.getReceiptDate()==null?"":Converter.FormatDate(collectionsRegister.getReceiptDate().toString()));
		collectionRegistersSubForm.setAmount(collectionsRegister.getCollectionAmt());
		int idc=collectionsRegister.getCustlvPaymentModeId();
		List list1=hibernateTemplate.find("select customLookupValue from CustomLookupValues where customLookupValueId='"+idc+"'");
		String modeofpay=list1.toString();
		modeofpay=modeofpay.replace('[',' ');
		modeofpay=modeofpay.replace(']',' ');
		modeofpay=modeofpay.trim();
		collectionRegistersSubForm.setModeOfPay(modeofpay);
		List list2=hibernateTemplate.find("select subscriptionPaidUptoDate from Family where familyId='"+collectionsRegister.getFamilyId()+"'");
		String lastPaidUpto=list2.toString();
		lastPaidUpto=lastPaidUpto.replace('[',' ');
		lastPaidUpto=lastPaidUpto.replace(']',' ');
		lastPaidUpto=lastPaidUpto.trim();
		System.out.println("---------LAST PAID UPTO----------"+lastPaidUpto);
		collectionRegistersSubForm.setLastPaidUpto(lastPaidUpto.equals("null")?"":Converter.FormatDate(lastPaidUpto));
		collectionRegistersSubForm.setFamilyId(collectionsRegister.getFamilyId());
		paidform.add(collectionRegistersSubForm);
	}		

		//roleForm1.setRoles(roleForm1.getRoles());
		collectionRegistersForm.setCollectionRegistersSubForm(paidform);
		return collectionRegistersForm;
	}
	public List modelist()
	{
		
		List list1=hibernateTemplate.find("select customLookupCategoryId from CustomLookupCategories where customLookupCategory='PAYMENT MODE'");
		String categoryid=list1.toString();
		categoryid=categoryid.replace('[',' ');
		categoryid=categoryid.replace(']',' ');
		categoryid=categoryid.trim();
		List list=hibernateTemplate.find("select customLookupValue from CustomLookupValues where customLookupCategoryId='"+categoryid+"'");
		return list;
	}
	
	public CollectionRegistersForm savenewcollection(String var1,String var2,String var3,String var4,String var5,String var6,String str,CollectionRegistersForm collectionRegistersForm) throws ParseException {
		CollectionsRegister collectionsRegister=new CollectionsRegister();
		collectionsRegister.setFamilyId(Integer.parseInt(var1));
		List list=hibernateTemplate.find("select customLookupValueId from CustomLookupValues where customLookupValue='"+var2+"'");
		String lvid=list.toString();
		lvid=lvid.replace('[',' ');
		lvid=lvid.replace(']',' ');
		lvid=lvid.trim();
		collectionsRegister.setCustlvPaymentModeId(Integer.parseInt(lvid));
		collectionsRegister.setCollectionAmt(Integer.parseInt(var3));
		collectionsRegister.setReceiptNumber(var4);
		collectionsRegister.setReceiptDate(var5==null?null:Converter.StringtoDateforDB(var5));
		collectionsRegister.setCreatedBy(str);
		collectionsRegister.setCreatedDate(new Date());
		collectionsRegister.setLastUpdatedDate(new Date());
		collectionsRegister.setLastUpdatedBy(str);
		hibernateTemplate.saveOrUpdate(collectionsRegister);
		List list2=hibernateTemplate.find("from Family where familyId='"+var1+"'");
		Family family=(Family)list2.get(0);
		family.setSubscriptionPaidUptoDate(var6==null?null:Converter.StringtoDateforDB(var6));
		hibernateTemplate.saveOrUpdate(family);
		return collectionRegistersForm;
	}
	
	public ContributionSchedulesForm getcollectionschedule(ContributionSchedulesSubForm contributionSchedulesSubForm,ContributionSchedulesForm contributionSchedulesForm) throws ParseException {
		List schedule=new ArrayList();
		
		List list=hibernateTemplate.find("from ContributionSchedules");
		for(int i=0;i<list.size();i++)	
		{
			ContributionSchedules contributionSchedules=(ContributionSchedules)list.get(i);
			contributionSchedulesSubForm=new ContributionSchedulesSubForm();
			contributionSchedulesSubForm.setContributionscheduleid(contributionSchedules.getContributionScheduleId());
			contributionSchedulesSubForm.setAmount(contributionSchedules.getContributionAmount());
			int id=contributionSchedules.getCustlvCollectionTypeId();
			List list2=hibernateTemplate.find("select customLookupValue from CustomLookupValues where customLookupValueId='"+id+"' ");
			contributionSchedulesSubForm.setCollectionType(list2.get(0).toString());
			int id1=contributionSchedules.getCustlvFrequencyTypeId();
			List list3=hibernateTemplate.find("select customLookupValue from CustomLookupValues where customLookupValueId='"+id1+"' ");
			contributionSchedulesSubForm.setCollectionFrequency(list3.get(0).toString());
			int id2=contributionSchedules.getCustlvDueDaysId();
			List list4=hibernateTemplate.find("select customLookupValue from CustomLookupValues where customLookupValueId='"+id2+"' ");
			contributionSchedulesSubForm.setCollectionDuedays(list4.get(0).toString());
			contributionSchedulesSubForm.setDueDate(contributionSchedules.getDueDate()==null?"":contributionSchedules.getDueDate().toString());
			contributionSchedulesSubForm.setStartDate(contributionSchedules.getDueDate()==null?"":Converter.FormatDate(contributionSchedules.getStartDate().toString()));
			contributionSchedulesSubForm.setEndDate(contributionSchedules.getEndDate()==null?"":Converter.FormatDate(contributionSchedules.getEndDate().toString()));
			contributionSchedulesSubForm.setEnabledFlag(contributionSchedules.getEnabledFlag());
			schedule.add(contributionSchedulesSubForm);
		}
		contributionSchedulesForm.setContributionSchedulesSubForm(schedule);
		return contributionSchedulesForm;
	}
	public List collectiontype()
	{
		//select sys.customLookupCategoryId from ChurchPreferences cp,CustomLookupValues sys where cp.customLookupValueId=sys.customLookupValueId
		String querystring="";
		List list=new ArrayList();
		List list1=hibernateTemplate.find("select custlvCollectionTypeId from ContributionSchedules where endDate is null");

		list=hibernateTemplate.find("select customLookupValue from CustomLookupValues where customLookupCategoryId=35 ");
		
		return list;
	}
	public List collectionfreq()
	{
		List list=hibernateTemplate.find("select customLookupValue from CustomLookupValues where customLookupCategoryId=46");
		return list;
	}
	public List duelist()
	{
		List list=hibernateTemplate.find("select customLookupValue from CustomLookupValues where customLookupCategoryId=48");
		return list;
	}
	
	
	public List collectiondue(String val)
	{
		List list=new ArrayList();
		ContributionSchedulesForm contributionSchedulesForm;
		List catid=hibernateTemplate.find("select customLookupCategoryId from CustomLookupCategories where customLookupCategory='"+val+"'");
		int id=Integer.parseInt(catid.get(0).toString());
		List list2=hibernateTemplate.find("from CustomLookupValues where customLookupCategoryId="+id+"");
	
		for(int i=0;i<list2.size();i++)
		{

			CustomLookupValues customLookupValues=(CustomLookupValues)list2.get(i);
			contributionSchedulesForm=new ContributionSchedulesForm();
			contributionSchedulesForm.setId(customLookupValues.getCustomLookupValueId()==null ?"":customLookupValues.getCustomLookupValueId().toString());
			contributionSchedulesForm.setValue(customLookupValues.getCustomLookupValue()==null?"":customLookupValues.getCustomLookupValue());
			list.add(contributionSchedulesForm);
		}
		return list;
	}
	public ContributionSchedulesForm savenewcontributionlist(String var1,String var2,String var3,String var4,String var5,String var6,String var7,String checkbox,String str,ContributionSchedulesForm contributionSchedulesForm) throws ParseException {
		// TODO Auto-generated method stub
	
		try{
		ContributionSchedules contributionSchedules=new ContributionSchedules();
		contributionSchedules.setContributionAmount(Integer.parseInt(var1));
		List list1=hibernateTemplate.find("select customLookupValueId from CustomLookupValues where customLookupCategoryId=35 and customLookupValue='"+var2+"' ");
		contributionSchedules.setCustlvCollectionTypeId(Integer.parseInt(list1.get(0).toString()));
		List list2=hibernateTemplate.find("select customLookupValueId from CustomLookupValues where customLookupCategoryId=46 and customLookupValue='"+var3+"' ");
		contributionSchedules.setCustlvFrequencyTypeId(Integer.parseInt(list2.get(0).toString()));
		contributionSchedules.setCustlvDueDaysId(Integer.parseInt(var4));
		contributionSchedules.setDueDate(Integer.parseInt(var5));
		contributionSchedules.setStartDate(var6==null?null:Converter.StringtoDateforDB(var6));
		contributionSchedules.setEndDate(var7==null?null:Converter.StringtoDateforDB(var7));
		contributionSchedules.setEnabledFlag(checkbox);
		contributionSchedules.setCreatedBy(str);
		contributionSchedules.setLastUpdatedBy(str);
		contributionSchedules.setCreatedDate(new Date());
		contributionSchedules.setLastUpdatedDate(new Date());
		hibernateTemplate.saveOrUpdate(contributionSchedules);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String queryString=null;
		hibernateTemplate.find(queryString);

		return null;
	}
	
	
	
}
