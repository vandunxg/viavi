package com.viavi.entity;

import com.viavi.entity.relation.RoleHasPermission;
import com.viavi.entity.relation.UserHasRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity(name = "role")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role extends AbstractEntity<Integer> implements Serializable {

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @ManyToMany
    @JoinTable(
            name = "role_has_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    Set<Permission> permissions = new HashSet<>();

}
