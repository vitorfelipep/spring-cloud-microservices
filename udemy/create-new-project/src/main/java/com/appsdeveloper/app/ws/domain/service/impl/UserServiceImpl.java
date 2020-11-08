package com.appsdeveloper.app.ws.domain.service.impl;

import com.appsdeveloper.app.ws.domain.dto.UserDTO;
import com.appsdeveloper.app.ws.domain.entity.User;
import com.appsdeveloper.app.ws.domain.service.UserService;
import com.appsdeveloper.app.ws.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    Map<String, User> users = new HashMap<>();
    private Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    public UserServiceImpl() {}

    @Override
    public ResponseEntity<Page<UserDTO>> findAll(int page, int limit) {
        var pages = PageRequest.of(page, limit, Sort.Direction.valueOf("ASC"), "cpf");
        var usersList = users.values().stream().collect(Collectors.toList());
        var usersPage = new PageImpl<>(usersList.stream().map(UserDTO::new).collect(Collectors.toList()), pages, users.size());
        if (!usersPage.getContent().isEmpty()) {
            return ResponseEntity.ok(usersPage);
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDTO> findByKey(String key) {
        if (users.containsKey(key)) {
            return ResponseEntity.ok(new UserDTO(users.get(key)));
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public UserDTO create(UserDTO newUser) {
        String key = utils.generatedUUId();
        newUser.setKey(key);
        var user = new User(newUser);
        users.put(key, user);
        return new UserDTO(users.get(key));
    }

    @Override
    public ResponseEntity<UserDTO> update(String key, UserDTO userDTO) {
        var user = users.get(key);
        if (user != null) {
            var updateUser = new User(userDTO);
            users.put(key, updateUser);
            return ResponseEntity.ok(new UserDTO(users.get(key)));
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public void delete(String key) {
        System.out.println("Verificando usuário...: " + key);
        users.remove(key);
        System.out.println("Deletando usuário com o cpf: " + key);
    }

}
