package com.online.videostreaming.classrooms.onlineclassrooms.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "t_role_user_mapper")
public class RoleUserMapper extends CreatedDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="t_role_user_mapper_id_seq")})
    @Id
    @GeneratedValue(generator = "sequence")
	@Column(name = "id")
	private Integer id;
	@Column(name = "user_id")
	private String userId;
	@Column(name = "role_id")
	private Integer roleId;
	@OneToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false,insertable = false, updatable = false)
	UsersRole role;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public UsersRole getRole() {
		return role;
	}
	public void setRole(UsersRole role) {
		this.role = role;
	}


	
	
	
	
	
	
	
}
