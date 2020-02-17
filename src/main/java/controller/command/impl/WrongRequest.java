package controller.command.impl;

import controller.command.Command;
import view.ConsolePrinter;

public class WrongRequest implements Command {

    @Override
    public void execute(){
        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.printError();
    }
}
