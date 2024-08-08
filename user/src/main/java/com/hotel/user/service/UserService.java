package com.hotel.user.service;

import com.hotel.user.dto.UserDTO;
import com.hotel.user.model.User;
import com.hotel.user.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
        @Autowired
        private UserRepo userRepo;

        @Autowired
        private ModelMapper modelMapper;

        public UserDTO saveUser(UserDTO userDTO) {
            userRepo.save(modelMapper.map(userDTO, User.class));
            return userDTO;
        }

}
