package me.cheese.obfusdeath;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

public class ObfuscateDeathMessages extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        getLogger().info("ObfuscateDeathMessages enabled.");
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        String msg = event.getDeathMessage();
        if (msg == null) return;

        Player victim = event.getEntity();
        LivingEntity damager = null;

        // Killer is a player
        if (victim.getKiller() != null) {
            damager = victim.getKiller();
        }

        // Killer is a mob / projectile owner etc.
        else if (victim.getLastDamageCause() != null) {
            Entity damagedBy = victim.getLastDamageCause().getEntity();
            if (damagedBy instanceof LivingEntity le) {
                damager = le;
            }
        }

        if (damager == null) return;

        // Bypass permission
        if (damager instanceof Player p && p.hasPermission("obfusdeath.bypass")) {
            return;
        }

        boolean invisible;

        if (damager instanceof Player p) {
            invisible = p.hasPotionEffect(PotionEffectType.INVISIBILITY);
        } else {
            invisible = damager.isInvisible();
        }

        if (!invisible) return;

        // Config text
        String pattern = getConfig().getString("obfuscation-format", "&k????&r");

        String realName = (damager instanceof Player p) ? p.getName() : damager.getName();

        // Replace placeholder
        String obfuscated = pattern.replace("%name%", realName);

        // Convert & color codes
        obfuscated = ChatColor.translateAlternateColorCodes('&', obfuscated);

        // Replace in message
        event.setDeathMessage(msg.replace(realName, obfuscated));
    }
}
