package com.adventofcode.Day4;

import java.util.List;
import java.util.stream.Collectors;

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

  public int getTheCardValue() {
    List<Integer> winningNumbersYouHave = findCardWinningNumbersYouHave(winningNumbers, numbersYouHave);
    if (winningNumbersYouHave.size() == 0) {
      return 0;
    }
    System.out.println(winningNumbersYouHave);
    Integer totalPoints = 1;
    winningNumbersYouHave.remove(0);
    for(Integer point:winningNumbersYouHave){
      totalPoints = totalPoints*2;
    }
        System.out.println(totalPoints);

    return totalPoints;
  }
  private static List<Integer> findCardWinningNumbersYouHave(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
    }
}
