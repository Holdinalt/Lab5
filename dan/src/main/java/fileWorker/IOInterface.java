package fileWorker;

import mainApp.Result;
/*
    интерфейс для сохранения значений коллекции
 */
public interface IOInterface {
    void write(Result result);
    void read (Result result);
}
