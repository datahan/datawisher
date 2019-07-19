package com.datahan.webapp.service.impl;

import com.datahan.webapp.service.HomeService;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Override
    public void print(String words) {
        System.out.println(words);
    }
}
