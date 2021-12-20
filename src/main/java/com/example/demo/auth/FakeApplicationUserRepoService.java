package com.example.demo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.demo.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserRepoService implements ApplicationUserRepo{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserRepoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(

                new ApplicationUser(
                        "berke",
                        passwordEncoder.encode("123"),
                        CUSTOMER.getGrantedAuthorities(),
                        true, true, true, true

                ),
                new ApplicationUser(
                        "berk",
                        passwordEncoder.encode("123"),
                        EMPLOYEE.getGrantedAuthorities(),
                        true, true, true, true

                ),
                new ApplicationUser(
                        "emre",
                        passwordEncoder.encode("123"),
                        ADMIN.getGrantedAuthorities(),
                        true, true, true, true

                )

        );

        return applicationUsers;
    }
}
