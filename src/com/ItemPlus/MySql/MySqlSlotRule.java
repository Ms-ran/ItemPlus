package com.ItemPlus.MySql;

/**
 * @author HotFlow
 */
public enum MySqlSlotRule
{
    PrimaryKey("Primary Key"),
    NotNull("Not Null"),
    Unique("Unique"),
    Binary("Binary"),
    Unsigned("Unsigned"),
    ZeroFill("Zero Fill"),
    AutoIncrement("Auto Increment");
    
    public String name;
    
    private MySqlSlotRule(String name)
    {
        this.name = name;
    }
}
