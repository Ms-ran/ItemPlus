/*
 * Copyright (C) 2015 HotFlow
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ItemPlus.Core;

import com.ItemPlus.Event.Plugin.PluginTaskFireEvent;
import com.ItemPlus.Event.Plugin.PluginTaskTimeChangeEvent;
import com.ItemPlus.Event.Plugin.PluginTimeChangeEvent;
import com.ItemPlus.Main;
import com.ItemPlus.Timer.ServerTimer;
import com.ItemPlus.Timer.Task.Task;
import com.ItemPlus.Timer.Task.TimerRepeatTask;
import com.ItemPlus.Timer.Task.TimerTask;
import com.ItemPlus.Timer.TimerState;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.plugin.Plugin;

/**
 * 时间运行器
 *
 * @author HotFlow
 */
public final class TimerRunnable
{
    private final int taskID;
    private TimerState taskState;

    /**
     * 构造时间运行器
     * @param plugin 插件
     * @param timer 服务器计时器
     */
    public TimerRunnable(final Plugin plugin, final ServerTimer timer)
    {
        this.taskState = TimerState.Suspending;

        int taskID = getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
        {
            @Override
            public void run()
            {
                if (taskState.equals(TimerState.Running))
                {
                    PluginTimeChangeEvent event = new PluginTimeChangeEvent(plugin, timer.getTime() + 1);
                    getServer().getPluginManager().callEvent(event);

                    if (event.isCancelled())
                    {
                        return;
                    }

                    timer.setTime(event.getTime());

                    for (int i = 0; i < Main.getTaskManager().getTasks().size(); i++)
                    {
                        Task task = Main.getTaskManager().getTasks().get(i);

                        if (task.getTime() > 0)
                        {
                            PluginTaskTimeChangeEvent event1 = new PluginTaskTimeChangeEvent(plugin, task, timer.getTime());
                            getServer().getPluginManager().callEvent(event1);

                            if (event1.isCancelled())
                            {
                                continue;
                            }

                            task.setTime(task.getTime() - 1L);
                        }
                        else
                        {
                            PluginTaskFireEvent event1 = new PluginTaskFireEvent(plugin, task, timer.getTime());
                            getServer().getPluginManager().callEvent(event1);

                            if (event1.isCancelled())
                            {
                                continue;
                            }

                            task.run();
                            
                            
                            if (task instanceof TimerTask)
                            {
                                task.remove();
                            }
                            else if(task instanceof TimerRepeatTask)
                            {
                                TimerRepeatTask repeatTask = (TimerRepeatTask) task;
                                repeatTask.setTime(repeatTask.getDefaultTime());
                            }
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
        this.taskState = TimerState.Running;
    }

    /**
     * 暂停计时
     */
    public void suspend()
    {
        this.taskState = TimerState.Suspending;
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
     * @return TaskState
     */
    public TimerState getCurrentState()
    {
        return this.taskState;
    }

    /**
     * 获取时间执行器ID
     *
     * @return Integer
     */
    public int getTaskID()
    {
        return this.taskID;
    }
}
