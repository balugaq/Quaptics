package org.metamechanists.quaptics.implementation.multiblocks.beacons.modules.player;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.metamechanists.quaptics.implementation.multiblocks.beacons.controllers.BeaconController;
import org.metamechanists.quaptics.implementation.multiblocks.beacons.modules.BeaconModule;
import org.metamechanists.quaptics.implementation.Settings;
import org.metamechanists.quaptics.implementation.multiblocks.beacons.modules.PlayerModule;
import org.metamechanists.quaptics.items.Lore;
import org.metamechanists.quaptics.items.Tier;
import org.metamechanists.quaptics.storage.QuapticTicker;
import org.metamechanists.quaptics.utils.Colors;

import java.util.Collection;


public class LuckModule extends BeaconModule implements PlayerModule {
    public static final Settings LUCK_MODULE_1_SETTINGS = Settings.builder()
            .tier(Tier.INTERMEDIATE)
            .operatingPowerHidden(true)
            .luckLevel(2)
            .build();
    public static final Settings LUCK_MODULE_2_SETTINGS = Settings.builder()
            .tier(Tier.ADVANCED)
            .operatingPowerHidden(true)
            .luckLevel(4)
            .build();

    public static final SlimefunItemStack LUCK_MODULE_1 = getBanner(new SlimefunItemStack(
            "QP_LUCK_MODULE_1",
            Material.YELLOW_BANNER,
            Colors.BEACONS.getFormattedColor() + "幸运模组 &dI",
            Lore.create(LUCK_MODULE_1_SETTINGS)));
    public static final SlimefunItemStack LUCK_MODULE_2 = getBanner(new SlimefunItemStack(
            "QP_LUCK_MODULE_2",
            Material.ORANGE_BANNER,
            Colors.BEACONS.getFormattedColor() + "幸运模组 &dII",
            Lore.create(LUCK_MODULE_2_SETTINGS)));

    public LuckModule(final ItemGroup itemGroup, final SlimefunItemStack item, final RecipeType recipeType, final ItemStack[] recipe, final Settings settings) {
        super(itemGroup, item, recipeType, recipe, settings);
    }

    private static @NotNull SlimefunItemStack getBanner(final @NotNull SlimefunItemStack stack) {
        final BannerMeta meta = (BannerMeta) stack.getItemMeta();
        meta.addPattern(new Pattern(DyeColor.LIME, PatternType.FLOWER));
        meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        stack.setItemMeta(meta);
        return stack;
    }

    @Override
    public void apply(final @NotNull BeaconController controller, final @NotNull Location controllerLocation, final @NotNull Collection<Player> players) {
        players.forEach(player -> player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, QuapticTicker.INTERVAL_TICKS_22 + 20, settings.getLuckLevel()-1)));
    }
}
