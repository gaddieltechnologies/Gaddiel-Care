package org.gaddiel.form;
import java.util.List;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleForm.
 */
public class RoleForm {
	
	private String roles;
	private String membername;
	private String view1;
	private String insert4;
	private String update2;
	private String delete3;
	private String selectto;
	private String member;
	private String selectfrom;
	private String roleId;
	private String roleName;
	private List<RoleForm2>lookups2;
	private String dispatch;
	private String username;
	private String User;
	private String Userid;

	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDispatch() {
		return dispatch;
	}
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}
	public List<RoleForm2> getLookups2() {
		return lookups2;
	}
	public void setLookups2(List<RoleForm2> lookups2) {
		this.lookups2 = lookups2;
	}
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getSelectto() {
		return selectto;
	}
	public void setSelectto(String selectto) {
		this.selectto = selectto;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getSelectfrom() {
		return selectfrom;
	}
	public void setSelectfrom(String selectfrom) {
		this.selectfrom = selectfrom;
	}
		
	public String getInsert4() {
		return insert4;
	}
	public void setInsert4(String insert4) {
		this.insert4 = insert4;
	}
	
		
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getView1() {
		return view1;
	}
	public void setView1(String view1) {
		this.view1 = view1;
	}
	public String getUpdate2() {
		return update2;
	}
	public void setUpdate2(String update2) {
		this.update2 = update2;
	}
	public String getDelete3() {
		return delete3;
	}
	public void setDelete3(String delete3) {
		this.delete3 = delete3;
	}
	
	
	
	

	

}
