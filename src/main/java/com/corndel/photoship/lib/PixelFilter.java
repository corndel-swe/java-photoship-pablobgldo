package com.corndel.photoship.lib;

import java.util.List;

@FunctionalInterface
public interface PixelFilter {
  List<Integer> apply(List<Integer> rgb);
}
