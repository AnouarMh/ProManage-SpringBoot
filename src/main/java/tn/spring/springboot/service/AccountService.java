package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Account;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Role;
import tn.spring.springboot.repository.AccountRepository;
import tn.spring.springboot.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);

        Account adminUser = new Account();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        accountRepository.save(adminUser);

//        User user = new User();
//        user.setUserName("raj123");
//        user.setUserPassword(getEncodedPassword("raj@123"));
//        user.setUserFirstName("raj");
//        user.setUserLastName("sharma");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
    }

    public Account registerNewUser(Account account) {

        Role role = roleRepository.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        account.setRole(userRoles);
        account.setUserPassword(getEncodedPassword(account.getUserPassword()));

        return accountRepository.save(account);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public void DeleteAccount(String userName){
        Account account=accountRepository.findById(userName).orElse(null);
        account.getRole().clear();

        accountRepository.deleteById(userName);
    }
    public Account updateAccount(Account account) {
        Role role = roleRepository.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        account.setRole(userRoles);
        account.setUserPassword(getEncodedPassword(account.getUserPassword()));
        return accountRepository.save(account);
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAll() ;
    }
}
