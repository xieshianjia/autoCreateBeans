package club.xieshianjia.beans;

import club.xieshianjia.utils.StringUtils;

import java.io.File;
import java.sql.*;

/**
 * @auther 作者：张嘉
 * @date 2019/8/31 14:48
 * @direction 说明：
 */
public class MyBeans {
    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *  structure with parameters
     * @param url database url
     * @param username database username
     * @param password database password
     */
    public MyBeans(String url, String username, String password) {
        this.URL = url;
        USERNAME = username;
        PASSWORD = password;
    }

    /**
     *
     * @param clazz 调用类名
     */
    public void ScanDatabase(Class clazz) {

        try {

            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pre = conn.prepareStatement("show tables");
            ResultSet result = pre.executeQuery();

            StringBuilder javaStr = null;

            String packageName = clazz.getPackage().getName();
            String dir = new File("").getCanonicalPath();
            dir = dir + "/src/" + StringUtils.packageNametoDir(packageName);

            while (result.next()) {
                String tableName = result.getString(1);
                PreparedStatement pres = conn.prepareStatement("select * from " + tableName);
                ResultSetMetaData res = pres.getMetaData();

                javaStr = new StringBuilder();

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

                    javaStr.append("    private " + type + " " + attrName + ";\r\n\r\n");
                    javaStr.append("    public " + type + " get" + StringUtils.firstToUpper(attrName) + " () {\r\n");
                    javaStr.append("        return " + attrName + ";\r\n");
                    javaStr.append("    }\r\n\r\n");
                    javaStr.append("    public void set" + StringUtils.firstToUpper(attrName) + "(" + type + " " + attrName + ") {\r\n");
                    javaStr.append("        this." + attrName + " = " + attrName + ";\r\n");
                    javaStr.append("    }\r\n");


                }
                javaStr.append("}");

                StringUtils.createJavaFile(StringUtils.firstToUpper(tableName), dir , javaStr);
                System.out.println(javaStr);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
