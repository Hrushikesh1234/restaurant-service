package com.htc.restaurantservice.presistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.htc.restaurantservice.model.Restaurent;

@Component
public interface RestaurentServiceRepository extends JpaRepository<Restaurent,Long> {
	
}
