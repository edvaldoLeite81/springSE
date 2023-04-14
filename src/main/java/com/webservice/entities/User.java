package com.webservice.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 @EqualsAndHashCode.Include
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotBlank(message = "the name field cannot be blank")
	 @Size(min = 7, max = 60,message="The name must contain between {min} and {max} characters")
	 private String name;
	 
	 @NotBlank(message = "email field cannot be blank")
	 @Email(message = "The email format is incorrect")
	 private String email;
	 
	 @NotBlank(message = "the phone field cannot be blank")
	 @Size(min=10, max=14, message ="the phone must contain the area code and be between {min} and {max} characters long" )
	 private String phone;
	 
	 @NotBlank(message ="the password field cannot be blank")
	 @Size(min = 4, max = 8,message="The password must contain between {min} and {max} characters")
	 private String password;
	 
	 @JsonIgnore
	 @OneToMany(mappedBy = "client")
	 private List<Order> orders = new ArrayList<>();
	 

}
