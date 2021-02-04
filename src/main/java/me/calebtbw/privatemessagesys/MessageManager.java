package me.calebtbw.privatemessagesys;


import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessageManager {

    private PrivateMessageSys main;

    public MessageManager(PrivateMessageSys main) {
        this.main = main;
    }

    public HashMap<Player, Player> recentlyMessaged = new HashMap<>();
}
