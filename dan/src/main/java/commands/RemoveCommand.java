package commands;

import collectionWorker.HashMapWrapper;
import mainApp.Result;
/*
    удаляет элемент из коллекции по его ID
 */
public class RemoveCommand implements Command {
    HashMapWrapper hashMapWrapper ;
    public RemoveCommand(ControlUnit cu, HashMapWrapper hw){
        cu.addCommand("remove" , this);
        hashMapWrapper = hw;
    }

    @Override
    public void execute(String options, Result result) {
        if(options == null){
            result.writeResult("Данная команда должна содержать аргумент. Запрос не будет исполнен");
            return;
        }
        try {

            result.writeResult(hashMapWrapper.removeElement(Long.parseLong(options)));
        } catch (NumberFormatException ec){
            result.writeResult("поступил неверный аргумент. Команда не будет исполнена");
        }

    }
}
