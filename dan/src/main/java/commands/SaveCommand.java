package commands;

import fileWorker.FileManager;
import mainApp.Result;
/*
    сохраняет коллекцию в файл
 */
public class SaveCommand implements Command {
    FileManager fileManager;
    public SaveCommand(ControlUnit cu , FileManager fileManager){
        cu.addCommand("save",this);
        this.fileManager = fileManager;
    }
    @Override
    public void execute(String options, Result result) {
        fileManager.write(result);
    }
}
