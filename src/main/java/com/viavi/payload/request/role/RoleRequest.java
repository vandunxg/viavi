package com.viavi.payload.request.role;

import com.viavi.entity.Permission;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleRequest implements Serializable {

    String name;
    String description;
    List<String> permissions;

}
