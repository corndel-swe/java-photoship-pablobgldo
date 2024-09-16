package com.corndel.photoship.exercises;

import static com.corndel.photoship.exercises.Exercise1b.arrayRotate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Exercise1bTest {

  // puts the last element to the front
  @Test
  void rotates() {
    assertEquals(
        List.of("z", "x", "y"),
        arrayRotate(new ArrayList<>(List.of("x", "y", "z"))));
  }

  // should swap the elements in a two-element list
  @Test
  void swaps() {
    assertEquals(
        List.of(2, 1),
        arrayRotate(new ArrayList<>(List.of(1, 2))));
  }
}
