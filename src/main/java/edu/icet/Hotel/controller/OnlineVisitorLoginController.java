package edu.icet.Hotel.controller;

import edu.icet.Hotel.dto.OnlineVisitorLogin;
import edu.icet.Hotel.response.LoginResponse;
import edu.icet.Hotel.response.LoginResult;
import edu.icet.Hotel.service.OnlineVisitorLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/online-visitor-login")
public class OnlineVisitorLoginController {

    final OnlineVisitorLoginService onlineVisitorLoginService;

    @PostMapping("/visitor-login")
    public ResponseEntity<LoginResponse> login(@RequestBody OnlineVisitorLogin onlineVisitorLogin) {
        LoginResult loginResult = onlineVisitorLoginService.validateCredentials(onlineVisitorLogin);

        // Build the response
        LoginResponse response = new LoginResponse(
                loginResult.isValid(),
                loginResult.getVisitorId().orElse(null) // Use null if visitorId is not present
        );

        if (response.isValid()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}