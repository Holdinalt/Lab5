package commands;

import mainApp.Result;

import java.util.*;

public class ControlUnit {
    private Map<String,Command> commandMap;
    private List<String> history;
    public ControlUnit(){
        commandMap = new HashMap<>();
        history = new ArrayList<>();
    }
    public void addCommand(String name, Command command){
        commandMap.put(name,command);
    }
    public void saveHistory(String command){
        if( history.size() >= 5){
            history.remove(0);
        }
        history.add(command);
    }
    public String checkHistory(){
        return history.toString();
    }
    public void executeCommand(String query, Result result){
        if(query.equals("")){
            return;
        }
        try {
            List<String> splitQuery = Arrays.asList(query.split(" "));
            if (splitQuery.size() == 1) {
                commandMap.get(splitQuery.get(0)).execute(null, result);
                saveHistory(splitQuery.get(0));
            } else if (splitQuery.size() == 2) {
                commandMap.get(splitQuery.get(0)).execute(splitQuery.get(1), result);
                saveHistory(splitQuery.get(0));
            } else {
                result.writeResult("Команда состоит из двух частей. Имя и возможные аргумент. В вашем запросе превышено количество элементоа в запросе");
            }
        } catch (NullPointerException ex){
            result.writeResult("Такой команды не существует");
        }

    }
    public void executeCommand(String name, String params, Result result){
        commandMap.get(name).execute(params,result);
    }
}
