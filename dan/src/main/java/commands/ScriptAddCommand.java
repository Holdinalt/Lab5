package commands;

import collectionWorker.HashMapWrapper;
import factories.StudyGroupFactory;
import mainApp.Result;

public class ScriptAddCommand implements Command {
    private HashMapWrapper hashMapWrapper;
    public ScriptAddCommand(ControlUnit cu, HashMapWrapper hmw){
        cu.addCommand("script_add", this);
        hashMapWrapper = hmw;
    }
    @Override
    public void execute(String options, Result result) {
        if(options != null){
            result.writeResult("Данная комада не содержит аргументов! Запрос не будет выполнен");
            return;
        }
        hashMapWrapper.addElement(new StudyGroupFactory().createStudyGroupWithParams(options));
        result.writeResult("Объект успешно добавлен в коллекцию!");
    }
}
