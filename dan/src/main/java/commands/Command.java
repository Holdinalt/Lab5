package commands;

import mainApp.Result;

public interface Command {
    void execute(String options, Result result);
}
