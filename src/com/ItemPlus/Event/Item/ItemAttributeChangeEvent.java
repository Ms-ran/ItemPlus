package com.ItemPlus.Event.Item;

import com.ItemPlus.Attribute.Attribute;
import com.ItemPlus.Item.ItemStack;
import org.bukkit.event.Cancellable;

/**
 * 物品属性变动事件
 *
 * @author HotFlow
 */
public class ItemAttributeChangeEvent extends ItemEvent implements Cancellable
{
    private final Attribute attribute;
    private Boolean cancelled = false;

    public ItemAttributeChangeEvent(ItemStack item, Attribute attribute)
    {
        super(item);
        this.attribute = attribute;
    }

    /**
     * 获取属性
     *
     * @return Attribute
     */
    public Attribute getAttribute()
    {
        return this.attribute;
    }

    @Override
    public boolean isCancelled()
    {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean bln)
    {
        this.cancelled = bln;
    }
}
