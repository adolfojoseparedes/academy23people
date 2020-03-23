package com.people23.academy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.sun.istack.NotNull;


/**
 * Entity that defines the database table for course through JPA 
 * with their respective fields, restrictions and relationships
 * 
 * @author 23 People Company
 *
 */
@Entity
@Table(name="course")
public class Course implements Serializable {
	
	private static final long serialVersionUID= 1L;

	@Id
	@NotNull
	@Column(name="code", length = 4, unique = true)
	private String code;
	
	@NotNull
	@Column (name="name", length = 50)
	private String name;
	
	@Column(name = "create_at")
	@Temporal (TemporalType.DATE)
	private Date createAt;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "code_course", referencedColumnName = "code")
	private List<Student> student = new ArrayList<>();

	@PrePersist
	public void PrePersist() {
		createAt = new Date();
		
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
}
