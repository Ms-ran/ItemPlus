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

package com.ItemPlus.Timer.Task;

/**
 * 执行器接口
 *
 * @author HotFlow
 */
public interface Task
{
    public abstract void run();

    /**
     * 获取时间
     *
     * @return long
     */
    public long getTime();

    /**
     * 设置时间
     *
     * @param time 时间
     */
    public void setTime(long time);

    /**
     * 获取介绍
     *
     * @return String
     */
    public String getDescription();

    /**
     * 移除执行器
     */
    public void remove();
}
