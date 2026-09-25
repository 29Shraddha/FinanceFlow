package com.financeflow.service;
import com.financeflow.entity.User;
import com.financeflow.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.financeflow.dto.UserRequestDTO;
import com.financeflow.dto.UserResponseDTO;
import java.time.LocalDateTime;
import com.financeflow.exception.DuplicateEmailException;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO saveUser(UserRequestDTO request) {
      if(userRepository.findByEmail(request.getEmail()).isPresent()){
          throw new DuplicateEmailException("Email already registered");
      }
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .createdAt(LocalDateTime.now())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponseDTO.builder()
                .id(savedUser.getId())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }
}
