package com.money.students.Service;


import com.money.students.Model.StudentModel;

public interface StudentService {
    StudentModel add(StudentModel studentModel);

    StudentModel update(Long id, StudentModel studentModel);

    void delete(Long id);

    StudentModel getById(Long id);

    StudentModel getByName(String name);

    Iterable<StudentModel> getAll();

    Float getMoyen(Long id);


}
