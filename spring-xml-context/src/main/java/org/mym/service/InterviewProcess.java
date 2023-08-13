package org.mym.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.mym.dao.DAO;
import org.mym.domain.Question;

import java.util.Collection;

@RequiredArgsConstructor
@Getter
public class InterviewProcess {
    private final DAO<Question> questionDao;

    /**
     * <p>Parse data through interface 'DAO' from file: 'test.csv'</p>
     * <p></p>
     * @author MYM
     */
    public Collection<Question> parseQuestions() {
        return getQuestionDao().getAllQuestions();
    }
}