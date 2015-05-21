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

import com.ItemPlus.Timer.Task.Task;
import org.bukkit.event.Cancellable;
import org.bukkit.plugin.Plugin;

/**
 * 执行器触发事件
 *
 * @author HotFlow
 */
public class PluginTaskFireEvent extends PluginEvent implements Cancellable
{
    private final Task task;
    private final long time;
    private Boolean cancelled = false;

    /**
     * 构造执行器触发事件
     * @param plugin 插件
     * @param task 执行器
     * @param time 时间
     */
    public PluginTaskFireEvent(Plugin plugin, Task task, long time)
    {
        super(plugin);
        this.task = task;
        this.time = time;
    }

    /**
     * 获取延时执行器
     *
     * @return Task
     */
    public Task getTask()
    {
        return this.task;
    }

    /**
     * 获取执行器时间
     *
     * @return long
     */
    public long getTime()
    {
        return this.time;
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
