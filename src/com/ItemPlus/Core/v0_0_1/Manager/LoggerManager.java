package com.ItemPlus.Core.v0_0_1.Manager;

import java.util.logging.Logger;

/**
 * @author HotFlow
 */
public final class LoggerManager
{
    private static final Logger logger = Logger.getLogger("Minecraft");

    /**
     * 获取Logger
     *
     * @return
     */
    public Logger getLogger()
    {
        return Logger.getLogger("Minecraft");
    }

    /**
     * 获取Logger
     *
     * @param name
     * @return
     */
    public Logger getLogger(String name)
    {
        return Logger.getLogger(name);
    }

    /**
     * 获取Logger
     *
     * @param name
     * @param resourceBundleName
     * @return
     */
    public Logger getLogger(String name, String resourceBundleName)
    {
        return Logger.getLogger(name, resourceBundleName);
    }
}