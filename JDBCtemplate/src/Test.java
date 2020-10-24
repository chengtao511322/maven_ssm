import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

    //测试能获取多少个连接
    public static void main(String[] args) throws SQLException {
        DruidDemo dd = new DruidDemo();
        DataSource ds = dd.getDs();

        Connection connection = ds.getConnection();
        String sql = "select cust_name from customers where cust_id =?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1,10003);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getObject(1));


        };



    }
}
