package tn.spring.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import tn.spring.springboot.entities.Role;

public interface RoleRepository extends CrudRepository<Role,String> {
}
