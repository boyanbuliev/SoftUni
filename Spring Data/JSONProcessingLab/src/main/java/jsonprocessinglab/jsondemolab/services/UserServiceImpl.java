package jsonprocessinglab.jsondemolab.services;


import jsonprocessinglab.jsondemolab.entities.User;
import jsonprocessinglab.jsondemolab.exceptions.NonExistingEntity;
import jsonprocessinglab.jsondemolab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NonExistingEntity(String.format("User with id=%s does not exist", id)));
    }

    @Override
    public User addUser(User user) {
        user.setId(null);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        getUserById(user.getId());
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public long getUsersCount() {
        return userRepository.count();
    }
}
