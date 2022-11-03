// package com.chuck.base.utils.web;
//
// import redis.clients.jedis.Jedis;
// import redis.clients.jedis.JedisPool;
// import redis.clients.jedis.JedisPoolConfig;
//
/// **
// * @description
// * @author: Chuck
// * @date: 1/16/2022 5:27 PM
// */
// public enum JedisUtil {
//  INSTANCE;
//
//  private final JedisPool pool;
//
//  JedisUtil() {
//    pool = new JedisPool(new JedisPoolConfig(), "localhost");
//  }
//
//  public void sadd(String key, String value) {
//    Jedis jedis = null;
//    try {
//      jedis = pool.getResource();
//      jedis.sadd(key, value);
//    } finally {
//      if (jedis != null) {
//        jedis.close();
//      }
//    }
//  }
//
//  public void srem(String key, String value) {
//    Jedis jedis = null;
//    try {
//      jedis = pool.getResource();
//      jedis.srem(key, value);
//    } finally {
//      if (jedis != null) {
//        jedis.close();
//      }
//    }
//  }
//
//  public boolean sismember(String key, String value) {
//    Jedis jedis = null;
//    try {
//      jedis = pool.getResource();
//      return jedis.sismember(key, value);
//    } finally {
//      if (jedis != null) {
//        jedis.close();
//      }
//    }
//  }
// }
