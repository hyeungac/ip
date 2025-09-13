package duke.task;

public class Deadline extends Task{
    private String by;
    public Deadline(String name, String by){
        super(name);
        this.by = by;
    }
    public String getBy() {
        return by;
    }

    @Override
    public void printinfo() {
        System.out.print("[D]");
        super.printinfo();
        System.out.println(" by: " + this.by);
    }
    @Override
    public String toString(){
        return ("D| " + isDone()+ " | " + getName() + " | " + by);
    }
}
