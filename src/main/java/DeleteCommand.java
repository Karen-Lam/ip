package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.command.Command;

/**
 * Represents a command from the user to delete a task from list.
 *
 * @author Karen
 */
public class DeleteCommand extends Command {

    private int num;

    public DeleteCommand(int num) {
        this.num = num;
    }

    /**
     * Checks if command is an exit command.
     *
     * @return false. Delete task command is not an exit command.
     */
    public boolean isExit() {
        return false;
    }

    /**
     * Deletes the selected task from the list. Prints message indicating to user that task was successfully deleted.
     *
     * @param tasks. A TaskList containing the set of task the user has.
     * @param ui. An Ui which allows for interaction between Duke and user.
     * @param storage. A Storage enabling Duke to store memory.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            ui.deleteTaskResponse(tasks.deleteTask(num - 1) , tasks);
        } catch (IndexOutOfBoundsException e1) {
            ui.taskNotChosenErrorMessage();
        }
    }

}
