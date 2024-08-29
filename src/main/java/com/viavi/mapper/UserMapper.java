package com.viavi.mapper;

import com.viavi.entity.User;
import com.viavi.payload.request.auth.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(target = "password", ignore = true)
    User toUser(RegisterRequest registerRequest);
}

