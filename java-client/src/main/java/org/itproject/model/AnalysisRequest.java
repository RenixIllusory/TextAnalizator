package org.itproject.model;

import com.google.gson.annotations.SerializedName;

public class AnalysisRequest {

    // Made by Renix

    @SerializedName("text")
    private final String text;

    public AnalysisRequest(String text) {
        this.text = text;
    }



}
