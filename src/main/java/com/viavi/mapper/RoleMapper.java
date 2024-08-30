package com.viavi.mapper;

import com.viavi.entity.Permission;
import com.viavi.entity.Role;
import com.viavi.payload.request.permission.PermissionRequest;
import com.viavi.payload.request.role.RoleRequest;
import com.viavi.repository.RoleRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper( RoleMapper.class );


    @Mapping(target = "name", expression = "java(request.getName().toUpperCase())")
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

}

