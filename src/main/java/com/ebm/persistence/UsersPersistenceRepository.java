package com.ebm.persistence;

import com.ebm.domain.Users;
import com.ebm.domain.repository.UsersRepository;
import com.ebm.persistence.crud.UsersCrudRepository;
import com.ebm.persistence.entity.EntityUsers;
import com.ebm.persistence.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsersPersistenceRepository implements UsersRepository {
    @Autowired
    private UsersCrudRepository usersCrudRepository;
    @Autowired
    private UsersMapper mapper;


    UsersPersistenceRepository(UsersCrudRepository usersCrudRepository, UsersMapper mapper) {
        this.usersCrudRepository = usersCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public Users save(Users user) {
        EntityUsers entityUsers = mapper.toUsersDomain(user);
        return mapper.toUsers(usersCrudRepository.save(entityUsers));
    }

    @Override
    public Optional<Users> getUserById(int idUser) {
        return usersCrudRepository.findById(idUser).map(userResult -> mapper.toUsers(userResult));
    }

    @Override
    public Optional<Users> findByUserName(String userName) {
        return usersCrudRepository.findByEntityUserName(userName).map(userResult -> mapper.toUsers(userResult));
    }

}
