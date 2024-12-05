package com.eraytasay.university.data.repository;

import com.eraytasay.university.data.entity.orm.Lecturer;
import org.springframework.data.repository.CrudRepository;

public interface ILecturerRepository extends CrudRepository<Lecturer, Integer> {
}
