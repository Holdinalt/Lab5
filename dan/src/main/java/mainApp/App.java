package mainApp;

import collectionWorker.HashMapWrapper;
import commands.*;
import factories.IdGenerator;
import factories.StudyGroupFactory;
import fileWorker.FileManager;
import sourseDate.Semester;
import sourseDate.StudyGroup;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import com.google.gson.Gson;
/*
    Даня , важно. Тут есть задокументированные строки. Когда будешь делать джарники - раздокументируй их и убри строку , которую я выделю
 */
public class App {
    public static void main(String[] args) throws IOException {
        ControlUnit cu = new ControlUnit();
        IdGenerator idGenerator = new IdGenerator();
        HashMapWrapper hashMapWrapper = new HashMapWrapper();
        //FileManager fl = new FileManager(hashMapWrapper, args[0]);
        FileManager fl = new FileManager(hashMapWrapper, "SaveFile"); //TODO УБРАТЬ
        CommandLoader commandLoader = new CommandLoader(cu,hashMapWrapper,fl);
        Result result = new Result();
        System.out.println("Добро пожаловать!  Введите команду");
        while (true) {
            System.out.print("> ");
            result.clear();
            String request = new Scanner(System.in).nextLine();
            if(request.equals("")){
                continue;
            }
            cu.executeCommand(request, result);
            System.out.println(result.checkResult());
        }


    }
}
