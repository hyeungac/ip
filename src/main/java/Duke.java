import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String[] list = new String[100];
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
                for (String task : list) {
                    if (index == task_count) {
                        break;
                    }

                    System.out.println(index + ": " + task);
                    index++;
                }
                System.out.println("____________________________________________________________");
            }
            else{
                list[task_count++] = line;
                System.out.println("____________________________________________________________\n" +
                        "added: "+line + "\n"+
                        "____________________________________________________________\n");
            }
        }

    }
}
