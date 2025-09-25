package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException;

    public boolean isExit(){
        return false;
    }
}
