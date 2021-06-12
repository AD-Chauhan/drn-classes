package com.online.videostreaming.classrooms.onlineclassrooms.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name = "mst_role")
public class UsersRole extends CreatedDetails implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="mst_role_role_id_seq")})
    @Id
    @GeneratedValue(generator = "sequence")
	@Column(name="role_id")
	private Integer roleId;
	@Column(name="name")
	private String role;
	@Column(name="abbre_code")
	private String abbreCode;
	
	
	
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAbbreCode() {
		return abbreCode;
	}
	public void setAbbreCode(String abbreCode) {
		this.abbreCode = abbreCode;
	}
	
	
	

}
