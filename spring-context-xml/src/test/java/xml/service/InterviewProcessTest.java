package xml.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.dao.DAO;
import xml.dao.InterviewParser;
import xml.domain.Question;

import java.io.IOException;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class InterviewProcessTest {
    private static InterviewProcess process;
    private static DAO<Question> dao;
    @BeforeAll
    static void setUp() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        dao = context.getBean(InterviewParser.class);
        process = context.getBean(InterviewProcess.class);
    }

    @Test
    @DisplayName("Successfully test for interviewParser from context.xml")
    void getInterviewParser() {
        assertNotNull(dao, "InterviewParser.class from context.xml was load incorrectly");
    }

    @Test
    @DisplayName("Successfully test for fileName from context.xml")
    void getFileName() {
        assertEquals("/test.csv", process.getFileName());
    }

    @Test
    @DisplayName("Successfully test for delimiter from context.xml")
    void getDelimiter() {
        assertEquals(";", process.getDelimiter());
    }

    @Test
    @DisplayName("Successfully test parsing the questions from context.xml")
    void parseQuestions() throws IOException {
        Collection<Question> interview = process.parseQuestions(process.getFileName(), process.getDelimiter());
        assertFalse(interview.isEmpty());
    }
}