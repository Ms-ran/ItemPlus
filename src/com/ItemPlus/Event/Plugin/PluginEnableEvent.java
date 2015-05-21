package com.ItemPlus.Event.Plugin;

import org.bukkit.event.Cancellable;
import org.bukkit.plugin.Plugin;

/**
 * 插件启动事件
 *
 * @author HotFlow
 */
public class PluginEnableEvent extends PluginEvent implements Cancellable
{
    private Boolean cancelled = false;

    public PluginEnableEvent(Plugin plugin)
    {
        super(plugin);
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
