package com.ebm.persistence;

import com.ebm.domain.Users;
import com.ebm.persistence.crud.UsersCrudRepository;
import com.ebm.persistence.entity.EntityUsers;
import com.ebm.persistence.mapper.UsersMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class UsersPersistenceRepositoryTest {
    UsersPersistenceRepository tester;
    UsersCrudRepository usersCrudRepository;
    UsersMapper mapper;

    @BeforeEach
    void initEach() {
        usersCrudRepository = Mockito.mock(UsersCrudRepository.class);
        mapper = Mockito.mock(UsersMapper.class);
        tester = new UsersPersistenceRepository(usersCrudRepository, mapper);
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new Users()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        EntityUsers user = new EntityUsers();
        Users userDomain = new Users();

        when(mapper.toUsersDomain(userDomain)).thenReturn(user);
        when(mapper.toUsers(user)).thenReturn(userDomain);

        when(usersCrudRepository.save(user)).thenReturn(user);

        assertEquals(userDomain, tester.save(userDomain), "save must be new instance Users");
    }

    @Test
    void TestGetUserByIdWithOutData() {
        assertEquals(Optional.empty(), tester.getUserById(0), "getUserById must be Optional.empty()");
    }

    @Test
    void TestGetUserByIdWithData() {

        Optional<Users> usersDomain = Optional.of(new Users());
        Optional<EntityUsers> users = Optional.of(new EntityUsers());
        when(usersCrudRepository.findById(1)).thenReturn(users);
        when(mapper.toUsers(users.get())).thenReturn(usersDomain.get());

        Optional<Users> userResult = tester.getUserById(1);

        assertEquals(usersDomain, userResult, "getUserById must be Optional.of(new Users())");
    }


    @Test
    void TestFindByUserNameWithOutData() {
        assertEquals(Optional.empty(), tester.findByUserName("myusername"), "findByUserName must be Optional.empty()");
    }

    @Test
    void TestFindByUserNameWithData() {

        Optional<Users> usersDomain = Optional.of(new Users());
        Optional<EntityUsers> users = Optional.of(new EntityUsers());
        when(usersCrudRepository.findByEntityUserName("Myusername")).thenReturn(users);
        when(mapper.toUsers(users.get())).thenReturn(usersDomain.get());

        Optional<Users> userResult = tester.findByUserName("Myusername");

        assertEquals(usersDomain, userResult, "findByUserName must be Optional.of(new Users())");
    }

}
