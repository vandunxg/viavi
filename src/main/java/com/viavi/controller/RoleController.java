package com.viavi.controller;

import com.sun.net.httpserver.Authenticator;
import com.viavi.constant.EndpointConstant;
import com.viavi.constant.UrlConstant;
import com.viavi.payload.SuccessResponse;
import com.viavi.payload.request.permission.PermissionRequest;
import com.viavi.payload.request.role.RoleRequest;
import com.viavi.service.PermissionService;
import com.viavi.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = {UrlConstant.ROLE_PERMISSION})
public class RoleController {

    RoleService roleService;

    @PostMapping(value = {EndpointConstant.ENDPOINT_ADD})
    ResponseEntity<SuccessResponse> addPermission(@RequestBody RoleRequest request) {

        return ResponseEntity.ok(roleService.addRole(request));

    }

}
