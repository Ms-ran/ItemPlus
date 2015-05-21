package com.ItemPlus.Core;

import com.ItemPlus.Event.Plugin.PluginDelayTaskRunEvent;
import com.ItemPlus.Event.Plugin.PluginDelayTaskTimeChangeEvent;
import com.ItemPlus.Event.Plugin.PluginTimeChangeEvent;
import com.ItemPlus.Main;
import com.ItemPlus.Timer.ServerTimer;
import com.ItemPlus.Timer.Task.DelayTask;
import com.ItemPlus.Timer.TaskState;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.plugin.Plugin;

/**
 * @author HotFlow
 */
public final class ServerRunnable
{
    private final int taskID;
    private TaskState taskState;

    public ServerRunnable(final Plugin plugin, final ServerTimer timer)
    {
        this.taskState = TaskState.Suspending;

        int taskID = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
        {
            @Override
            public void run()
            {
                if (taskState.equals(TaskState.Running))
                {
                    PluginTimeChangeEvent event = new PluginTimeChangeEvent(plugin, timer.getTime() + 1);
                    getServer().getPluginManager().callEvent(event);

                    if (event.isCancelled())
                    {
                        return;
                    }

                    timer.setTime(event.getTime());

                    for (int i = 0; i < Main.getTaskManager().getDelayTaskManager().getTasks().size(); i++)
                    {
                        DelayTask task = Main.getTaskManager().getDelayTaskManager().getTasks().get(i);

                        if (task.getTime() > 0)
                        {
                            PluginDelayTaskTimeChangeEvent event1 = new PluginDelayTaskTimeChangeEvent(plugin, task, timer.getTime());
                            getServer().getPluginManager().callEvent(event1);

                            if (event1.isCancelled())
                            {
                                continue;
                            }

                            task.setTime(task.getTime() - 1L);
                        }
                        else
                        {
                            PluginDelayTaskRunEvent event1 = new PluginDelayTaskRunEvent(plugin, task, timer.getTime());
                            getServer().getPluginManager().callEvent(event1);

                            if (event1.isCancelled())
                            {
                                continue;
                            }

                            task.run();
                            Main.getTaskManager().getDelayTaskManager().getTasks().remove(task);
                        }
                    }
                }
                else
                {
                    return;
                }
            }

        }, 0L, 20L);

        this.taskID = taskID;
    }

    /**
     * 开始计时
     */
    public void start()
    {
        this.taskState = TaskState.Running;
    }

    /**
     * 暂停计时
     */
    public void suspend()
    {
        this.taskState = TaskState.Suspending;
    }

    /**
     * 清除计时器
     */
    public void clear()
    {
        getServer().getScheduler().cancelTask(this.taskID);
    }

    /**
     * 获取执行器当前状态
     *
     * @return
     */
    public TaskState getCurrentState()
    {
        return this.taskState;
    }

    /**
     * 获取时间执行器ID
     *
     * @return
     */
    public int getTaskID()
    {
        return this.taskID;
    }
}
