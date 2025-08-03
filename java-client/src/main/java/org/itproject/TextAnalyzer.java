package org.itproject;

import org.itproject.model.TextAnalysisResult;
import org.itproject.model.TextAnalysisService;

import java.net.http.HttpClient;
import java.util.Scanner;

public class TextAnalyzer {

    // Made by Renix

    private final TextAnalysisService analysisService;
    private final Scanner scanner;
    private String url;

    public TextAnalyzer() {
        this.url = "http://localhost:8080/TextAnalyzer";
        this.analysisService = new TextAnalysisService(url);
        this.scanner = new Scanner(System.in);
    }


    public void init() {
        try {
            System.out.println("Введите текст для анализа или exit для выхода:");
            while (true) {
                System.out.print("> ");
                String text = scanner.nextLine().trim();

                if (text.equalsIgnoreCase("exit")) {
                    break;
                }

                if (text.isEmpty()) {
                    System.out.println("Текст не может быть пустым!");
                    continue;
                }

                try {
                    TextAnalysisResult result = analysisService.analyzeText(text);
                    System.out.println("----------------------------------");
                    System.out.println("\nРезультаты анализатора:");
                    System.out.println(result);
                    System.out.println("----------------------------------");
                } catch (Exception e) {
                }
            }
        } finally {
            scanner.close();
            System.out.println("Программа завершена");
        }

        scanner.close();
    }


}
