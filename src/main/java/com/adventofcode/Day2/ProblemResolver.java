package com.adventofcode.Day2;

import java.util.Map;

public class ProblemResolver {

  public static Map<String, Integer> assumption = Map.of(
    "red",
    12,
    "blue",
    14,
    "green",
    13
  );

  public static boolean isPossible(Game testGame) {
    for (int i = 0; i < testGame.handfullsOfCubes.length; i++) {
      Map<String, Integer> handfull = testGame.handfullsOfCubes[i];
      int handfullRed = (handfull.get("red") == null ? 0 : handfull.get("red"));
      int handfullBlue =
        (handfull.get("blue") == null ? 0 : handfull.get("blue"));
      int handfullGreen =
        (handfull.get("green") == null ? 0 : handfull.get("green"));

      if (handfullRed > assumption.get("red")) return false;
      if (handfullBlue > assumption.get("blue")) return false;
      if (handfullGreen > assumption.get("green")) return false;
    }
    return true;
  }

  public static int resolvePart1(String[] documentLines) {
    int total=0;
    for (String line : documentLines) {
      Game game = DocumentParser.getGameFromLine(line);
      if(isPossible(game)){
        total += game.id;
      }
    }
    return total;
  }
}
