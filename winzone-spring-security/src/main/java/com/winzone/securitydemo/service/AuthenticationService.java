package com.winzone.securitydemo.service;

import com.winzone.securitydemo.entity.Account;
import com.winzone.securitydemo.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
@AllArgsConstructor
@Service
public class AuthenticationService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String account) {

        return accountRepository
            .findByAccount(account)
            .map(this::createSpringSecurityUser)
            .orElseThrow(() -> new UsernameNotFoundException("Account " + account + " was not found in the database"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(Account account) {
        List<GrantedAuthority> grantedAuthorities =
                Collections.singletonList(new SimpleGrantedAuthority(account.getAuthority().name()));
        return new org.springframework.security.core.userdetails.User(account.getAccount(), account.getPassword(), grantedAuthorities);
    }
}
