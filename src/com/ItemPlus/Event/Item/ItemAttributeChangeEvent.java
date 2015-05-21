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

    /**
     * 构造物品属性变动事件
     * @param item 物品
     * @param attribute 属性 
     */
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
