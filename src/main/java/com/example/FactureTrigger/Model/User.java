package com.example.FactureTrigger.Model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.FactureTrigger.Enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user;
	
	@Column()
	private String userEmail;
	
	@Column
	private String userName;
	
	@Column
	private String password;
	
	@Enumerated
	private Role role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userEmail;
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
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id_user, String userEmail, String userName, String password, Role role) {
		super();
		this.id_user = id_user;
		this.userEmail = userEmail;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

		
	
	
}
