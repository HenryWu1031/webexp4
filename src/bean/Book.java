package bean;

public class Book {
    public int id;
    public String name;
    public String kind;
    public String time;
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setKind(String kind){
        this.kind=kind;
    }
    public String getKind(){
        return this.kind;
    }
    public String getTime( ){
        return this.time;
    }
    public void setTime(String time){
        this.time=time;
    }
}
