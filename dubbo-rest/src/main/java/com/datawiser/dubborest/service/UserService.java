package com.datawiser.dubborest.service;

import com.datawiser.dubborest.model.User;

public interface UserService {

    User queryUserById(Integer id);
    User updateUser(User user);
    void deleteUserByIds(Integer[] ids);
}
