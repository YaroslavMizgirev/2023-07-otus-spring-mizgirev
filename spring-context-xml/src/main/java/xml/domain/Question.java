package xml.domain;

import java.util.List;

public record Question(int id, String question, int rightAnswer, List<String> answers) {
}
