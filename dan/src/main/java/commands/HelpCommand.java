package commands;

import mainApp.Result;
/*
    выводит скудную инфомарцию о командах...
 */
public class HelpCommand implements Command {
    public HelpCommand(ControlUnit cu){
        cu.addCommand("help", this);
    }
    @Override
    public void execute(String options, Result result) {
        result.writeResult("Доступные комнады: clear,execute,exit,help,info,history,insert,save,show  и др");
    }
}
