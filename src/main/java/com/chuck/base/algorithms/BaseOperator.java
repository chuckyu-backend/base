package com.chuck.base.algorithms;

import edu.princeton.cs.algs4.StdRandom;

public class BaseOperator {
  /**
   * 反向排序
   *
   * @param a
   */
  public void reverse(int[] a) {
    int len = a.length;
    for (int i = 0; i < len / 2; i++) {
      int temp = a[i];
      a[i] = a[len - 1 - i];
      a[len - i - 1] = temp;
    }
  }

  /**
   * 矩阵相乘：m*m
   *
   * @param a
   * @param b
   * @return
   */
  public int[][] matrixMultiply(int[][] a, int[][] b) {
    int len = a.length;
    int[][] c = new int[len][len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        for (int k = 0; k < len; k++) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return c;
  }

  /**
   * 是否为素数
   *
   * @param n
   * @return
   */
  public static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  private boolean isPrime1(int a) {
    if (a < 2) {
      return false;
    }
    for (int i = 2; i * i <= a; i++) {
      if (a % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * 调和级数
   *
   * @param n
   * @return
   */
  public static double h(int n) {
    double sum = 0.0;
    for (int i = 0; i <= n; i++) {
      sum += 1.0 / i;
    }
    StdRandom.bernoulli();
    return sum;
  }

  /**
   * 最大公约数
   *
   * <p>p >q >0
   *
   * @param p
   * @param q
   * @return
   */
  public static int gcd(int p, int q) {
    if (q == 0) {
      return p;
    }
    int r = p % q;
    return gcd(q, r);
  }

  private int gcd1(int p, int q) {
    int r = p % q;
    if (r == 0) {
      return q;
    }
    return gcd1(q, r);
  }

  /**
   * 平方根：牛顿迭代法
   *
   * @param c
   * @return
   */
  public static double sqrt(double c) {
    if (c < 0) {
      return Double.NaN;
    }
    double err = 1e-15;
    double t = c;
    while (Math.abs(t - c / t) > err * t) {
      t = (c / t + t) / 2.0;
    }
    return t;
  }

  public static boolean isEven(int n) {
    return (n & 1 ^ 1) == 1;
  }
}
