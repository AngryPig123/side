package org.spring.oauth2.email_validate_register.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;


@Entity
@Getter
@Table(name = "authorities")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Authority extends BaseEntity {

    @Id
    @Column(name = "authority_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorityId;

    @Column(name = "authority_name", nullable = false, unique = true)
    private String authorityName;

    @Column(name = "end_point", nullable = false)
    private String endPoint;

    @OneToMany(mappedBy = "authorityId", fetch = LAZY)
    private List<RoleAuthority> roleAuthorities = new ArrayList<>();

}
