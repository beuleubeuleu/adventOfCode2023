package com.adventofcode.Day4;

import java.util.ArrayList;
import java.util.List;

public class pileOfCardsParser {

  public static Cards getCards(String[] exampleDocs) {
    List<Card> cardsList = new ArrayList<>();

    for (String line : exampleDocs) {
      String[] parts = line.split(":");
      int id = Integer.parseInt(parts[0].trim().split("\\s+")[1]);
      List<Integer> winningNumbers = parseNumbers(
        parts[1].split("\\|")[0].trim()
      );
      List<Integer> numbersYouHave = parseNumbers(
        parts[1].split("\\|")[1].trim()
      );

      Card card = new Card(id, winningNumbers, numbersYouHave);
      cardsList.add(card);
    }

    return new Cards(cardsList);
  }

  private static List<Integer> parseNumbers(String numbersString) {
    String[] numberTokens = numbersString.split("\\s+");
    List<Integer> numbers = new ArrayList<>();

    for (String token : numberTokens) {
      numbers.add(Integer.parseInt(token.trim()));
    }

    return numbers;
  }
}
