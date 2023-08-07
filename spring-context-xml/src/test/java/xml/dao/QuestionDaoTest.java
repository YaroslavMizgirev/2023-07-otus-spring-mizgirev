package xml.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.domain.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class QuestionDaoTest {
    private static DAO<Question> dao;
    @BeforeAll
    static void setUp() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        dao = context.getBean(QuestionDao.class);
    }

    @Test
    @DisplayName("QuestionDao.class from context.xml was load correctly")
    void uploaderWasMakeCorrectlyFromSpringContextXML() {
        assertNotNull(dao, "QuestionDao.class from context.xml was load incorrectly");
    }
    @Test
    @DisplayName("Successfully test for fileName from context.xml")
    void getFileName() {
//        assertEquals("/test.csv", dao.getFileName());
    }
    @Test
    @DisplayName("Successfully test for delimiter from context.xml")
    void getDelimiter() {
//        assertEquals(";", dao.getDelimiter());
    }
}