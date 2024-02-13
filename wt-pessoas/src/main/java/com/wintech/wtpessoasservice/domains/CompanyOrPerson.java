package com.wintech.wtpessoasservice.domains;

import com.wintech.wtpessoasservice.domains.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyOrPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeCompanyOrPerson typeCompanyOrPerson;

    @Enumerated(EnumType.STRING)
    private Set<TypeRegister> type = new HashSet<>();

    private String name;
    private String telephone1;
    private String telephone2;
    private String email;

    private String cpfOrCnpj;
    private String rgOrIe;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private Address deliveryAddress;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Component> components = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyOrPerson that = (CompanyOrPerson) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
