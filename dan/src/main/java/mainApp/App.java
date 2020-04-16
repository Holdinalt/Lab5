package mainApp;

import collectionWorker.HashMapWrapper;
import commands.*;
import factories.IdGenerator;
import factories.StudyGroupFactory;
import fileWorker.FileManager;
import sourseDate.StudyGroup;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import com.google.gson.Gson;

public class App {
    public static void main(String[] args) throws IOException {
        ControlUnit cu = new ControlUnit();
        IdGenerator idGenerator = new IdGenerator();
        HashMapWrapper hashMapWrapper = new HashMapWrapper();
        FileManager fl = new FileManager(hashMapWrapper,"SaveFile");
        CommandLoader commandLoader = new CommandLoader(cu,hashMapWrapper,fl);
        Result result = new Result();
        System.out.println("Добро пожаловать!  Введите команду");
        while (true) {
            System.out.print("> ");
            result.clear();
            cu.executeCommand(new Scanner(System.in).nextLine(), result);
            System.out.println(result.checkResult());
        }

    }
}
