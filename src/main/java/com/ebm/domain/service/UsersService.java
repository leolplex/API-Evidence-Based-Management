package com.ebm.domain.service;

import com.ebm.domain.Users;
import com.ebm.domain.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users save(Users user) {
        return usersRepository.save(user);
    }

    public Optional<Users> getUserById(int idUser) {
        return usersRepository.getUserById(idUser);
    }

    public Optional<Users> findByUserName(String userName) {
        return usersRepository.findByUserName(userName);
    }
}
