/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
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
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    @Mapping(source = "permissions", target = "permissionsList")
    @Mapping(source = "mainDepartments", target = "mainDepartmentsList")
    @Mapping(source = "departments", target = "departmentsList")
    UserDTO map(User user);

    @Mapping(source = "permissionsList", target = "permissions")
    @Mapping(source = "mainDepartmentsList", target = "mainDepartments")
    @Mapping(source = "departmentsList", target = "departments")
    User map(UserDTO userDTO);

    @ValueMapping(source = "UNRECOGNIZED", target = MappingConstants.NULL)
    Permission map(PermissionDTO permissionDTO);

    PermissionDTO map(Permission perm);


    Department map(DepartmentDTO departmentDTO);
    DepartmentDTO map(Department department);
}
