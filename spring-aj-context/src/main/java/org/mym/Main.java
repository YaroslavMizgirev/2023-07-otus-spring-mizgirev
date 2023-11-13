package org.mym;

import org.mym.config.ApplicationSettings;
import org.mym.services.IOServiceStreams;
import org.mym.services.QuestionParsingService;
import org.mym.services.processors.AddNewUserCommand;
import org.mym.services.processors.ProcessInterviewCommand;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {
    public static void main(String[] args) {
        var ioService = new IOServiceStreams(System.out, System.in);
        var appSettings = new ApplicationSettings(Main.class);

        var newUser = new AddNewUserCommand(ioService).processCommand();
        var questionList = appSettings.getContext().getBean(QuestionParsingService.class).parseAll();
        var interview = new ProcessInterviewCommand(ioService, newUser, questionList).processCommand();

//        ioService.outputString(newUser.toString());
        ioService.outputString(interview.toString());
    }
}
