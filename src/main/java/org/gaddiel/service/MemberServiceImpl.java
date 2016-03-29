package org.gaddiel.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;

import org.gaddiel.dao.MemberDao;
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



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberServiceImpl.
 */
@Service
public  class MemberServiceImpl implements MemberService{
	
	/** The member dao. */
	@Autowired
	private MemberDao memberDao;
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getroleslist()
	 */
	@Transactional

	public List getcustomlist(int name) {
		return memberDao.getcustomlist(name);
	}
	public List getaddnewcustompreflist() {
		return memberDao.getaddnewcustompreflist() ;
	}
	
	public List getcustomaddnewnamelist(String name) {
		return memberDao.getcustomaddnewnamelist(name); 
	}
	
	public FamilypopupForm getsubscriptionlist(SubscriptionPlanForm subscriptionPlanForm,FamilypopupForm familypopupForm) throws ParseException {
		return memberDao.getsubscriptionlist(subscriptionPlanForm,familypopupForm);
	}
	
	public ChurchPreferences  deletecustompreferences(String Value, String name)
	{
		return memberDao.deletecustompreferences(Value,name);
	}
	
	public ChurchConfigurationForm customnewlinesave(String var, String var1, String var2, String var3, String var4, String checkbox, String str, ChurchConfigurationForm churchConfigurationForm) throws ParseException
	{
		return memberDao.customnewlinesave(var, var1,  var2,  var3,  var4,  checkbox,  str, churchConfigurationForm);
	}
	
