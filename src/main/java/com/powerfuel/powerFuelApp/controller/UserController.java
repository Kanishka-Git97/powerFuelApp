package com.powerfuel.powerFuelApp.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.powerfuel.powerFuelApp.model.User;
import com.powerfuel.powerFuelApp.service.UserRegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserRegistrationService userRegistrationService;




    @PostMapping("/register")
    public String registerUser(@RequestBody ObjectNode data){
        User newUser=new User();


        String name=data.get("name").asText();
        String companytp=data.get("company_id").asText();
        String username=data.get("user_name").asText();
        String password=data.get("password").asText();

        String role=data.get("role").asText();
        String status=data.get("status").asText();


        newUser.setName(name);
        newUser.setCompanyId(companytp);
        newUser.setUserName(username);
        newUser.setPassword(password);
        newUser.setRole(role);
        newUser.setStatus(status);

        userRegistrationService.userRegistration(newUser);

        return "success";



    }

    @PostMapping("/viewEmployees")
    public List<User> viewAllEmployees(@RequestBody ObjectNode data){
        return userRegistrationService.getAllEmployees(data.get("company_id").asText());
    }

    @PostMapping("/viewSingleEmployees")
    public List<User> viewSingleEmployee(@RequestBody ObjectNode data){
        return userRegistrationService.getSingleEmployee(data.get("emp_id").asInt());
    }

    /*----update employee details----*/
    @PostMapping("/updateEmployee")
    public void updateEmployee(@RequestBody ObjectNode data){
        String name=data.get("name").asText();
        String password=data.get("password").asText();
        String role=data.get("role").asText();
        String user_name=data.get("userName").asText();
        String status=data.get("status").asText();
        int id=data.get("id").asInt();
        userRegistrationService.updateEmployeeDetails(name,password,role,user_name,id,status);
    }


    /*-----validate user login=---------*/
    @PostMapping("/uservalidate")
    public List<User> validateLogin(@RequestBody ObjectNode data){
        String user_name=data.get("user_name").asText();
        String password=data.get("password").asText();
        String company_id=data.get("company_id").asText();
        return userRegistrationService.validateLogin(user_name,password,company_id);

    }
}
