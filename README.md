# autoCreateBeans
最终功能：根据数据库读到的表生成相对应的pojo类

# 用法

    class Test{
        @Test 
        public void aa{
            String URL = "jdbc:mysql://[ip]:[port]/[database]?characterEncoding=utf8&..";
            String USERNAME = "[root]";
            String PASSWORD = "[root]";
            MyBeans mybeans = new MyBeans(URL,USERNAME,PASSWORD);
            mybeans.ScanDatabase(Test.class);
        }
    }

> pojo类会生成在Test.java的包中
  
## 记录一下
- 还有许多地方需要完善，比如表中字段名是有下划线格式的==

