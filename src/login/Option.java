package login;

public enum Option {
    Admin,Staff;
    private Option(){
    }
    public String value(){
        return name();
    }
    public static Option fromValue(String v){
        return valueOf(v);
    }
}
