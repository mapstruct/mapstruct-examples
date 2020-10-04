/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example;

import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.example.mapper.UserMapper;
import org.mapstruct.example.protobuf.Department;
import org.mapstruct.example.protobuf.Permission;
import org.mapstruct.example.protobuf.User;
import org.mapstruct.example.protobuf.UserProtos.UserDTO;

/**
 * @author Thomas Kratz
 */
public class ProtobufTest {
    /**
     * Test if everything is working when sources are present
     */
    @Test
    public void test() throws InvalidProtocolBufferException {
        User user = new User();
        user.setId("");
        user.setEmail("test");
        user.getPermissions().add(Permission.ADMIN);
        user.getMainDepartments().add(new Department("SALES"));
        user.getDepartments().add(new Department("AFTER_MARKET"));

        UserDTO dto = UserMapper.INSTANCE.map(user);
        UserDTO deserialized = UserDTO.parseFrom(dto.toByteArray());
        User back = UserMapper.INSTANCE.map(deserialized);

        Assert.assertEquals("", back.getId());
        Assert.assertEquals("test", back.getEmail());
        Assert.assertTrue(back.getPermissions().contains(Permission.ADMIN));

        Assert.assertEquals(1,back.getMainDepartments().size());
        Assert.assertEquals("SALES",back.getMainDepartments().get(0).getName());

        Assert.assertEquals(1,back.getDepartments().size());
        Assert.assertEquals("AFTER_MARKET",back.getDepartments().get(0).getName());
    }


    @Test
    public void testNulls() throws InvalidProtocolBufferException {
        User user = new User();
        // if id is null we should get the default empty string
        user.setEmail("test");
        user.getPermissions().add(Permission.ADMIN);

        UserDTO dto = UserMapper.INSTANCE.map(user);
        UserDTO deserialized = UserDTO.parseFrom(dto.toByteArray());
        User back = UserMapper.INSTANCE.map(deserialized);

        Assert.assertEquals("", back.getId());
        Assert.assertEquals("test", back.getEmail());
        Assert.assertTrue(back.getPermissions().contains(Permission.ADMIN));
    }
}
