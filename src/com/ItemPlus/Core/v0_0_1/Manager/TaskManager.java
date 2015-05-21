package com.ItemPlus.Core.v0_0_1.Manager;

import com.ItemPlus.Timer.Task.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * 执行器管理器
 *
 * @author HotFlow
 */
public class TaskManager
{
    private final List<Task> tasks = new ArrayList<Task>();

    /**
     * 获取执行器列表
     *
     * @return List<Task>
     */
    public List<Task> getTasks()
    {
        return this.tasks;
    }
}
