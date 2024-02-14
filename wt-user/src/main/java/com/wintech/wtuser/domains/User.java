package com.wintech.wtuser.domains;

import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.internal.bytebuddy.implementation.bind.MethodDelegationBinder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @Setter(AccessLevel.NONE)
    @JoinTable(
            name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(login, that.login) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email);
    }
}
