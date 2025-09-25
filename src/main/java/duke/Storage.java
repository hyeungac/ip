package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {

    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public TaskList load() throws DukeException{
        TaskList tasks = new TaskList();
        File file = new File(filePath);

        if (!file.exists()) {
            return tasks;
        }
        try (Scanner scanner = new Scanner(file)){
            int index = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                if (line.charAt(0) == 'T') {
                    tasks.addTask(new Todo(parts[2]));
                } else if (line.charAt(0) == 'D') {
                    tasks.addTask(new Deadline(parts[2], parts[3]));
                } else if (line.charAt(0) == 'E') {
                    tasks.addTask(new Event(parts[2], parts[3], parts[4]));
                }
                if (parts[1].equalsIgnoreCase("true")) {
                    tasks.getTask(index).setDone(true);
                }
                index++;
            }
        } catch (IOException e){
            throw new DukeException ("error when loading the file");
        }
        return tasks;
    }

    public void SaveTasks(TaskList tasks) throws DukeException{
        try (FileWriter fw = new FileWriter(filePath)){
            String txtToAdd = "";
            for (int i =0; i < tasks.getSize(); i++) {
                String new_line = tasks.getTask(i).toString();
                txtToAdd += new_line + "\n";
            }
            fw.write(txtToAdd);
        } catch (IOException e){
            throw new DukeException("Error saving file.");
        }
    }
}
