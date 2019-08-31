package utils;

import pojo.Attribute;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtils {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Attribute> ScanDatabase(String URL, String USERNAME, String PWD) {
        List<Attribute> attributeList = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PWD);
            PreparedStatement pre = conn.prepareStatement("show tables");
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                String tableName = result.getString(1);
                PreparedStatement pres = conn.prepareStatement("select * from " + tableName);
                ResultSetMetaData res = pres.getMetaData();
                for (int i = 1; i <= res.getColumnCount(); i++) {
                    Attribute attr = new Attribute();
                    attr.setTableName(tableName);
                    String columnName = res.getColumnName(i);
                    String columnTypeName = res.getColumnTypeName(i);

                    attr.setAttrName(columnName);
                    attr.setType(columnTypeName);
                    attributeList.add(attr);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attributeList;
    }
}
