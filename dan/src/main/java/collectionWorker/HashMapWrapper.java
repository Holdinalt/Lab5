package collectionWorker;

import sourseDate.Person;
import sourseDate.StudyGroup;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapWrapper implements CollectionWrapper {
    private Map<Long,StudyGroup> groupMap;
    private Date createDate;
    public HashMapWrapper(){
        groupMap = new HashMap<>();
        createDate = new Date();
    }
    public String printAdmins(){
        Set<Long> keySet = groupMap.keySet();
        List<Person> adminList = new ArrayList<>();
        for(Long n : keySet){
            adminList.add(groupMap.get(n).getGroupAdmin());
        }
        Collections.sort(adminList, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getPassportID().compareTo(t1.getPassportID());
            }
        });
        return adminList.toString();

    }
    public String removeBySBE(int a){
        groupMap.keySet().removeIf(aLong -> groupMap.get(aLong).getShouldBeExpelled() == a);
        return "Удаление прошло успешно";

    }
    public String removeLowerKey(Long l){
        groupMap.keySet().removeIf(x -> groupMap.get(x).getId() < l);
        return "Удаление прошло успешно";
    }
    public int sumOfElement(){
        Set<Long> keySet = groupMap.keySet();
       int result = 0;
        for(Long n : keySet){
            result += groupMap.get(n).getShouldBeExpelled();
        }
        return result;
    }
    @Override
    public String addElement(StudyGroup st) {
        groupMap.put(st.getId(),st);
        return "Новый элемент успешно добавлен!";
    }

    @Override
    public String removeElement(long id) {
        groupMap.remove(id);
        return "Элемент успешно удален!";

    }

    @Override
    public String info() {
        return "Тип коллекции: HashMap" +
                "Дата создания: " + createDate +
                "Количество элементов: " + groupMap.size();
    }

    @Override
    public String show() {
        if(groupMap.size() == 0) {
            return "коллекция пуста!";
        }
        String s = "";
        Set<Long> keys = groupMap.keySet();
        for(Long key : keys){
            s+=groupMap.get(key).toString();
        }
        return s;
    }

    @Override
    public String updateById(long id, StudyGroup st) {
        if(groupMap.get(id) == null){
            return "По данному адресу нет элемента , запись не будет произведена";
        }
        groupMap.replace(id, st);
        return "Объект: " + st.getName() + " теперь хранится по адресу "+ id;
    }

    @Override
    public String clear() {
        groupMap.clear();
        return "коллекция была очищена";
    }

    @Override
    public Boolean isEmpty() {
        return groupMap.isEmpty();
    }

    @Override
    public Iterator getIterator() {
        return groupMap.keySet().iterator();
    }

    @Override
    public StudyGroup getStudyGroup(long l) {
        return groupMap.get(l);
    }


}
