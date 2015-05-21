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
     * @param second
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
