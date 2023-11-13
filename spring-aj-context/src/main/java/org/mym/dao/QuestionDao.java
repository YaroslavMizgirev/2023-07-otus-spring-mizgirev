package org.mym.dao;

import org.mym.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getAll();
}
