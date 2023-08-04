package xml.dao;

import java.io.IOException;
import java.util.Collection;

public interface DAO<T> {
    Collection<T> getAllQuestions(String filename, String delimiter) throws IOException;
}