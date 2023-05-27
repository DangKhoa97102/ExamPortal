package com.khoa.examportal.service;

import com.khoa.examportal.model.exam.Quiz;

import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Quiz getQuiz(Long id);

    public void deleteQuiz(Long id);
}
