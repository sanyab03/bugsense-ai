package com.bugsense.model;

import java.sql.Timestamp;

import com.bugsense.model.enums.Priority;
import com.bugsense.model.enums.Status;

public class Bug {

    private int id;
    private String title;
    private String description;

    private Priority priority;
    private Status status;

    private int reporterId;

    private String aiSummary;
    private String aiRootCause;
    private String aiReproductionSteps;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    private String aiSuggestedFix;
    private String aiSeverityExplanation;
    private Double aiConfidence;

    public Bug() {
    }

    public Bug(int id, String title, String description,
               Priority priority,
               Status status,
               int reporterId,
               String aiSummary,
               String aiRootCause,
               String aiReproductionSteps,
               Timestamp createdAt,
               Timestamp updatedAt) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.reporterId = reporterId;
        this.aiSummary = aiSummary;
        this.aiRootCause = aiRootCause;
        this.aiReproductionSteps = aiReproductionSteps;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getReporterId() {
        return reporterId;
    }

    public void setReporterId(int reporterId) {
        this.reporterId = reporterId;
    }

    public String getAiSummary() {
        return aiSummary;
    }

    public void setAiSummary(String aiSummary) {
        this.aiSummary = aiSummary;
    }

    public String getAiRootCause() {
        return aiRootCause;
    }

    public void setAiRootCause(String aiRootCause) {
        this.aiRootCause = aiRootCause;
    }

    public String getAiReproductionSteps() {
        return aiReproductionSteps;
    }

    public void setAiReproductionSteps(String aiReproductionSteps) {
        this.aiReproductionSteps = aiReproductionSteps;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAiSuggestedFix() {
    return aiSuggestedFix;
}

    public void setAiSuggestedFix(String aiSuggestedFix) {
        this.aiSuggestedFix = aiSuggestedFix;
    }

    public String getAiSeverityExplanation() {
        return aiSeverityExplanation;
    }

    public void setAiSeverityExplanation(String aiSeverityExplanation) {
        this.aiSeverityExplanation = aiSeverityExplanation;
    }

    public Double getAiConfidence() {
        return aiConfidence;
    }

    public void setAiConfidence(Double aiConfidence) {
        this.aiConfidence = aiConfidence;
    }

    @Override
    public String toString() {
        return "Bug{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}