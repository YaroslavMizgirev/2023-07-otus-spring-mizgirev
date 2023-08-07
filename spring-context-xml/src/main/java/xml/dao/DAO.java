package xml.dao;

import java.util.Collection;

public interface DAO<T> {
    Collection<T> getAllQuestions();
}