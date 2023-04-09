package com.elchologamer.userlogin.listener;

import com.elchologamer.userlogin.ULPlayer;
import com.elchologamer.userlogin.UserLogin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (UserLogin.getPlugin().getConfig().getStringList("ignoredPlayers").contains(event.getPlayer().getName())) return;

        if (!UserLogin.getPlugin().getConfig().getBoolean("vanillaJoinMessages", !UserLogin.getPlugin().getConfig().getBoolean("disableVanillaJoinMessages", true))) {
            event.setJoinMessage(null);
        }
        ULPlayer.get(event.getPlayer()).onJoin(false);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (UserLogin.getPlugin().getConfig().getStringList("ignoredPlayers").contains(event.getPlayer().getName())) return;

        ULPlayer.get(event.getPlayer()).onQuit();
    }
}