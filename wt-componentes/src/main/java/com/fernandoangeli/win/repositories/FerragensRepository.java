package com.fernandoangeli.win.repositories;

import com.fernandoangeli.win.domains.Ferragem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FerragensRepository extends JpaRepository <Ferragem, Long> {

    // Query não será mais utilizada por enquanto.
//    @Query(
//            value = "SELECT LAST(ID) FROM hardware_component",
//            nativeQuery = true
//    )
//    Long nextId();

}
