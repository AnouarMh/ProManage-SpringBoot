package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
}
