public class UserInfo {
    private String name;
    private String password;
    public void setName(String name){
        this.name=name;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
    public  UserInfo(String name,String password) {
        this.name=name;
        this.password=password;
    }
    public  UserInfo(){};
}
