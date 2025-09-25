package duke;

import duke.command.Command;
import duke.command.AddToCommand;
import duke.command.DeleteCommand;
import duke.command.ByeCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.command.MarkCommand;
import duke.command.UnmarkCommand;
import duke.command.WeirdCommand;
import duke.command.WrongCommand;

public class  Parser {
    public static Command parse(String UserCommand){
        if  (UserCommand.equals("bye")){
            return new ByeCommand();
        } else if (UserCommand.equals("list")){
            return new ListCommand();
        } else if (UserCommand.contains("unmark")){
            try{
                String index = UserCommand.substring(UserCommand.indexOf(" ")+1);
                int ind =  Integer.parseInt(index);
                ind--;
                return new UnmarkCommand(ind);
            }  catch (NumberFormatException e){
                return new WrongCommand("input is not a number");
            }

        } else if (UserCommand.contains("mark")) {
            try{
                String index = UserCommand.substring(UserCommand.indexOf(" ")+1);
                int ind =  Integer.parseInt(index);
                ind--;
                return new MarkCommand(ind);
            }  catch (NumberFormatException e){
                return new WrongCommand("input is not a number");
            }
        } else if (UserCommand.contains("delete")){
            String index = UserCommand.substring(UserCommand.indexOf(" ") + 1);
            int ind = Integer.parseInt(index);
            ind--;
            return new DeleteCommand(ind);
        } else if (UserCommand.contains("todo") || UserCommand.contains("event") || UserCommand.contains("deadline")){
            return new AddToCommand(UserCommand);
        } else if (UserCommand.contains("find")){
            String entry = UserCommand.substring(UserCommand.indexOf(" ") + 1);
            return new FindCommand(entry);
        }
        else {
            return new WeirdCommand();
        }
    }
}
