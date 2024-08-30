package com.viavi.entity.relation;

import com.viavi.entity.AbstractEntity;
import com.viavi.entity.Permission;
import com.viavi.entity.Role;
import com.viavi.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@Entity(name = "user_has_role")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserHasRole extends AbstractEntity<Integer> implements Serializable {

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
