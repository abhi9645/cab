package com.LibManag.lib.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.LibManag.lib.repository.DriverRepository;
import com.LibManag.lib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSOutput;

import com.LibManag.lib.model.Driver;
import com.LibManag.lib.model.User;
import com.LibManag.lib.services.DriverService;
import com.LibManag.lib.services.UserService;
@RestController
@Repository
public class UserController {
private DriverService driverService  ;
private DriverRepository driverRepository;
private UserService userservice  ;
private UserRepository userRepository;
public UserController(UserService userservice, UserRepository userRepository,DriverService driverService, DriverRepository driverRepository) {
		super();
		this.userservice = userservice;
        this.userRepository=userRepository;
        this.driverService = driverService;
	    this.driverRepository = driverRepository;
	}
@PostMapping("/adduser")
public ResponseEntity<User>addusers(@RequestBody User user)
{
    	
    User users=null;
    System.out.println(user);
    try{

        
        users = userservice.adduser(user);
        
    }
    catch(Exception ex)
    {
    	System.out.println(ex);
        ex.getMessage();
        
    }
    return new ResponseEntity<User>(users, HttpStatus.OK);
}

@PutMapping("/userupdate/{id}")
public ResponseEntity<User>resetuser(@RequestBody  User user, @PathVariable("id") int id)
{
    User users=null;
    System.out.println(user);
    try{
        users = userservice.updateuser(user,id );
    }
    catch(Exception ex)
    {
        ex.getMessage();
    }
    return new ResponseEntity<User>(users, HttpStatus.OK);
}

    @PutMapping("/chooserideradd/{fid}/{sname}/{did}")
    public ResponseEntity<User>addrider(@PathVariable("fid") int fid, @PathVariable("did") int did, @PathVariable("sname") String sname)
    {
        try{
            Optional<User> user1 = userRepository.findById(fid);
            if(user1 !=null) {
                User userUpdate =user1.get();
                System.out.println(userUpdate);
                userUpdate.setDname(sname);

               userRepository.save(userUpdate);
               
                System.out.println("Ride started");
            }
            Optional<Driver> driver1 = driverRepository.findById(did);
//            System.out.println(driver1);
            if(driver1 !=null) {
                Driver userUpdate =driver1.get();
                System.out.println(userUpdate);
                userUpdate.setStatus(true);

               driverRepository.save(userUpdate);
               
              
            }

        }
        catch(Exception ex)
        {
            ex.getMessage();
            System.out.println("Ride could not start");
        }
        return new ResponseEntity<User>(HttpStatus.OK);
    }

}
