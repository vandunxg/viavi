package com.viavi.entity;

import com.viavi.entity.relation.RoleHasPermission;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity(name = "permission")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission extends AbstractEntity<Integer> implements Serializable {

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @OneToMany(mappedBy = "permission")
    Set<RoleHasPermission> roleHasPermissions = new HashSet<>();

}
