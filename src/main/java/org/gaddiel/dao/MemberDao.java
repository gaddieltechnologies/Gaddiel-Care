package org.gaddiel.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;

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
import org.gaddiel.form.RoleUserForm;
import org.gaddiel.form.SubscriptionPaidForm;
import org.gaddiel.form.SubscriptionPlanForm;
import org.gaddiel.form.SystemLookupsForm;
import org.gaddiel.form.LookupspopupForm;
import org.gaddiel.form.UserAssignmentForm;
import org.gaddiel.form.UserAssignmentSubForm;
import org.gaddiel.form.UserRoleForm;
import org.gaddiel.model.ChurchActivityAddresses;
import org.gaddiel.model.ChurchAddressContacts;
import org.gaddiel.model.ChurchConfiguration;
import org.gaddiel.model.ChurchPreferences;
import org.gaddiel.model.SystemRoles;
import org.gaddiel.model.SystemSubscriberFunctions;




// TODO: Auto-generated Javadoc
/**
 * The Interface MemberDao.
 */
public interface MemberDao {

	/**
	 * Validate login.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	public MainForm validateLogin(String username);
	public List getcustomaddnewnamelist(String name);
	/**
	 * Currency.
	 *
	 * @return the list
	 */
	public List currency();
	public ChurchPreferences  deletecustompreferences(String Value, String name);
	/**
	 * State.
	 *
	 * @return the list
	 */
	public List state();
	public List getaddnewcustompreflist();
	public ChurchConfigurationForm customnewlinesave(String var, String var1, String var2, String var3, String var4, String checkbox, String str, ChurchConfigurationForm churchConfigurationForm) throws ParseException;
	/**
	 * Gets the lookupsvalue.
	 *
	 * @return the lookupsvalue
	 */
	public SystemLookupsForm getlookupsvalue();
	public MainForm systemlinesave(String var, String var1, String var2, String var3, String var4, String var5, String checkbox, String str, MainForm mainForm1) throws ParseException;
	public List getcustomlist(int name);
	public MainForm saveinline(String var, String var1, String var2, String var3, String var4,  String checkbox,  String str) throws ParseException;
	/**
	 * Gets the customlookupsvalue.
	 *
	 * @return the customlookupsvalue
	 */
	public List getcustomlookupsvalue();
	public List getnewroleslist();
	/**
	 * Gets the addnewcustomlookupsvalue.
	 *
	 * @return the addnewcustomlookupsvalue
	 */
	public Lookups getaddnewcustomlookupsvalue();
	public CustomLookupsForm addnewsave(String str,CustomLookupsForm  mainForm1, LookupspopupForm systemlookupspopupForm) throws ParseException;
	/**
	 * Gets the fetch list.
	 *
	 * @param categoryType the category type
	 * @return the fetch list
	 */
	public List<Object> getfetchList(String categoryType);
	public RoleUserForm newinlinesave(String var, String var1, String var2,String roleassignmentid,String checkbox, String str, RoleUserForm roleUserForm) throws ParseException;
	/**
	 * Savelookups.
	 *
	 * @param mainForm the main form
	 * @param str the str
	 * @return the custom lookups form
	 * @throws Exception the exception
	 */
	public Lookups paginationmethod(CustomLookupsForm mainForm1) throws IOException, SQLException, ClassNotFoundException;
	public Lookups getcustomTempList(CustomLookupsForm getcustomTempList) throws IOException, SQLException ;
	public CustomLookupsForm savelookups(CustomLookupsForm mainForm, String str) throws java.lang.Exception;
	public CustomLookupsForm customlinesave(String var, String var1, String var2, String var3, String var4, String var5, String checkbox, String str, CustomLookupsForm mainForm1) throws ParseException;
	/**
	 * Gets the view list.
	 *
	 * @param mainForm1 the main form1
	 * @return the view list
	 * @throws Exception the exception
	 */
	public Lookups getviewList(CustomLookupsForm mainForm1) throws Exception;
	public CustomLookupsForm savecustominline(String var, String var1, String var2, String var3, String var4, String checkbox, String str) throws ParseException;
	/**
	 * Deletelookups.
	 *
	 * @param value the value
	 * @return the list
	 */
	public List deletelookups(String value); 
	public FamilypopupForm getsubscriptionlist(SubscriptionPlanForm subscriptionPlanForm,FamilypopupForm familypopupForm) throws ParseException;
	/**
	 * Gets the customlookslist.
	 *
	 * @param customLookupsForm the custom lookups form
	 * @return the customlookslist
	 * @throws Exception the exception
	 */
	public Lookups getcustomlookslist(CustomLookupsForm customLookupsForm)throws Exception;
	public FamilypopupForm getsubscriptionpaidlist(SubscriptionPaidForm subscriptionPaidForm,FamilypopupForm familypopupForm) throws ParseException;
	/**
	 * Gets the systemview list.
	 *
	 * @param mainForm1 the main form1
	 * @return the systemview list
	 * @throws Exception the exception
	 */
	public SystemLookupsForm getSystemviewList(MainForm mainForm1) throws Exception;
	public CollectionRegistersForm getcollectionregister(CollectionRegistersSubForm collectionRegistersSubForm,CollectionRegistersForm collectionRegistersForm) throws ParseException;
	public List duelist();
	/**
	 * Save systemlookups.
	 *
	 * @param mainForm the main form
	 * @param str the str
	 * @return the main form
	 * @throws Exception the exception
	 */
	public MainForm saveSystemlookups(MainForm mainForm, String str) throws Exception;
	public FamilypopupForm savenewsubscriptionlist(String var1,String var2,String var3,String var4,String var5,String str,FamilypopupForm familypopupForm) throws ParseException;
	/**
	 * Delete systemlookups.
	 *
	 * @param value the value
	 * @return the list
	 */
	public List deleteSystemlookups(String value); 
	public FamilypopupForm savesubscriptionlist(String var1,String var2,String var3,String var4,String var5,String str,FamilypopupForm familypopupForm) throws ParseException;
	/**
	 * Gets the systemlookslist.
	 *
	 * @param mainForm the main form
	 * @return the systemlookslist
	 * @throws Exception the exception
	 */
	public SystemLookupsForm getSystemlookslist(MainForm mainForm)throws Exception;
	public List collectiontype();
	public List collectionfreq();
	public List collectiondue(String val);
	/**
	 * Gets the addnew systemlookslist.
	 *
	 * @param mainForm the main form
	 * @return the addnew systemlookslist
	 * @throws Exception the exception
	 */
	public SystemLookupsForm getadvancedsearchsystemlookslist(MainForm mainForm)throws Exception;
	
