package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Account;
import tn.spring.springboot.service.AccountService;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostConstruct
    public void initRoleAndUser() {
        accountService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public Account registerNewUser(@RequestBody Account account) {
        return accountService.registerNewUser(account);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }

    @DeleteMapping("/deleteAccount/{userName}")
    @PreAuthorize("hasRole('Admin')")
    public void DeleteAccount(@PathVariable String userName){
        accountService.DeleteAccount(userName);
    }

    @PutMapping("/updateaccount")
    @PreAuthorize("hasRole('User')")
    public Account updateAccount(@RequestBody Account account){
        return accountService.updateAccount(account);
    }

    @GetMapping("/getallaccount")
    @PreAuthorize("hasRole('Admin')")
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }
}
