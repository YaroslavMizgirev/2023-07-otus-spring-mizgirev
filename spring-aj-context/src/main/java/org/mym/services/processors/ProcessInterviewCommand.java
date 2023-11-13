package org.mym.services.processors;

import org.mym.domain.Answer;
import org.mym.domain.InterviewResult;
import org.mym.domain.Question;
import org.mym.domain.User;
import org.mym.services.IOService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcessInterviewCommand implements SingleCommandProcessor<List<InterviewResult>> {
    private final IOService ioService;
    private final User user;
    private final List<Question> questionList;

    public ProcessInterviewCommand(IOService ioService, User user, List<Question> questionList) {
        this.ioService = ioService;
        this.user = user;
        this.questionList = questionList;
    }

    @Override
    public List<InterviewResult> processCommand() {
        List<InterviewResult> interviewResult = new ArrayList<>();
        for (Question q : questionList) {
            AtomicInteger x = new AtomicInteger(1);
            List<String> answersList = q.answers().stream()
                    .map(a -> x.getAndIncrement() + ": " + a.answer())
                    .toList();
            String questionString = q.question() + " " + answersList.toString() + " (type 1,2...): ";
            var answerOption = ioService.readIntsWithPrompt(questionString);
            List<Answer> customAnswer = new ArrayList<>();
            for (Integer i : answerOption) {
                Answer answer = new Answer(q.answers().get(i).answer(), true);
                customAnswer.add(answer);
            }
            interviewResult.add(new InterviewResult(user, q, customAnswer));
        }
        return interviewResult;
    }
}
