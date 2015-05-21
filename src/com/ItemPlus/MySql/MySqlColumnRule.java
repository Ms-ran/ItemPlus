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

package com.ItemPlus.MySql;

/**
 * MySql列规则
 *
 * @author HotFlow
 */
public enum MySqlColumnRule
{
    PrimaryKey("Primary Key"),
    NotNull("Not Null"),
    Unique("Unique"),
    Binary("Binary"),
    Unsigned("Unsigned"),
    ZeroFill("Zero Fill"),
    AutoIncrement("Auto Increment");

    public String name;

    private MySqlColumnRule(String name)
    {
        this.name = name;
    }
}
