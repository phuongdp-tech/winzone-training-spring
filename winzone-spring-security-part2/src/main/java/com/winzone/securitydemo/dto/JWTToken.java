package com.winzone.securitydemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JWTToken {
    private String accessToken;
}
