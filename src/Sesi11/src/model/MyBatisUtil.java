package Sesi11.src.model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import java.io.IOException;
import java.io.Reader;

//public class MyBatisUtil {
//    private static SqlSessionFactory sqlSessionFactory;
//
//    static {
//        try {
//            sqlSessionFactory = new SqlSessionFactoryBuilder()
//                    .build(Resources.getResourceAsStream("Sesi11\\src\\resource\\mybatis-config\\xml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static SqlSession getSqlSession() {
//        return sqlSessionFactory.openSession();
//    }
//}
//


public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // Use classpath resource reference for mybatis-config.xml
            Reader reader = Resources.getResourceAsReader("Sesi11/src/resource/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
