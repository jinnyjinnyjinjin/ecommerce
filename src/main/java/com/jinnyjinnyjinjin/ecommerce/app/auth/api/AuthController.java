package com.jinnyjinnyjinjin.ecommerce.app.auth.api;

import com.jinnyjinnyjinjin.ecommerce.app.auth.api.request.SignUpRequest;
import com.jinnyjinnyjinjin.ecommerce.app.auth.service.AuthService;
import com.jinnyjinnyjinjin.ecommerce.app.category.api.ApiResponse;
import com.jinnyjinnyjinjin.ecommerce.app.user.dto.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class AuthController {

    private final AuthService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signup(@RequestBody SignUpRequest request) {

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
