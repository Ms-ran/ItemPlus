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
