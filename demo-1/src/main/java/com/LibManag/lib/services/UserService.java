package com.LibManag.lib.services;

import org.springframework.stereotype.Service;

import com.LibManag.lib.model.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService
{
    public List<User>getallstudenets();
    public User adduser(User user);
    public User updateuser(User user, int id);

}
