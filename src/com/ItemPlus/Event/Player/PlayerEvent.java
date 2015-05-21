package com.ItemPlus.Event.Player;

import com.ItemPlus.Player.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * 玩家事件
 *
 * @author HotFlow
 */
public class PlayerEvent extends Event
{
    private static final HandlerList handlers = new HandlerList();
    private final Player player;

    /**
     * 构造玩家事件
     * @param player 玩家
     */
    public PlayerEvent(Player player)
    {
        this.player = player;
    }

    /**
     * 获取玩家
     *
     * @return Player
     */
    public Player getPlayer()
    {
        return this.player;
    }

    /**
     * 获取处理者
     *
     * @return HandlerList
     */
    public HandlerList getHandlers()
    {
        return handlers;
    }

    /**
     * 获取处理者列表
     *
     * @return HandlerList
     */
    public static HandlerList getHandlerList()
    {
        return handlers;
    }
}
