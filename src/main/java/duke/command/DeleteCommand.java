package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class DeleteCommand extends Command {
    private int index;
    public DeleteCommand(int index){
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        if (index < 0 || index >= tasks.getSize()){
            ui.showError("emmm, does this task exist?");
            return;
        }
        ui.showMessage("well! ive deleted: ");
        System.out.println(tasks.getTask(index).printinfo());
        tasks.removeTask(index);
        storage.SaveTasks(tasks);
    }
}
