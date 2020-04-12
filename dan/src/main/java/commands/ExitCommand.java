package commands;

import mainApp.Result;

public class ExitCommand implements Command{
    public ExitCommand(ControlUnit cu){
        cu.addCommand("exit", this);
    }

    @Override
    public void execute(String options, Result result) {
        if(options != null){
            result.writeResult("Данная комада не содержит аргументов! Запрос не будет выполнен");
            return;
        }
        System.exit(0);
    }
}
