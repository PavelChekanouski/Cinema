package controller;

import controller.command.Command;
import controller.command.CommandProvider;
import view.ConsoleReader;

public class Controller {
    private final CommandProvider commandProvider = new CommandProvider();
    private final ConsoleReader reader = new ConsoleReader();

    public void executeTask() {
        String request = reader.readClient();
        Command command = commandProvider.getCommand(request);
        try{
            command.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
