package com.cyrillic.farm.controller;

import com.cyrillic.farm.resource.AuthUser;
import com.cyrillic.farm.resource.RequestUser;
import com.cyrillic.farm.security.JwtTokenUtil;

import javax.validation.Valid;

import com.cyrillic.farm.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController extends BaseController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/auth/login")
    public ResponseEntity<AuthUser> authenticate(@RequestBody @Valid RequestUser request) {

        try {
            var userPassAuthToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()); 
            Authentication authenticate = authenticationManager.authenticate(userPassAuthToken);

            User user = (User) authenticate.getPrincipal();
            var token = jwtTokenUtil.generateAccessToken(user);

            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, token)
                    .body(new AuthUser(user.getUsername(), token));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
