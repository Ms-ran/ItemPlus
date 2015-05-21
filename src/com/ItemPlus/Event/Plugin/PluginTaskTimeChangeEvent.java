package com.ItemPlus.Event.Plugin;

import com.ItemPlus.Timer.Task.Task;
import org.bukkit.event.Cancellable;
import org.bukkit.plugin.Plugin;

/**
 * 执行器时间改变事件
 *
 * @author HotFlow
 */
public class PluginTaskTimeChangeEvent extends PluginEvent implements Cancellable
{
    private final Task task;
    private final long time;
    private Boolean cancelled = false;

    /**
     * 构造执行器时间改变事件
     * @param plugin 插件
     * @param task 执行器
     * @param time 时间
     */
    public PluginTaskTimeChangeEvent(Plugin plugin, Task task, long time)
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