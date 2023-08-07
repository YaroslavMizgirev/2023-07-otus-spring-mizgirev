package xml.domain;

public record Answer(String answer, boolean right) {
    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", right=" + right +
                '}';
    }
}
