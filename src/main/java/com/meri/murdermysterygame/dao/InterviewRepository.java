package com.meri.murdermysterygame.dao;

import com.meri.murdermysterygame.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {

    //List<Interview> findAllByOrderByPerson_id();
}
