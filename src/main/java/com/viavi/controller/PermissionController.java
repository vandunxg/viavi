package com.viavi.controller;

import com.viavi.constant.EndpointConstant;
import com.viavi.constant.UrlConstant;
import com.viavi.payload.SuccessResponse;
import com.viavi.payload.request.permission.PermissionRequest;
import com.viavi.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = {UrlConstant.URL_PERMISSION})
public class PermissionController {

    PermissionService permissionService;

    @PostMapping(value = {EndpointConstant.ENDPOINT_ADD})
    ResponseEntity<SuccessResponse> addPermission(@RequestBody PermissionRequest request) {

        return ResponseEntity.ok(permissionService.addPermission(request));

    }

}
