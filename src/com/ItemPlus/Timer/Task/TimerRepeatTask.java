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
 * 延时重复执行器
 *
 * @author HotFlow
 */
public abstract class TimerRepeatTask implements Task
{
    private long time;
    private final long defaultTime;
    private final String description;

    /**
     * 构造延时重复执行器
     *
     * @param time 间隔
     */
    public TimerRepeatTask(long time)
    {
        this(time, null);
    }

    /**
     * 构造延时重复执行器
     *
     * @param time 间隔
     * @param description 介绍
     */
    public TimerRepeatTask(long time, String description)
    {
        this.time = time;
        this.defaultTime = time;
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

    /**
     * 获取默认时间
     *
     * @return long
     */
    public long getDefaultTime()
    {
        return this.defaultTime;
    }
}
