package com.bugsense.service;

import org.springframework.stereotype.Service;

import com.bugsense.model.Bug;
import com.openai.client.OpenAIClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;

@Service
public class AIService {

    private final OpenAIClient client;

    public AIService(OpenAIClient client) {
        this.client = client;
    }

    public Bug analyzeBug(Bug bug) {

        String prompt = """
You are an expert software engineer.

Analyze the following software bug and provide:

Summary:
Root Cause:
Reproduction Steps:
Suggested Fix:
Severity:
Confidence:

Bug Title:
%s

Bug Description:
%s
""".formatted(bug.getTitle(), bug.getDescription());

        ResponseCreateParams params = ResponseCreateParams.builder()
                .model(ChatModel.GPT_4_1_MINI)
                .input(prompt)
                .build();

        Response response = client.responses().create(params);

        System.out.println(response);

        bug.setAiConfidence(95.0);

        return bug;

        // Temporary (we'll split this into separate fields later)
        // bug.setAiSummary(aiResponse);
        // bug.setAiRootCause(aiResponse);
        // bug.setAiReproductionSteps(aiResponse);
        // bug.setAiSuggestedFix(aiResponse);
        // bug.setAiSeverityExplanation(aiResponse);
        
    }
}