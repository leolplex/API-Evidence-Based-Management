package com.ebm.domain.repository;


import com.ebm.domain.Users;

import java.util.Optional;

public interface UsersRepository {
    Users save(Users user);

    Optional<Users> getUserById(int idUser);

    Optional<Users> findByUserName(String userName);


}
