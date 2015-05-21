package com.ItemPlus;

import com.ItemPlus.Core.v0_0_1.Manager.LoggerManager;
import com.ItemPlus.Core.v0_0_1.Manager.TaskManager;
import com.ItemPlus.Event.Plugin.PluginDisableEvent;
import com.ItemPlus.Event.Plugin.PluginEnableEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author HotFlow
 */
public class Main extends JavaPlugin
{
    public static Main plugin;
    public static String prefix = "[ItemPlus] ";
    public static final LoggerManager logger = new LoggerManager();
    private static final TaskManager taskManager = new TaskManager();

    @Override
    public void onEnable()
    {
        PluginEnableEvent event = new PluginEnableEvent(this);
        getServer().getPluginManager().callEvent(event);

        if (event.isCancelled())
        {
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }

    @Override
    public void onDisable()
    {
        PluginDisableEvent event = new PluginDisableEvent(this);
        getServer().getPluginManager().callEvent(event);
    }

    /**
     * 获取执行器管理器
     *
     * @return TaskManager
     */
    public static TaskManager getTaskManager()
    {
        return Main.taskManager;
    }
}
