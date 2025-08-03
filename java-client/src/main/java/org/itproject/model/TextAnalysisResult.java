package org.itproject.model;


import com.google.gson.annotations.SerializedName;

public class TextAnalysisResult {

    // Made by Renix

    @SerializedName("num_words")
    private int wordCount;

    @SerializedName("num_chars")
    private int charCount;

    @SerializedName("unique_words")
    private int uniqueWords;

    @SerializedName("average_word_length")
    private double averageWordLength;



    @Override
    public String toString() {
        return String.format(
                        "Слов: %d%n" +
                        "Символов: %d%n" +
                        "Уникальных слов: %d%n" +
                        "Средняя длина слова: %.2f",
                wordCount, charCount, uniqueWords, averageWordLength
        );
    }
}
