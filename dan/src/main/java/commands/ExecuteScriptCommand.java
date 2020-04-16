package commands;

import exceptions.RecursionOnScriptException;
import factories.ScriptPathChecker;
import mainApp.Result;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {
    private ControlUnit controlUnit;
    private Scanner sc;
    private File file;
    public ExecuteScriptCommand(ControlUnit cu){
        controlUnit = cu;
        cu.addCommand("execute_script", this);
    }
    @Override
    public void execute(String options, Result result) {
        int currLine = 0; // подсчет строк
        ScriptPathChecker.addNewPath(options);
        file = new File(options); // получсем путь к скрипту
        List<String> check = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                ++currLine;
                String newxtLine = sc.nextLine();
                if(newxtLine.isEmpty()){
                    continue;
                }
                check = Arrays.asList(newxtLine.split(" "));
                if(check.get(0).equals("insert")){
                    String buffer = sc.nextLine()+ " " + sc.nextLine() +" "+ sc.nextLine() +" "+ sc.nextLine()+" "+ sc.nextLine() +" "+ sc.nextLine();
                    controlUnit.executeCommand("script_add", buffer, result);
                    continue;
                }
                if(check.get(0).equals("execute_script")){
                    String pathBuff =check.get(1);
                    if(ScriptPathChecker.checkRecursion(pathBuff)){
                        System.out.println("обнаруженв рекурсия! срипт будет прерван");
                        throw new RecursionOnScriptException();
                    }
                    ScriptPathChecker.addNewPath(pathBuff);
                    controlUnit.executeCommand(check.get(0), check.get(1),result);
                    continue;
                }
                if(check.size() == 1){
                    controlUnit.executeCommand(check.get(0),null,result);
                    continue;
                }
                controlUnit.executeCommand(check.get(0), check.get(1),result);
            }
            sc.close();
            ScriptPathChecker.clear();
        } catch (FileNotFoundException ex){
            System.out.println("Файл не найден");
        } catch (RecursionOnScriptException ex2){
            System.out.println("Скрипт прерван!");
        }
        catch (Exception e){
            System.out.println("Ошибка в строке: "+currLine );
            System.out.println("Команда, в которой произшла ошибка " + check.toString() );
        }
    }

    }

