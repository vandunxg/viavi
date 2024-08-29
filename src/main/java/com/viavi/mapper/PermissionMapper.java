package com.viavi.mapper;

import com.viavi.entity.Permission;
import com.viavi.payload.request.permission.PermissionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionMapper INSTANCE = Mappers.getMapper( PermissionMapper.class );

    Permission toPermission(PermissionRequest request);

}

