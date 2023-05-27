package com.khoa.examportal.service;

import com.khoa.examportal.model.exam.Question;
import com.khoa.examportal.model.exam.Quiz;

import java.util.Set;

public interface QuestionService {

    Question addQuestion(Question question);

    Question updateQuestion(Question question);

    Set<Question> getQuestions();

    Question getQuestion(Long id);

    Set<Question> getQuestionOfQuiz(Quiz quiz);

    void deleteQuestion(Long id);

}
