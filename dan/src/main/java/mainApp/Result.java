package mainApp;

public class Result {
    private String res;
    public Result(){
        res = "";
    }
    public void writeResult(String s){
        res += "\n" + s ;
    }
    public String checkResult(){
        return res;
    }
}
