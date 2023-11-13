package org.mym.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public record InterviewResult(User user, Question question, List<Answer> customAnswer) {
    @Override
    public String toString() {
        AtomicInteger x = new AtomicInteger(1);
        return "\nInterviewResult{" +
                "\n\tuser=" + user +
                ", \n\tquestion=" + question.question() + question.answers().stream().filter(Answer::right).toList() +
                ", \n\tcustomAnswer=" + customAnswer +
                '}';
    }
}
