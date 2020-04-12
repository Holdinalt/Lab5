package collectionWorker;

import sourseDate.StudyGroup;

import java.util.Iterator;

public interface CollectionWrapper {
    String addElement(StudyGroup st);
    String removeElement(long id);
    String info();
    String show();
    String updateById(long id, StudyGroup st);
    String clear();
    Boolean isEmpty();
    Iterator getIterator();
    StudyGroup getStudyGroup(long l);
}
