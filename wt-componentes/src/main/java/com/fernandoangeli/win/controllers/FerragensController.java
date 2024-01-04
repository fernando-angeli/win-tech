package com.fernandoangeli.win.controllers;

import com.fernandoangeli.win.dtos.FerragemDto;
import com.fernandoangeli.win.services.ComponentesFerragensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/componentes/ferragens")
public class FerragensController {

    @Autowired
    private ComponentesFerragensService service;

    @GetMapping
    public ResponseEntity<Page<FerragemDto>> findAll(Pageable pageable){
        Page<FerragemDto> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FerragemDto>> findById(@PathVariable Long id){
        Optional<FerragemDto> ferragemDto = service.findById(id);
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<FerragemDto> insert(@RequestBody FerragemDto ferragemDto){
        ferragemDto = service.insert(ferragemDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ferragemDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(ferragemDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FerragemDto> update(@PathVariable Long id, @RequestBody FerragemDto dto){
        FerragemDto ferragemDto = service.update(id, dto);
        return ResponseEntity.ok().body(ferragemDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
