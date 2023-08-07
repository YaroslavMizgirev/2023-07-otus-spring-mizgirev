package xml.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.dao.DAO;
import xml.dao.QuestionDao;
import xml.domain.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InterviewProcessTest {
    private static InterviewProcess process;
    private static DAO<Question> dao;
    @BeforeAll
    static void setUp() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        process = context.getBean(InterviewProcess.class);
    }

    @Test
    @DisplayName("InterviewProcess.class from context.xml was load correctly")
    void getInterviewProcess() {
        assertNotNull(process, "InterviewProcess.class from context.xml was load incorrectly");
    }

    @Test
    @DisplayName("Successfully test parsing the questions from context.xml")
    void parseQuestions() {
        Collection<Question> interview = process.parseQuestions();
        assertFalse(interview.isEmpty());
    }
}