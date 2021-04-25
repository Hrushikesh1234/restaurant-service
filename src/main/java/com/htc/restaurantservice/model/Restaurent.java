package com.htc.restaurantservice.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="restaurents")
public class Restaurent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long restaurentId;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@OneToMany(targetEntity=Tables.class)
	private List<Tables> tables;

	public long getRestaurentId() {
		return restaurentId;
	}

	public void setRestaurentId(long restaurentId) {
		this.restaurentId = restaurentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Tables> getTables() {
		return tables;
	}

	public void setTables(List<Tables> tables) {
		this.tables = tables;
	}

	@Override
	public String toString() {
		return "Restaurent [restaurentId=" + restaurentId + ", name=" + name + ", address=" + address + ", tables="
				+ tables + "]";
	}
	
}
