package duke;

import duke.controllers.Main;
import javafx.application.Application;

/**
 * A launcher class to workaround classpath issues.
 */
public class Launcher {
    public Launcher() {
    }

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}
