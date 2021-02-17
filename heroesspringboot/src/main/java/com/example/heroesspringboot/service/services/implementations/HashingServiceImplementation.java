package com.example.heroesspringboot.service.services.implementations;

import com.example.heroesspringboot.service.services.HashingService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class HashingServiceImplementation implements HashingService {
    @Override
    public String hash(String str) {
        return DigestUtils.sha256Hex(str);
    }
}
