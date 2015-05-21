package com.ItemPlus.MySql;

/**
 * @author HotFlow
 */
public class MySqlSlot
{
    public final String flag;

    public MySqlSlot(String type, MySqlSlotRule[] rules, String name)
    {
        StringBuilder sb = new StringBuilder();

        sb.append(name).append(" ").append(type).append(" ");

        for (MySqlSlotRule r : rules)
        {
            sb.append(r.name).append(" ");
        }

        this.flag = sb.toString();
    }
}
