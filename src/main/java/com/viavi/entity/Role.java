package com.viavi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;


@Data
@Entity(name = "role")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role extends AbstractEntity<Integer> implements Serializable {

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;


}
