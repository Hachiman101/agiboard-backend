package com.kanboard.service;

import com.kanboard.entity.User;

public interface UserServiceInterface {
    User findOne(String username);
}