	/**
	 * Gets the addnewcustomlookslist.
	 *
	 * @param customLookupsForm the custom lookups form
	 * @return the addnewcustomlookslist
	 * @throws Exception the exception
	 */
	public Lookups getadvancedsearchcustomlookslist(CustomLookupsForm customLookupsForm)throws Exception;
	public ContributionSchedulesForm getcollectionschedule(ContributionSchedulesSubForm contributionSchedulesSubForm,ContributionSchedulesForm contributionSchedulesForm) throws ParseException;
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public ChurchConfigurationForm getaddress();
	public ContributionSchedulesForm savenewcontributionlist(String var1,String var2,String var3,String var4,String var5,String var6,String var7,String checkbox,String str,ContributionSchedulesForm contributionSchedulesForm) throws ParseException;
	/**
	 * Gets the contacts.
	 *
	 * @param address the address
	 * @return the contacts
	 */
	public ChurchContactsPopup editcontacts(int id)  throws ParseException;
	public ChurchContactsPopup savecontacts(ChurchContactsPopup churchAddressPopup,int addid,String str) throws ParseException;
	public List getchurchtypelist(String name);
	/**
	 * Gets the contacts.
	 *
	 * @param churchContactsSubForm the church contacts sub form
	 * @param churchConfigurationForm the church configuration form
	 * @return the contacts
	 */
	public ChurchConfigurationForm getcontacts(ChurchAddressSubForm churchAddressSubForm,ChurchContactsSubForm churchContactsSubForm, ChurchConfigurationForm churchConfigurationForm);
	public ChurchConfigurationForm getaddress(ChurchAddressSubForm churchAddressSubForm, ChurchConfigurationForm churchConfigurationForm);
	/**
	 * Gets the addressmode.
	 *
	 * @return the addressmode
	 */
	public List getaddressmode(); 
	public RoleUserForm inlinesave(String var, String var1, String var2, String var3, String var4,String roleassignmentid,String checkbox, String str, RoleUserForm roleUserForm) throws ParseException;
	/**
	 * Gets the update elements.
	 *
	 * @param churchConfigurationForm the church configuration form
	 * @return the update elements
	 * @throws ParseException the parse exception
	 */
	public ChurchActivityAddresses getUpdateElements(ChurchConfigurationForm churchConfigurationForm)throws ParseException;
	public ChurchConfigurationForm deleteaddress(ChurchConfigurationForm churchConfigurationForm,int id);
	/**
	 * Gets the update elements1.
	 *
	 * @param churchConfigurationForm the church configuration form
	 * @param churchContactsSubForm the church contacts sub form
	 * @return the update elements1
	 * @throws ParseException the parse exception
	 */
	public ChurchAddressPopup editaddresspopup(ChurchAddressPopup churchAddressPopup, int id)throws ParseException;
	
	/**
	 * Setaddress.
	 *
	 * @param churchConfigurationForm the church configuration form
	 * @return the church configuration form
	 * @throws ParseException the parse exception
	 */
	public ChurchAddressPopup saveaddress(ChurchAddressPopup churchAddressPopup,String str) throws ParseException;
	public List modelist();
	public ChurchConfigurationForm newlinesave(String var, String var1, String var2, String var3, String var4, String checkbox, String str, ChurchConfigurationForm churchConfigurationForm) throws ParseException;
	/**
	 * Savecontacts.
	 *
	 * @param churchConfigurationForm the church configuration form
	 * @param churchContactsSubForm the church contacts sub form
	 * @return the string
	 * @throws ParseException the parse exception
	 */
	public String savecontacts(ChurchConfigurationForm churchConfigurationForm, ChurchContactsSubForm churchContactsSubForm)throws ParseException;
	
