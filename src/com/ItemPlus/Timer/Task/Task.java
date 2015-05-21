package com.ItemPlus.Timer.Task;

/**
 * 执行器接口
 *
 * @author HotFlow
 */
public interface Task
{
    public abstract void run();

    /**
     * 获取时间
     *
     * @return long
     */
    public long getTime();

    /**
     * 设置时间
     *
     * @param time
     */
    public void setTime(long time);

    /**
     * 获取介绍
     *
     * @return String
     */
    public String getDescription();

    /**
     * 移除执行器
     */
    public void remove();
}
