package com.adventofcode.Day2;

import java.util.HashMap;
import java.util.Map;

public class DocumentParser {
    public static Game getGameFromLine(String documentLine) {
        int id;
        Map[] handfulls;

        int colonIndex = documentLine.indexOf(':');
        id = Integer.parseInt(documentLine.substring(5, colonIndex).trim());

        String valuesPart = documentLine.substring(colonIndex + 1);
        String[] gameParts = valuesPart.split(";");

        Map[] valuesArray = new Map[gameParts.length];

        for (int i = 0; i < gameParts.length; i++) {
            String[] quantityColorPairs = gameParts[i].trim().split(", ");
            Map<String, Integer> partMap = new HashMap<>();

            for (String pair : quantityColorPairs) {
                String[] quantityColor = pair.split("\\s+");
                if (quantityColor.length == 2) {
                    int quantity = Integer.parseInt(quantityColor[0]);
                    String color = quantityColor[1];
                    partMap.put(color, quantity);
                }
            }

            valuesArray[i] = partMap;
        }

        return new Game(id, valuesArray);
    }
}
