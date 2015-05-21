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

import org.bukkit.event.Cancellable;
import org.bukkit.plugin.Plugin;

/**
 * 服务器时间改变事件
 *
 * @author HotFlow
 */
public class PluginTimeChangeEvent extends PluginEvent implements Cancellable
{
    private long time;
    private Boolean cancelled = false;

    /**
     * 构造服务器时间改变事件
     * @param plugin 插件
     * @param time 时间
     */
    public PluginTimeChangeEvent(Plugin plugin, long time)
    {
        super(plugin);
        this.time = time;
    }

    /**
     * 获取时间
     *
     * @return long
     */
    public long getTime()
    {
        return this.time;
    }

    /**
     * 获取时间
     *
     * @param time 时间
     */
    public void setTime(long time)
    {
        this.time = time;
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
