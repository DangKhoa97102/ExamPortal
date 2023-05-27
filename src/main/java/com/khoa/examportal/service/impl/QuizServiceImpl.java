package com.khoa.examportal.service.impl;

import com.khoa.examportal.Repository.QuizRepository;
import com.khoa.examportal.model.exam.Quiz;
import com.khoa.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long id) {
        return this.quizRepository.findById(id).get();
    }

    @Override
    public void deleteQuiz(Long id) {
        Quiz quiz = new Quiz();
        quiz.setQId(id);
        this.quizRepository.delete(quiz);
    }
}
