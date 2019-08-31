package test;

public class a {
    public static void main(String[] args) {
        String packageName = "com.aaa.bbb.text";
        StringBuilder javaStr = new StringBuilder();
        int pos = packageName.lastIndexOf('.');
        if (pos == -1) {
            javaStr.append("package pojo;\r\n");
        } else {
            packageName = packageName.substring(0, pos+1);
            javaStr.append("package " + packageName + "pojo;\r\n\r\n");
            javaStr.append("as");
        }
        System.out.println(javaStr.toString());
    }
}
