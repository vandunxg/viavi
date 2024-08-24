package com.viavi.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@MappedSuperclass
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class AbstractEntity<T> implements Serializable {

    @Id
    T id;

}
