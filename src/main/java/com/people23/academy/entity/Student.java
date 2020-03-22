package com.people23.academy.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import com.sun.istack.NotNull;


@Entity
@Table(name="student")
public class Student implements Serializable{

	private static final long serialVersionUID= 1L;
	
	@Id
	@NotNull
	@Column(name="rut", length = 10, unique = true)
	private String rut;
	
	@NotNull
	@Column (name="name", length = 50)
	private String name;
	
	@NotNull
	@Column (name="last_name", length = 50)
	private String lastName;
	
	@Min(18)
	@Column (name="age")
	private int age;
	
	@Max(4)
	@Column (name="code_course", length = 4)
	private String codeCourse;
	
	@Column(name = "create_at")
	@Temporal (TemporalType.DATE)
	private Date createAt;
	
	@PrePersist
	public void PrePersist() {
		createAt = new Date();
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCodeCourse() {
		return codeCourse;
	}

	public void setCodeCourse(String codeCourse) {
		this.codeCourse = codeCourse;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
}
