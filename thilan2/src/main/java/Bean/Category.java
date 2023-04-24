package Bean;

public class Category {
    private String idType;
    private String name;

    public Category(String idType, String name) {
        this.idType = idType;
        this.name = name;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
