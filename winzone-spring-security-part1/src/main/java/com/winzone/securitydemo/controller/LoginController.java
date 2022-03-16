package com.winzone.securitydemo.controller;

import com.winzone.securitydemo.dto.JWTToken;
import com.winzone.securitydemo.dto.LoginRequestDto;
import com.winzone.securitydemo.security.TokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
@RestController
@RequestMapping("/api/login")
@AllArgsConstructor
public class LoginController {

    private final TokenProvider tokenProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping()
    public ResponseEntity<JWTToken> authorize(@Valid @RequestBody LoginRequestDto requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                requestDto.getAccount().toLowerCase(),
                requestDto.getPassword()
        );

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(JWTToken.builder().accessToken(jwt).build());
    }
}
