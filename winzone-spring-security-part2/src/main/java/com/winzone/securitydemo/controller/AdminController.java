package com.winzone.securitydemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("[Winzone.vn] You can connect to ADMIN API");
    }
}
