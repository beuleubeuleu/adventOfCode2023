package com.adventofcode.Day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class GondolaLift {

  public String[] EngineSchematics;

  public GondolaLift(String[] exampleDocs) {
    this.EngineSchematics = exampleDocs;
  }

  public int[] getParts() {
    List<Integer> numbersList = new ArrayList<>();
    String[] inputArray = this.EngineSchematics;

    for (int lineIndex = 0; lineIndex < inputArray.length; lineIndex++) {
      String currentLine = inputArray[lineIndex];
      Set<Integer> processedIndices = new HashSet<>();

      for (int charIndex = 0; charIndex < currentLine.length(); charIndex++) {
        if (processedIndices.contains(charIndex)) {
          continue;
        }

        char currentChar = currentLine.charAt(charIndex);

        if (Character.isDigit(currentChar)) {
          int wholeNumber = extractNumber(inputArray, lineIndex, charIndex);
          if (
            hasSymbolAdjacentChar(inputArray, lineIndex, charIndex, wholeNumber)
          ) {
            numbersList.add(wholeNumber);
          }

          // Mark the indices of the processed characters for the current number
          for (
            int i = charIndex;
            i < charIndex + String.valueOf(wholeNumber).length();
            i++
          ) {
            processedIndices.add(i);
          }
        }
      }
    }

    System.out.println(IntStream.of(convertListToArray(numbersList)).sum());

    return convertListToArray(numbersList);
  }

  public int getSumOfGearRatio() {
    int total = 0;
    for (int lineIndex = 0; lineIndex < EngineSchematics.length; lineIndex++) {
      String currentLine = EngineSchematics[lineIndex];
      for (
        int charIndex = 0;
        charIndex < EngineSchematics.length;
        charIndex++
      ) {
        char currentChar = currentLine.charAt(charIndex);
        // if(isGear(currentChar)) {
        //     total+=getGearRatio(currentChar);
        // }
      }
    }
    return total;
  }

  private static boolean hasSymbolAdjacentChar(
    String[] inputArray,
    int lineIndex,
    int charIndex,
    int wholeNumber
  ) {
    String adjacent = "";

    String currentLine = inputArray[lineIndex];
    String charAfterWholeNumber = (
        charIndex + String.valueOf(wholeNumber).length() < currentLine.length()
      )
      ? String.valueOf(
        currentLine.charAt(charIndex + String.valueOf(wholeNumber).length())
      )
      : "";

    String charBeforeWholeNumber = (charIndex - 1 >= 0)
      ? String.valueOf(currentLine.charAt(charIndex - 1))
      : "";

    String charAboveWholeNumber = (lineIndex - 1 >= 0)
      ? inputArray[lineIndex - 1].substring(
          Math.max(charIndex - 1, 0),
          Math.min(
            charIndex + String.valueOf(wholeNumber).length() + 1,
            inputArray[lineIndex - 1].length()
          )
        )
      : "";

    String charBelowWholeNumber = (lineIndex + 1 < inputArray.length)
      ? inputArray[lineIndex + 1].substring(
          Math.max(charIndex - 1, 0),
          Math.min(
            charIndex + String.valueOf(wholeNumber).length() + 1,
            inputArray[lineIndex + 1].length()
          )
        )
      : "";

    adjacent += charAboveWholeNumber;
    adjacent += charBeforeWholeNumber;
    adjacent += charAfterWholeNumber;
    adjacent += charBelowWholeNumber;

    return containsSymbols(adjacent);
  }

  private static int extractNumber(String[] inputArray, int row, int col) {
    int currentNumber = 0;

    // Accumulate digits to form the number
    while (
      col < inputArray[row].length() &&
      Character.isDigit(inputArray[row].charAt(col))
    ) {
      currentNumber =
        currentNumber *
        10 +
        Character.getNumericValue(inputArray[row].charAt(col));
      col++;
    }

    return currentNumber;
  }

  private static int[] convertListToArray(List<Integer> numbersList) {
    return numbersList.stream().mapToInt(Integer::intValue).toArray();
  }

  private static boolean containsSymbols(String input) {
    // Define the set of allowed characters
    String allowedCharacters =
      "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.";

    // Check if the input contains any character not in the allowed set
    for (char c : input.toCharArray()) {
      if (allowedCharacters.indexOf(c) == -1) {
        return true; // The string contains symbols
      }
    }

    return false; // The string doesn't contain symbols
  }

  public boolean isGear(int lineIndex, int charIndex) {
    String currentLine = this.EngineSchematics[lineIndex];
    if (currentLine.charAt(charIndex) != '*') {
      return false;
    }

    String charAfterAsterisk = (charIndex + 1 < currentLine.length())
    ? String.valueOf(currentLine.charAt(charIndex + 1))
    : "";

String charBeforeAsterisk = (charIndex - 1 >= 0)
    ? String.valueOf(currentLine.charAt(charIndex - 1))
    : "";

String charAboveLeftAsterisk = (lineIndex - 1 >= 0) && (charIndex - 1 >= 0)
    ? String.valueOf(this.EngineSchematics[lineIndex - 1].charAt(charIndex - 1))
    : "";

String charAboveAsterisk = (lineIndex - 1 >= 0)
    ? String.valueOf(this.EngineSchematics[lineIndex - 1].charAt(charIndex))
    : "";

String charAboveRightAsterisk = (lineIndex - 1 >= 0) && (charIndex + 1 < this.EngineSchematics[lineIndex - 1].length())
    ? String.valueOf(this.EngineSchematics[lineIndex - 1].charAt(charIndex + 1))
    : "";

String charBelowLeftAsterisk = (lineIndex + 1 < this.EngineSchematics.length) && (charIndex - 1 >= 0)
    ? String.valueOf(this.EngineSchematics[lineIndex + 1].charAt(charIndex - 1))
    : "";

String charBelowAsterisk = (lineIndex + 1 < this.EngineSchematics.length)
    ? String.valueOf(this.EngineSchematics[lineIndex + 1].charAt(charIndex))
    : "";

String charBelowRightAsterisk = (lineIndex + 1 < this.EngineSchematics.length) && (charIndex + 1 < this.EngineSchematics[lineIndex + 1].length())
    ? String.valueOf(this.EngineSchematics[lineIndex + 1].charAt(charIndex + 1))
    : "";



    return true;
  }
}