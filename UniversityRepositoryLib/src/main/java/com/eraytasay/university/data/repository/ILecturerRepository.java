package com.eraytasay.university.data.repository;

import com.eraytasay.university.data.entity.orm.Lecturer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ILecturerRepository extends CrudRepository<Lecturer, Integer> {
    Optional<Lecturer> findLecturerByCitizenId(String citizenId);
}
