package com.ItemPlus.Event.Plugin;

import com.ItemPlus.Timer.Task.Task;
import org.bukkit.event.Cancellable;
import org.bukkit.plugin.Plugin;

/**
 * @author HotFlow
 */
public class PluginTaskFireEvent extends PluginEvent implements Cancellable
{
    private final Task task;
    private final long time;
    private Boolean cancelled = false;

    public PluginTaskFireEvent(Plugin plugin, Task task, long time)
    {
        super(plugin);
        this.task = task;
        this.time = time;
    }

    /**
     * 获取延时执行器
     *
     * @return
     */
    public Task getTask()
    {
        return this.task;
    }

    /**
     * 获取服务器时间
     *
     * @return
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