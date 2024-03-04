package com.meri.murdermysterygame.controller;

import com.meri.murdermysterygame.dto.InterviewDto;
import com.meri.murdermysterygame.dto.PersonDto;
import com.meri.murdermysterygame.exception.ObjectNotFoundException;
import com.meri.murdermysterygame.service.InterviewService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getInterview")
    public InterviewDto getInterview(@RequestParam("id") Long id){
        InterviewDto interviewDto = null;
        try {
            interviewDto = interviewService.getInterviewById(id);
        } catch (ObjectNotFoundException e) {
            System.out.println("interview cannot be found");
        }
        return interviewDto;
    }

    @PostMapping("/addInterview")
    public void addInterview(@RequestBody InterviewDto interviewDto){
        interviewService.createInterview(interviewDto);
    }

    @PutMapping("/updateInterview")
    public void updateInterview(@RequestBody InterviewDto interviewDto, @RequestParam("id") Long id){
        interviewService.updateInterview(interviewDto, id);
    }

    @DeleteMapping("/deleteInterview")
    public void deletePInterview(@RequestParam("id") Long id) {
        try {
            InterviewDto interviewDto = null;
            interviewDto = interviewService.getInterviewById(id);
            interviewService.deleteInterview(interviewDto);
        } catch (ObjectNotFoundException e) {
            System.out.println("interview cannot be found to delete");
        }
    }
}
