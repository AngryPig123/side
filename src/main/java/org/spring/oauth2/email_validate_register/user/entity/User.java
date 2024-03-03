package org.spring.oauth2.email_validate_register.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.spring.oauth2.email_validate_register.user.dto.UserDto;
import org.spring.oauth2.email_validate_register.roleauth.entity.Roles;
import org.spring.oauth2.email_validate_register.entity.BaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

import static jakarta.persistence.FetchType.LAZY;


@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity implements UserDetails {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @ColumnDefault("1")
    @Column(name = "account_non_expired", nullable = false)
    private boolean accountNonExpired;

    @ColumnDefault("1")
    @Column(name = "account_non_locked", nullable = false)
    private boolean accountNonLocked;

    @ColumnDefault("1")
    @Column(name = "credentials_non_expired", nullable = false)
    private boolean credentialsNonExpired;

    @ColumnDefault("1")
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Setter
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "role_id")
    private Roles roles;

    public User(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    public UserDto toDto() {
        return UserDto.builder()
                .userEmail(userEmail)
                .password(password)
                .roleName(roles.getRoleName())
                .build();
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.getRoleAuthorities().stream()
                .map(a -> new SimpleGrantedAuthority(
                        a.getAuthorityId().getAuthorityName()
                )).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}
