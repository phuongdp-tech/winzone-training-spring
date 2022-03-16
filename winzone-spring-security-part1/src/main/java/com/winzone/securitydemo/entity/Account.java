package com.winzone.securitydemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.winzone.securitydemo.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 50, unique = true, nullable = false)
    private String account;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(length = 60, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role authority;
}
