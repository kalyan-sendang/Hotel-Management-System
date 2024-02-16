package com.java.hospitalmanagementsystem.controllers;

import com.java.hospitalmanagementsystem.models.dto.auth.AuthenticationRequest;
import com.java.hospitalmanagementsystem.models.dto.auth.RegisterRequest;
import com.java.hospitalmanagementsystem.responses.Response;
import com.java.hospitalmanagementsystem.responses.SuccessResponse;

import com.java.hospitalmanagementsystem.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is the controller for authentication-related operations in the API. It handles
 * registration, authentication, email confirmation, password reset, and password reset
 * confirmation.
 */
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
  private final AuthenticationService authenticationService;

  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }
//  private final EmailService emailConfirmation;

  @PostMapping("/register")
  public ResponseEntity<Response> register(@RequestBody RegisterRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new SuccessResponse<>(authenticationService.register(request)));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<Response> authenticate(@RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(new SuccessResponse<>(authenticationService.authenticate(request)));
  }

//  @GetMapping("/email-confirmation/{token}")
//  public ResponseEntity<Response> confirmEmail(@PathVariable String token) {
//    emailConfirmation.confirmEmail(token);
//    return ResponseEntity.ok(new SuccessResponse<>(null));
//  }

//  @PostMapping("/password-reset")
//  public ResponseEntity<Response> passwordReset(
//      @RequestBody @Valid PasswordResetRequest passwordResetRequest) {
//    authenticationService.resetPasswordRequest(passwordResetRequest);
//    return ResponseEntity.ok().body(new SuccessResponse<>(null));
//  }

//  @PostMapping("/password-reset-confirm/{token}")
//  public ResponseEntity<Response> passwordResetConfirm(
//      @PathVariable String token,
//      @RequestBody @Valid PasswordResetConfirmedRequest passwordRequest) {
//    authenticationService.resetPassword(token, passwordRequest);
//    return ResponseEntity.ok().body(new SuccessResponse<>(null));
//  }
}
