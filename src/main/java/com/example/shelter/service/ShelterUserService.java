package com.example.shelter.service;

import com.example.shelter.domain.ShelterUser;
import com.example.shelter.mapper.ShelterUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterUserService {

    @Autowired
    ShelterUserMapper shelterUserMapper;


    public ShelterUser selectUser(Long id) {
        return shelterUserMapper.selectUser(id);
    }


}
