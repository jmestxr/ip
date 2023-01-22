package duke;

import org.junit.jupiter.api.Test;
import task.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaskListTest {
    @Test
    public void add() {
        TaskList taskList = new TaskList();
        TaskStub dummyTask = new TaskStub("Dummy Task");
        taskList.add(dummyTask);
        assertEquals(1, taskList.getNoOfTasks());
        assertEquals("Dummy Task", taskList.list().get(0).toString());
    }

    @Test
    public void delete_valid() {
        TaskList taskList = new TaskList();
        TaskStub dummyTask = new TaskStub("Dummy Task");
        taskList.add(dummyTask);
        try {
            taskList.delete(1);
            return; /* passed */
        } catch (DukeException e) {
            fail();
        }
    }

    @Test
    public void delete_invalid() {
        TaskList taskList = new TaskList();
        TaskStub dummyTask = new TaskStub("Dummy Task");
        taskList.add(dummyTask);
        try {
            taskList.delete(0);
            fail();
        } catch (DukeException e) {
            return; /* passed */
        }
    }

    @Test
    public void markAndUnmark_valid() {
        TaskList taskList = new TaskList();
        TaskStub dummyTask = new TaskStub("Dummy Task");
        taskList.add(dummyTask);
        try {
            taskList.mark(1);
            assertEquals("X", dummyTask.getStatusIcon());
            taskList.unmark(1);
            assertEquals(" ", dummyTask.getStatusIcon());
        } catch (DukeException e) {
            fail();
        }
    }

}

class TaskStub extends Task {
    public TaskStub(String description) {
        super(description);
    }
    @Override
    public String getSavedFormat() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}