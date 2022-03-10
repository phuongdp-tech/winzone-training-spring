package com.winzone.securitydemo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
@Data
public class LoginRequestDto {

    @NotNull
    @Size(min = 1, max = 50)
    private String account;

    @NotNull
    @Size(min = 4, max = 100)
    private String password;
}
