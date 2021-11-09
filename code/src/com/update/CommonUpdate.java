package com.update;

import com.utils.Utils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CommonUpdate {
    //通用的增删改操作
    public static int update(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库连接
            conn = Utils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0;i < args.length;i++) {
                ps.setObject(i+1,args[i]);
            }
            //4.执行
            /**
             * ps.execute()
             * 如果执行的是查询操作，有返回结果，则此方法返回true；
             * 如果执行的是增删改操作，没有返回结果，则此方法返回false；
             */
//          方式二:
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            Utils.closeResource(conn,ps);
        }
        return 0;
    }
}
