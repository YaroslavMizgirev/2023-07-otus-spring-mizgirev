package org.mym.services.processors;

import org.mym.domain.User;
import org.mym.services.IOService;

import java.util.Optional;

public class AddNewUserCommand implements SingleCommandProcessor<User> {
    private final IOService ioService;

    public AddNewUserCommand(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public User processCommand() {
        String firstName = ioService.readStringWithPrompt("Input your first name: ");
        String lastName = ioService.readStringWithPrompt("Input your last name: ");
        return new User(firstName, lastName);
    }
}
