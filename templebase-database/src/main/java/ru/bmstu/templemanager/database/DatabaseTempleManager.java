package ru.bmstu.templemanager.database;

import ru.bmstu.templebase.model.Temple;
import ru.bmstu.templebase.model.TempleFields;
import ru.bmstu.templebase.manager.BaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DatabaseTempleManager implements BaseManager<Temple, TempleFields> {

    public DatabaseTempleManager() {
        run();
    }

    private final String driverName = "com.mysql.jdbc.Driver";
    private final String connectionString = "jdbc:mysql://localhost:3306/test";
    private final String login = "root";
    private final String password = "password";
    private Connection connection;

    private void run() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Can't get class. No driver found");
            e.printStackTrace();
            return;
        }

        connection = null;
        try {
            connection = DriverManager.getConnection(connectionString, login, password);

        } catch (SQLException e) {
            System.out.println("Can't get connection. Incorrect URL");
            e.printStackTrace();
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Can't close connection");
            e.printStackTrace();

        }
    }


    @Override
    public void add(Temple temple) {
        try {
            Statement  st =connection.createStatement();
            st.execute("insert into Temple (id, name)"
                    +" values ("+temple.getId()+", '"+temple.getName()+"')");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addAll(Collection<Temple> temples) {
        for(Temple t: temples) {
            add(t);
        }
    }

    @Override
    public Temple get(int id) {
        Temple temple = null;
        try {
            Statement  st =connection.createStatement();
            ResultSet rs =st.executeQuery("select * from Temple where id="+id);

            while(rs.next()) {
                temple= mapTemple(rs);
            }

            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temple;
    }

    private Temple mapTemple(ResultSet rs) throws Exception{
        int id = rs.getInt("id");
        String name = rs.getString("name");
        Temple temple = new Temple();
        temple.setId(id);
        temple.setName(name);
        return temple;
    }
    @Override
    public Collection<Temple> getAll() {
        List<Temple> temples = new ArrayList<>();
        try {
            Statement  st =connection.createStatement();
            ResultSet rs =st.executeQuery("select * from Temple");

            while(rs.next()) {
                temples.add(mapTemple(rs));
            }

            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temples;
    }

    @Override
    public void update(Temple temple) {
        try {
            Statement  st =connection.createStatement();
            st.executeUpdate("update Temple "
                    +"  set name = '"+ temple.getName()+"' where id ="+temple.getId());
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAll(Collection<Temple> temples) {
        for (Temple t: temples) {
            update(t);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Statement  st =connection.createStatement();
            st.execute("delete Temple "
                    +"  where id ="+id);
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Temple> searchBy(TempleFields field, String value) {
        return null;
    }
}
