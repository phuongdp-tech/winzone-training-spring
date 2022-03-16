package com.winzone.securitydemo.repository;

import com.winzone.securitydemo.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author <a href="mailto:phuongdp.tech@gmail.com">PhuongDP</a>
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByAccount(String account);
}
