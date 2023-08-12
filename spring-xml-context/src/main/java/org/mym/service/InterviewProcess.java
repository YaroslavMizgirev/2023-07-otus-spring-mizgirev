package org.mym.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.mym.dao.DAO;
import org.mym.domain.Question;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class InterviewProcess {
    private DAO<Question> questionDao;

    public Collection<Question> parseQuestions() {
        return getQuestionDao().getAllQuestions();
    }
}