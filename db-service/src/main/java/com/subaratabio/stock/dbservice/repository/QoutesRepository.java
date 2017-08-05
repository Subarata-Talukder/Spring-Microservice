package com.subaratabio.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subaratabio.stock.dbservice.model.Quote;

public interface QoutesRepository extends JpaRepository<Quote, Integer>{

	List<Quote> findByUserName(String userName);

}
