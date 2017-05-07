package org.mapstruct.example.protobuf;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Kratz
 */
public class User {

    private String id;
    private String email;
    private List<Permission> permissions = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
