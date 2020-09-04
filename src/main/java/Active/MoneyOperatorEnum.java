package Active;

public enum MoneyOperatorEnum {

    DISCOUNT("打折","discount"),
    SUBTRACTION("直减","subtraction")

    ;

    private String name;
    private String key;

    private MoneyOperatorEnum(String name,String key){
        this.key = key;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }
}
