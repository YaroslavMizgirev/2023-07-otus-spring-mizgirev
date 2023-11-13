package org.mym.services;

import org.mym.domain.Question;

import java.util.List;

public interface QuestionParsingService {
    List<Question> parseAll();
}
