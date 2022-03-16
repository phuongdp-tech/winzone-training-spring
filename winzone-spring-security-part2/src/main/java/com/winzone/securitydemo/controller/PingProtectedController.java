package com.winzone.securitydemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
@RestController
@RequestMapping("/api")
public class PingProtectedController {

    @GetMapping("ping-protected")
    public ResponseEntity<String> myProfile() {
        return ResponseEntity.ok("Account authenticated");
    }
}
