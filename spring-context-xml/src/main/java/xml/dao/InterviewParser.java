package xml.dao;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import xml.domain.Question;
import xml.service.InterviewProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class InterviewParser implements DAO<Question> {
    private final static Logger LOGGER = LogManager.getLogger(InterviewProcess.class);
    @Override
    public Collection<Question> getAllQuestions(String fileName, String delimiter) throws IOException {
        List<Question> interviewList = new ArrayList<>();

        InputStream resource = new ClassPathResource(fileName, this.getClass().getClassLoader()).getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
        Scanner scanner = new Scanner(reader);

        final String[] title = scanner.nextLine().split(delimiter);
        LOGGER.log(Level.INFO, String.format("Parse title line: %s", Arrays.toString(title)));

        while (scanner.hasNext()) {
            final String[] value = scanner.nextLine().split(delimiter);
            Question question = new Question(
                    Integer.parseInt(value[0]),
                    value[1],
                    Integer.parseInt(value[2]),
                    new ArrayList<>(Arrays.asList(value).subList(3, value.length - 1))
            );
            LOGGER.log(Level.INFO, String.format("Parse new element of array to %s", question));

            interviewList.add(question);
        }
        reader.close();
        return interviewList;
    }
}