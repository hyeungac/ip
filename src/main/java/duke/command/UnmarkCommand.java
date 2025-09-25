package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

import java.io.IOException;

public class UnmarkCommand extends Command{
    int  index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        if (index < 0 || index >= tasks.getSize()){
            ui.showError("emmm, does this task exist?");
            return;
        }
        tasks.getTask(index).setDone(false);
        storage.SaveTasks(tasks);
        ui.showMessage("Nice! I've marked this task as undone:");
        System.out.println(tasks.getTask(index).printinfo());
    }
}
