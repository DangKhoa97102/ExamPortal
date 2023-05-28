package com.khoa.examportal.controller;

import com.khoa.examportal.model.exam.Quiz;
import com.khoa.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    //add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //get a quiz
    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable("quizId") Long id) {
        return ResponseEntity.ok(this.quizService.getQuiz(id));
    }

    //get Quizzes
    @GetMapping("/")
    public ResponseEntity<?> getQuizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //delete quiz
    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long id) {
        this.quizService.deleteQuiz(id);
    }
}
