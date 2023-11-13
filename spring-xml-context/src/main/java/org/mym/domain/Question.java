package org.mym.domain;

import java.util.List;

public record Question(int id, String question, List<Answer> answers) {
    @Override
    public String toString() {
        return "\nQuestion{" +
                "\n\tid=" + id +
                ", \n\tquestion='" + question + '\'' +
                ", \n\tanswers=" + answers +
                '}';
    }
}
