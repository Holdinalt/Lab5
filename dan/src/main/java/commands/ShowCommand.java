package commands;

import collectionWorker.HashMapWrapper;
import mainApp.Result;

public class ShowCommand implements Command {
    public HashMapWrapper hashMapWrapper;
    public ShowCommand(ControlUnit controlUnit, HashMapWrapper hashMapWrapper){
        controlUnit.addCommand("show", this);
        this.hashMapWrapper = hashMapWrapper;
    }
    @Override
    public void execute(String options, Result result) {
        if(options != null){
            result.writeResult("Данная комада не содержит аргументов! Запрос не будет выполнен");
            return;
        }
        result.writeResult(hashMapWrapper.show());
    }
}
