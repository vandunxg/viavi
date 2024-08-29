package com.viavi.mapper;

import com.viavi.entity.Permission;
import com.viavi.payload.request.permission.PermissionRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.jmx.export.annotation.ManagedOperation;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionMapper INSTANCE = Mappers.getMapper( PermissionMapper.class );

    Permission toPermission(PermissionRequest request);

}

