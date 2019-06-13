import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads{
    private List<Ad> AdsList;
    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPass()
            );
        }catch(SQLException e){
            e.printStackTrace();
        }
        AdsList = new ArrayList<>();
    }

    @Override
    public List<Ad> all() {
        AdsList = new ArrayList<>();
        try {
            String query = "SELECT * FROM ads";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                AdsList.add(
                new Ad(rs.getInt("id"),rs.getInt("user_id"),
                        rs.getString("title"),rs.getString("description"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return AdsList;
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String query = "INSERT INTO ads(user_id, title, description) " +
                    "VALUES ("+ad.getUserId()+", '"+ad.getTitle()+"', '"+ad.getDescription()+"');";
            System.out.println(query);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                long id = rs.getLong(1);
                System.out.println("Inserted a new record! New id: " + id);
                return id;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
