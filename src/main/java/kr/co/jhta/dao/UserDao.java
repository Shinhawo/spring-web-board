package kr.co.jhta.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.co.jhta.vo.User;

@Mapper
public interface UserDao {

	// 신규 사용자 등록 기능
	void insertUser(User user);
	
	// 이메일로 사용자 정보 조회기능
	User getUserByEmail(String email);
	
	// 번호로 사용자 정보 조회기능
	User getUserByNo(int no);
	
	User getUserByPassword(String password);
	
	// 사용자 정보 수정 기능
	void updateUser(User user);
}
