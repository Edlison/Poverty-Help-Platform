package com.edlison.marketing.service;

import com.edlison.marketing.appoint.StoreAppoint;
import com.edlison.marketing.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    StoreAppoint storeAppoint;

    public SystemResult login(String email, String password) {

        return storeAppoint.login(email, password) ? SystemResult.LOGIN_SUCCESS : SystemResult.LOGIN_PASSWORD_REJECTED;
    }
}
