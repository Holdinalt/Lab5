package commands;

import mainApp.Result;

public interface Command {
    public void execute(String options, Result result);
}
