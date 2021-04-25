package com.htc.restaurantservice.presistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.restaurantservice.model.Tables;

@Repository
public interface TablesRepository extends JpaRepository<Tables,Long> {

}
