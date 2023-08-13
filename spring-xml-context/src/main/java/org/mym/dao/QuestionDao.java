package org.mym.dao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.mym.domain.Answer;
import org.mym.domain.Question;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
@Getter
@Log4j2
public class QuestionDao implements DAO<Question> {
    private final String fileName;
    private final String delimiter;

    @Override
    public Collection<Question> getAllQuestions() {
        List<Question> interviewList = new ArrayList<>();

        try (var resource = new ClassPathResource(getFileName(), this.getClass().getClassLoader()).getInputStream();
            var reader = new BufferedReader(new InputStreamReader(resource));
            Scanner scanner = new Scanner(reader)) {
            final String[] title = scanner.nextLine().split(getDelimiter());

            while (scanner.hasNext()) {
                final String[] split = scanner.nextLine().split(getDelimiter());

                int id = Integer.parseInt(split[0]);
                String questionValue = split[1];
                List<Answer> answers = new ArrayList<>();
                for (int i = 2; i < split.length; i = i + 2) {
                    Answer answer = new Answer(split[i], Boolean.parseBoolean(split[i + 1]));
                    answers.add(answer);
                }
                Question question = new Question(id, questionValue, answers);

                interviewList.add(question);
            }
        } catch (IOException e) {
            log.log(Level.ERROR, e.getStackTrace());
        }
        return interviewList;
    }
}