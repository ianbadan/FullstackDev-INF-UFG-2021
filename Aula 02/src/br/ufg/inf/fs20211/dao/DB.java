package br.ufg.inf.fs20211.dao;

import br.ufg.inf.fs20211.exceptions.DbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
    private static Connection conn = null;

    public static Connection getConnection() throws DbException {
        if(conn == null){
            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url,props);
            } catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    private static Properties loadProperties() throws DbException{
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection() throws DbException{
        if(conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st) throws DbException{
        if(st !=null){
            try{
                st.close();
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) throws DbException{
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
}
