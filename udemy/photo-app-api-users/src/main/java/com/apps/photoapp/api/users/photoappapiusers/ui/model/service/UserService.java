package com.apps.photoapp.api.users.photoappapiusers.ui.model.service;

import com.apps.photoapp.api.users.photoappapiusers.ui.model.dto.UserDTO;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<UserDTO> findAll(int page, int limit, String sort);
    UserDTO findById(Long id);
    UserDTO create(UserDTO userDTO);
    UserDTO update(UserDTO userDTO);
    void delete(Long id);

}
