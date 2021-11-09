package com.utils;

import com.bean.Diary;
import com.diary.Main;
import com.update.*;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static com.diary.Main.isTrue;
import static com.update.CommonUpdate.update;

/**
 * 操作数据库的工具类
 */
public class Utils {
    public static Connection getConnection() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        //读取配置文件中的4个基本信息
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
        //加载驱动
        Class clazz = Class.forName(driverClass);
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    public static void closeResource(Connection conn, PreparedStatement ps) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void readKeyBoard(int input,boolean True) {
        if (input == 1) {
            Scanner sc = new Scanner(System.in);
            LocalDateTime date = LocalDateTime.now();
            System.out.print("请输入日记内容：");
            String content = sc.nextLine();
            String sql = "insert into diary(date,content)values(?,?)";
            int insertCount = update(sql,date,content);
            System.out.println(insertCount > 0 ? "添加成功" : "添加失败");
        }else if (input == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入要删除内容对应的序号：");
            int deleteNumber = sc.nextInt();
            String sql = "delete from diary where number = ?";
            int deleteCount = update(sql, deleteNumber);
            System.out.println(deleteCount > 0 ? "删除成功" : "删除失败");
        }else if (input == 3) {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入要修改内容对应的序号：");
            String revampString = sc.nextLine();
            System.out.print("请输入你的修改内容：");
            String revampContent = sc.nextLine();
            int revampNumber = Integer.parseInt(revampString);
            String sql = "update diary set content = ? where number = ?";
            int revampCount = update(sql,revampContent,revampNumber);
            System.out.println(revampCount > 0 ? "修改成功" : "修改失败");
        }else if (input == 4) {
            System.out.println("你的所有内容如下：");
            String sql = "select number,date,content from diary";
            List<Diary> list = CommonQuery.getForList(Diary.class, sql);
            list.forEach(System.out::println);
        }else if (input == 0) {
            System.out.println("程序已退出！");
            isTrue = false;
        }else {
            System.out.println("输入有误，请重新输入：");
        }
    }
}

