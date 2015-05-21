package com.ItemPlus.Event.Player;

import com.ItemPlus.Player.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author HotFlow
 */
public class PlayerEvent extends Event
{
    private static final HandlerList handlers = new HandlerList();
    private final Player player;

    public PlayerEvent(Player player)
    {
        this.player = player;
    }

    /**
     * 获取玩家
     *
     * @return
     */
    public Player getPlayer()
    {
        return this.player;
    }

    /**
     * 获取处理者
     *
     * @return
     */
    public HandlerList getHandlers()
    {
        return handlers;
    }

    /**
     * 获取处理者列表
     *
     * @return
     */
    public static HandlerList getHandlerList()
    {
        return handlers;
    }
}
