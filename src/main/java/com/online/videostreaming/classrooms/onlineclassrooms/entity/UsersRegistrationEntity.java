/*
 * package com.online.videostreaming.classrooms.onlineclassrooms.entity;
 * 
 * import java.io.Serializable; import java.util.Date; import java.util.List;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.FetchType; import javax.persistence.GeneratedValue; import
 * javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.JoinTable; import javax.persistence.ManyToMany; import
 * javax.persistence.ManyToOne; import javax.persistence.Table;
 * 
 * import org.hibernate.annotations.GenericGenerator; import
 * org.hibernate.annotations.Parameter;
 * 
 * import lombok.AllArgsConstructor; import lombok.Data; import lombok.Getter;
 * import lombok.NoArgsConstructor; import lombok.Setter; import
 * lombok.ToString;
 * 
 * @Entity
 * 
 * @Table(name = "drn_classes_student")
 * 
 * @Data
 * 
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 * 
 * @ToString
 * 
 * @Getter
 * 
 * @Setter public class UsersRegistrationEntity extends CreatedDetails
 * implements Serializable {
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * @GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
 * 
 * @Parameter(name = "sequence", value = "drn_classes_student_seq") })
 * 
 * @Id
 * 
 * @GeneratedValue(generator = "sequence")
 * 
 * @Column(name = "user_id") private Integer userId;
 * 
 * @Column(name = "first_name") private String firstName;
 * 
 * @Column(name = "middle_name") private String middleName;
 * 
 * @Column(name = "last_name") private String lastName;
 * 
 * @Column(name = "email") private String email;
 * 
 * @Column(name = "password") private String userPassword;
 * 
 * @ManyToOne(fetch = FetchType.EAGER)
 * 
 * @JoinColumn(name = "role_id", referencedColumnName = "role_id") private
 * RoleUserMapper rolesmapping;
 * 
 * @Column(name = "phone") private String phone;
 * 
 * @Column(name = "deactivated_reason") private String deactivatedReason;
 * 
 * @Column(name = "batch") private String batch;
 * 
 * @Column(name = "correspondance_address") private String
 * correspondanceAddress;
 * 
 * @Column(name = "permanent_address") private String permanentAddress;
 * 
 * @Column(name = "father_name") private String fatherName;
 * 
 * @Column(name = "mother_name") private String motherName;
 * 
 * @Column(name = "failed_attempt") private Integer failedAttempt;
 * 
 * @Column(name = "is_account_non_locked") private Boolean isAccountNonLocked;
 * 
 * @Column(name = "locktime") private Date lockTime;
 * 
 * }
 */