/*
 * Copyright (C) 2015 HotFlow
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
