package com.bugsense.ai;

public class AIResponse {

    private String summary;
    private String rootCause;
    private String reproductionSteps;
    private String suggestedFix;
    private double confidence;
    private String severityExplanation;

    public String getSeverityExplanation() {
        return severityExplanation;
    }

    public void setSeverityExplanation(String severityExplanation) {
        this.severityExplanation = severityExplanation;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRootCause() {
        return rootCause;
    }

    public void setRootCause(String rootCause) {
        this.rootCause = rootCause;
    }

    public String getReproductionSteps() {
        return reproductionSteps;
    }

    public void setReproductionSteps(String reproductionSteps) {
        this.reproductionSteps = reproductionSteps;
    }

    public String getSuggestedFix() {
        return suggestedFix;
    }

    public void setSuggestedFix(String suggestedFix) {
        this.suggestedFix = suggestedFix;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

}