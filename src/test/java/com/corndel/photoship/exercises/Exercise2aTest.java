package com.corndel.photoship.exercises;

import static com.corndel.photoship.exercises.Exercise2a.getMiddle;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Exercise2aTest {

  // should return middle elements of a multi-element list
  @Test
  void middleMultiple() {
    assertEquals(
        List.of(6, 1, 7),
        getMiddle(new ArrayList<>(List.of(4, 6, 1, 7, 9))));
  }

  // should return a single middle element for a list of three elements
  @Test
  void middleSingle() {
    assertEquals(
        List.of(3),
        getMiddle(new ArrayList<>(List.of(2, 3, 4))));
  }

  // should return an empty list for a two-element list
  @Test
  void noMiddle() {
    assertEquals(
        List.of(),
        getMiddle(new ArrayList<>(List.of(1, 2))));
  }
}
