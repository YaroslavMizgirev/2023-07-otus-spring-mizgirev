package org.mym.config;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.mym.service.InterviewProcess;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j2
public class AppConfig implements Runnable {
    @Override
    public void run() {
        var context = new ClassPathXmlApplicationContext("/context.xml");
        var interviewProcess = context.getBean(InterviewProcess.class);
        var interviewList = interviewProcess.parseQuestions();

        log.log(Level.INFO, String.format("Result: %s", interviewList.toString()));
    }
}
