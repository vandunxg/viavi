package com.viavi.repository;

import com.viavi.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    boolean existsByName(String name);

    Optional<Permission> findByName(String name);

    @Query(value = "SELECT * FROM permission WHERE name IN :names", nativeQuery = true)
    List<Permission> findAllByName(@Param("names") List<String> names);

}
