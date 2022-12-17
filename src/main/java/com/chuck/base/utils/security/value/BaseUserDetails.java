package com.chuck.base.utils.security.value;

import lombok.Data;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

/**
 * 认证用户信息
 *
 * @description
 * @author: Chuck
 * @date: 2/19/2022 10:57 AM
 */
@Data
@Value
public class BaseUserDetails implements UserDetails {

  private String username;

  private String password;

  private String salt;

  private Set<? extends GrantedAuthority> authorities;

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
