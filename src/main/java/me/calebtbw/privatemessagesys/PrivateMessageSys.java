package me.calebtbw.privatemessagesys;

import org.bukkit.plugin.java.JavaPlugin;

public final class PrivateMessageSys extends JavaPlugin {

    /* COMMANDS
     * - message <player> <message>
     * - reply <message>
     */

    private MessageManager manager;

    @Override
    public void onEnable() {
        getLogger().info("PrivateMessageSys v1.0 has been enabled!");

        getCommand("message").setExecutor(new MessageCommand(this));
        getCommand("reply").setExecutor(new ReplyCommand(this));

        manager = new MessageManager(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("PrivateMessageSys v1.0 has been disabled!");
    }

    public MessageManager getMessageManager() { return manager; }


}
