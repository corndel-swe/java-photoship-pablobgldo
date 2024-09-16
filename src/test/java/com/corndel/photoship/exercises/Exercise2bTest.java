package com.corndel.photoship.exercises;

import static com.corndel.photoship.exercises.Exercise2b.convertFilesizes;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Exercise2bTest {

  // should convert a list of file sizes from KB to MB
  @Test
  void works() {
    assertEquals(
        List.of(1.4, 0.5, 2.1),
        convertFilesizes(List.of(1400., 500., 2100.)));
  }

  // should handle an empty list
  @Test
  void handlesEmptyList() {
    assertEquals(List.of(), convertFilesizes(List.of()));
  }

  // should handle lists with a single element
  @Test
  void handleListsWithSingleElement() {
    assertEquals(List.of(1.), convertFilesizes(List.of(1000.)));
  }

  // should handle lists with large numbers
  @Test
  void handlesBigNumbers() {
    assertEquals(List.of(1000., 500.), convertFilesizes(List.of(1000000., 500000.)));
  }
}
