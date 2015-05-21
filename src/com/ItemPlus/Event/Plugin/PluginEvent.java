package com.ItemPlus.Event.Plugin;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

/**
 * 插件事件
 *
 * @author HotFlow
 */
public class PluginEvent extends Event
{
    private static final HandlerList handlers = new HandlerList();
    private final Plugin plugin;

    public PluginEvent(Plugin plugin)
    {
        this.plugin = plugin;
    }

    /**
     * 获取插件
     *
     * @return Plugin
     */
    public Plugin getPlugin()
    {
        return this.plugin;
    }

    /**
     * 获取处理者
     *
     * @return HandlerList
     */
    public HandlerList getHandlers()
    {
        return handlers;
    }

    /**
     * 获取处理者列表
     *
     * @return HandlerList
     */
    public static HandlerList getHandlerList()
    {
        return handlers;
    }
}
