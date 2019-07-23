package com.arek.dbrepo.dbservice.service;

import com.arek.dbrepo.dbservice.model.Role;
import com.arek.dbrepo.dbservice.model.User;
import com.arek.dbrepo.dbservice.repository.RoleRepository;
import com.arek.dbrepo.dbservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveUser(User user) {
    user.setActive(1);
    Role role= roleRepository.findByRole("ROLE_USER");
    user.setRoles(new HashSet<Role>(Arrays.asList(role)));
    userRepository.save(user);
    }
}
