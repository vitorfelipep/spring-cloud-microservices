package com.apps.photoapp.api.users.photoappapiusers.ui.model.service;

import com.apps.photoapp.api.users.photoappapiusers.ui.model.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public Page<UserDTO> findAll(int page, int limit, String sort) {
        return null;
    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        userDTO.setId(UUID.randomUUID().getMostSignificantBits());
        return null;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
