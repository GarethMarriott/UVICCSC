//Copyright (c) 2017 Copyright Holder All Rights Reserved.
/*
Classes can access other classes private variables
Midterm Stuff:
implement a .equals()

O(i)  -constant
O(n)  -linear

**Abstract Data Types (ADT)**

LIST--
  hypothetical list characteristics
  addFront
  addBack
  size
  clear
  get


MIDTERM 1  ******

  java basics
  arrays
  Object references(array is like an object ref)
  ADT(Abstract data types)
    -list
    -ArrayList
  LinkedLists











*/

import java.util.*;

public class JavaReview{

  public static void main(String[] args) {


int[] arr1 = {1,4,6,2,3};
int[] arr2 = {1};
int[] arr3 = {7,7,8,4};

int[] arr11 = gareth(arr1);
int[] arr22 = gareth(arr2);
int[] arr33 = gareth(arr3);

System.out.println(printArray(arr11));
System.out.println(printArray(arr22));
System.out.println(printArray(arr33));
/*
    String s = "inheritance";
    String a = s.substring(2 , 5);
    System.out.println(a);

    int[][] test1 = {{31,24,64,75},
                    {645,84,4,6},
                    {64,6,}};

    int placeholder = test1[0][0];

    for (int i=0; test1.length > i; i++) {
      for (int j=0; test1[i].length > j; j++) {
        if (test1[i][j] > placeholder) {
          placeholder = test1[i][j];
        }
      }
    }
  System.out.println(placeholder);

*/





  }

  public static int[] gareth(int[] a){
    int[] buffer = new int[a.length];
    int count = 0;
    for (int i = 0; i<a.length; i++) {
      if (a[i] < 4) {
        buffer[count] = a[i];
        count++;
      }
    }
    int[] b = new int[count];
    for (int i = 0; i<count; i++) {
      b[i]=buffer[i];
    }
    return b;
  }

  public static String printArray(int[] a){
    String s = "{";
    for (int i = 0; i < a.length; i++) {
      s += a[i];
      s += " ";
    }
    s += "}";
    return s;
  }


}
