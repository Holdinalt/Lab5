package commands;

import collectionWorker.HashMapWrapper;
import mainApp.Result;
/*
    выводит информацию о админах группы и соритрует по какому-то критерию
 */
public class PrintFieldCommand implements Command {
    private HashMapWrapper hashMapWrapper;
    public PrintFieldCommand(ControlUnit cu, HashMapWrapper hm){
        cu.addCommand("print_admin",this);
        hashMapWrapper = hm;
    }

    @Override
    public void execute(String options, Result result) {
        if(options != null){
            result.writeResult("Данная комада не содержит аргументов! Запрос не будет выполнен");
            return;
        }
        result.writeResult(hashMapWrapper.printAdmins());
    }
}
