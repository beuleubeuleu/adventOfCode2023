package com.adventofcode.Day4;

import java.util.List;

public class Card {

  private int id;
  private List<Integer> winningNumbers;
  private List<Integer> numbersYouHave;

  public Card(
    int id,
    List<Integer> winningNumbers,
    List<Integer> numbersYouHave
  ) {
    this.id = id;
    this.winningNumbers = winningNumbers;
    this.numbersYouHave = numbersYouHave;
  }
}
