package duke;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public String readCommand(){
        return scanner.nextLine();
    }

    public void showWelcome(){
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
    }
    public void showGoodbye(){
        System.out.println(" Bye. Hope to see you again soon!");
    }
    public void showMessage(String message){
        System.out.println(message);
    }

    public void showError(String message){
        System.out.println(message);
    }

    public void showDummyLine(){
        System.out.println("____________________________________________________________");
    }

    public void showLoadingError() {
        System.out.println();
    }
}
