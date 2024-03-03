package org.spring.oauth2.email_validate_register.roleauth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.repository.AuthorityRepository;
import org.spring.oauth2.email_validate_register.repository.RoleAuthorityRepository;
import org.spring.oauth2.email_validate_register.repository.RolesRepository;
import org.spring.oauth2.email_validate_register.roleauth.dto.req.RoleAuthorityDto;
import org.spring.oauth2.email_validate_register.roleauth.entity.Authority;
import org.spring.oauth2.email_validate_register.roleauth.entity.RoleAuthority;
import org.spring.oauth2.email_validate_register.roleauth.entity.Roles;
import org.spring.oauth2.email_validate_register.roleauth.entity.etc.RoleAuthorityId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class RoleAuthorityServiceImpl implements RoleAuthorityService {

    private final RolesRepository rolesRepository;
    private final AuthorityRepository authorityRepository;
    private final RoleAuthorityRepository roleAuthorityRepository;

    @Override
    public List<RoleAuthorityDto> insertRoleAuthority(List<RoleAuthorityDto> roleAuthorityDtoList) {

        List<RoleAuthorityId> roleAuthorityIds = roleAuthorityDtoList.stream().map(RoleAuthorityDto::toRoleAuthorityId).toList();

        List<RoleAuthority> roleAuthorities = roleAuthorityIds.stream()
                .map(item -> {
                    Optional<Authority> findAuthority = authorityRepository.findById(item.getAuthorityId());
                    Optional<Roles> findRoles = rolesRepository.findById(item.getRoleId());
                    if (findAuthority.isPresent() && findRoles.isPresent()) {
                        Authority authority = findAuthority.get();
                        Roles roles = findRoles.get();
                        RoleAuthorityId id = new RoleAuthorityId(roles.getRoleId(), authority.getAuthorityId());
                        return new RoleAuthority(id, roles, authority);
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .toList();

        List<RoleAuthority> resultList = roleAuthorityRepository.saveAll(roleAuthorities);

        return resultList.stream().map(RoleAuthority::toDto).toList();
    }


}
