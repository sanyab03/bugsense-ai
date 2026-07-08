package com.bugsense.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugsense.model.Bug;
import com.bugsense.service.AIService;
import com.bugsense.service.BugService;

@RestController
@RequestMapping("/api/bugs")
public class BugController {

    private final BugService bugService;
    private final AIService aiService;

    public BugController(BugService bugService, AIService aiService) {
        this.bugService = bugService;
        this.aiService = aiService;
    }

    @PostMapping("/analyze")
    public Bug analyzeBug(@RequestBody Bug bug) {

        bugService.createBug(bug);

        return aiService.analyzeBug(bug);
    }
}