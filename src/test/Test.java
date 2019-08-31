package test;

import utils.JdbcUtils;


public class Test {


    public static void main(String[] args) {
        String URL = "jdbc:mysql://www.xieshianjia.club:3306/iccar?characterEncoding=utf8";
        String USERNAME = "root";
        String PASSWORD = "kutenglaoshuhunya";

        JdbcUtils.ScanDatabase(URL, USERNAME, PASSWORD);
    }


}
