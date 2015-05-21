package com.ItemPlus.Event.Plugin;

import org.bukkit.event.Cancellable;
import org.bukkit.plugin.Plugin;

/**
 * 服务器时间改变事件
 *
 * @author HotFlow
 */
public class PluginTimeChangeEvent extends PluginEvent implements Cancellable
{
    private long time;
    private Boolean cancelled = false;

    public PluginTimeChangeEvent(Plugin plugin, long time)
    {
        super(plugin);
        this.time = time;
    }

    /**
     * 获取时间
     *
     * @return long
     */
    public long getTime()
    {
        return this.time;
    }

    /**
     * 获取时间
     *
     * @param time
     */
    public void setTime(long time)
    {
        this.time = time;
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
