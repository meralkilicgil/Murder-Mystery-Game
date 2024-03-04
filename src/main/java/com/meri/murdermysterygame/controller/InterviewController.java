package com.meri.murdermysterygame.controller;

import com.meri.murdermysterygame.dto.InterviewDto;
import com.meri.murdermysterygame.service.InterviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping("/getAllInterviews")
    public List<InterviewDto> getAllInterviews(){
        return interviewService.getAllInterviewDtoList();
    }
}
