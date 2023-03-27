package com.company.FirstProject.controller;

import com.company.FirstProject.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "student")

public class StudentController {

    private List<Student> studentList;
    private Integer studentIx;

    public StudentController() {
        this.studentList = new ArrayList<>();
        this.studentIx = 0;
    }

    //localhost:8080/student/create
    @PostMapping(value = "/create")

    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        student.setStudentId(++this.studentIx);
        student.setCreatedAt(LocalDateTime.now());
        this.studentList.add(student);
        return ResponseEntity.ok().body("Student successful created!");

    }

    //localhost:8080/student/get?id=1
    @GetMapping(value = "/get")
    public ResponseEntity<?> getStudent(@RequestParam(value = ("id")) Integer keyValue) {
        for (Student student : this.studentList) {
            if (student.getStudentId().equals(keyValue)) {
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.badRequest().body("Student is not found!");

    }

    //localhost:8080/student/update?id=1&id2=4
    @PutMapping(value = "/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student student, @RequestParam(value = ("id")) Integer keyValue) {
        for (Student s : this.studentList) {
            if (s.getStudentId().equals(keyValue)) {
                s.setFirstname(student.getFirstname());
                s.setLastname(student.getLastname());
                s.setEmail(student.getEmail());
                s.setPassword(student.getPassword());
                s.setAge(student.getAge());
                s.setUpdatedAt(LocalDateTime.now());
                this.studentList.add(s);
                return ResponseEntity.ok().body("Student successful updated!");
            }

        }
        return ResponseEntity.badRequest().body("Student is not found!");

    }

    //localhost:8080/student/delete?id=1
    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteStudent(@RequestBody Integer id) {
        for (Student student : this.studentList) {
            if (student.getStudentId().equals(id)) {
                this.studentList.remove(student);
                return ResponseEntity.ok().body("Student successful updated!");
            }
        }
        return ResponseEntity.badRequest().body("Student is not found!");
    }

    @GetMapping(value = "/get-all")
    public List<Student> getAll() {
        return this.studentList;
    }

}
