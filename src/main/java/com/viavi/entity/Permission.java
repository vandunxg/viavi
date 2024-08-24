package com.viavi.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Entity(name = "permission")
public class Permission extends AbstractEntity<String> implements Serializable {


}
