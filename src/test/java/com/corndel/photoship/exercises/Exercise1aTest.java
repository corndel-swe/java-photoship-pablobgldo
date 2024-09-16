package com.corndel.photoship.exercises;

import static com.corndel.photoship.exercises.Exercise1a.firstAddLast;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Exercise1aTest {

  // should return the sum of the first and last elements in a multi-element array
  @Test
  void firstLast() {
    assertEquals(firstAddLast(new int[] { 4, 1, 9, 5, 2 }), 6);
  }

  // should handle negative numbers correctly
  @Test
  void negatives() {
    assertEquals(firstAddLast(new int[] { -3, 1, 4, -2 }), -5);
  }
}
