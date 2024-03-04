package com.meri.murdermysterygame.service;

import com.meri.murdermysterygame.dao.InterviewDao;
import com.meri.murdermysterygame.dto.InterviewDto;
import com.meri.murdermysterygame.entity.Interview;
import com.meri.murdermysterygame.exception.ObjectNotFoundException;
import com.meri.murdermysterygame.utils.DtoUtils;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewService {

    private final InterviewDao interviewDao;

    public InterviewService(InterviewDao interviewDao) {
        this.interviewDao = interviewDao;
    }

    public List<InterviewDto> getAllInterviewDtoList(){
        List<Interview> result = interviewDao.getAll();
        return result.stream().map(DtoUtils::convertInterviewEntityToInterviewDto).toList();
    }

    public InterviewDto getInterviewById(Long id) throws ObjectNotFoundException {
        Interview interview = interviewDao.getById(id);
        return DtoUtils.convertInterviewEntityToInterviewDto(interview);
    }

    public void createInterview(InterviewDto interviewDto){
        Interview interview = DtoUtils.convertInterviewDtoToInterviewEntity(interviewDto);
        interviewDao.create(interview);
    }

    public void updateInterview(InterviewDto interviewDto, Long id) {
        Interview interview = DtoUtils.convertInterviewDtoToInterviewEntity(interviewDto);
        interview.setId(id);
        interviewDao.update(interview);
    }

    public void deleteInterview(InterviewDto interviewDto){
        Long id = interviewDto.getId();
        interviewDao.delete(id);
    }
}
