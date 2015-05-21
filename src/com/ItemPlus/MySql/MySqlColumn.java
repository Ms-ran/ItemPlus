package com.ItemPlus.MySql;

/**
 * MySql列
 *
 * @author HotFlow
 */
public class MySqlColumn
{
    public final String flag;

    /**
     * 构造MySql列
     * @param type 类型
     * @param rules 规则
     * @param name  名称
     */
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
