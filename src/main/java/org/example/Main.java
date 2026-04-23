package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String inputText = "Привіт! Як твої справи? Це лабораторна робота номер два. Що ти робиш сьогодні? Я вивчаю Java і це круто.";
            int targetLength = 5;

            if (inputText == null) {
                throw new Exception("Вхідний текст не може бути null.");
            }

            StringBuffer textBuffer = new StringBuffer(inputText);

            if (textBuffer.length() == 0) {
                System.out.println("Попередження: Вхідний текст порожній.");
                return;
            }


            List<String> result = getWordsFromQuestions(textBuffer, targetLength);


            System.out.println("--- Початкові дані ---");
            System.out.println("Текст: " + textBuffer);
            System.out.println("\n--- Результат ---");
            if (result.isEmpty()) {
                System.out.println("Слів не знайдено.");
            } else {
                result.forEach(word -> System.out.println("- " + word));
            }

        } catch (Exception e) {
            System.err.println("Виникла помилка: " + e.getMessage());
        }
    }


    public static List<String> getWordsFromQuestions(StringBuffer textBuffer, int targetLength) {
        String[] sentences = textBuffer.toString().split("(?<=[.!?])\\s*");
        List<String> foundWords = new ArrayList<>();

        for (String sentence : sentences) {
            StringBuffer currentSentence = new StringBuffer(sentence);


            if (currentSentence.length() > 0 && currentSentence.charAt(currentSentence.length() - 1) == '?') {
                String[] words = currentSentence.toString().split("[^а-яА-Яa-zA-ZіІїЇєЄґҐ]+");

                for (String word : words) {
                    if (word.length() == targetLength) {
                        String lowerCaseWord = word.toLowerCase();
                        if (!foundWords.contains(lowerCaseWord)) {
                            foundWords.add(lowerCaseWord);
                        }
                    }
                }
            }
        }
        return foundWords;
    }
}