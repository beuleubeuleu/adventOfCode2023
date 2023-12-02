package com.adventofcode.Day2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import org.junit.Test;

public class GameTest {

  @Test
  public void can_create_a_game() {
    int id = 1;
    Map[] handfullsOfCubes = {
      Map.of("red", 4, "blue", 3),
      Map.of("red", 1, "blue", 6, "green", 2),
      Map.of("green", 2),
    };
    Game testGame = new Game(id, handfullsOfCubes);
    assertEquals(id, testGame.id);
    assertArrayEquals(handfullsOfCubes, testGame.handfullsOfCubes);
  }

  @Test
  public void check_if_a_game_is_possible() {
    int id = 1;
    Map[] handfullsOfCubes = {
      Map.of("red", 4, "blue", 3),
      Map.of("red", 1, "blue", 6, "green", 2),
      Map.of("green", 2),
    };
    Game testGame = new Game(id, handfullsOfCubes);

    assertTrue(ProblemResolver.isPossible(testGame));
  }
}
