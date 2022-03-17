package com.sapient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	  @Column(name = "id")
	  private Long id;
	  @Column(name = "name")
	  private String name;
	  @Column(name = "email")
	  private String emailId;


}
