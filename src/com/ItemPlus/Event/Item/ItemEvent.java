package com.ItemPlus.Event.Item;

import com.ItemPlus.Item.ItemStack;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author HotFlow
 */
public class ItemEvent extends Event
{
    private static final HandlerList handlers = new HandlerList();
    private final ItemStack item;

    public ItemEvent(ItemStack item)
    {
        this.item = item;
    }

    /**
     * 获取物品
     *
     * @return
     */
    public ItemStack getItem()
    {
        return this.item;
    }

    /**
     * 获取处理者
     *
     * @return
     */
    public HandlerList getHandlers()
    {
        return handlers;
    }

    /**
     * 获取处理者列表
     *
     * @return
     */
    public static HandlerList getHandlerList()
    {
        return handlers;
    }
}
