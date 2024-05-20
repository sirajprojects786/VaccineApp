package com.tap.vaccine.RegisterEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="MEMBER")
public class MemberEntity implements java.io.Serializable{
	
	@ManyToOne
	@JoinColumn(name = "Fk_EMAIL", referencedColumnName = "email",insertable = false, updatable = false)
	private RegisterEntity registerEntity;
	
	
	@Id
	@Column(name="MEMBER_ID")
	private int memberId;
	@Column(name="NAME")
	private String name;
	@Column(name="GENDER")
	private String gender;
	@Column(name="DATE_OF_BIRTH")
	private String dob;
	@Column(name="ID_PROOF")
	private String idProof;
	@Column(name="ID_PROOF_NO")
	private String idProofNo;
	@Column(name="VACCINE_TYPE")
	private String vaccineType;
	@Column(name="DOSE")
	private String dose;
	@Column(name="Fk_EMAIL")
	private String fk_email;
	
	
	
	
	public MemberEntity() {
		System.out.println("inside in constructor of memberEntity");
	}
	
	
	
	
	public MemberEntity(int memberId, String name, String gender, String dob, String idProof, String idProofNo,
			String vaccineType, String dose, String fk_email) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.idProof = idProof;
		this.idProofNo = idProofNo;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.fk_email = fk_email;
	}
	
	
	
	
	public MemberEntity( String name, String gender, String dob, String idProof,
			String idProofNo, String vaccineType, String dose, String fk_email) {
		super();
		
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.idProof = idProof;
		this.idProofNo = idProofNo;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.fk_email = fk_email;
	}
	
	public MemberEntity(String name, String gender, String dob, String idProof, String idProofNo, String vaccineType,
			String dose) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.idProof = idProof;
		this.idProofNo = idProofNo;
		this.vaccineType = vaccineType;
		this.dose = dose;
	}
	
	public int getMemberId() {
		return memberId;
	}

	
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getDob() {
		return dob;
	}
	public String getIdProof() {
		return idProof;
	}
	public String getIdProofNo() {
		return idProofNo;
	}
	public String getVaccineType() {
		return vaccineType;
	}
	public String getDose() {
		return dose;
	}
	
	public String getFk_email() {
		return fk_email;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public void setFk_email(String fk_email) {
		this.fk_email = fk_email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	public void setIdProofNo(String idProofNo) {
		this.idProofNo = idProofNo;
	}
	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	
	
	@Override
	public String toString() {
		return "memberEntity [name=" + name + ", gender=" + gender + ", dob=" + dob + ", idProof=" + idProof
				+ ", idProofNo=" + idProofNo + ", vaccineType=" + vaccineType + ", dose=" + dose+", fk_email=" + fk_email + "]";
	}
	
	
	
	
	

}
