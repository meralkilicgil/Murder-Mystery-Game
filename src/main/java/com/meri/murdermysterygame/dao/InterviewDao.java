package com.meri.murdermysterygame.dao;

import com.meri.murdermysterygame.entity.Interview;
import com.meri.murdermysterygame.repository.InterviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewDao {

    private final InterviewRepository interviewRepository;

    public InterviewDao(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    public List<Interview> getAll(){
        return interviewRepository.findAllByOrderById();
    }

    public Optional<Interview> getById(Long id){
        return interviewRepository.findById(id);
    }

    public void create(Interview interview){
        interviewRepository.save(interview);
    }

    public void update(Interview updatedInterview){
        interviewRepository.save(updatedInterview);
    }

    public void delete(Long id){
        interviewRepository.deleteById(id);
    }
}
