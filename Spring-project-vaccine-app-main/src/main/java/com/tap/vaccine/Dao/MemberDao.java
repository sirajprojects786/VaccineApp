package com.tap.vaccine.Dao;

import java.util.List;

import com.tap.vaccine.RegisterEntity.MemberEntity;
import com.tap.vaccine.RegisterEntity.RegisterEntity;

public interface MemberDao {

	boolean saveMember(MemberEntity entity);

	List<MemberEntity> getAllDetails();
	public void  updateMemberCount(RegisterEntity entity);

	int  getMemberCount(String email);

	RegisterEntity getRegisterEntityByEmail(String email);
	List<MemberEntity> getAllDetailsByEmail(String fk_email) ;

	boolean deleteData(String idProofNo);

	MemberEntity getRegisterEntityById(int memberId);

	boolean saveData(MemberEntity entity);


	

}
