package com.adventofcode.Day2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class GameTest {

    @Test
    public void can_create_a_game(){ 
        int id = 1;
        Game testGame = new Game(id);
        assertEquals("Id should match", id, testGame.id);
    }
    
}
