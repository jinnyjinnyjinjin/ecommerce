package com.jinnyjinnyjinjin.ecommerce.app.user.api;

import com.jinnyjinnyjinjin.ecommerce.app.category.api.ApiResponse;
import com.jinnyjinnyjinjin.ecommerce.app.user.api.request.UserRegisterRequest;
import com.jinnyjinnyjinjin.ecommerce.app.user.dto.SignupDto;
import com.jinnyjinnyjinjin.ecommerce.app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signup(@RequestBody UserRegisterRequest request) {

        SignupDto signupDto = SignupDto.of(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );

        userService.signup(signupDto);

        return new ResponseEntity<>(
                new ApiResponse(
                        true,
                        "User created successfully"
                ),
                HttpStatus.CREATED);
    }
}
