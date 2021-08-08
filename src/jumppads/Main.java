package jumppads;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        System.out.println("JumpPad in");
    }

    public void onDisable() {
        System.out.println("JumpPad out");
    }

    @EventHandler
    public void jumpPad(PlayerMoveEvent event) {
        Player p = (Player) event.getPlayer();
        Location loc = event.getPlayer().getLocation().clone();
        if (loc.getBlock().getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE) {
            p.setVelocity(p.getLocation().getDirection().multiply(2).setY(2));
        }

    }
}