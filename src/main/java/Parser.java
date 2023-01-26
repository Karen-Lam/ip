package duke;

import duke.command.ExitCommand;
import duke.command.ListCommand;
import duke.command.MarkCommand;
import duke.command.UnmarkCommand;
import duke.command.DeleteCommand;
import duke.command.AddTodoCommand;
import duke.command.AddDeadlineCommand;
import duke.command.AddEventCommand;
import duke.command.Command;
import duke.Ui;

public class Parser {

    public static Command parse(String input) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        String[] arrStr = input.split(" ", 2);
        String instruction = arrStr[0];

        switch (instruction) {
            case "bye":
                return new ExitCommand();

            case "list":
                return new ListCommand();

            case "mark":
                return new MarkCommand(Integer.parseInt(arrStr[1]));

            case "unmark":
                return new UnmarkCommand(Integer.parseInt(arrStr[1]));

            case "delete":
                return new DeleteCommand(Integer.parseInt(arrStr[1]));

            case "todo":
                return new AddTodoCommand(arrStr[1]);

            case "deadline":
                String[] split = arrStr[1].split(" /by ", 2);
                return new AddDeadlineCommand(split[0], split[1]);

            case "event":
                String[] split1 = arrStr[1].split(" /from ", 2);
                String[] split2 = split1[1].split(" /to ", 2);
                return new AddEventCommand(split1[0], split2[0], split2[1]);

            default:
                throw new IllegalArgumentException();
        }
    }
}
