package com.ItemPlus.Event.Plugin;

import org.bukkit.plugin.Plugin;

/**
 * 插件关闭事件
 *
 * @author HotFlow
 */
public class PluginDisableEvent extends PluginEvent
{

    public PluginDisableEvent(Plugin plugin)
    {
        super(plugin);
    }

}
