package commands;

import collectionWorker.HashMapWrapper;
import mainApp.Result;

public class SumCommand implements Command {
    private HashMapWrapper hashMapWrapper;
    public SumCommand(ControlUnit cu, HashMapWrapper hw){
        cu.addCommand("sum_sbe", this);
        hashMapWrapper = hw;
    }
    @Override
    public void execute(String options, Result result) {
        if(options != null){
            result.writeResult("Данная комада не содержит аргументов! Запрос не будет выполнен");
            return;
        }
        result.writeResult("Сумма: " +hashMapWrapper.sumOfElement());
    }
}
