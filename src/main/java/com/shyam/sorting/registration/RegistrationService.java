package com.shyam.sorting.registration;

import com.shyam.sorting.user.Role;
import com.shyam.sorting.user.User;
import com.shyam.sorting.user.UserRepo;
import com.shyam.sorting.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserRepo userRepo;
    private final UserService userService;
    public void register(RegistrationRequest request) {
        User existingUser = userRepo.findByEmail(request.getEmail());
        if(existingUser != null){
            throw new IllegalStateException(String.format("User already exist with email %s",request.getEmail()));
        }
        User newUser = new User(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                Role.USER
        );
        userService.signUp(newUser);
    }
}