	public ContributionSchedulesForm savenewcontributionlist(String var1,String var2,String var3,String var4,String var5,String var6,String var7,String checkbox,String str,ContributionSchedulesForm contributionSchedulesForm) throws ParseException {
		return memberDao.savenewcontributionlist(var1,var2,var3,var4,var5,var6,var7,checkbox,str,contributionSchedulesForm);
	}
	public List duelist()
	{
		return memberDao.duelist();
	}
	public List getroleslist()
	{
		return memberDao.getroleslist();
		
	}
	public List getnewroleslist() {
		return memberDao.getnewroleslist();
	}
	public RoleUserForm newinlinesave(String var, String var1, String var2,String roleassignmentid,String checkbox, String str, RoleUserForm roleUserForm) throws ParseException
	{
		return memberDao.newinlinesave(var,var1,var2,roleassignmentid,checkbox, str, roleUserForm);
	}
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#saveprefvalues(java.lang.String, java.lang.String, org.gaddiel.form.ChurchPreferencesForm)
	 */
	public ChurchPreferencesForm saveprefvalues(String name, String str1, ChurchPreferencesForm churchPreferencesForm)
	{
		return memberDao.saveprefvalues(name, str1, churchPreferencesForm);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#validateLogin(java.lang.String)
	 */
	public MainForm validateLogin(String username) {
		// TODO Auto-generated method stub
		return memberDao.validateLogin(username);
		
	}
	
	public CollectionRegistersForm getcollectionregister(CollectionRegistersSubForm collectionRegistersSubForm,CollectionRegistersForm collectionRegistersForm) throws ParseException {
		
		return memberDao.getcollectionregister(collectionRegistersSubForm,collectionRegistersForm);
	}
	
	
	public FamilypopupForm getsubscriptionpaidlist(SubscriptionPaidForm subscriptionPaidForm,FamilypopupForm familypopupForm) throws ParseException {
		return memberDao.getsubscriptionpaidlist(subscriptionPaidForm,familypopupForm);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#existingLookups(java.util.List)
	 */
	public List existingLookups(List churchlookups){
		return memberDao.existingLookups(churchlookups);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#saveexistingLookupsinchurch(org.gaddiel.form.ChurchConfigPopupForm, java.util.List)
	 */
	public ChurchPreferences saveexistingLookupsinchurch(ChurchConfigPopupForm churchConfigPopupForm, List existinglooksinchurch)
	{
		return memberDao.saveexistingLookupsinchurch(churchConfigPopupForm, existinglooksinchurch);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#existingLookupsinchurch()
	 */
	public List existingLookupsinchurch()
	{
		return memberDao.existingLookupsinchurch();
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getpopuplist(java.lang.String)
	 */
	public List getpopuplist(String name)
	{
		return memberDao.getpopuplist(name);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getlookupsvalue()
	 */
	public SystemLookupsForm getlookupsvalue() {
		// TODO Auto-generated method stub
		return memberDao.getlookupsvalue();
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getcustomlookupsvalue()
	 */
	public List getcustomlookupsvalue() {
		// TODO Auto-generated method stub
		return memberDao.getcustomlookupsvalue();
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getaddnewcustomlookupsvalue()
	 */
	public Lookups getaddnewcustomlookupsvalue(){
		return memberDao.getaddnewcustomlookupsvalue();
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#savelookups(org.gaddiel.form.CustomLookupsForm, java.lang.String)
	 */
	public CustomLookupsForm savelookups(CustomLookupsForm mainForm, String str) throws java.lang.Exception {
		// TODO Auto-generated method stub
		return memberDao.savelookups(mainForm, str);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getfetchList(java.lang.String)
	 */
	public List<Object> getfetchList(String categoryType) {
		// TODO Auto-generated method stub
		return memberDao.getfetchList(categoryType);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getaddressmode()
	 */
	public List getaddressmode() {
		return memberDao.getaddressmode(); 
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getaddress()
	 */
	public ChurchConfigurationForm getaddress()
	{
		return memberDao.getaddress();
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#currency()
	 */
	public List currency(){
		return memberDao.currency();
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#state()
	 */
	public List state(){
		return memberDao.state();
}


	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getdetails(org.gaddiel.form.ChurchConfigurationForm)
	 */
	public ChurchConfiguration getdetails(ChurchConfigurationForm churchConfigurationForm,String str) {
		return memberDao.getdetails(churchConfigurationForm,str); 
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getcontacts(java.lang.String)
	 */
	public ChurchContactsPopup editcontacts(int id)  throws ParseException {
		// TODO Auto-generated method stub
		return memberDao.editcontacts(id);
	}

	public ChurchContactsPopup savecontacts(ChurchContactsPopup churchAddressPopup,int addid,String str) throws ParseException {
		return memberDao.savecontacts(churchAddressPopup, addid,str);
	}
	
	public ContributionSchedulesForm getcollectionschedule(ContributionSchedulesSubForm contributionSchedulesSubForm,ContributionSchedulesForm contributionSchedulesForm) throws ParseException {
		return memberDao.getcollectionschedule(contributionSchedulesSubForm,contributionSchedulesForm);
	}
	
	public List getchurchtypelist(String name) {
		return memberDao.getchurchtypelist(name); 
	}
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getcontacts(org.gaddiel.form.ChurchContactsSubForm, org.gaddiel.form.ChurchConfigurationForm)
	 */
	public ChurchConfigurationForm getcontacts(ChurchAddressSubForm churchAddressSubForm,ChurchContactsSubForm churchContactsSubForm, ChurchConfigurationForm churchConfigurationForm)
	{
		return memberDao.getcontacts(churchAddressSubForm,churchContactsSubForm, churchConfigurationForm);
	}
	public ChurchConfigurationForm getaddress(ChurchAddressSubForm churchAddressSubForm, ChurchConfigurationForm churchConfigurationForm)
	{
		return memberDao.getaddress(churchAddressSubForm, churchConfigurationForm);	
	}
	public RoleUserForm inlinesave(String var, String var1, String var2, String var3, String var4,String roleassignmentid,String checkbox, String str, RoleUserForm roleUserForm) throws ParseException
	{
		return memberDao.inlinesave(var,var1,var2,var3,var4,roleassignmentid,checkbox,str,roleUserForm);
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#deletecontacts(java.lang.String, java.lang.String)
	 */
	public ChurchAddressContacts  deletecontacts(int id)
	{
		return memberDao.deletecontacts(id);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getUpdateElements(org.gaddiel.form.ChurchConfigurationForm)
	 */
	public ChurchActivityAddresses getUpdateElements(ChurchConfigurationForm churchConfigurationForm)throws ParseException
	{
		return memberDao.getUpdateElements(churchConfigurationForm);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getUpdateElements1(org.gaddiel.form.ChurchConfigurationForm, org.gaddiel.form.ChurchContactsSubForm)
	 */
	public ChurchAddressPopup editaddresspopup(ChurchAddressPopup churchAddressPopup, int id)throws ParseException
	{
		return memberDao.editaddresspopup(churchAddressPopup,id);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#setaddress(org.gaddiel.form.ChurchConfigurationForm)
	 */
	public ChurchAddressPopup saveaddress(ChurchAddressPopup churchAddressPopup,String str) throws ParseException
	{
		return memberDao.saveaddress(churchAddressPopup,str); 
	}
	
	public List collectiontype()
	{
		return memberDao.collectiontype();
	}
	public List collectionfreq()
	{
		return memberDao.collectionfreq();
	}
	public List collectiondue(String val)
	{
		return memberDao.collectiondue(val);	
	}
	

	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#savecontacts(org.gaddiel.form.ChurchConfigurationForm, org.gaddiel.form.ChurchContactsSubForm)
	 */
	public String savecontacts(ChurchConfigurationForm churchConfigurationForm, ChurchContactsSubForm churchContactsSubForm)throws ParseException {
		return memberDao.savecontacts(churchConfigurationForm, churchContactsSubForm);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#deleteMemberElements(org.gaddiel.form.ChurchConfigurationForm)
	 */
	public String deleteMemberElements(ChurchConfigurationForm churchConfigurationForm)
	{
		return memberDao.deleteMemberElements(churchConfigurationForm);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#deleteMemberElements1(org.gaddiel.form.ChurchConfigurationForm)
	 */
	public String deleteMemberElements1(ChurchConfigurationForm churchConfigurationForm)
	{
		return memberDao.deleteMemberElements1(churchConfigurationForm);
	}
	
	
	public ChurchConfigurationForm deleteaddress(ChurchConfigurationForm churchConfigurationForm,int id)
	{
		return memberDao.deleteaddress(churchConfigurationForm,id);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getpreferencesvalue()
	 */
	public ChurchPreferencesForm getpreferencesvalue()
	{
		return memberDao.getpreferencesvalue();
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getviewList(org.gaddiel.form.CustomLookupsForm)
	 */
	public Lookups getviewList(CustomLookupsForm mainForm1) throws Exception
	{
		return memberDao.getviewList(mainForm1);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#deletelookups(java.lang.String)
	 */
	public List deletelookups(String value) 
	{
		return memberDao.deletelookups(value);
	}
	

	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getpriviligeslist()
	 */
	public List getpriviligeslist() {
		// TODO Auto-generated method stub
		return memberDao.getpriviligeslist();
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#savelookups2(org.gaddiel.form.RoleForm)
	 */
	public String savelookups2(RoleForm roleForm) throws Exception{
		// TODO Auto-generated method stub
				return memberDao.savelookups2(roleForm);
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#addrole(org.gaddiel.form.RoleUserForm)
	 */
	public String addrole(RoleUserForm roleuser) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#setrole(org.gaddiel.form.RoleUserForm)
	 */
	public RoleUserForm setrole(RoleUserForm roleUserForm) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.setrole(roleUserForm);
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#editrole(org.gaddiel.form.RoleUserForm)
	 */
	public SystemRoles editrole(RoleUserForm roleUserForm) {
		// TODO Auto-generated method stub
		return memberDao.editrole(roleUserForm);
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getuserrolelist(org.gaddiel.form.RoleUserForm)
	 */
	public RoleUserForm getuserrolelist(RoleUserForm roleUserForm)throws Exception {
		// TODO Auto-generated method stub
		return memberDao.getuserrolelist(roleUserForm);
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#deluserrole(java.lang.String)
	 */
	public UserAssignmentForm deluserrole(int id,int roleid){
		// TODO Auto-generated method stub
		return memberDao.deluserrole(id,roleid);
	}


	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#deletepreferences(java.lang.String, java.lang.String)
	 */
	public ChurchPreferences deletepreferences(String Value, String name) {
		// TODO Auto-generated method stub
		return memberDao.deletepreferences(Value, name);
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getcustomlookslist(org.gaddiel.form.CustomLookupsForm)
	 */
	public Lookups getcustomlookslist(CustomLookupsForm customLookupsForm)throws Exception
	{
		return memberDao.getcustomlookslist(customLookupsForm);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getaddnewcustomlookslist(org.gaddiel.form.CustomLookupsForm)
	 */
	public Lookups getadvancedsearchcustomlookslist(CustomLookupsForm customLookupsForm)throws Exception
	{
		return memberDao.getadvancedsearchcustomlookslist(customLookupsForm);
	}

	public ChurchPrefCustomForm getcustompreferencesvalue() {
		return memberDao.getcustompreferencesvalue();
	}
	
	public Lookups paginationmethod(CustomLookupsForm mainForm1) throws IOException, SQLException, ClassNotFoundException
	{
		return memberDao.paginationmethod(mainForm1);
	}
	public Lookups getcustomTempList(CustomLookupsForm getcustomTempList) throws IOException, SQLException 
	{
		return memberDao.getcustomTempList(getcustomTempList);
	}
	
	public ChurchConfigurationForm newlinesave(String var, String var1, String var2, String var3, String var4, String checkbox, String str, ChurchConfigurationForm churchConfigurationForm) throws ParseException
	{
		return memberDao.newlinesave(var, var1, var2, var3, var4, checkbox, str, churchConfigurationForm);
	}
	
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getSystemviewList(org.gaddiel.form.MainForm)
	 */
	public SystemLookupsForm getSystemviewList(MainForm mainForm1)
			throws Exception {
		// TODO Auto-generated method stub
		return memberDao.getSystemviewList(mainForm1);
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#saveSystemlookups(org.gaddiel.form.MainForm, java.lang.String)
	 */
	public MainForm saveSystemlookups(MainForm mainForm, String str) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.saveSystemlookups(mainForm, str);
	}

	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getaddnewSystemlookslist(org.gaddiel.form.MainForm)
	 */
	public SystemLookupsForm getadvancedsearchsystemlookslist(MainForm mainForm)throws Exception
	{
		return memberDao.getadvancedsearchsystemlookslist(mainForm);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#deleteSystemlookups(java.lang.String)
	 */
	public List deleteSystemlookups(String value) {
		// TODO Auto-generated method stub
		return memberDao.deleteSystemlookups(value);
	}
	
	/* (non-Javadoc)
	 * @see org.gaddiel.service.MemberService#getSystemlookslist(org.gaddiel.form.MainForm)
	 */
	public SystemLookupsForm getSystemlookslist(MainForm mainForm)throws Exception {
		return memberDao.getSystemlookslist(mainForm);
	}

	
	public MainForm saveinline(String var, String var1, String var2, String var3, String var4,  String checkbox,  String str) throws ParseException{
		return memberDao.saveinline(var, var1, var2, var3, var4, checkbox, str);
	}

	public List getpriviligeslist(RoleForm roleForm1) {
		// TODO Auto-generated method stub
		return memberDao.getpriviligeslist(roleForm1);

	}
	public List modelist()
	{
		return memberDao.modelist();
	}
	public CollectionRegistersForm savenewcollection(String var1,String var2,String var3,String var4,String var5,String var6,String str,CollectionRegistersForm collectionRegistersForm) throws ParseException {
		return memberDao.savenewcollection(var1,var2,var3,var4,var5,var6,str,collectionRegistersForm);
	}
	
	public CustomLookupsForm customlinesave(String var, String var1, String var2, String var3, String var4, String var5, String checkbox, String str, CustomLookupsForm mainForm1) throws ParseException
	{
		return memberDao.customlinesave(var, var1, var2, var3, var4, var5, checkbox, str, mainForm1);
	}

	public CustomLookupsForm addnewsave(String str,CustomLookupsForm  mainForm1, LookupspopupForm systemlookupspopupForm) throws ParseException
	{
		return memberDao.addnewsave(str, mainForm1, systemlookupspopupForm); 
	}
	
	public CustomLookupsForm savecustominline(String var, String var1, String var2, String var3, String var4, String checkbox, String str) throws ParseException
	{
		return memberDao.savecustominline(var, var1, var2, var3, var4, checkbox, str);
	}
	public MainForm systemlinesave(String var, String var1, String var2, String var3, String var4, String var5, String checkbox, String str, MainForm mainForm1) throws ParseException 
	{
		return memberDao.systemlinesave(var, var1, var2, var3, var4, var5, checkbox, str, mainForm1); 
	}
	public RoleForm saverolelist(RoleForm roleForm1) {
		// TODO Auto-generated method stub
		return memberDao.saverolelist(roleForm1);
	}
	public List getaddnewpreflist()
	{
		return memberDao.getaddnewpreflist();
	}
	public List getaddnewnamelist(String name) {
		return memberDao.getaddnewnamelist(name);
	}
	public SystemLookupsForm getTempList(MainForm getTempList) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return memberDao.getTempList(getTempList);
	}

	public FamilypopupForm savesubscriptionlist(String var1,String var2,String var3,String var4,String var5,String str,FamilypopupForm familypopupForm) throws ParseException {
		return memberDao.savesubscriptionlist(var1,var2,var3,var4,var5,str,familypopupForm);
	}
	
	public RoleUserForm getuserlist(RoleUserForm roleUserForm) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.getuserlist(roleUserForm);
	}
	public UserAssignmentSubForm getuserlist(UserAssignmentForm userAssignmentForm)throws Exception{
		// TODO Auto-generated method stub
				return memberDao.getuserlist(userAssignmentForm);
	}
	
	public UserAssignmentSubForm getcustomTempList(UserAssignmentForm getuserTempList) throws IOException, SQLException {
		return memberDao.getcustomTempList(getuserTempList);
	}
	
	public FamilypopupForm savenewsubscriptionlist(String var1,String var2,String var3,String var4,String var5,String str,FamilypopupForm familypopupForm) throws ParseException {
		return memberDao.savenewsubscriptionlist(var1,var2,var3,var4,var5,str,familypopupForm);
	}
	
	public UserAssignmentSubForm paginationmethod(UserAssignmentForm userAssignmentForm) throws IOException, SQLException, ClassNotFoundException{
		return memberDao.paginationmethod(userAssignmentForm);
	}
	
	public List getusernamelist() {
		// TODO Auto-generated method stub
				return memberDao.getusernamelist();
		
	}
	}

