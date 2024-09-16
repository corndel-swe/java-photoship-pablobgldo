package com.corndel.photoship.exercises;

import static com.corndel.photoship.exercises.Exercise3a.nameTag;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Exercise3aTest {

  // should return a greeting with the name in uppercase
  @Test
  void upperCase() {
    assertEquals("Hello, my name is ABDI!", nameTag("abdi"));
  }

  // should handle names already in uppercase
  @Test
  void alreadyUpperCase() {
    assertEquals("Hello, my name is ALICE!", nameTag("ALICE"));
  }

  // should handle names with mixed case
  @Test
  void mixedCase() {
    assertEquals("Hello, my name is ELIZABETH!", nameTag("eLiZaBeTh"));
  }

  // should handle single-character names
  @Test
  void singleCharacter() {
    assertEquals("Hello, my name is B!", nameTag("b"));
  }
}
