package com.api.crud.controllers;


import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUser();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user ){
        return this.userService.saveUser(user) ;
    }
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUSerById(@PathVariable Long id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request,long id){
        return this.userService.updateByid(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id")Long id){
      boolean ok = this.userService.deleteUser(id);

      if (ok){
           return "User with id" + id + "deleted!";
      }else {
          return "Error, we have a problem and can't delete user id ";
      }
    }

}
