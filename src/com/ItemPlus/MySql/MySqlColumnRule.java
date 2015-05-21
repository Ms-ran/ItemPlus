package com.ItemPlus.MySql;

/**
 * MySql列规则
 *
 * @author HotFlow
 */
public enum MySqlColumnRule
{
    PrimaryKey("Primary Key"),
    NotNull("Not Null"),
    Unique("Unique"),
    Binary("Binary"),
    Unsigned("Unsigned"),
    ZeroFill("Zero Fill"),
    AutoIncrement("Auto Increment");

    public String name;

    private MySqlColumnRule(String name)
    {
        this.name = name;
    }
}
