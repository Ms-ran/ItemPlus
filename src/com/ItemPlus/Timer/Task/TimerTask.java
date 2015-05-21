package com.ItemPlus.Timer.Task;

import com.ItemPlus.Main;

/**
 * @author HotFlow
 */
public abstract class TimerTask implements Task
{
    private long time;
    private final String description;

    public TimerTask(long time)
    {
        this(time, null);
    }

    public TimerTask(long time, String description)
    {
        this.time = time;
        this.description = description;
    }

    public long getTime()
    {
        return this.time;
    }

    public void setTime(long time)
    {
        this.time = time;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void remove()
    {
        Main.getTaskManager().getTasks().remove(this);
    }
}
