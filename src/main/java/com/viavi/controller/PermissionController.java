package com.viavi.controller;

import com.viavi.constant.EndpointConstant;
import com.viavi.constant.UrlConstant;
import com.viavi.entity.Permission;
import com.viavi.payload.SuccessResponse;
import com.viavi.payload.request.permission.PermissionRequest;
import com.viavi.repository.PermissionRepository;
import com.viavi.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = {UrlConstant.URL_PERMISSION})
@Validated
public class PermissionController {

    PermissionService permissionService;

    @PostMapping(value = {EndpointConstant.ENDPOINT_ADD})
    ResponseEntity<SuccessResponse> addPermission(@Validated @RequestBody PermissionRequest request) {

        return ResponseEntity.ok(permissionService.addPermission(request));

    }

    @PatchMapping(value = {EndpointConstant.ENDPOINT_UPDATE_DESCRIPTION})
    ResponseEntity<SuccessResponse> updateDescription(@Validated @RequestBody PermissionRequest request) {

        return ResponseEntity.ok(permissionService.updatePermissionDescription(request));

    }

}
