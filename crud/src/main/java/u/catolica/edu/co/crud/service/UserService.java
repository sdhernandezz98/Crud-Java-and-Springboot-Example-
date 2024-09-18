package u.catolica.edu.co.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import u.catolica.edu.co.crud.model.User;
import u.catolica.edu.co.crud.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setStatus(userDetails.getStatus());
        user.setIdRole(userDetails.getIdRole());
        user.setIdCompany(userDetails.getIdCompany());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}