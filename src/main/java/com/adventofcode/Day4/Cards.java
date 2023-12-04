package com.adventofcode.Day4;

import java.util.List;
import java.util.stream.IntStream;

public class Cards {

  private List<Card> cards;

  public Cards(List<Card> cards) {
    this.cards = cards;
  }

  public int getSumOfValues() {
    return cards.stream().mapToInt(Card::getTheCardValue).sum();
  }

  public int getTotalScratchcards() {
    int[] nombreDeCarte = new int[cards.size()];

    for (int cardIndex = 0; cardIndex < cards.size(); cardIndex++) {
      nombreDeCarte[cardIndex]++;
      for (
        int cartesRestantes = nombreDeCarte[cardIndex];
        cartesRestantes > 0;
        cartesRestantes--
      ) {
        int points = cards.get(cardIndex).getTheCardNumberOfWinningNumber();
        for (int addCopy=1; addCopy<=points; addCopy++) {
          nombreDeCarte[cardIndex+addCopy]++;
        }
      }
    }
    return IntStream.of(nombreDeCarte).sum();
  }
}
