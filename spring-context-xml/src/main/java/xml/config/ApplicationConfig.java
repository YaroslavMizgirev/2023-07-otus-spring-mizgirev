package xml.config;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.service.InterviewProcess;

public class ApplicationConfig implements Runnable {
    private final static Logger LOGGER = LogManager.getLogger(ApplicationConfig.class);
    @Override
    public void run() {
        var context = new ClassPathXmlApplicationContext("/context.xml");
        var interviewProcess = context.getBean(InterviewProcess.class);
        var interviewList = interviewProcess.parseQuestions();

        LOGGER.log(Level.INFO, String.format("Result: %s", interviewList.toString()));
    }
}
