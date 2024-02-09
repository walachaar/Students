package com.money.students.Service;

import com.money.students.Model.StudentModel;
import com.money.students.Repository.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentsRepository studentRepository;

    public StudentServiceImpl(StudentsRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentModel add(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }

    @Override
    public StudentModel update(Long id, StudentModel studentModel) {
        Optional<StudentModel> student = studentRepository.findById(id);
        if (student.isPresent()) {
            StudentModel Data = student.get();
            Data.setId(id);
            return studentRepository.save(studentModel);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<StudentModel> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
        }

    }

    @Override
    public StudentModel getById(Long id) {
        Optional<StudentModel> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    @Override
    public StudentModel getByName(String name) {
        Optional<StudentModel> student = studentRepository.findByName(name);
        return student.orElse(null);
    }

    @Override
    public Iterable<StudentModel> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Float getMoyen(Long id) {
        return studentRepository.getMoyen(id);
    }
}
