package com.spendit.user.api.repository;

import com.spendit.user.api.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
