package com.viavi.service.implement;

import com.viavi.entity.Role;
import com.viavi.exception.RoleException;
import com.viavi.mapper.RoleMapper;
import com.viavi.payload.SuccessResponse;
import com.viavi.payload.request.role.RoleRequest;
import com.viavi.repository.PermissionRepository;
import com.viavi.repository.RoleRepository;
import com.viavi.service.RoleService;
import com.viavi.utils.ErrorCode;
import com.viavi.utils.SuccessCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImp implements RoleService {

    RoleRepository roleRepository;
    PermissionRepository permissionRepository;

    @Override
    public SuccessResponse addRole(RoleRequest request) {

        if (roleRepository.existsByName(request.getName())) {
            throw new RoleException(ErrorCode.ERROR_ROLE_EXIST);
        }

        Role newRole = RoleMapper.INSTANCE.toRole(request);
        var permissions = permissionRepository.findAllByName(request.getPermissions());
        newRole.setPermissions(new HashSet<>(permissions));

        log.info("\n------------------------------SAVE PERMISSION---------------");
        roleRepository.save(newRole);

        return new SuccessResponse(SuccessCode.SUCCESS_ADD);

    }

}
