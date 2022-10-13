package com.jinnyjinnyjinjin.ecommerce.app.auth.api;

import com.jinnyjinnyjinjin.ecommerce.app.auth.api.request.SignInRequest;
import com.jinnyjinnyjinjin.ecommerce.app.auth.api.request.SignUpRequest;
import com.jinnyjinnyjinjin.ecommerce.app.auth.service.AuthService;
import com.jinnyjinnyjinjin.ecommerce.app.ApiResponse;
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

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signup(@RequestBody SignUpRequest request) {

        SignupDto signupDto = SignupDto.of(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );

        authService.signup(signupDto);

        return new ResponseEntity<>(
                new ApiResponse(
                        true,
                        "User created successfully"
                ),
                HttpStatus.CREATED);
    }

    @PostMapping("/signIn")
    public ResponseEntity<String> signIn(@RequestBody SignInRequest request) {
        String token = authService.signIn(request.getEmail(), request.getPassword());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
