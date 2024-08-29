package com.viavi.service;

import com.viavi.payload.SuccessResponse;
import com.viavi.payload.request.permission.PermissionRequest;
import org.springframework.stereotype.Service;

@Service
public interface PermissionService {

    SuccessResponse addPermission(PermissionRequest permissionRequest);

}
