package com.LibManag.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LibManag.lib.model.Driver;


@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {

}
