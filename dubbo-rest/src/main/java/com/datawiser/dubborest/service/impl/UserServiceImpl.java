package com.datawiser.dubborest.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.datawiser.dubborest.model.User;
import com.datawiser.dubborest.service.UserService;

import javax.ws.rs.*;

@Path("users")
@Service(registry = "zkregistry", timeout = 5000)
public class UserServiceImpl implements UserService {

    @Override
    @GET
    @Path("register")
    @Produces(value = {"application/json;charset=utf-8"})
    public User queryUserById(@QueryParam("id") Integer id) {
        System.out.println("id: " + id);
        return new User(id + "", "用户1");
    }

    @Override
    @POST
    @Path("update")
    public User updateUser(User user) {
        return user;
    }

    @Override
    @POST
    @Path("delete")
    public void deleteUserByIds(Integer[] ids) {

        for (Integer id: ids) {
            System.out.println("id: " + id);
        }
    }
}
