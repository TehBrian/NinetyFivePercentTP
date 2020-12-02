package xyz.tehbrian.ninetyfivepercenttp.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class RTPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            World world = player.getWorld();

            // TODO Bounds configurable in config.yml
            Random random = new Random();
            int x = random.nextInt(10000) - 5000;
            int z = random.nextInt(10000) - 5000;
            int y = world.getHighestBlockAt(x, z).getY();
            Location location = new Location(world, x, y, z);

            player.teleport(location);
            // Now, was that so hard?
        }
        return true;
    }
}
