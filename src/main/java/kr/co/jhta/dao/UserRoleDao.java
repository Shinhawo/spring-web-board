package kr.co.jhta.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.jhta.vo.UserRole;

@Mapper
public interface UserRoleDao {

	// 사용자의 보유권한정보를 저장하기
	void insertUserRole(UserRole userRole);
	
	// 지정된 사용자번호에 해당하는 사용자의 모든 보유권한을 조회한다.
	List<UserRole> getUserRolesByUserNo(int userNo);
}
