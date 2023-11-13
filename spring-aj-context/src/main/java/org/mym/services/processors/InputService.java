package org.mym.services.processors;

import java.util.List;

public interface InputService {
    String readStringWithPrompt(String prompt);
    List<Integer> readIntsWithPrompt(String prompt);
}
