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

package com.ItemPlus.Event.Plugin;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

/**
 * 插件事件
 *
 * @author HotFlow
 */
public class PluginEvent extends Event
{
    private static final HandlerList handlers = new HandlerList();
    private final Plugin plugin;

    /**
     * 构造插件事件
     * @param plugin 插件 
     */
    public PluginEvent(Plugin plugin)
    {
        this.plugin = plugin;
    }

    /**
     * 获取插件
     *
     * @return Plugin
     */
    public Plugin getPlugin()
    {
        return this.plugin;
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
