package net.brnbrd.rottenleather;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Util {
    public static ObjectArrayList<ItemStack> with(ObjectArrayList<ItemStack> before, ItemStack addition) {
        before.add(addition);
        return before;
    }

    public static ObjectArrayList<ItemStack> with(ObjectArrayList<ItemStack> before, Item addition, int count) {
        if (count > 0) {
            before.add(new ItemStack(addition, count));
        }
        return before;
    }
}
