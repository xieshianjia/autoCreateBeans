package pojo;

public class Attribute {
    private String tableName;
    private String attrName;
    private String type;


    @Override
    public String toString() {
        return "Attribute{" +
                "tableName='" + tableName + '\'' +
                ", attrName='" + attrName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
