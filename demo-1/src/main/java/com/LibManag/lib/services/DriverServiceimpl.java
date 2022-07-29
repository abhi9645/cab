package com.LibManag.lib.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LibManag.lib.model.Driver;

import com.LibManag.lib.repository.DriverRepository;


import java.util.List;

@Service
public class DriverServiceimpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;

	@Override
	public List<Driver> getallstudenets() {
		// TODO Auto-generated method stub
		List<Driver> driver=driverRepository.findAll();
		return driver;
	}



	@Override
	public Driver addDriver(Driver Driver) {
		// TODO Auto-generated method stub
		System.out.println("hey");
		return driverRepository.save(Driver);
	}




}
	
	


