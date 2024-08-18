package me.lukiiy.DCBAchiev;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        DCBAdvancement.getInstance().setupConfig();
        commandSender.sendMessage("§a" + DCBAdvancement.getInstance().getName() + " Reload complete.");
        return true;
    }
}
