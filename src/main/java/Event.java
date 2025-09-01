public class Event extends Task{
    private String from;
    private String to;
    public Event(String name, String from, String to){
        super(name);
        this.from = from;
        this.to = to;
    }
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }

    @Override
    public void printinfo() {
        System.out.print("[E]");
        super.printinfo();
        System.out.println("(from: " + this.from + "to: " + this.to + ")");
    }
}
