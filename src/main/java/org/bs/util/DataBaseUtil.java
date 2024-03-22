package org.bs.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author KSaMar
 * @version 1.0
 * 数据库连接工具
 */
public class DataBaseUtil {
    /**
     * 数据库驱动名称
     */
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    /**
     * 数据库连接地址
     */
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bookstore";
    /**
     * 数据库连接名称
     */
    private static final String DATABASE_USERNAME = "root";
    /**
     * 数据库连接密码
     */
    private static final String DATABASE_PASSWORD = "123456";

    private Connection connection;

    /**
     * 创建数据库连接
     */
    public DataBaseUtil() {
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return 数据库连接
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * 关闭源
     */
    public static void close(AutoCloseable... autoCloseables) {
        for (AutoCloseable closeable : autoCloseables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
