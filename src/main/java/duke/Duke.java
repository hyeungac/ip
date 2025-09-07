package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Task[] list = new Task[100];
        int task_count = 0;
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________\n" +
                " Hello! I'm Gordon_Duke\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n");

        while (true) {
            String line;
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            if(line.equalsIgnoreCase("bye")){
                System.out.println("____________________________________________________________\n" +
                        " Bye. Hope to see you again soon!\n" +
                        "____________________________________________________________\n");
                break;
            } else if(line.equalsIgnoreCase("list")){
                int index = 0;
                System.out.println("____________________________________________________________");
                for (Task task : list) {
                    if (index == task_count) {
                        break;
                    }
                    int num = index + 1;
                    System.out.print(num + ". " );
                    task.printinfo();
                    index++;
                }
                System.out.println("____________________________________________________________");
            } else if(line.contains("unmark")){
                try{
                    String index = line.substring(line.indexOf(" ")+1);
                    int ind =  Integer.parseInt(index);
                    ind--;
                    list[ind].setDone(false);
                    System.out.println("____________________________________________________________");
                    System.out.println("OK, I've marked this task as not done yet:");
                    list[ind].printinfo();
                    System.out.println("____________________________________________________________");
                } catch(NumberFormatException e){
                    System.out.println("______________________________________________________________");
                    System.out.println("emmmm, seems like you didn't enter a number?");
                    System.out.println("______________________________________________________________");
                } catch(IndexOutOfBoundsException e){
                    System.out.println("______________________________________________________________");
                    System.out.println("emmmm, seems like you forgot to enter something?");
                    System.out.println("______________________________________________________________");
                } catch(NullPointerException e){
                    System.out.println("______________________________________________________________");
                    System.out.println("emmm, does this task exist?");
                    System.out.println("______________________________________________________________");
                }


            } else if(line.contains("mark")){
                try{
                    String index = line.substring(line.indexOf(" ")+1);
                    int ind =  Integer.parseInt(index);
                    ind--;
                    list[ind].setDone(true);
                    System.out.println("____________________________________________________________");
                    System.out.println("Nice! I've marked this task as done:");
                    list[ind].printinfo();
                    System.out.println("____________________________________________________________");
                } catch(NumberFormatException e){
                    System.out.println("______________________________________________________________");
                    System.out.println("emmmm, seems like you didn't enter a number?");
                    System.out.println("______________________________________________________________");
                } catch(IndexOutOfBoundsException e) {
                    System.out.println("______________________________________________________________");
                    System.out.println("emmmm, seems like you forgot to enter something?");
                    System.out.println("______________________________________________________________");
                } catch(NullPointerException e){
                    System.out.println("______________________________________________________________");
                    System.out.println("emmm, does this task exist?");
                    System.out.println("______________________________________________________________");
                }
            } else{
                if(line.contains("todo")){
                    try{
                        int firstspace = line.indexOf(" ");
                        if (firstspace == -1 || firstspace + 1 >= line.length()) {
                            throw new IndexOutOfBoundsException();
                        }
                        String TaskName = line.substring(firstspace + 1);
                        list[task_count++] = new Todo(TaskName);
                    } catch(IndexOutOfBoundsException e){
                        System.out.println("______________________________________________________________");
                        System.out.println("emmmm, seems like you forgot to enter your todo name?");
                        System.out.println("______________________________________________________________");
                        continue;
                    }

                } else if(line.contains("deadline")){
                    try{
                        String[] parts = line.split("/");
                        int firstspace = parts[0].indexOf(" ");
                        if (firstspace == -1) {
                            throw new StringIndexOutOfBoundsException();
                        }
                        String TaskName = parts[0].substring(firstspace + 1);
                        list[task_count++] = new Deadline(TaskName, parts[1]);
                    } catch(StringIndexOutOfBoundsException e){
                        System.out.println("______________________________________________________________");
                        System.out.println("emmmm, seems like you forgot to enter your deadline name?");
                        System.out.println("______________________________________________________________");
                        continue;
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("______________________________________________________________");
                        System.out.println("emmm, seemslike you forgot to enter your deadline date?");
                        System.out.println("______________________________________________________________");
                        continue;
                    }

                } else if (line.contains("event")){
                    try {
                        String[] parts = line.split("/");
                        int firstspace = parts[0].indexOf(" ");
                        if (firstspace == -1) {
                            throw new StringIndexOutOfBoundsException();
                        }
                        String TaskName = parts[0].substring(firstspace + 1);
                        list[task_count++] = new Event(TaskName, parts[1], parts[2]);
                    }  catch(StringIndexOutOfBoundsException e){
                        System.out.println("______________________________________________________________");
                        System.out.println("emmmm, seems like you forgot to enter your event name?");
                        System.out.println("______________________________________________________________");
                        continue;
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("______________________________________________________________");
                        System.out.println("emmmm, seems like you forgot to enter your event time?");
                        System.out.println("______________________________________________________________");
                        continue;
                    }
                } else{
                    System.out.println("______________________________________________________________");
                    System.out.println("sorry, gordon is too dumb to understand you command :((");
                    System.out.println("______________________________________________________________");
                    continue;
                }
                System.out.println("____________________________________________________________\n" +
                        "well! ive added: ");
                list[task_count-1].printinfo();
                System.out.println("\n"+
                        "____________________________________________________________\n");

            }
        }

    }
}
