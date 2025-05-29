package com.sampleproject.sampleproject.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	/*
	 * @SequenceGenerator( name="user_sequence", sequenceName="user_sequence",
	 * allocationSize=1)
	 * 
	 * @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_sequence")
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	private String full_name;
	private String email;
	private String password;
	private String phone;
	@CreationTimestamp
	@Column(name = "createddate")
	private String createddate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

}
