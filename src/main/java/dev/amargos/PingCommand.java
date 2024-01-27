package dev.amargos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            try {
                int ping = getPing(player);
                player.sendMessage("Tu ping es: " + ping + "ms");
            } catch (Exception e) {
                player.sendMessage("No se pudo obtener el ping.");
            }
        } else {
            sender.sendMessage("Este comando solo puede ser ejecutado por un jugador.");
        }
        return true;
    }

    private int getPing(Player player) throws Exception {
        Field entityPlayerField = player.getClass().getDeclaredField("entity");
        Object entityPlayer = entityPlayerField.get(player);
        Field pingField = entityPlayer.getClass().getDeclaredField("ping");
        return pingField.getInt(entityPlayer);
    }
}