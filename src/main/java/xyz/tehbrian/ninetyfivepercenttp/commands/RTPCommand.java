package xyz.tehbrian.ninetyfivepercenttp.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.tehbrian.ninetyfivepercenttp.NinetyFivePercentTP;

import java.util.Random;

public class RTPCommand implements CommandExecutor {

    private final NinetyFivePercentTP main;

    public RTPCommand(NinetyFivePercentTP main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            FileConfiguration config = main.getConfig();
            Player player = (Player) sender;
            World world = player.getWorld();

            int xOrigin = config.getInt("origin.x");
            int zOrigin = config.getInt("origin.z");
            int bound = config.getInt("bound");

            Random random = new Random();
            // I failed math class, so this should work alright.
            int x = xOrigin + (random.nextInt(bound * 2) - bound);
            int z = zOrigin + (random.nextInt(bound * 2) - bound);
            int y = world.getHighestBlockAt(x, z).getY();
            Location location = new Location(world, x, y, z);

            player.teleportAsync(location);
            // Now, was that so hard?
        }
        return true;
    }
}
