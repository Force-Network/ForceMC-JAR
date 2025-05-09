package io.papermc.paper.network;

import net.minecraft.server.MinecraftServer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.spigotmc.SpigotConfig;
import java.io.File;
import java.util.logging.Logger;

public final class ForceNetworkController {
    private static final Logger LOGGER = Logger.getLogger("ForceNetworkController");
    public static void enforceSettings(MinecraftServer server){
        File spigotConfig = new File("spigot.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(spigotConfig);
        config.set("settings.bungeecord", true);
        try {
            config.save(spigotConfig);
        }catch (Exception e){
            LOGGER.severe("ForceNetwork Controller: failed to write spigot.yml: " + e.getMessage());
        }
        if (!config.getBoolean("settings.bungeecord")) {
            throw new RuntimeException("ForceNetworkController: BungeeCord mode MUST be enabled.");
        }
    }
}
