package com.example.demo.services;

import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.UserLoginDto;
import com.example.demo.dtos.UserRegisterDto;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private UserDto loggedUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public String registerUser(UserRegisterDto registerDto) {
        StringBuilder sb = new StringBuilder();
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            sb.append("Passwords don't match");
        } else if (this.validatorUtil.isValid(registerDto)) {
            User user = modelMapper.map(registerDto, User.class);
            if (userRepository.count() == 0) {
                user.setRole(Role.ADMIN);
            } else {
                user.setRole(Role.USER);
            }
            sb.append(String.format("%s was registered%n", registerDto.getFullName()));
            userRepository.saveAndFlush(user);
        } else {
            this.validatorUtil.violations(registerDto)
                    .forEach(e -> sb.append(String.format("%s%n", e.getMessage())));
        }
        return sb.toString().trim();
    }

    @Override
    public String loginUser(UserLoginDto loginDto) {
        StringBuilder sb = new StringBuilder();
        Optional<User> user = this.userRepository
                .findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if (user.isPresent()) {
            if (loggedUser != null) {
                sb.append("User is already logged in");
            } else {
                loggedUser = modelMapper.map(user.get(), UserDto.class);
                sb.append("Successfully logged in ").append(user.get().getFullName());
            }
        } else {
            sb.append("Incorrect username");
        }
        return sb.toString();
    }

    @Override
    public String logoutUser() {
        if (loggedUser != null) {
            String message = String.format("User %s successfully loged out", loggedUser.getFullName());
            loggedUser = null;
            return message;
        }
        return "Cannot log out. No user was logged in";
    }

    @Override
    public boolean isAdminLogged() {
        return this.loggedUser != null &&
                this.userRepository.findByEmail(loggedUser.getEmail()).getRole().equals(Role.ADMIN);
    }
}
