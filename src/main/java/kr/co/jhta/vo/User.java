package kr.co.jhta.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {

	private int no;
	private String email;
	private String encryptedPassword;
	private Date updateDate;
	private Date createDate;
	private List<String> roleNames;
	
	@Builder
	public User(int no, String email, String encryptedPassword, Date updateDate, 
			Date createDate, List<String> roleNames) {
		super();
		this.no = no;
		this.email = email;
		this.encryptedPassword = encryptedPassword;
		this.updateDate = updateDate;
		this.createDate = createDate;
		this.roleNames = roleNames;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		for (String roleName : roleNames) {
			authorities.add(new SimpleGrantedAuthority(roleName));
		}
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return encryptedPassword;
	}
	
	@Override
	public String getUsername() {
		return email;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
