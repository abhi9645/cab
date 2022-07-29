package com.LibManag.lib.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.LibManag.lib.repository.DriverRepository;
import com.LibManag.lib.repository.UserRepository;
import com.LibManag.lib.response.Drivers;
import com.LibManag.lib.response.Findride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSOutput;

import com.LibManag.lib.model.Driver;
import com.LibManag.lib.model.User;
import com.LibManag.lib.services.DriverService;
import com.LibManag.lib.services.UserService;

import static java.lang.Math.pow;

@RestController
@Repository
public class DriverController {
private DriverService driverService  ;
private DriverRepository driverRepository;
private UserService userservice  ;
private UserRepository userRepository;
public DriverController(UserService userservice, UserRepository userRepository, DriverService driverService, DriverRepository driverRepository) {
	super();
	this.userservice = userservice;
    this.userRepository=userRepository;
	this.driverService = driverService;
    this.driverRepository = driverRepository;
}
//Math.sqrt(pow((y1-y),2)-pow((x1-x),2));
@PostMapping("/addDriver")
public ResponseEntity<Driver>addusers(@RequestBody Driver driver)
{
    	
    Driver drivers=null;
    System.out.println(driver);
    try{

        
        drivers = driverService.addDriver(driver);
        
    }
    catch(Exception ex)
    {
    	System.out.println(ex);
        ex.getMessage();
        
    }
    return new ResponseEntity<Driver>(drivers, HttpStatus.OK);
}

@PostMapping("/driverslist")
public ResponseEntity<List<Drivers>>driverlist(@RequestBody Findride findride)
{
    int x1 = findride.getX1();
    int y1 = findride.getY1();
   // System.out.println(x1);
    List<Drivers>drivers = null;
    List<Driver>d = driverRepository.findAll();
    for(int i=0;i<d.size();i++)
    {
      int x = d.get(i).getX();
      int y = d.get(i).getY();
       // System.out.println(y);
      if(Math.sqrt(pow((y1-y),2)+pow((x1-x),2)) < 5)
      {
         Drivers dr = new Drivers(d.get(i).getDriverName(),d.get(i).getDid());
         if(!d.get(i).isStatus()) {
          System.out.println(dr.getDriverName());
         }
      }
    }
    return new ResponseEntity<List<Drivers>>(drivers,HttpStatus.OK);
}

@GetMapping("/change_driver_status/{id}")
public ResponseEntity<Driver>driverlist1(@PathVariable("id") int id)
{
	
	try {
		Optional<Driver> user1 = driverRepository.findById(id);
		System.out.println(user1);
        if(user1 !=null) {
            Driver userUpdate =user1.get();
            System.out.println(userUpdate);
            userUpdate.setStatus(false);

           driverRepository.save(userUpdate);
           
            System.out.println("status changed ");
        }
        
	}catch(Exception e){
		e.getMessage();
		System.out.println("hey1");
	}

    return new ResponseEntity<Driver>(HttpStatus.OK);
}

@PostMapping("/calculateBill/{id}/{did}")
public ResponseEntity<List<Drivers>>driverlist1(@RequestBody Findride findride, @PathVariable("id") int id ,@PathVariable("did") int did)
{
    int x1 = findride.getX1();
    int y1 = findride.getY1();
    int x2 = findride.getX2();
    int y2 = findride.getY2();
	try {
	    Optional<Driver> user1 = driverRepository.findById(did);
	    double amount= Math.sqrt(pow((y2-y1),2)+pow((x2-x1),2));
	    System.out.println("Bill of the ride is" +" "+amount );
		System.out.println(user1);
        if(user1 !=null) {
            Driver userUpdate =user1.get();
            System.out.println(userUpdate);
            double total=userUpdate.getEarnings();
            total+=amount;
            userUpdate.setEarnings(total);
            userUpdate.setX(x2);
            userUpdate.setY(y2);
           driverRepository.save(userUpdate);
           
            System.out.println("total earnings ");
        }
        Optional<User> user2 = userRepository.findById(id);
        if(user2 !=null) {
            User userUpdate =user2.get();
            System.out.println(userUpdate);
            userUpdate.setX(x2);
            userUpdate.setY(y2);
           userRepository.save(userUpdate);
           
            
        }
        
	}catch(Exception e){
		e.getMessage();
		System.out.println("hey1");
	}
    
    
    return new ResponseEntity<List<Drivers>>(HttpStatus.OK);
}

}

