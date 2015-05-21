package com.ItemPlus.MySql;

/**
 * MySql列
 *
 * @author HotFlow
 */
public class MySqlColumn
{
    public final String flag;

    public MySqlColumn(String type, MySqlColumnRule[] rules, String name)
    {
        StringBuilder sb = new StringBuilder();

        sb.append(name).append(" ").append(type).append(" ");

        for (MySqlColumnRule r : rules)
        {
            sb.append(r.name).append(" ");
        }

        this.flag = sb.toString();
    }
}
