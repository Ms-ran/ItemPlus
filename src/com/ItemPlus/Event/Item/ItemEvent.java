package com.ItemPlus.Event.Item;

import com.ItemPlus.Item.ItemStack;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * 物品事件
 *
 * @author HotFlow
 */
public class ItemEvent extends Event
{
    private static final HandlerList handlers = new HandlerList();
    private final ItemStack item;

    /**
     * 构造物品事件
     *
     * @param item 物品
     */
    public ItemEvent(ItemStack item)
    {
        this.item = item;
    }

    /**
     * 获取物品
     *
     * @return ItemStack
     */
    public ItemStack getItem()
    {
        return this.item;
    }

    /**
     * 获取处理者
     *
     * @return HandlerList
     */
    public HandlerList getHandlers()
    {
        return handlers;
    }

    /**
     * 获取处理者列表
     *
     * @return HandlerList
     */
    public static HandlerList getHandlerList()
    {
        return handlers;
    }
}
