package com.khoa.examportal.service.impl;

import com.khoa.examportal.Repository.QuestionRepository;
import com.khoa.examportal.Repository.QuizRepository;
import com.khoa.examportal.model.exam.Question;
import com.khoa.examportal.model.exam.Quiz;
import com.khoa.examportal.service.QuestionService;
import com.khoa.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long id) {
        return this.questionRepository.findById(id).get();
    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long id) {
        Question question = new Question();
        question.setQuesId(id);
        this.questionRepository.delete(question);
    }
}
