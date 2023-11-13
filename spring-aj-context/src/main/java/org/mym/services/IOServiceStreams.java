package org.mym.services;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IOServiceStreams implements IOService {
    private final PrintStream output;
    private final Scanner input;

    public IOServiceStreams(PrintStream outputStream, InputStream inputStream) {
        this.output = outputStream;
        this.input = new Scanner(inputStream);
    }

    @Override
    public String readStringWithPrompt(String prompt) {
        outputString(prompt);
        return input.nextLine();
    }

    @Override
    public List<Integer> readIntsWithPrompt(String prompt) {
        outputString(prompt);
        return Arrays.stream(input.nextLine().split(","))
                        .map(a -> Integer.parseInt(a) - 1)
                        .toList();
    }

    @Override
    public void outputString(String s) {
        output.print(s);
    }
}
