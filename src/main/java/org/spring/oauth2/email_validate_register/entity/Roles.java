package org.spring.oauth2.email_validate_register.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.spring.oauth2.email_validate_register.entity.etc.BaseEntity;
import org.spring.oauth2.email_validate_register.user.entity.User;


import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Table(name = "roles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Roles extends BaseEntity {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "roles", fetch = LAZY)
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "roleId", fetch = LAZY)
    private List<RoleAuthority> roleAuthorities = new ArrayList<>();

    public Roles(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
