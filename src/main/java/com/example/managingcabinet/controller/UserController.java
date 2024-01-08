package com.example.managingcabinet.controller;

import com.example.managingcabinet.dto.auth.AuthCreateRespDto;
import com.example.managingcabinet.dto.user.UserCreateReqDto;
import com.example.managingcabinet.dto.user.UserPatchReqDto;
import com.example.managingcabinet.dto.user.UserRespDto;
import com.example.managingcabinet.dto.user.UserUpdateReqDto;
import com.example.managingcabinet.mapper.UserMapper;
import com.example.managingcabinet.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    @PostMapping
    @Operation(summary = "Method to confirm user with confirmation code")
    public ResponseEntity<AuthCreateRespDto> create(@RequestBody @Valid UserCreateReqDto create) {

        log.info("AuthCreateReqDto : {}", create);

        create.validateFields();

        return ResponseEntity.ok(service.create(mapper.toModel(create), create.getType()));
    }

    @PutMapping
    @Operation(summary = "Method to confirm user with confirmation code")
    public ResponseEntity<UserRespDto> update(@RequestBody @Valid UserUpdateReqDto update) {

        log.info("UserUpdateReqDto : {}", update);

        return ResponseEntity.ok(mapper.toRespDto(service.update(mapper.toModel(update))));
    }

    @PatchMapping
    @Operation(summary = "Method to confirm user with confirmation code")
    public ResponseEntity<UserRespDto> patch(@RequestBody @Valid UserPatchReqDto patch) {

        log.info("AuthCreateReqDto : {}", patch);

        return ResponseEntity.ok(mapper.toRespDto(service.patch(mapper.toModel(patch))));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Method to confirm user with confirmation code")
    public ResponseEntity<UserRespDto> get(@PathVariable("id") Long id) {

        log.info("get User : {}", id);

        return ResponseEntity.ok(mapper.toRespDto(service.getById(id)));
    }

    @DeleteMapping
    @Operation(summary = "Delete own Account")
    public ResponseEntity<Void> delete() {

        log.info("delete User  initialized! ");

        service.delete();

        return ResponseEntity.ok().build();
    }

}
