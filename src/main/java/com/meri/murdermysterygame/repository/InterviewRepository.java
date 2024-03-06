package com.meri.murdermysterygame.repository;

import com.meri.murdermysterygame.entity.Interview;
import com.meri.murdermysterygame.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    List<Interview> findAllByOrderById();
}
