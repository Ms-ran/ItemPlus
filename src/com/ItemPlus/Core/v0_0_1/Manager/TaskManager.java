package com.ItemPlus.Core.v0_0_1.Manager;

/**
 * @author HotFlow
 */
public class TaskManager
{
    private final DelayTaskManager delayTaskManager = new DelayTaskManager();

    /**
     * 获取延时执行器管理器
     *
     * @return
     */
    public DelayTaskManager getDelayTaskManager()
    {
        return this.delayTaskManager;
    }
}
