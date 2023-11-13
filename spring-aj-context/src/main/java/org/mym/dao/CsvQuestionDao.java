package org.mym.dao;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.mym.domain.Answer;
import org.mym.domain.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@PropertySource("classpath:application.properties")
@Repository
@Log4j2
public class CsvQuestionDao implements QuestionDao {
    private final String fileName;
    private final String delimiter;

    public CsvQuestionDao(@Value("${application.testFile}")String fileName,
                          @Value("${application.delimiter}")String delimiter) {
        this.fileName = fileName;
        this.delimiter = delimiter;
    }
    @Override
    public List<Question> getAll() {
        List<Question> questionList = new ArrayList<>();
        completeQuestionList(questionList);
        return questionList;
    }

    public void completeQuestionList(List<Question> questionList) {
        try (var resource = new ClassPathResource(fileName, this.getClass().getClassLoader()).getInputStream()) {
            var reader = new BufferedReader(new InputStreamReader(resource));
            var scanner = new Scanner(reader);
            readTitle(scanner.nextLine());
            readBody(questionList, scanner);
        } catch (IOException e) {
            log.log(Level.ERROR, e.getStackTrace());
        }
    }

    public void readTitle(String title) {
    }

    public void readBody(List<Question> questionList, Scanner scanner) {
        while (scanner.hasNext()) {
            Question question = parseQuestion(scanner.nextLine());
            questionList.add(question);
        }
    }

    public Question parseQuestion(String body) {
        final String[] nextLine = body.split(delimiter);
        List<Answer> answerList = parseAnswers(nextLine);
        var question = new Question(Integer.parseInt(nextLine[0]), nextLine[1], answerList);
        return question;
    }

    public List<Answer> parseAnswers(String[] parsedString) {
        List<Answer> answerList = new ArrayList<>();
        for (int i = 2; i < parsedString.length; i += 2) {
            Answer answer = new Answer(parsedString[i], Boolean.parseBoolean(parsedString[i + 1]));
            answerList.add(answer);
        }
        return answerList;
    }
}
