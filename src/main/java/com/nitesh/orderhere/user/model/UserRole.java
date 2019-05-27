
package com.nitesh.orderhere.user.model;

import javax.persistence.*;

@Entity
@Table(name = "users_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RoleId")
    private int roleId;

    @Column(name = "UserRole")
    private String userRole;

    public UserRole() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}
