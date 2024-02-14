package com.wintech.wtclientservice.domains;

import com.wintech.wtclientservice.domains.enums.TypeCompanyOrPerson;
import com.wintech.wtclientservice.domains.enums.TypeRegister;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Client {

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

}
