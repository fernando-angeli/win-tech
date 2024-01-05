package com.wintech.wtuser.controllers;

import com.wintech.wtuser.dtos.UserDto;
import com.wintech.wtuser.dtos.UserInsertDto;
import com.wintech.wtuser.dtos.UserUpdateDto;
import com.wintech.wtuser.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuarios")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserDto> insert (@Valid @RequestBody UserInsertDto userInsertDto){
        UserDto userDto = service.insert(userInsertDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userInsertDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(userDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDto>> findById(@PathVariable Long id){
        Optional<UserDto> userDto = service.findById(id);
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping
    public ResponseEntity<Page<UserDto>> findAll(Pageable pageable){
        Page users = service.findAll(pageable);
        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @Valid @RequestBody UserUpdateDto dto){
        UserDto newUser = service.update(id, dto);
        return ResponseEntity.ok().body(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
