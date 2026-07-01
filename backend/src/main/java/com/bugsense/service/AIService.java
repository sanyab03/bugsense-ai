package com.bugsense.service;

import com.bugsense.model.Bug;

public class AIService {

    public Bug analyzeBug(Bug bug) {

        bug.setAiSummary(
                "AI Summary placeholder"
        );

        bug.setAiRootCause(
                "AI Root Cause placeholder"
        );

        bug.setAiReproductionSteps(
                "AI Reproduction placeholder"
        );

        bug.setAiSuggestedFix(
                "AI Suggested Fix placeholder"
        );

        bug.setAiSeverityExplanation(
                "Severity placeholder"
        );

        bug.setAiConfidence(95.0);

        return bug;
    }

}