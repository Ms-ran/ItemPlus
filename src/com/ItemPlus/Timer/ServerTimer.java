package com.ItemPlus.Timer;

import com.ItemPlus.Core.ServerRunnable;
import com.ItemPlus.Main;

/**
 * @author HotFlow
 */
public final class ServerTimer
{
    private final ServerRunnable task;
    private long time;

    public ServerTimer()
    {
        this.task = new ServerRunnable(Main.plugin, this);
        this.time = 0L;
    }

    /**
     * 获取游戏时间
     *
     * @return
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
     * @return
     */
    public ServerRunnable getTimerTask()
    {
        return this.task;
    }

}