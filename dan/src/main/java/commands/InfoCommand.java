package commands;

import collectionWorker.HashMapWrapper;
import mainApp.Result;
/*
    команда, которая выводит информацию о коллекции
 */
public class InfoCommand implements Command {
    private HashMapWrapper hashMapWrapper;
    public InfoCommand(ControlUnit controlUnit, HashMapWrapper hm){
        controlUnit.addCommand("info", this);
        hashMapWrapper = hm;
    }
    @Override
    public void execute(String options, Result result) {
        if(options != null){
            result.writeResult("Данная комада не содержит аргументов! Запрос не будет выполнен");
            return;
        }
        result.writeResult(hashMapWrapper.info());
    }
}
