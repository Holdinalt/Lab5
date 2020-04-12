package commands;

import collectionWorker.HashMapWrapper;
import mainApp.Result;

public class RemoveLowerKeyCommand implements Command {
    private HashMapWrapper hashMapWrapper ;
    public RemoveLowerKeyCommand(ControlUnit cu, HashMapWrapper hashMapWrapper){
        cu.addCommand("remove_lover", this);
        this.hashMapWrapper = hashMapWrapper;
    }
    @Override
    public void execute(String options, Result result) {
        if(options == null){
            result.writeResult("Данная команда должна содержать аргумент. Запрос не будет исполнен");
            return;
        }
        result.writeResult(hashMapWrapper.removeLowerKey(Long.parseLong(options)));

    }
}
