package com.viavi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.io.Serializable;

public abstract class AbstractIdEntity implements Serializable {

    @Id
    @Column(name = "id")
    Long id;

}
