package command;

import java.util.Iterator;

import duke.TaskList;
import duke.Ui;
import task.Task;

/**
 * Command to list all the latest recorded tasks of the current chat session.
 */
public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui) {
        Iterator<Task> tasksIterator = tasks.list().iterator();
        if (!tasksIterator.hasNext()) {
            ui.showSuccess("There are currently no tasks in your list.");
            return;
        }
        ui.showSuccess("Here are the tasks in your list:");
        int taskNo = 1;
        while (tasksIterator.hasNext()) {
            Task task = tasksIterator.next();
            ui.showSuccess(taskNo + ". " + task.toString());
            taskNo += 1;
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}