package commands;

import collectionWorker.HashMapWrapper;
import factories.StudyGroupFactory;
import mainApp.Result;
import sourseDate.StudyGroup;

public class InsertCommand implements Command {
    private HashMapWrapper hashMapWrapper;
    public InsertCommand(ControlUnit cu, HashMapWrapper hmw){
        cu.addCommand("insert", this);
        hashMapWrapper = hmw;
    }
    @Override
    public void execute(String options, Result result) {
        if(options != null){
            result.writeResult("Данная комада не содержит аргументов! Запрос не будет выполнен");
            return;
        }
        hashMapWrapper.addElement(new StudyGroupFactory().createStudyGroup());
        result.writeResult("Объект успешно добавлен в коллекцию!");
    }
}
