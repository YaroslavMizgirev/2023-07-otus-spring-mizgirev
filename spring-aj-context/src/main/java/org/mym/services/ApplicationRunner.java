package org.mym.services;

import org.mym.config.ApplicationSettings;

public class ApplicationRunner {
    private final IOService ioService;
    private final ApplicationSettings applicationSettings;

    public ApplicationRunner(IOService ioService, ApplicationSettings applicationSettings) {
        this.ioService = ioService;
        this.applicationSettings = applicationSettings;
    }

    public void run() {
        //
    }
}
