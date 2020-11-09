package com.apps.photoapp.api.users.photoappapiusers.ui.model.repository;

import com.apps.photoapp.api.users.photoappapiusers.ui.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
