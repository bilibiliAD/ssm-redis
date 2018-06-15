package com.nfc.service;

import com.nfc.pojo.User;

/**
 * Created by ms-zk on 2017-03-15.
 */
public interface UserService {
    User findByEmail(String email);
}
