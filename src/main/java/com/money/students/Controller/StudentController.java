package com.money.students.Controller;

import com.money.students.Model.StudentModel;
import com.money.students.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/Students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public Iterable<StudentModel> getStudents() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public StudentModel getStudent(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @GetMapping("/")
    public StudentModel getStudent(@RequestParam String name) {
        return studentService.getByName(name);
    }

    @PostMapping("/")
    public ResponseEntity<StudentModel> addStudent(@RequestBody StudentModel studentModel) {
        return new ResponseEntity<>(studentService.add(studentModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public StudentModel updateStudent(@RequestBody StudentModel studentModel, @PathVariable Long id) {
        return studentService.update(id, studentModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/moyen/{id}")
    public Float getMoyen(@PathVariable Long id) {
        return studentService.getMoyen(id);
    }


}
