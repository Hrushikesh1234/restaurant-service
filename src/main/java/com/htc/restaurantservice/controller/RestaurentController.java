package com.htc.restaurantservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.restaurantservice.model.Restaurent;
import com.htc.restaurantservice.model.Tables;
import com.htc.restaurantservice.presistence.RestaurentServiceRepository;
import com.htc.restaurantservice.presistence.TablesRepository;

@RestController
@RequestMapping("/api")
public class RestaurentController {
	
	@Autowired
	private RestaurentServiceRepository res;
	
	@Autowired
	private TablesRepository table;
	
	@PostMapping("/restaurents")
	public boolean addRestaurent(@RequestBody Restaurent restaurent) {
		Restaurent r = new Restaurent();
		r.setName(restaurent.getName());
		r.setAddress(restaurent.getAddress());
		
		for(Tables tables:restaurent.getTables()) {
			Tables t = new Tables();
			t.setTableId(tables.getTableId());
			t.setSeats(tables.getSeats());
			table.save(t);
		}
		r.setTables(restaurent.getTables());
		res.save(r);
		return true;
	}
	
	@GetMapping("/restaurents/{id}")
	public Restaurent getRestaurent(@PathVariable Long id) {
		Restaurent r = res.findById(id).get();
		return r;
	}
	
	@PutMapping("/restaurents/{id}")
	boolean updateRestaurent(@PathVariable Long id,@RequestBody Restaurent restaurent) {
		Restaurent r = res.findById(id).get();
		r.setName(restaurent.getName());
		r.setAddress(restaurent.getAddress());
		List<Tables> tab = r.getTables();
		for(Tables tables:restaurent.getTables()) {
			Tables t = new Tables();
			t.setTableId(tables.getTableId());
			t.setSeats(tables.getSeats());
			table.save(t);
			tab.add(tables);
		}
		r.setTables(tab);
		res.save(r);
		return true;
	}
	
	@Autowired
	public void setRes(RestaurentServiceRepository res) {
		this.res = res;
	}

	@Autowired
	public void setTable(TablesRepository table) {
		this.table = table;
	}
	
}
