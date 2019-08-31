package utils;

import test.Test;

import java.sql.*;

public class JdbcUtils {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void ScanDatabase(String URL, String USERNAME, String PWD) {

        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PWD);
            PreparedStatement pre = conn.prepareStatement("show tables");
            ResultSet result = pre.executeQuery();

            StringBuilder javaStr = null;


            while (result.next()) {
                String tableName = result.getString(1);
                PreparedStatement pres = conn.prepareStatement("select * from " + tableName);
                ResultSetMetaData res = pres.getMetaData();

                javaStr = new StringBuilder();

                String packageName = Test.class.getPackage().getName();
                int pos = packageName.lastIndexOf('.');
                if (pos == -1) {
                    javaStr.append("package pojo;\r\n\r\n");
                } else {
                    packageName = packageName.substring(0, pos + 1);
                    javaStr.append("package " + packageName + "pojo;\r\n\r\n");
                }
                javaStr.append("public class " + StringUtils.firstToUpper(tableName) + "{\r\n");


                for (int i = 1; i <= res.getColumnCount(); i++) {

                    String columnName = res.getColumnName(i);
                    String columnTypeName = res.getColumnTypeName(i);

                    String type = "";
                    type = StringUtils.judgeType(columnTypeName);
                    String attrName = "";
                    attrName = columnName;
                    javaStr.append("    private " + type + " " + attrName + ";\r\n");


                }
                javaStr.append("}");
                System.out.println(javaStr);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
