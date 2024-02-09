package com.money.students.Repository;

import com.money.students.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<StudentModel, Long> {

    Optional<StudentModel> findByName(String name);

    Float getMoyen(Long id);
}
