package duke.task;

public class Todo extends Task{
    public Todo(String name){
        super(name);
    }

    @Override
    public String printinfo() {
        String output = "";
        output += "[T]";
        output += super.printinfo();
        return output;
    }

    @Override
    public String toString(){
        return ("T|" + isDone() +"|"+ getName());
    }
}
