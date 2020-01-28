package com.fsimone.hibernate.entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;



@Entity
@Table(name = "testentity")
public class TestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;


	@Column(name = "description")
	private String description;

	public TestEntity() {

	}

	public TestEntity(String description) {
	    this.description = description;
	}



	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}


	@Override
	public String toString() {
		return "TestEntity [id=" + id + ", description=" + description + "]";
	}
}



