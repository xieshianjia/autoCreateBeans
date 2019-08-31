package utils;

import java.io.*;

/**
 * @auther 作者：张嘉
 * @date 2019/8/31 9:40
 * @direction 说明：
 */
public class StringUtils {
    /**
     * 首字母转大写
     *
     * @param str
     * @return 转换后的字符串
     */
    public static String firstToUpper(String str) {
        str = str.toLowerCase();
        return (str.toUpperCase().charAt(0)) + str.substring(1);
    }

    public static void createJavaFile(StringBuilder javaStr) throws Exception {
        File file = new File("");
        OutputStreamWriter out = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(out);
    }


    /**
     * Integer    : INT , TINYINT , SMALLINT , MEDIUMINT
     * Double     : DOUBLE , FLOAT
     * String     : CHAR , VARCHAR , DATE , TIME ,YEAR , DATETIME ,TIMESTAMP
     * byte[]     : BLOB
     * Boolean    : BIT
     * BigInteger : BIGINT
     * BigDecimal : DECIMAL
     * <p>
     * MEDIUMBLOB-LONGBLOB-BINARY-VARBINARY-GEOMETRY
     *
     * @param typeName
     * @return
     */
    public static String judgeType(String typeName) {
        String type = "";
        if ("INT".equals(typeName)) {
            type = "Integer";
        } else if ("TINYINT".equals(typeName)) {
            type = "Integer";
        } else if ("SMALLINT".equals(typeName)) {
            type = "Integer";
        } else if ("MEDIUMINT".equals(typeName)) {
            type = "Integer";
        } else if ("DOUBLE".equals(typeName)) {
            type = "Double";
        } else if ("FLOAT".equals(typeName)) {
            type = "Double";
        } else if ("CHAR".equals(typeName)) {
            type = "String";
        } else if ("VARCHAR".equals(typeName)) {
            type = "String";
        } else if ("DATETIME".equals(typeName)) {
            type = "String";
        } else if ("DATE".equals(typeName)) {
            type = "String";
        } else if ("TIME".equals(typeName)) {
            type = "String";
        } else if ("YEAR".equals(typeName)) {
            type = "String";
        } else if ("TIMESTAMP".equals(typeName)) {
            type = "String";
        } else if ("BLOB".equals(typeName)) {
            type = "byte[]";
        } else if ("BIT".equals(typeName)) {
            type = "Boolean";
        } else if ("BIGINT".equals(typeName)) {
            type = "BigInteger";
        } else if ("DECIMAL".equals(typeName)) {
            type = "BigDecimal";
        }


        return type;
    }


}
