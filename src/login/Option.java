package login;

public enum Option {
    Admin,Staff,Broker,Security;
    private Option(){
    }
    public String value(){
        return name();
    }
    public static Option fromValue(String v){
        return valueOf(v);
    }
}
