package commands;

import collectionWorker.HashMapWrapper;
import mainApp.Result;

public class RemoveAllByCommand implements Command {
    private HashMapWrapper hashMapWrapper;
    public RemoveAllByCommand(ControlUnit cu, HashMapWrapper hashMapWrapper){
        cu.addCommand("remove_by_sbe", this);
        this.hashMapWrapper = hashMapWrapper;
    }
    @Override
    public void execute(String options, Result result) {
        if(options == null){
            result.writeResult("Данная команда должна содержать аргумент. Запрос не будет исполнен");
            return;
        }
        try {

            result.writeResult(hashMapWrapper.removeBySBE(Integer.parseInt(options)));
        } catch (NumberFormatException ec){
            result.writeResult("поступил неверный аргумент. Команда не будет исполнена");
        }

    }
}
