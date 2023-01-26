package duke.command;

import duke.Storage;
import duke.Ui;
import duke.TaskList;

/**
 * Represents a command from the user.
 *
 * @author Karen
 */
public abstract class Command {
    /**
     * Checks if command is an exit command.
     *
     * @return A boolean value indicating whether it is an exit command.
     */
    public abstract boolean isExit();

    /**
     * Executes the command.
     *
     * @param tasks. A TaskList containing the set of task the user has.
     * @param ui. An Ui which allows for interaction between Duke and user.
     * @param storage. A Storage enabling Duke to store memory.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage);
}
