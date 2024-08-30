package com.viavi.payload.request.permission;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionRequest {

    @NotBlank(message = "name not be must blank")
    String name;

    String description;

}
