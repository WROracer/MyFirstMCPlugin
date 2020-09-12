package de.wroracer.myfirstmcplugin.util;

import net.minecraft.server.v1_8_R3.Enchantment;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta itemMeta;

    public ItemBuilder(Material material, short subID){
        item = new ItemStack(material, 1, subID);
        itemMeta = item.getItemMeta();
    }

    public ItemBuilder(Material material){
        this(material, (short)0);
    }

    public ItemBuilder setName(String name){
        itemMeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setLore(String... lore){
        itemMeta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder setAmount(int amount){
        item.setAmount(amount);
        return this;
    }

    public ItemStack buid(){
        item.setItemMeta(itemMeta);
        return item;
    }
}
