package org.mym.services;

import org.mym.dao.QuestionDao;
import org.mym.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CsvQuestionParsingService implements QuestionParsingService {
    private final QuestionDao questionDao;
    @Autowired
    public CsvQuestionParsingService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }
    @Override
    public List<Question> parseAll() {
        return questionDao.getAll();
    }
}
