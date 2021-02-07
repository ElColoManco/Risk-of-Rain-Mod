package com.elcolomanco.riskofrainmod.items;

import java.util.List;
import java.util.Random;

import com.elcolomanco.riskofrainmod.setup.ModSetup;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class LensMakersGlassesItem extends Item {
	
	private static int ammount;
	private static double chance;
	private static int random;
	private static Random rand = new Random();
	
	public LensMakersGlassesItem(Properties properties) {
		super(new Item.Properties()
				.maxStackSize(64)
				.group(ModSetup.RIKSOFRAIN_GROUP));
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.riskofrainmod.lens_makers_glasses.tooltip1"));
		tooltip.add(new TranslationTextComponent("item.riskofrainmod.lens_makers_glasses.tooltip2"));
		tooltip.add(new TranslationTextComponent("item.riskofrainmod.lens_makers_glasses.tooltip3"));
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		ammount = stack.getCount();
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	public static int getAmmount() {
		return ammount;
	}
	
	public static double getChance() {
		if (ammount > 0) {
			chance = (6.25 * ammount) -1;
		}
		return chance;
	}
	
	public static int getRandomCrit() {
		random = rand.nextInt(99);
		return random;
	}
}
