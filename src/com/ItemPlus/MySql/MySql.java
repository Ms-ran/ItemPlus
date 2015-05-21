package com.ItemPlus.MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 直接面向MySql的操作，以后更改为HashMap读写
 *
 * @author HotFlow
 */
public class MySql
{
    private String schema;
    private String table;
    private final Connection connection;

    /**
     * 初始化MySql连接
     *
     * @param host 地址
     * @param port 端口
     * @param schema 数据库
     * @param table 表
     * @param userName 用户名
     * @param password 密码
     * @throws java.sql.SQLException
     */
    public MySql(String host, int port, String schema, String table, String userName, String password) throws SQLException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.schema = schema;
        this.table = table;
        this.connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/", userName, password);
    }

    /**
     * 设置数据库
     *
     * @param schema
     * @throws java.sql.SQLException
     */
    public void setSchema(String schema) throws SQLException
    {
        if (!connection.isClosed())
        {
            this.schema = schema;
        }
        else
        {
            this.schema = null;
        }
    }

    /**
     * 是否拥有schema
     *
     * @return @throws SQLException
     */
    public Boolean hasSchema() throws SQLException
    {
        int i = 0;
        PreparedStatement sql = this.connection.prepareStatement("SHOW Schemas Like '" + this.schema + "';");
        ResultSet result = sql.executeQuery();

        while (result.next())
        {
            i += 1;
        }

        return i > 0;
    }

    /**
     * 设置表格
     *
     * @param table
     * @throws java.sql.SQLException
     */
    public void setTable(String table) throws SQLException
    {
        if (!this.connection.isClosed())
        {
            this.table = table;
        }
        else
        {
            this.table = null;
        }
    }

    /**
     * 是否拥有table
     *
     * @return
     * @throws java.sql.SQLException
     */
    public Boolean hasTable() throws SQLException
    {
        if (!this.connection.isClosed())
        {
            try
            {
                PreparedStatement sql = this.connection.prepareStatement("SELECT * FROM " + this.schema + "." + this.table + ";");

                return sql.execute();
            }
            catch (SQLException ex)
            {
                return false;
            }
        }

        return false;
    }

    /**
     * 获取数据库
     *
     * @return
     */
    public String getSchema()
    {
        return this.schema;
    }

    /**
     * 获取表格
     *
     * @return
     */
    public String getTable()
    {
        return this.table;
    }

    /**
     * 是否连接
     *
     * @return
     * @throws SQLException
     */
    public Boolean isConnected() throws SQLException
    {
        return !this.connection.isClosed();
    }

    /**
     * 断开连接
     *
     * @throws SQLException
     */
    public synchronized void disconnect() throws SQLException
    {
        if (!this.connection.isClosed())
        {
            this.connection.close();
        }
    }

    /**
     * 创建数据库
     *
     * @param name
     * @return
     * @throws SQLException
     */
    public synchronized Boolean createSchema(String name) throws SQLException
    {
        PreparedStatement sql = this.connection.prepareStatement("create database " + name);
        return sql.execute();
    }

    /**
     * 创建表格
     *
     * @param table
     * @param slots
     * @return
     * @throws java.sql.SQLException
     */
    public synchronized Boolean createTable(String table, MySqlSlot[] slots) throws SQLException
    {
        if (this.isConnected())
        {
            if (this.schema != null)
            {
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < slots.length; i++)
                {
                    MySqlSlot slot = slots[i];
                    sb.append(slot.flag);
                    if (i < slots.length - 1)
                    {
                        sb.append(", ");
                    }
                }

                PreparedStatement sql = this.connection.prepareStatement("CREATE TABLE " + this.schema + "." + table + "(" + sb.toString() + ");");
                return sql.execute();
            }
        }

        return false;
    }

    /**
     * 执行命令
     *
     * @param statement
     * @return
     * @throws java.sql.SQLException
     */
    public synchronized ResultSet executeQuery(String statement) throws SQLException
    {
        if (this.isConnected())
        {
            PreparedStatement sql = this.connection.prepareStatement(statement);
            return sql.executeQuery();
        }

        return null;
    }

    /**
     * 执行命令
     *
     * @param statement
     * @return
     * @throws java.sql.SQLException
     */
    public synchronized Boolean execute(String statement) throws SQLException
    {
        if (this.isConnected())
        {
            PreparedStatement sql = this.connection.prepareStatement(statement);
            return sql.execute();
        }

        return false;
    }

    /**
     * 执行命令
     *
     * @param statement
     * @return
     * @throws SQLException
     */
    public synchronized int executeUpdate(String statement) throws SQLException
    {
        if (this.isConnected())
        {
            PreparedStatement sql = this.connection.prepareStatement(statement);
            return sql.executeUpdate();
        }

        return 0;
    }

    /**
     * 添加数据
     *
     * @param map
     * @return
     * @throws SQLException
     */
    public synchronized Boolean insert(HashMap<String, String> map) throws SQLException
    {
        if (this.isConnected())
        {
            if (this.getSchema() != null && this.getTable() != null)
            {
                StringBuilder keys = new StringBuilder();
                StringBuilder values = new StringBuilder();

                for (String key : map.keySet())
                {
                    keys.append(key).append(",");
                    values.append(map.get(key)).append(",");
                }

                if (keys.length() > 0)
                {
                    keys.deleteCharAt(keys.length() - 1);
                }

                if (values.length() > 0)
                {
                    values.deleteCharAt(values.length() - 1);
                }

                PreparedStatement sql = this.connection.prepareStatement("Insert into " + this.schema + "." + this.table + " (" + keys.toString() + ")" + " values (" + values.toString() + ")");
                return sql.execute();
            }
        }

        return false;
    }

    /**
     * 更新符合条件数据
     *
     * @param condition
     * @param key
     * @param value
     * @return
     * @throws java.sql.SQLException
     */
    public synchronized int update(String condition, String key, String value) throws SQLException
    {
        if (this.isConnected())
        {
            if (this.getSchema() != null && this.getTable() != null)
            {
                PreparedStatement sql = this.connection.prepareStatement("Update " + this.schema + "." + this.table + " SET " + key + "='" + value + "' WHERE " + condition + ";");
                return sql.executeUpdate();
            }
        }

        return 0;
    }

    /**
     * 删除符合条件数据
     *
     * @param key
     * @param value
     * @return
     * @throws SQLException
     */
    public synchronized int delete(String key, String value) throws SQLException
    {
        if (this.isConnected())
        {
            if (this.getSchema() != null && this.getTable() != null)
            {
                PreparedStatement sql = this.connection.prepareStatement("DELETE FROM " + this.schema + "." + this.table + " WHERE " + key + " ='" + value + "';");
                return sql.executeUpdate();
            }
        }

        return 0;
    }

    /**
     * 获取键中所有符合值
     *
     * @param condition
     * @param key
     * @return
     * @throws SQLException
     */
    public synchronized List<Object> getValuesOfKey(String condition, String key) throws SQLException
    {
        if (this.isConnected())
        {
            if (this.getSchema() != null && this.getTable() != null)
            {
                List<Object> values = new ArrayList<Object>();

                PreparedStatement sql = this.connection.prepareStatement("SELECT " + key + " FROM " + this.schema + "." + this.table + " WHERE " + condition + ";");
                ResultSet result = sql.executeQuery();

                while (result.next())
                {
                    values.add(result.getObject(key));
                }

                return values;
            }
        }

        return null;
    }

    /**
     * 获取键中所有符合值
     *
     * @param condition
     * @param key
     * @return
     * @throws SQLException
     */
    public synchronized List<Integer> getIntegersOfKey(String condition, String key) throws SQLException
    {
        List<Integer> list = new ArrayList<Integer>();
        for (Object o : this.getValuesOfKey(condition, key))
        {
            list.add((Integer) o);
        }

        return list;
    }

    /**
     * 获取键中所有符合值
     *
     * @param condition
     * @param key
     * @return
     * @throws SQLException
     */
    public synchronized List<String> getStringsOfKey(String condition, String key) throws SQLException
    {
        List<String> list = new ArrayList<String>();
        for (Object o : this.getValuesOfKey(condition, key))
        {
            list.add((String) o);
        }

        return list;
    }

    /**
     * 键是否存在
     *
     * @param key
     * @return
     * @throws java.sql.SQLException
     */
    public synchronized Boolean isKeyExist(String key) throws SQLException
    {
        if (this.isConnected())
        {
            if (this.getSchema() != null && this.getTable() != null)
            {
                int size = 0;
                PreparedStatement sql = this.connection.prepareStatement("SELECT " + key + " FROM " + this.schema + "." + this.table + ";");
                ResultSet result = sql.executeQuery();

                while (result.next())
                {
                    size++;
                }

                return size > 0;
            }
        }

        return false;
    }

    /**
     * 获取现有键
     *
     * @return
     * @throws SQLException
     */
    public synchronized List<String> getKeys() throws SQLException
    {
        if (this.isConnected())
        {
            if (this.getSchema() != null && this.getTable() != null)
            {
                List<String> keys = new ArrayList<String>();
                PreparedStatement sql = this.connection.prepareStatement("select COLUMN_NAME from information_schema.COLUMNS where table_name = '" + this.table + "';");
                ResultSet result = sql.executeQuery();

                while (result.next())
                {
                    keys.add(result.getString("COLUMN_NAME"));
                }

                return keys;
            }
        }

        return null;
    }

    /**
     * 键是否拥有值
     *
     * @param key
     * @param value
     * @return 0为否
     * @throws SQLException
     */
    public synchronized Boolean isKeyHasValue(String key, String value) throws SQLException
    {
        return this.getValuesOfKey(key + "='" + value + "'", key) == null ? false : this.getValuesOfKey(key + "='" + value + "'", key).size() > 0;
    }

    /**
     * 获取键信息
     *
     * @param key
     * @return
     */
    public synchronized ResultSet getKeyInfo(String key) throws SQLException
    {
        return this.connection.prepareStatement("show columns from " + this.table + " where Field = '" + key + "';").executeQuery();
    }
}