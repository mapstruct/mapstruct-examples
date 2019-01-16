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
    private List<Department> mainDepartments = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();

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

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Department> getMainDepartments() {
		return mainDepartments;
	}

	public void setMainDepartments(List<Department> mainDepartments) {
		this.mainDepartments = mainDepartments;
	}
}