	/**
	 * Delete member elements.
	 *
	 * @param churchConfigurationForm the church configuration form
	 * @return the string
	 */
	public String deleteMemberElements(ChurchConfigurationForm churchConfigurationForm);
	
	/**
	 * Delete member elements1.
	 *
	 * @param churchConfigurationForm the church configuration form
	 * @return the string
	 */
	public String deleteMemberElements1(ChurchConfigurationForm churchConfigurationForm);
	
	/**
	 * Gets the details.
	 *
	 * @param churchConfigurationForm the church configuration form
	 * @return the details
	 */
	public ChurchConfiguration getdetails(ChurchConfigurationForm churchConfigurationForm,String str); 
	
	/**
	 * Gets the preferencesvalue.
	 *
	 * @return the preferencesvalue
	 */
	public ChurchPreferencesForm getpreferencesvalue();
	public List getaddnewpreflist();
	public List getaddnewnamelist(String name);
	/**
	 * Existing lookups.
	 *
	 * @param churchlookups the churchlookups
	 * @return the list
	 */
	public List existingLookups(List churchlookups);
	
	/**
	 * Existing lookupsinchurch.
	 *
	 * @return the list
	 */
	public List existingLookupsinchurch();
	
	/**
	 * Saveexisting lookupsinchurch.
	 *
	 * @param churchConfigPopupForm the church config popup form
	 * @param existinglooksinchurch the existinglooksinchurch
	 * @return the church preferences
	 */
	public ChurchPreferences saveexistingLookupsinchurch(ChurchConfigPopupForm churchConfigPopupForm, List existinglooksinchurch);
	
	/**
	 * Gets the popuplist.
	 *
	 * @param name the name
	 * @return the popuplist
	 */
	public List getpopuplist(String name);
	
	/**
	 * Saveprefvalues.
	 *
	 * @param name the name
	 * @param str1 the str1
	 * @param churchPreferencesForm the church preferences form
	 * @return the church preferences form
	 */
	public ChurchPreferencesForm saveprefvalues(String name, String str1, ChurchPreferencesForm churchPreferencesForm);
	
	/**
	 * Deletepreferences.
	 *
	 * @param Value the value
	 * @param name the name
	 * @return the church preferences
	 */
	public ChurchPreferences  deletepreferences(String Value, String name);
	
	/**
	 * Deletecontacts.
	 *
	 * @param title the title
	 * @param name the name
	 * @return the church address contacts
	 */
	public ChurchAddressContacts  deletecontacts(int id);
	
	/**
	 * Gets the roleslist.
	 *
	 * @return the roleslist
	 */
	public List getroleslist();
	
	/**
	 * Gets the priviligeslist.
	 *
	 * @return the priviligeslist
	 */
	public List getpriviligeslist();
	
	/**
	 * Savelookups2.
	 *
	 * @param roleForm the role form
	 * @return the string
	 * @throws Exception the exception
	 */
	public String savelookups2(RoleForm roleForm) throws Exception;
	
	/**
	 * Addrole.
	 *
	 * @param roleuser the roleuser
	 * @return the string
	 */
	public String addrole(RoleUserForm roleuser);
	
	/**
	 * Setrole.
	 *
	 * @param roleUserForm the role user form
	 * @return the role user form
	 * @throws Exception the exception
	 */
	public RoleUserForm setrole(RoleUserForm roleUserForm) throws Exception;
	
	/**
	 * Editrole.
	 *
	 * @param roleUserForm the role user form
	 * @return the system roles
	 */
	public SystemRoles editrole(RoleUserForm roleUserForm);
	
	/**
	 * Gets the userrolelist.
	 *
	 * @param roleUserForm the role user form
	 * @return the userrolelist
	 * @throws Exception the exception
	 */
	public RoleUserForm getuserrolelist(RoleUserForm roleUserForm)throws Exception;
	public CollectionRegistersForm savenewcollection(String var1,String var2,String var3,String var4,String var5,String var6,String str,CollectionRegistersForm collectionRegistersForm) throws ParseException;
	/**
	 * Deluserrole.
	 *
	 * @param value the value
	 * @return the list
	 */
	public UserAssignmentForm deluserrole(int id,int roleid);
	public List getpriviligeslist(RoleForm roleForm1);

	public RoleForm saverolelist(RoleForm roleForm1);

	public SystemLookupsForm getTempList(MainForm getTempList) throws IOException, SQLException;
	
	public RoleUserForm getuserlist(RoleUserForm roleUserForm)throws Exception;
	
	public List getusernamelist();
	public ChurchPrefCustomForm getcustompreferencesvalue();
	public UserAssignmentSubForm getuserlist(UserAssignmentForm userAssignmentForm)throws Exception;
	
	public UserAssignmentSubForm getcustomTempList(UserAssignmentForm getuserTempList) throws IOException, SQLException;
	public UserAssignmentSubForm paginationmethod(UserAssignmentForm userAssignmentForm) throws IOException, SQLException, ClassNotFoundException;

}
