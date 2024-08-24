package com.viavi.entity;

import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class AbstractNameEntity implements Serializable {

    @Id
    String name;

}
