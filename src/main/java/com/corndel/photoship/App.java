package com.corndel.photoship;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import java.io.IOException;
import java.util.concurrent.Callable;

import com.corndel.photoship.lib.Converter;
import com.corndel.photoship.lib.Pixels;

@Command(name = "photoship", version = "1.0", description = "The Photoship CLI", mixinStandardHelpOptions = true, subcommands = {
    StripRedCommand.class,
    StripGreenCommand.class,
    StripBlueCommand.class,
    InvertCommand.class,
    GrayscaleCommand.class,
    BlackAndWhiteCommand.class,
    ColorChannelCommand.class,
    SepiaCommand.class,
    AdjustBrightnessCommand.class
})
public class App implements Callable<Integer> {

  public static void main(String[] args) {
    int exitCode = new CommandLine(new App()).execute(args);
    System.exit(exitCode);
  }

  @Override
  public Integer call() throws Exception {
    return 0;
  }
}

@Command(name = "strip-red", description = "Remove red from the image")
class StripRedCommand implements Callable<Integer> {

  @Parameters(index = "0", description = "The image filename")
  private String filename;

  @Override
  public Integer call() throws Exception {
    try {
      var image = new Converter(filename);
      image.applyFilter(Pixels::stripRed);
      image.saveImage();
    } catch (IOException e) {
      System.err.println("Failed to process the image: " + e.getMessage());
      return 1;
    }
    return 0;
  }
}

@Command(name = "strip-green", description = "Remove green from the image")
class StripGreenCommand implements Callable<Integer> {

  @Parameters(index = "0", description = "The image filename")
  private String filename;

  @Override
  public Integer call() throws Exception {
    try {
      var image = new Converter(filename);
      image.applyFilter(Pixels::stripGreen);
      image.saveImage();
    } catch (IOException e) {
      System.err.println("Failed to process the image: " + e.getMessage());
      return 1;
    }
    return 0;
  }
}

@Command(name = "strip-blue", description = "Remove blue from the image")
class StripBlueCommand implements Callable<Integer> {

  @Parameters(index = "0", description = "The image filename")
  private String filename;

  @Override
  public Integer call() throws Exception {
    try {
      var image = new Converter(filename);
      image.applyFilter(Pixels::stripBlue);
      image.saveImage();
    } catch (IOException e) {
      System.err.println("Failed to process the image: " + e.getMessage());
      return 1;
    }
    return 0;
  }
}

@Command(name = "invert", description = "Invert the colors of the image")
class InvertCommand implements Callable<Integer> {

  @Parameters(index = "0", description = "The image filename")
  private String filename;

  @Override
  public Integer call() throws Exception {
    try {
      var image = new Converter(filename);
      image.applyFilter(Pixels::invert);
      image.saveImage();
    } catch (IOException e) {
      System.err.println("Failed to process the image: " + e.getMessage());
      return 1;
    }
    return 0;
  }
}

@Command(name = "grayscale", description = "Convert the image to grayscale")
class GrayscaleCommand implements Callable<Integer> {

  @Parameters(index = "0", description = "The image filename")
  private String filename;

  @Override
  public Integer call() throws Exception {
    try {
      var image = new Converter(filename);
      image.applyFilter(Pixels::grayscale);
      image.saveImage();
    } catch (IOException e) {
      System.err.println("Failed to process the image: " + e.getMessage());
      return 1;
    }
    return 0;
  }
}

@Command(name = "black-and-white", description = "Convert the image to black and white")
class BlackAndWhiteCommand implements Callable<Integer> {

  @Parameters(index = "0", description = "The image filename")
  private String filename;

  @Override
  public Integer call() throws Exception {
    try {
      var image = new Converter(filename);
      image.applyFilter(Pixels::blackAndWhite);
      image.saveImage();
    } catch (IOException e) {
      System.err.println("Failed to process the image: " + e.getMessage());
      return 1;
    }
    return 0;
  }
}

@Command(name = "color-channel", description = "Isolate a specific color channel (red, green, or blue)")
class ColorChannelCommand implements Callable<Integer> {

  @Parameters(index = "0", description = "The image filename")
  private String filename;

  @Parameters(index = "1", description = "The color channel to isolate ('r', 'g', or 'b')")
  private char color;

  @Override
  public Integer call() throws Exception {
    try {
      var image = new Converter(filename);
      image.applyFilter(rgb -> Pixels.colorChannel(rgb, color));
      image.saveImage();
      System.out.println("Color channel isolated: " + color);
    } catch (IOException e) {
      System.err.println("Failed to process the image: " + e.getMessage());
      return 1;
    } catch (IllegalArgumentException e) {
      System.err.println("Invalid color channel: " + color);
      return 1;
    }
    return 0;
  }
}

@Command(name = "sepia", description = "Apply sepia tone to the image")
class SepiaCommand implements Callable<Integer> {

  @Parameters(index = "0", description = "The image filename")
  private String filename;

  @Override
  public Integer call() throws Exception {
    try {
      var image = new Converter(filename);
      image.applyFilter(Pixels::sepia);
      image.saveImage();
    } catch (IOException e) {
      System.err.println("Failed to process the image: " + e.getMessage());
      return 1;
    }
    return 0;
  }
}

@Command(name = "adjust-brightness", description = "Adjust the brightness of the image")
class AdjustBrightnessCommand implements Callable<Integer> {

  @Parameters(index = "0", description = "The image filename")
  private String filename;

  @Parameters(index = "1", description = "The brightness value (positive or negative)")
  private int brightness;

  @Override
  public Integer call() throws Exception {
    try {
      var image = new Converter(filename);
      image.applyFilter(rgb -> Pixels.adjustBrightness(rgb, brightness));
      image.saveImage();
    } catch (IOException e) {
      System.err.println("Failed to process the image: " + e.getMessage());
      return 1;
    }
    return 0;
  }
}