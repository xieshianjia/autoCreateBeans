package test;

import pojo.Attribute;
import utils.JdbcUtils;


import java.util.List;

public class Test {


    public static void main(String[] args) {
        String URL = "jdbc:mysql://www.xieshianjia.club:3306/iccar?characterEncoding=utf8";
        String USERNAME = "root";
        String PASSWORD = "kutenglaoshuhunya";

        List<Attribute> attributeList = JdbcUtils.ScanDatabase(URL, USERNAME, PASSWORD);

        String tableName ="";
        for (Attribute attribute : attributeList) {
            if (!tableName.equals(attribute.getTableName())) {
                tableName = attribute.getTableName();
                System.out.println(tableName);
            }
            String packageName = Test.class.getPackage().getName();
            StringBuilder javaStr = new StringBuilder();
            int pos = packageName.lastIndexOf('.');
            if (pos == -1) {
                javaStr.append("package pojo;\r\n\r\n");
            } else {
                packageName = packageName.substring(0, pos+1);
                javaStr.append("package "+packageName+"pojo;\r\n\r\n");
            }
            System.out.println(javaStr);
        }



    }


}