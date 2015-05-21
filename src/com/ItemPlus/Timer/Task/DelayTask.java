package com.ItemPlus.Timer.Task;

/**
 * @author HotFlow
 */
public abstract class DelayTask
{
    private long time;
    private final String description;

    public DelayTask(long time)
    {
        this.time = time;
        this.description = null;
    }

    public DelayTask(long time, String description)
    {
        this.time = time;
        this.description = description;
    }

    /**
     * 执行代码
     */
    public abstract void run();

    /**
     * 获取时间
     *
     * @return
     */
    public long getTime()
    {
        return this.time;
    }

    /**
     * 设置时间
     *
     * @param time
     */
    public void setTime(long time)
    {
        this.time = time;
    }

    /**
     * 获取介绍
     *
     * @return
     */
    public String getDescription()
    {
        return this.description;
    }
}