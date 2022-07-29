package com.LibManag.lib.services;

import org.springframework.stereotype.Service;

import com.LibManag.lib.model.Driver;


import java.util.List;
import java.util.Optional;

@Service
public interface DriverService
{
    public List<Driver>getallstudenets();
    public Driver addDriver(Driver Driver);
   
}
