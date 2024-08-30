package com.viavi.mapper;

import com.viavi.entity.Permission;
import com.viavi.payload.request.permission.PermissionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionMapper INSTANCE = Mappers.getMapper( PermissionMapper.class );

    @Mapping(target = "name", expression = "java(request.getName().toUpperCase())")
    Permission toPermission(PermissionRequest request);

    @Mapping(target = "name", ignore = true)
    void updatePermission(@MappingTarget Permission permission, PermissionRequest permissionRequest);

}

