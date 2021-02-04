package me.calebtbw.privatemessagesys;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReplyCommand implements CommandExecutor {

    private PrivateMessageSys main;

    public ReplyCommand(PrivateMessageSys main) {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (args.length > 0) {
            if (main.getMessageManager().recentlyMessaged.containsKey(player)) {
                if (main.getMessageManager().recentlyMessaged.get(player) != null) {
                    Player target = main.getMessageManager().recentlyMessaged.get(player);

                    StringBuilder message = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        message.append(args[i]).append(" ");
                    }

                    player.sendMessage(ChatColor.GREEN + "-> " + target.getName() + ChatColor.GRAY + " " + message.toString());
                    target.sendMessage(ChatColor.GREEN + "<- " + player.getName() + ChatColor.GRAY + " " + message.toString());
                } else {
                    player.sendMessage(ChatColor.RED + "That player is not online!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You've not messaged anyone recently.");
            }
        } else {
            player.sendMessage(ChatColor.RED + "Invalid usage! Use /reply <message>.");
        }
        return false;

    }
}