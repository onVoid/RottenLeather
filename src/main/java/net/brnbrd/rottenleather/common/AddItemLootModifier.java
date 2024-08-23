package net.brnbrd.rottenleather.common;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.brnbrd.rottenleather.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class AddItemLootModifier extends LootModifier {
    public static final Codec<AddItemLootModifier> CODEC = RecordCodecBuilder.create(inst -> codecStart(inst)
            .and(ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(g -> g.item))
            .and(Codec.INT.fieldOf("minAmount").forGetter(g -> g.minAmount))
            .and(Codec.INT.fieldOf("maxAmount").forGetter(g -> g.maxAmount))
            .apply(inst, AddItemLootModifier::new));
    protected final Item item;
    protected final int minAmount;
    protected final int maxAmount;

    public AddItemLootModifier(LootItemCondition[] conditions, Item item, int minAmount, int maxAmount) {
        super(conditions);
        this.item = item;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (this.maxAmount < 1 || this.maxAmount < this.minAmount) {
            return generatedLoot;
        }
        return Util.with(generatedLoot, this.item, (this.minAmount == this.maxAmount) ?
            this.minAmount : context.getRandom().nextIntBetweenInclusive(this.minAmount, this.maxAmount)
        );
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return RottenLeatherLootModifiers.ADD_ITEM.get();
    }
}