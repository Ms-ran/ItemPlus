package com.ItemPlus.Attribute;

import java.util.UUID;
import javax.annotation.Nonnull;

/**
 * @author HotFlow
 */
public interface Attribute
{
    /**
     * 获取名字
     *
     * @return
     */
    public String getName();

    /**
     * 设置名字
     *
     * @param name
     */
    public void setName(String name);

    /**
     * 获取类型
     *
     * @return
     */
    public Attribute getType();

    /**
     * 获取操作方式
     *
     * @return
     */
    public int getOperation();

    /**
     * 设置操作方式
     * 增加数值(0)/乘以百分比(1)/增加百分比(2)
     *
     * @param operation
     */
    public void setOperation(int operation);

    /**
     * 获取数据
     *
     * @return
     */
    public Object getAmount();

    /**
     * 设置数据
     *
     * @param amount
     */
    public void setAmount(Object amount);

    /**
     * 获取UUID
     *
     * @return
     */
    public UUID getUUID();

    /**
     * 设置UUID
     *
     * @param id
     */
    public void setUUID(@Nonnull UUID id);
}
