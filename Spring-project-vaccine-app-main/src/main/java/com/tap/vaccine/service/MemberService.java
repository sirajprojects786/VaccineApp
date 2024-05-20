package com.tap.vaccine.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.Dao.MemberDao;
import com.tap.vaccine.RegisterEntity.MemberEntity;
import com.tap.vaccine.RegisterEntity.RegisterEntity;

@Component
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	private static final int maxMembers = 4;

	public boolean validate(String name, String gender, String dob, String idProof, String idProofNo,
			String vaccineType, String dose, String fk_email) {
		boolean fla = false;
		if (!name.isEmpty() && name != null && !name.isBlank()) {
			fla = true;
			System.out.println("name is valid");
		} else {
			fla = false;
			System.out.println("name is invalid");
			return fla;
		}

		if (!gender.isEmpty() && gender!="" && !gender.isBlank())
			{
			fla = true;
			System.out.println("gender is valid");
		} else {
			fla = false;
			System.out.println("gender is invalid");
			return fla;
		}
		if (!dob.isEmpty() && dob != null && !dob.isBlank()) {
			fla = true;
			System.out.println("dob is valid");
		} else {
			fla = false;
			System.out.println("dob is invalid");
			return fla;
		}
		if (!idProof.isEmpty() && idProof != null && !idProof.isBlank()) {
			fla = true;
			System.out.println("idProof is valid");
		} else {
			fla = false;
			System.out.println("idProof is invalid");
			return fla;
		}
		if (!idProofNo.isEmpty() && idProofNo != null && !idProofNo.isBlank()) {
			fla = true;
			System.out.println("idProofNo is valid");
		} else {
			fla = false;
			System.out.println("idProofNo is invalid");
			return fla;
		}
		if (!vaccineType.isEmpty() && vaccineType != null && !vaccineType.isBlank()) {
			fla = true;
			System.out.println("vaccineType is valid");
		} else {
			fla = false;
			System.out.println("vaccineType is invalid");
			return fla;
		}

		if (!dose.isEmpty() && dose != null && !dose.isBlank()) {
			fla = true;
			System.out.println("dose is valid");
		} else {
			fla = false;
			System.out.println("dose is invalid");
			return fla;
		}

		return fla;

	}

	public boolean validateName(String name) {
		boolean flag = false;
		if (!name.isEmpty() && name != null && !name.isBlank()) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean validateGender(String gender) {
		boolean flag = false;
		if (!gender.isEmpty() && gender != "" && !gender.isBlank()) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean validateDob(String dob) {
		boolean flag = false;
		if (!dob.isEmpty() && dob != null && !dob.isBlank()) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean validateIdProof(String idProof) {
		boolean flag = false;
		if (!idProof.isEmpty() && idProof != null && !idProof.isBlank()) {
			flag = true;
			System.out.println("idProof is valid");
		} else {
			flag = false;
			System.out.println("idProof is invalid");
			return flag;
		}
		return flag;

	}

	public boolean validateIdProofNo(String idProofNo) {
		boolean flag = false;
		if (!idProofNo.isEmpty() && idProofNo != null && !idProofNo.isBlank()) {
			flag = true;
			System.out.println("idProofNo is valid");
		} else {
			flag = false;
			System.out.println("idProofNo is invalid");
			return flag;
		}
		return flag;

	}

	public boolean validateVaccineType(String vaccineType) {
		boolean flag = false;
		if (!vaccineType.isEmpty() && vaccineType != null && !vaccineType.isBlank()) {
			flag = true;
			System.out.println("vaccineType is valid");
		} else {
			flag = false;
			System.out.println("vaccineType is invalid");
			return flag;
		}
		return flag;

	}

	public boolean validateDose(String dose) {
		boolean flag = false;
		if (!dose.isEmpty() && dose != null && !dose.isBlank()) {
			flag = true;
			System.out.println("dose is valid");
		} else {
			flag = false;
			System.out.println("dose is invalid");
			return flag;
		}
		return flag;
	}

	public List<MemberEntity> getAllMemberDetails(String fk_email) {
		return memberDao.getAllDetailsByEmail(fk_email);

	}

	public boolean checkMemberCount(String email) {
		boolean greater = false;

		RegisterEntity entity = memberDao.getRegisterEntityByEmail(email);

		if (entity != null) {
			if (entity.getMemberCount() < maxMembers) {
				entity.setMemberCount(entity.getMemberCount() + 1);
				memberDao.updateMemberCount(entity);
				greater = true;
				
			} else {
				greater = false;
			}
		}

		return greater;

	}

	public boolean storeDetails(String name, String gender, String dob, String idProof, String idProofNo,
			String vaccineType, String dose, String fk_email) {
		boolean store = false;
		RegisterEntity entity1 = memberDao.getRegisterEntityByEmail(fk_email);
		MemberEntity entity = new MemberEntity(name, gender, dob, idProof, idProofNo, vaccineType, dose, fk_email);
		if (entity1 != null) {
			if (entity1.getMemberCount()-1< maxMembers) {
				boolean data = memberDao.saveMember(entity);
				if( data) {
					return data;
				}
				else {
					entity1.setMemberCount(entity1.getMemberCount() -1);
					memberDao.updateMemberCount(entity1);
					return data;
				}

			} else {
				store = false;
				return store;
			}
		}
		return store;
		
	}

	public boolean deleteRecord(String idProofNo,String userEmail) {
		boolean record=memberDao.deleteData(idProofNo);
		boolean greater=false;
		if(record) {
			RegisterEntity entity = memberDao.getRegisterEntityByEmail(userEmail);
			if (entity != null) {
				entity.setMemberCount(entity.getMemberCount() - 1);
				memberDao.updateMemberCount(entity);
				greater = true;
				return greater;
			}
			else {
				greater=false;
				return greater;
			}
		}
		return greater;
		
	}

	public MemberEntity getDetails(int memberId) {
		return memberDao.getRegisterEntityById(memberId);
		
	}

	public boolean updateAllDetails(int memberId, String name, String gender, String dob, String idProof, String idProofNo,
			String vaccineType, String dose, String email) {
		
		
		MemberEntity entity = new MemberEntity(memberId,name, gender, dob, idProof, idProofNo, vaccineType, dose,email);
		return memberDao.saveData(entity);
		
		
	}

	

}
