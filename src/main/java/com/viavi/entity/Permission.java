package com.viavi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;


@Data
@Entity(name = "permission")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission extends AbstractEntity<Integer> implements Serializable {

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

}
