package com.example.demo.auth;

import java.util.Optional;

public interface ApplicationUserRepo {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}

