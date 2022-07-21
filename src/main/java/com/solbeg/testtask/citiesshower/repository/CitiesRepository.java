package com.solbeg.testtask.citiesshower.repository;

import com.solbeg.testtask.citiesshower.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CitiesRepository extends PagingAndSortingRepository<City, Long> {

    Page<City> findAll(Pageable pageable);

    City findByName(String name);

    @Modifying
    @Query("update City u set u.name = :name, u.photoReference = :photoReference where u.id = :id")
    City setCity(@Param(value = "id") long id, @Param(value = "name") String name, @Param(value = "name") String photoReference);
}
