package com.chuck.base.utils.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 用户认证（CRM微服务专有）
 *
 * <p>Should be extend
 *
 * @description
 * @author: Chuck
 * @date: 2/19/2022 11:21 AM
 */
public interface LoadUserService extends UserDetailsService {

  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
