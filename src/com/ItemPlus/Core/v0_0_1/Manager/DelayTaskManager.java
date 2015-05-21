package com.ItemPlus.Core.v0_0_1.Manager;

import com.ItemPlus.Timer.Task.DelayTask;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HotFlow
 */
public final class DelayTaskManager
{
    private final List<DelayTask> tasks = new ArrayList<DelayTask>();

    /**
     * 获取延时执行器列表
     *
     * @return
     */
    public List<DelayTask> getTasks()
    {
        return this.tasks;
    }
}
