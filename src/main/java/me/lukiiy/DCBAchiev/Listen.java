package me.lukiiy.DCBAchiev;

import me.lukiiy.discordBridge.DCBridge;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class Listen implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void done(PlayerAdvancementDoneEvent e) {
        Advancement advancement = e.getAdvancement();
        AdvancementDisplay display = advancement.getDisplay();

        if (display == null || !display.shouldAnnounceChat()) return;
        String msg = DCBAdvancement.confString("msg." + display.getType().toString().toLowerCase())
                .replace("(user)", e.getPlayer().getName())
                .replace("(achievement)", display.getTitle());

        DCBridge.sendDCMsg(msg);
    }
}
