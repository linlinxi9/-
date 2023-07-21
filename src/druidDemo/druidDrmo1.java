package druidDemo;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import utils.druidTool;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class druidDrmo1 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //获得连接
            connection = druidTool.getConnection();
            //定义sql语句
            String sql = "insert into account values(null,?,?)";
            //获得pstmt对象
            preparedStatement = connection.prepareStatement(sql);
            //给？赋值
            preparedStatement.setString(1,"王五");
            preparedStatement.setDouble(2,3000);
            //执行sql
            int i = preparedStatement.executeUpdate();

            System.out.println(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            druidTool.close(preparedStatement,connection);
        }
    }
}
