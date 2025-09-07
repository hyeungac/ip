package duke.task;

public class Todo extends Task{
    public Todo(String name){
        super(name);
    }

    @Override
    public void printinfo() {
        System.out.print("[T]");
        super.printinfo();
        System.out.println();
    }
}
