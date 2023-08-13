package org.mym.config;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.mym.domain.Question;
import org.mym.service.InterviewProcess;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;
import java.util.function.Function;

@Log4j2
@Getter
public enum ProcessConfig {
    CONFIG;
    private Collection<Question> questions;

    public void run(String contextFileName, Function<String, ClassPathXmlApplicationContext> f) {
        var context = f.apply(contextFileName);
        var interviewProcess = context.getBean(InterviewProcess.class);

        CONFIG.questions = interviewProcess.parseQuestions();
        log.log(Level.INFO, String.format("Result: %s", CONFIG.questions.toString()));
    }
}
