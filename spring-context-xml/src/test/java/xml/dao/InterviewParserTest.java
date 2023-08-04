package xml.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.domain.Question;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class InterviewParserTest {
    private static DAO<Question> uploader;
    @BeforeAll
    static void setUp() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        uploader = context.getBean(InterviewParser.class);
    }

    @Test
    @DisplayName("InterviewParser.class was load correctly from context.xml")
    void uploaderWasMakeCorrectlyFromSpringContextXML() {
        assertNotNull(uploader, "InterviewParser.class from context.xml was load incorrectly");
    }
}