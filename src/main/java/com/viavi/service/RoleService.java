package com.viavi.service;

import com.viavi.payload.SuccessResponse;
import com.viavi.payload.request.permission.PermissionRequest;
import com.viavi.payload.request.role.RoleRequest;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    SuccessResponse addRole(RoleRequest roleRequest);

}
