package command;

import duke.DukeException;
import duke.TaskList;
import duke.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        /* Put this line before tasks.save() because we want it to be executed
        regardless of whether the tasks could be saved to local file. */
        ui.showSuccess("ok bye");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
