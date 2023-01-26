package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.command.Command;

/**
 * Represents a command from the user to mark a task as done.
 *
 * @author Karen
 */
public class MarkCommand extends Command {

    private int num;

    public MarkCommand(int num) {
        this.num = num;
    }

    /**
     * Checks if command is an exit command.
     *
     * @return false. Mark task command is not an exit command.
     */
    public boolean isExit() {
        return false;
    }

    /**
     * Marks the selected task in the list as done. Prints a message indicating to user that task successfully marked.
     *
     * @param tasks. A TaskList containing the set of task the user has.
     * @param ui. An Ui which allows for interaction between Duke and user.
     * @param storage. A Storage enabling Duke to store memory.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            ui.markTaskResponse(tasks.markTask(num, true));
        } catch (IndexOutOfBoundsException e1) {
            ui.taskNotChosenErrorMessage();
        }
    }

}
