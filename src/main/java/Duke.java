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
            }
            else if(line.equalsIgnoreCase("list")){
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
            }
            else if(line.contains("unmark")){
                String index = line.substring(line.indexOf(" ")+1);
                int ind =  Integer.parseInt(index);
                ind--;
                list[ind].setDone(false);
                System.out.println("____________________________________________________________");
                System.out.println("OK, I've marked this task as not done yet:");
                list[ind].printinfo();
                System.out.println("____________________________________________________________");

            }
            else if(line.contains("mark")){
                String index = line.substring(line.indexOf(" ")+1);
                int ind =  Integer.parseInt(index);
                ind--;
                list[ind].setDone(true);
                System.out.println("____________________________________________________________");
                System.out.println("Nice! I've marked this task as done:");
                list[ind].printinfo();
                System.out.println("____________________________________________________________");

            }
            else{
                if(line.contains("todo")){
                    int firstspace = line.indexOf(" ");
                    String TaskName = line.substring(firstspace + 1);
                    list[task_count++] = new Todo(TaskName);
                }
                else if(line.contains("deadline")){
                    String[] parts = line.split("/");
                    int firstspace = parts[0].indexOf(" ");
                    String TaskName = parts[0].substring(firstspace + 1);
                    list[task_count++] = new Deadline(TaskName, parts[1]);
                }
                else if (line.contains("event")){
                    String[] parts = line.split("/");
                    int firstspace = parts[0].indexOf(" ");
                    String TaskName = parts[0].substring(firstspace + 1);
                    list[task_count++] = new Event(TaskName, parts[1], parts[2]);
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
