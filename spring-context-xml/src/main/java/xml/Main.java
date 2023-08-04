package xml;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.service.InterviewProcess;

import java.io.IOException;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        var context = new ClassPathXmlApplicationContext("/context.xml");
        var interviewProcess = context.getBean(InterviewProcess.class);
        var interviewList = interviewProcess.parseQuestions(interviewProcess.getFileName(), interviewProcess.getDelimiter());

        LOGGER.log(Level.INFO, String.format("Result: %s", interviewList.toString()));
    }
}