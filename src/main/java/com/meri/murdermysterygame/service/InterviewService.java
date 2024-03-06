package com.meri.murdermysterygame.service;

import com.meri.murdermysterygame.dao.InterviewDao;
import com.meri.murdermysterygame.dto.InterviewDto;
import com.meri.murdermysterygame.dto.PersonDto;
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
        Optional<Interview> result = interviewDao.getById(id);
        if(result.isPresent()) {
            return DtoUtils.convertInterviewEntityToInterviewDto(result.get());
        }
        throw new ObjectNotFoundException("Interview cannot be found with Id: " + id, HttpStatusCode.valueOf(404));
    }

    public InterviewDto createInterview(InterviewDto interviewDto) throws ObjectNotFoundException {
        if(interviewDto.getPersonId() != null){
            PersonDto personDto = new PersonDto();
            personDto.setId(interviewDto.getPersonId());
            interviewDto.setPerson(personDto);
        }
        Interview interview = DtoUtils.convertInterviewDtoToInterviewEntity(interviewDto);
        interviewDao.create(interview);
        return getInterviewById(interview.getId());
    }

    public InterviewDto updateInterview(InterviewDto interviewDto, Long id) throws ObjectNotFoundException {
        Interview interview = DtoUtils.convertInterviewDtoToInterviewEntity(interviewDto);
        interview.setId(id);
        interviewDao.update(interview);
        return getInterviewById(id);
    }

    public void deleteInterview(InterviewDto interviewDto){
        Long id = interviewDto.getId();
        interviewDao.delete(id);
    }
}
