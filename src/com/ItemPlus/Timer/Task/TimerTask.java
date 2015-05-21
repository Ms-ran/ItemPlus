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
