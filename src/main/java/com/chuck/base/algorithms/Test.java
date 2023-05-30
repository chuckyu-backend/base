package com.chuck.base.algorithms;

import com.chuck.base.algorithms.sort.Insertion;
import com.chuck.base.algorithms.sort.LSD;
import com.chuck.base.algorithms.sort.Selection;
import com.chuck.base.algorithms.sort.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Test {
//  public static void main1(String[] args) {
//    String alg1 = args[0];
//    String alg2 = args[1];
//    int n = Integer.parseInt(args[2]);
//    int t = Integer.parseInt(args[3]);
//    double t1 = timeRandomInput(alg1, n, t);
//    double t2 = timeRandomInput(alg2, n, t);
//    StdOut.printf("For %d random Doubles \n %s is ", n, alg1);
//    StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
//  }

  private static double time(String alg, Comparable[] a) {
    Stopwatch timer = new Stopwatch();
    switch (alg) {
      case "Insertion":
        Insertion.sort(a);
      case "Selection":
        Selection.sort(a);
      case "Shell":
        Shell.sort(a);
    }
    return timer.elapsedTime();
  }

  private static double timeRandomInput(String alg, int n, int t) {
    double total = 0.0;
    Double[] a = new Double[n];
    for (int i = 0; i < t; i++) {
      for (int j = 0; j < n; j++) {
        a[j] = StdRandom.uniform();
      }
      total += time(alg, a);
    }
    return total;
  }

//  public static void main(String[] args) {
//    LSD.sort(new String[] {"4PGC938", "2IYE230", "3CIO720", "1ICK750"}, 7);
//  }

  public static boolean isPalindrome(int x) {
    int y = 0;

    return x == y;
  }
}
