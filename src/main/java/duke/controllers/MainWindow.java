package duke.controllers;

import duke.Duke;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.nio.file.Paths;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends BorderPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;

    @FXML
    private UserControl userControl;

    private Duke duke;

    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/mascot.png"));

    @FXML
    public void initialize() {
        this.duke = new Duke(this, Paths.get(".", "data", "duke.txt"));
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        userControl.setMainWindow(this);
    }

    public void addUserDialog(String msg) {
        UserDialog dialog = new UserDialog(msg);
        dialogContainer.getChildren().add(dialog);
    }

    public void addDukeDialog(String msg) {
        DukeDialog dialog = new DukeDialog(msg, dukeImage);
        dialogContainer.getChildren().add(dialog);
    }

    public void terminate() {
        /* Wait for 0.5 seconds before closing the app */
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
            Platform.exit();
            System.exit(0); /* close the app */
        }));

        timeline.play();
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    public void handleUserInput(String input) {
        if (input.length() > 0) {
            this.duke.handleUserInput(input);
        }
    }
}