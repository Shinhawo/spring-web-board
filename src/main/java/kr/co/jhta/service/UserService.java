package kr.co.jhta.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.UserDao;
import kr.co.jhta.dao.UserRoleDao;
import kr.co.jhta.vo.User;
import kr.co.jhta.vo.UserRole;
import kr.co.jhta.web.form.AddUserForm;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
	
	private final UserDao userDao;
	private final UserRoleDao userRoleDao;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDao.getUserByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("["+email+"]");
		}
		
		List<UserRole> userRoles = userRoleDao.getUserRolesByUserNo(user.getNo());
		List<String> roleNames = new ArrayList<String>();
		for (UserRole role : userRoles) {
			roleNames.add(role.getRoleName());
		}
		user.setRoleNames(roleNames);
		
		return user;
	}
	
	// 신규 사용자 등록하기
	public void createUser(AddUserForm form) {
		User user = new User();
		BeanUtils.copyProperties(form, user);
		
		String encryptedPassword = passwordEncoder.encode(form.getPassword());
		user.setEncryptedPassword(encryptedPassword);
		
		userDao.insertUser(user);
		
		UserRole role = new UserRole();
		role.setUser(user);
		role.setRoleName("ROLE_USER");
		
		userRoleDao.insertUserRole(role);
	}
	
	
	// 사용자 상세정보 제공하기(보유권한 정보도 같이 조회함)
	public User getUserDetail(int userNo) {
		
		return null;
	}
	
	// 사용자 정보 변경하기	
	public void modifyUser(User user) {

	}
}
