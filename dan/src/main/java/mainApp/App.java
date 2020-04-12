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
        IdGenerator i = new IdGenerator();
        HashMapWrapper hashMapWrapper = new HashMapWrapper();
        FileManager fl = new FileManager(hashMapWrapper,"SaveFile");
        PrintFieldCommand pt = new PrintFieldCommand(cu,hashMapWrapper);
        InsertCommand in = new InsertCommand(cu,hashMapWrapper);
        ShowCommand sh = new ShowCommand(cu,hashMapWrapper);
        RemoveAllByCommand re = new RemoveAllByCommand(cu,hashMapWrapper);
        SaveCommand sa = new SaveCommand(cu, fl);
        UpdateCommand updateCommand = new UpdateCommand(cu, hashMapWrapper);
        ExecuteScriptCommand e = new ExecuteScriptCommand(cu);
        System.out.println("Добро пожаловать!  Введите команду");
        while (true) {
            System.out.print("> ");
            Result r = new Result();
            cu.executeCommand(new Scanner(System.in).nextLine(), r);
            System.out.println(r.checkResult());
        }

    }
}
