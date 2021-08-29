package com.entiv.bindingcursepatch;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;

public class BindingCursePatch extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        String[] message = {
                "§e§l" + getName() + "§a 插件§e v" + getDescription().getVersion() + " §a已启用",
                "§a插件制作作者:§e EnTIv §aQQ群:§e 600731934"
        };
        Bukkit.getConsoleSender().sendMessage(message);
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        String[] message = {
                "§e§l" + getName() + "§a 插件§e v" + getDescription().getVersion() + " §a已卸载",
                "§a插件制作作者:§e EnTIv §aQQ群:§e 600731934"
        };
        Bukkit.getConsoleSender().sendMessage(message);
    }

    @EventHandler
    public void onEnchant(PrepareAnvilEvent event) {
        ItemStack result = event.getResult();
        Player player = event.getView().getPlayer() instanceof Player ? ((Player) event.getView().getPlayer()) : null;

        if (result == null || player == null) return;

        if (result.getType().getMaxDurability() == 0 && result.getEnchantments().containsKey(Enchantment.BINDING_CURSE)) {
            event.setResult(new ItemStack(Material.AIR));
            player.updateInventory();
        }
    }
}
