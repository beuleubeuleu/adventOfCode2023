package com.adventofcode.Day4;

import java.util.List;

public class Cards {

  private List<Card> cards;

  public Cards(List<Card> cards) {
    this.cards = cards;
  }

public int getSumOfValues() {
  return cards.stream()
  .mapToInt(Card::getTheCardValue)
  .sum();}
}
