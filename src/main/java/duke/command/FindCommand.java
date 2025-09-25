package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class FindCommand extends Command {
    private String entry;
    public FindCommand(String entry) {
        this.entry = entry;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        String output = tasks.findingTaskWithName(entry);
        if (output.isEmpty()) {
            ui.showError("uh oh... cant find such task: " + entry);
            return;
        }
        ui.showMessage(output);
    }
}