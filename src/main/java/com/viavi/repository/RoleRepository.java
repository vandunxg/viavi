package com.viavi.repository;

import com.viavi.entity.Permission;
import com.viavi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    boolean existsByName(String name);

}
