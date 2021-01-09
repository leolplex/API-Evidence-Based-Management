package com.ebm.domain.service;

import com.ebm.domain.Users;
import com.ebm.domain.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EBMUserDetailService implements UserDetailsService {
    @Autowired
    private final UsersRepository usersRepository;

    public EBMUserDetailService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> userRepo = usersRepository.findByUserName(username);


        return userRepo.map(users -> {
            if (users.getUsername() == null || users.getUsername().isEmpty() ||
                    users.getPassword() == null || users.getPassword().isEmpty()) {
                return null;
            }
            return new User(users.getUsername(), users.getPassword(), new ArrayList<>());
        }).orElse(null);

    }
}
