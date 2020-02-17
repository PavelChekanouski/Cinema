package controller.command;

import controller.command.impl.FindByDate;
import controller.command.impl.FindByDirectorId;
import controller.command.impl.FindByDirectorIdAndDate;
import controller.command.impl.WrongRequest;

import java.util.EnumMap;

public class CommandProvider {
    private EnumMap<CommandNames, Command> repository = new EnumMap<>(CommandNames.class);

    public CommandProvider() {
        repository.put(CommandNames.FindByDate, new FindByDate());
        repository.put(CommandNames.FindByDirectorId, new FindByDirectorId());
        repository.put(CommandNames.FindByDirectorIdAndDate, new FindByDirectorIdAndDate());
        repository.put(CommandNames.WrongRequest, new WrongRequest());
    }

    public Command getCommand(String request) {
        Command command;
        try {
            CommandNames commandName = CommandNames.valueOf(request);
            command = repository.get(commandName);
        } catch (Exception e) {
            command = repository.get(CommandNames.WrongRequest);
            e.printStackTrace();
        }
        return command;
    }
}
