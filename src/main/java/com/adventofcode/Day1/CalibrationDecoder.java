package com.adventofcode.Day1;
public class CalibrationDecoder{

    public static int getDigitFromString (String string, int index){
        char firstLetter = '\0'; // Default value
        char secondLetter = '\0'; // Default value
        char thirdLetter = '\0'; // Default value
        char fourthLetter = '\0'; // Default value
        char fifthLetter = '\0'; // Default value

        if (string.length() > index) {
            firstLetter = string.charAt(index);
        }

        if (string.length() > index + 1) {
            secondLetter = string.charAt(index + 1);
        }

        if (string.length() > index + 2) {
            thirdLetter = string.charAt(index + 2);
        }

        if (string.length() > index + 3) {
            fourthLetter = string.charAt(index + 3);
        }

        if (string.length() > index + 4) {
            fifthLetter = string.charAt(index + 4);
        }

        if(firstLetter == 'o') {
            if(secondLetter == 'n') {
                if (thirdLetter == 'e'){
                    return 1;
                }
            }
        }
        else if (firstLetter == 't') {
            if (secondLetter == 'w') {
                if (thirdLetter == 'o'){
                    return 2;
                }
            }
            if (secondLetter == 'h') {
                if (thirdLetter == 'r'){
                    if (fourthLetter == 'e'){
                        if (fifthLetter == 'e'){
                            return 3;
                        }
                    }
                }
            }
        }
        else if (firstLetter == 'f') {
            if (secondLetter == 'o') {
                if (thirdLetter == 'u'){
                    if (fourthLetter == 'r'){
                        return 4;
                    }
                }
            }
            if (secondLetter == 'i') {
                if (thirdLetter == 'v'){
                    if (fourthLetter == 'e'){
                        return 5;
                    }
                }
            }
        }
        else if (firstLetter == 's') {
            if (secondLetter == 'i') {
                if (thirdLetter == 'x'){
                    return 6;
                }
            }
            if (secondLetter == 'e') {
                if (thirdLetter == 'v'){
                    if (fourthLetter == 'e'){
                        if (fifthLetter == 'n'){
                            return 7;
                        }
                    }
                }
            }
        }
        else if (firstLetter == 'e') {
            if (secondLetter == 'i') {
                if (thirdLetter == 'g'){
                    if (fourthLetter == 'h'){
                        if (fifthLetter == 't'){
                            return 8;
                        }
                    }
                }
            }
        }
        else if (firstLetter == 'n') {
            if (secondLetter == 'i') {
                if (thirdLetter == 'n'){
                    if (fourthLetter == 'e'){
                        return 9;
                    }
                }
            }
        }
        
        return -1;
    }

    public static Integer decode(String string) {
        String firstNumber = "";
        String lastNumber = "";
        for (int i = 0; i < string.length();) {
            int digit = CalibrationDecoder.getDigitFromString(string, i);
            if (!Character.isDigit(string.charAt(i))){
                if (digit != -1){
                    firstNumber = Integer.toString(digit);
                    break;
                } else {
                    i++;
                }
            } else {
                firstNumber = String.valueOf(string.charAt(i));
                break;
            }
        }

        for (int i = string.length()-1; i >= 0;) {
            int digit = CalibrationDecoder.getDigitFromString(string, i);
            if (!Character.isDigit(string.charAt(i))){
                if (digit != -1){
                    lastNumber = Integer.toString(digit);
                    break;
                } else {
                    i--;
                }
            } else {
                lastNumber = String.valueOf(string.charAt(i));
                break;
            }
        }

        int code = Integer.parseInt(firstNumber + lastNumber);

        return code;
    }

    public static Integer decodeManyAndSum(String[] listOfStrings) {
        int total = 0;
        for(int i = 0; i<listOfStrings.length; i++ ) {
            total += CalibrationDecoder.decode(listOfStrings[i]);
        }
        return total;
    }
}
