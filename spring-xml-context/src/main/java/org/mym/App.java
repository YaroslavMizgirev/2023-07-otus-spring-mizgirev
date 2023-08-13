/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.mym;

import lombok.extern.log4j.Log4j2;
import org.mym.config.ProcessConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Log4j2
public class App {

    public static void main(String[] args) {
        ProcessConfig.CONFIG.run("/context.xml", ClassPathXmlApplicationContext::new);
    }
}
