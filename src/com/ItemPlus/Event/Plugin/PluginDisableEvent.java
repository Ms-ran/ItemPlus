package com.ItemPlus.Event.Plugin;

import org.bukkit.plugin.Plugin;

/**
 * 插件卸载事件
 *
 * @author HotFlow
 */
public class PluginDisableEvent extends PluginEvent
{

    /**
     * 构造插件卸载事件
     * @param plugin 插件
     */
    public PluginDisableEvent(Plugin plugin)
    {
        super(plugin);
    }

}
