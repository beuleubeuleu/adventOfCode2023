package com.adventofcode.Day3;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class GondolaLiftTest {
    @Test
    public void get_exemple_engine_schematics() {
        String[] exampleDocs = {"467..114..",
        "...*......",
        "..35..633.",
        "......#...",
        "617*......",
        ".....+.58.",
        "..592.....",
        "......755.",
        "...$.*....",
        ".664.598.."};
        GondolaLift exGondolaLift = new GondolaLift(exampleDocs);

        assertArrayEquals(exampleDocs, exGondolaLift.EngineSchematics);
    }
}
