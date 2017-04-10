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



  Big O notation

  let f(n) and g(n) be functions mapping integers to real numbers.

  we say f(n) is O(g(n)) if there is a real constant C and an integer
  n0 > 1 such that f(n) < Cg(n) , n>=n0

  Sorting Algorithms
  Selection Sort
  Merge Sort
  Tree Sort
    -insert into BST
    -in order traversal

  Hashing functions

  integers must be small with respect to the size of keys

  Must be a "good" hash function

  open Adressing:

    Create an array of size m
    insert key at the index coresponding hash functions output.
    collision is when more then one key hashes to the same value.
    if collision, linear probeing
    linear probeing(keep go one less until you find an empty space)

    Load Factor = N (number of elements) /m (table size)
    Expect constant time preformance:
      good hash function
      Load Factor < 0.5

  Seperate Chaining:

    array of LinkedLists or BST's
    all items that hash to same value go into linked list
    Load Factor = N(number of elements) / m (table size)
    c(small constant)
    Load Factor < c
    (this implies the adverage Linked list is c)




*/

import java.util.*;

public class JavaReview{

  public static void main(String[] args) {




  }
}
