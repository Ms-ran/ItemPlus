package com.ItemPlus.Core.v0_0_1.Attribute;

import com.ItemPlus.Attribute.Attribute;
import java.util.UUID;

/**
 * @author HotFlow
 */
public class LifeSteal implements Attribute
{
    private String name;
    private int operation;
    private int amount;
    private UUID uuid;

    public LifeSteal(String name, int operation, int amount, UUID uuid)
    {
        this.name = name;
        this.operation = operation;
        this.amount = amount;
        this.uuid = uuid;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Attribute getType()
    {
        return this;
    }

    public String getTypeString()
    {
        return "itemPlus.lifeSteal";
    }

    public int getOperation()
    {
        return this.operation;
    }

    public void setOperation(int operation)
    {
        this.operation = operation;
    }

    public Integer getAmount()
    {
        return this.amount;
    }

    public void setAmount(Object amount)
    {
        this.amount = (Integer) amount;
    }

    public UUID getUUID()
    {
        return this.uuid;
    }

    public void setUUID(UUID id)
    {
        this.uuid = id;
    }
}
