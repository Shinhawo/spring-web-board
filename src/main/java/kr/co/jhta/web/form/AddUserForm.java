package kr.co.jhta.web.form;

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
public class AddUserForm {

	private int no;
	private String email;
	private String password;
	private Date updateDate;
	private Date createDate;
	private List<String> roleNames;
	
	@Builder
	public AddUserForm(int no, String email, String password, Date updateDate, Date createDate,
			List<String> roleNames) {
		super();
		this.no = no;
		this.email = email;
		this.password = password;
		this.updateDate = updateDate;
		this.createDate = createDate;
		this.roleNames = roleNames;
	}
	
	

	
}

