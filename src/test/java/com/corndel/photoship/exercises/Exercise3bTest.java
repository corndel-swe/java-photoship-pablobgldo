package com.corndel.photoship.exercises;

import static com.corndel.photoship.exercises.Exercise3b.formatPrice;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Exercise3bTest {

  // should format the amount as a price with the currency symbol
  @Test
  void formatsCorrectly() {
    assertEquals(formatPrice(12.83795, "£"), "£12.84");
  }

  // should add trailing 0 if needed
  @Test
  void addsTrailingZero() {
    assertEquals(formatPrice(2.5, "$"), "$2.50");
  }

  // should handle zero correctly
  @Test
  void handlesZero() {
    assertEquals(formatPrice(0, "$"), "$0.00");
  }

  // should handle negative numbers
  @Test
  void handlesNegative() {
    assertEquals(formatPrice(-10.99, "€"), "€-10.99");
  }

  // should format the price correctly with large numbers
  @Test
  void handlesLargeNumbers() {
    assertEquals(formatPrice(123456.789, "¥"), "¥123456.79");
  }

  // should handle different currency symbols
  @Test
  void handlesDifferentCurrency() {
    assertEquals(formatPrice(100, "₹"), "₹100.00");
  }
}
