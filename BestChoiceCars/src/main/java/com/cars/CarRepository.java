package com.cars;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends CrudRepository < Car, Long > {

	List<Car> findCarsByBrand(@Param(value="brand") String brand);
	
	@Query(value="select distinct(brand) from cars", nativeQuery= true)
	List<String> findBrands();
	
	@Query(value="select * from cars where price < ?1", nativeQuery= true)
	List<Car> findCarsBelowFive(int price);
	
	@Query(value="select * from cars where price > ?1", nativeQuery= true)
	List<Car> findCarsAboveFive(int price);
}
