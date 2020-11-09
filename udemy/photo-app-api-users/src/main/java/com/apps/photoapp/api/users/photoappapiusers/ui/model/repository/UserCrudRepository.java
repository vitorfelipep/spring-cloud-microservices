package com.apps.photoapp.api.users.photoappapiusers.ui.model.repository;

import com.apps.photoapp.api.users.photoappapiusers.ui.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Long> {
}
