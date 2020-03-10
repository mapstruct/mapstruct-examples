/**
 * Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 * and/or other contributors as indicated by the @authors tag. See the
 * copyright.txt file in the distribution for a full listing of all
 * contributors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mapstruct.example.mapper;

import com.google.protobuf.StringValue;
import org.mapstruct.AfterMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ValueMapping;
import org.mapstruct.example.protobuf.Department;
import org.mapstruct.example.protobuf.Permission;
import org.mapstruct.example.protobuf.User;
import org.mapstruct.example.protobuf.UserProtos.DepartmentDTO;
import org.mapstruct.example.protobuf.UserProtos.PermissionDTO;
import org.mapstruct.example.protobuf.UserProtos.UserDTO;
import org.mapstruct.factory.Mappers;

/**
 * @author Thomas Kratz
 */
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = ProtoMapper.class)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    @Mapping(source = "permissions", target = "permissionsList")
    @Mapping(source = "mainDepartments", target = "mainDepartmentsList")
    @Mapping(source = "departments", target = "departmentsList")
    UserDTO map(User user);

    @Mapping(source = "permissionsList", target = "permissions")
    @Mapping(source = "mainDepartmentsList", target = "mainDepartments")
    @Mapping(source = "departmentsList", target = "departments")
    @Mapping(source = "alternateEmailsList", target = "alternateEmails")
    User map(UserDTO userDTO);

    @ValueMapping(source = "UNRECOGNIZED", target = MappingConstants.NULL)
    Permission map(PermissionDTO permissionDTO);

    PermissionDTO map(Permission perm);


    Department map(DepartmentDTO departmentDTO);
    DepartmentDTO map(Department department);
    
    @AfterMapping
    default void after(User user, @MappingTarget final UserDTO.Builder builder) {
        int idx = 0;
        for (String item : user.getAlternateEmails()) {
            builder.addAlternateEmails(idx++, StringValue.of(item));
        }
    }
}
