package com.viavi.service.implement;

import com.viavi.entity.Permission;
import com.viavi.exception.PermissionException;
import com.viavi.mapper.PermissionMapper;
import com.viavi.payload.SuccessResponse;
import com.viavi.payload.request.permission.PermissionRequest;
import com.viavi.repository.PermissionRepository;
import com.viavi.service.PermissionService;
import com.viavi.utils.ErrorCode;
import com.viavi.utils.SuccessCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionServiceImp implements PermissionService {

    PermissionRepository permissionRepository;

    @Override
    public SuccessResponse addPermission(PermissionRequest request) {

        if (permissionRepository.existsByName(request.getName())) {
            throw new PermissionException(ErrorCode.ERROR_PERMISSION_EXIST);
        }

        Permission newPermission = PermissionMapper.INSTANCE.toPermission(request);

        log.info("\n------------------------------SAVE PERMISSION---------------\n");
        permissionRepository.save(newPermission);

        return new SuccessResponse(SuccessCode.SUCCESS_ADD);

    }

    @Override
    public SuccessResponse updatePermissionDescription(PermissionRequest request) {

        var permission = permissionRepository.findByName(request.getName())
                .orElseThrow(() -> new PermissionException(ErrorCode.ERROR_PERMISSION_NOT_EXIST));

        PermissionMapper.INSTANCE.updatePermission(permission, request);

        log.info("\n------------------------------UPDATE PERMISSION---------------\n");
        permissionRepository.save(permission);

        return new SuccessResponse(SuccessCode.SUCCESS_UPDATE);

    }

}
