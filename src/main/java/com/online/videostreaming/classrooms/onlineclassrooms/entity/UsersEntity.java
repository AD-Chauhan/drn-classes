package com.online.videostreaming.classrooms.onlineclassrooms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "drn_classes_student")

public class UsersEntity extends CreatedDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "drn_classes_student_seq") })
	@Id
	@GeneratedValue(generator = "sequence")

	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String userPassword;

	@ManyToMany(fetch = FetchType.EAGER)

	@JoinTable(name = "t_role_user_mapper", joinColumns = {

			@JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = {

					@JoinColumn(name = "role_id", referencedColumnName = "role_id") })
	private List<UsersRole> roles;

	@Column(name = "phone")
	private String phone;
	@Column(name = "deactivated_reason")
	private String deactivatedReason;
	@Column(name = "batch")
	private String batch;
	@Column(name = "correspondance_address")
	private String correspondanceAddress;
	@Column(name = "permanent_address")
	private String permanentAddress;
	@Column(name = "father_name")
	private String fatherName;
	@Column(name = "mother_name")
	private String motherName;
	@Column(name = "failed_attempt")
	private Integer failedAttempt;
	@Column(name = "is_account_non_locked")
	private Boolean isAccountNonLocked;
	@Column(name = "locktime")
	private Date lockTime;

	@Column(name = "roll_no")
	private String rollNo;
	
	public UsersEntity() {
		super();
	}

	
	
	public UsersEntity(Integer userId, String firstName, String middleName, String lastName, String email,
			String userPassword, List<UsersRole> roles, String phone, String deactivatedReason, String batch,
			String correspondanceAddress, String permanentAddress, String fatherName, String motherName,
			Integer failedAttempt, Boolean isAccountNonLocked, Date lockTime, String rollNo) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.userPassword = userPassword;
		this.roles = roles;
		this.phone = phone;
		this.deactivatedReason = deactivatedReason;
		this.batch = batch;
		this.correspondanceAddress = correspondanceAddress;
		this.permanentAddress = permanentAddress;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.failedAttempt = failedAttempt;
		this.isAccountNonLocked = isAccountNonLocked;
		this.lockTime = lockTime;
		this.rollNo = rollNo;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<UsersRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UsersRole> roles) {
		this.roles = roles;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeactivatedReason() {
		return deactivatedReason;
	}

	public void setDeactivatedReason(String deactivatedReason) {
		this.deactivatedReason = deactivatedReason;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getCorrespondanceAddress() {
		return correspondanceAddress;
	}

	public void setCorrespondanceAddress(String correspondanceAddress) {
		this.correspondanceAddress = correspondanceAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Integer getFailedAttempt() {
		return failedAttempt;
	}

	public void setFailedAttempt(Integer failedAttempt) {
		this.failedAttempt = failedAttempt;
	}

	public Boolean getIsAccountNonLocked() {
		return isAccountNonLocked;
	}

	public void setIsAccountNonLocked(Boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	

}
