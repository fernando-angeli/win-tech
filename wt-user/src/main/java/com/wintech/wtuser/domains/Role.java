package com.wintech.wtuser.domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Data
@Table(name = "tb_role")
@AllArgsConstructor
@NoArgsConstructor
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String roleName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
