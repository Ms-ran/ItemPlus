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

package com.ItemPlus.Attribute;

import java.util.UUID;
import javax.annotation.Nonnull;

/**
 * 属性接口
 *
 * @author HotFlow
 */
public interface Attribute
{
    /**
     * 获取名字
     *
     * @return String
     */
    public String getName();

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name);

    /**
     * 获取类型
     *
     * @return Attribute
     */
    public Attribute getType();

    /**
     * 获取类型字符串(用于保存进NBT的字符串)
     *
     * @return String
     */
    public String getTypeString();

    /**
     * 获取操作方式
     *
     * @return Integer
     */
    public int getOperation();

    /**
     * 设置操作方式 增加数值(0)/乘以百分比(1)/增加百分比(2)
     *
     * @param operation 操作方式
     */
    public void setOperation(int operation);

    /**
     * 获取数据
     *
     * @return Object
     */
    public Object getAmount();

    /**
     * 设置数据
     *
     * @param amount 数据
     */
    public void setAmount(Object amount);

    /**
     * 获取UUID
     *
     * @return UUID
     */
    public UUID getUUID();

    /**
     * 设置UUID
     *
     * @param id UUID
     */
    public void setUUID(@Nonnull UUID id);
}
