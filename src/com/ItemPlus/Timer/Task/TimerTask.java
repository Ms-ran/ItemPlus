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

package com.ItemPlus.Timer.Task;

import com.ItemPlus.Main;

/**
 * 延时执行器
 *
 * @author HotFlow
 */
public abstract class TimerTask implements Task
{
    private long time;
    private final String description;

    /**
     * 构造延时执行器
     * @param time 延时
     */
    public TimerTask(long time)
    {
        this(time, null);
    }

    /**
     * 构造延时执行器
     * @param time 延时
     * @param description 介绍 
     */
    public TimerTask(long time, String description)
    {
        this.time = time;
        this.description = description;
    }

    public long getTime()
    {
        return this.time;
    }

    public void setTime(long time)
    {
        this.time = time;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void remove()
    {
        Main.getTaskManager().getTasks().remove(this);
    }
}
