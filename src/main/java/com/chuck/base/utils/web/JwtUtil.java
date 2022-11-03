package com.chuck.base.utils.web;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @description
 * @author: Chuck
 * @date: 1/16/2022 4:37 PM
 */
@ConditionalOnBean(RedisTemplate.class)
public class JwtUtil {

  private final RedisTemplate<String, Object> redisTemplate;

  public JwtUtil(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  private static final String REDIS_SET_ACTIVE_SUBJECTS = "active-subjects";

  public String generateToken(String signingKey, String subject) {
    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);

    JwtBuilder builder =
        Jwts.builder()
            .setSubject(subject)
            .setIssuedAt(now)
            .signWith(SignatureAlgorithm.HS256, signingKey);
    redisTemplate.opsForSet().add(REDIS_SET_ACTIVE_SUBJECTS, subject);
    return builder.compact();
  }

  public static String getSubject(
      HttpServletRequest httpServletRequest, String jwtTokenCookieName, String signingKey) {
    String token = CookieUtil.getValue(httpServletRequest, jwtTokenCookieName);
    if (token == null) {
      return null;
    }
    return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody().getSubject();
  }

  public String parseToken(
      HttpServletRequest httpServletRequest, String jwtTokenCookieName, String signingKey) {
    String token = CookieUtil.getValue(httpServletRequest, jwtTokenCookieName);
    if (token == null) {
      return null;
    }

    String subject =
        Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody().getSubject();
    if (!redisTemplate.opsForSet().isMember(REDIS_SET_ACTIVE_SUBJECTS, subject)) {
      return null;
    }

    return subject;
  }

  public void invalidateRelatedTokens(HttpServletRequest httpServletRequest) {
    redisTemplate
        .opsForSet()
        .remove(REDIS_SET_ACTIVE_SUBJECTS, (String) httpServletRequest.getAttribute("username"));
  }
}
