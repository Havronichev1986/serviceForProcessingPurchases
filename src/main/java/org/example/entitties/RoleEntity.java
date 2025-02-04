package org.example.entitties;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity implements GrantedAuthority {
        @Id
        private Long id;

        private String name;

        @Transient
        @ManyToMany(mappedBy = "roles")
        private Set<UsersEntity> users;

    @Override
    public String getAuthority() {
        return "";
    }
}
