package com.appsdeveloper.app.ws.domain.service;

import com.appsdeveloper.app.ws.domain.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<Page<UserDTO>> findAll(int page, int limit);
    ResponseEntity<UserDTO> findByKey(String key);
    UserDTO create(UserDTO newUser);
    ResponseEntity<UserDTO> update(String key, UserDTO userDTO);
    void delete(String key);

}
