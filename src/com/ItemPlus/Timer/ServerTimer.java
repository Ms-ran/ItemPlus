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

package com.ItemPlus.Timer;

import com.ItemPlus.Core.TimerRunnable;
import com.ItemPlus.Main;

/**
 * 服务器计时器
 *
 * @author HotFlow
 */
public final class ServerTimer
{
    private final TimerRunnable task;
    private long time;

    /**
     * 构造服务器计时器
     */
    public ServerTimer()
    {
        this.task = new TimerRunnable(Main.plugin, this);
        this.time = 0L;
    }

    /**
     * 获取游戏时间
     *
     * @return long
     */
    public long getTime()
    {
        return this.time;
    }

    /**
     * 设置游戏时间
     *
     * @param second 秒
     */
    public void setTime(long second)
    {
        this.time = second;
    }

    /**
     * 获取时间执行器
     *
     * @return ServerRunnable
     */
    public TimerRunnable getTimerRunnable()
    {
        return this.task;
    }

}
