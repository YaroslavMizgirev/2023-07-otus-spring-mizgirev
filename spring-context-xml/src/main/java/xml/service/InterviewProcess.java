package xml.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xml.dao.QuestionDao;
import xml.domain.Question;

import java.io.IOException;
import java.util.Collection;

@AllArgsConstructor
@Setter
@Getter
public class InterviewProcess {
    private final static Logger LOGGER = LogManager.getLogger(InterviewProcess.class);
    private QuestionDao questionDao;

    public Collection<Question> parseQuestions() {
        return questionDao.getAllQuestions();
    }
}