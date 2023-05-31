package de.c3kay.NoKaboom;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public class NoKaboom extends JavaPlugin implements Listener {

    @Override
    public void onDisable() {
        getLogger().info("NoKaboom disabled");
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        // copy embedded config if needed
        saveDefaultConfig();

        getLogger().info("NoKaboom " + getDescription().getVersion() + " enabled");
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent e) {
        final Map<EntityType, String> explosiveEntities = Map.of(
                EntityType.PRIMED_TNT, "tnt",
                EntityType.MINECART_TNT, "tnt",
                EntityType.ENDER_CRYSTAL, "endercrystal",
                EntityType.CREEPER, "creeper",
                EntityType.FIREBALL, "ghast",
                EntityType.WITHER, "wither",
                EntityType.WITHER_SKULL, "wither"
        );

        final EntityType explodedEntity = e.getEntityType();

        if (
                explosiveEntities.containsKey(explodedEntity)
                && !getConfig().getBoolean(explosiveEntities.get(explodedEntity), false)
        ) {
            e.setCancelled(true);

            // this is only for the sound and animation
            // unfortunately the animation is really small with power = 0
            // TODO: does the power of explosions stack?
            e.getEntity().getWorld().createExplosion(e.getLocation(), 0F, false, false);

            getLogger().info("Canceled explosion of " + explodedEntity);
        }
    }
}
