package org.metamechanists.quaptics.implementation.blocks.testing;

import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.metamechanists.quaptics.connections.ConnectionGroup;
import org.metamechanists.quaptics.connections.ConnectionPoint;
import org.metamechanists.quaptics.connections.ConnectionPointType;
import org.metamechanists.quaptics.implementation.blocks.Settings;
import org.metamechanists.quaptics.implementation.blocks.base.ConnectedBlock;
import org.metamechanists.quaptics.items.Lore;
import org.metamechanists.quaptics.items.Tier;
import org.metamechanists.quaptics.utils.BlockStorageAPI;
import org.metamechanists.quaptics.utils.Keys;
import org.metamechanists.quaptics.utils.builders.ItemDisplayBuilder;
import org.metamechanists.quaptics.utils.id.complex.ConnectionGroupId;
import org.metamechanists.quaptics.utils.transformations.TransformationMatrixBuilder;

import java.util.List;

public class OscillatingConcentrator extends ConnectedBlock {
    public static final Settings OSCILLATING_CONCENTRATOR_SETTINGS = Settings.builder()
            .tier(Tier.TESTING)
            .displayRadius(0.45F)
            .connectionRadius(0.45F)
            .emissionPower(1)
            .build();
    public static final SlimefunItemStack OSCILLATING_CONCENTRATOR = new SlimefunItemStack(
            "QP_TESTING_OSCILLATING_CONCENTRATOR",
            Material.BLACK_STAINED_GLASS_PANE,
            "&8Oscillating Concentrator &FI",
            Lore.create(OSCILLATING_CONCENTRATOR_SETTINGS,
                    "&7● Toggles power on/off every tick",
                    "&7● Concentrates epic admin hax into a quaptic ray"));

    private final Vector outputLocation = new Vector(0.0F, 0.0F, settings.getConnectionRadius());
    private final Vector3f mainDisplaySize = new Vector3f(settings.getDisplayRadius()*2);

    public OscillatingConcentrator(final ItemGroup itemGroup, final SlimefunItemStack item, final RecipeType recipeType, final ItemStack[] recipe, final Settings settings) {
        super(itemGroup, item, recipeType, recipe, settings);
    }

    @Override
    protected void initDisplays(@NotNull final DisplayGroup displayGroup, final @NotNull Location location, final @NotNull Player player) {
        displayGroup.addDisplay("main", new ItemDisplayBuilder(location.clone().toCenterLocation())
                .setMaterial(Material.BLACK_STAINED_GLASS_PANE)
                .setTransformation(new TransformationMatrixBuilder()
                        .scale(mainDisplaySize)
                        .rotate((float)(Math.PI/2), 0.0F, settings.getRotationY())
                        .buildForItemDisplay())
                .build());
    }
    @Override
    protected List<ConnectionPoint> initConnectionPoints(final ConnectionGroupId groupId, final Player player, final Location location) {
        return List.of(new ConnectionPoint(ConnectionPointType.OUTPUT, groupId, "output", formatPointLocation(player, location, outputLocation)));
    }

    @Override
    public void onQuapticTick(@NotNull final ConnectionGroup group, @NotNull final Location location) {
        final boolean enabled = isEnabled(location);
        final double power = enabled ? settings.getEmissionPower() : 0;
        getLink(location, "output").ifPresent(link -> link.setPower(power));
        setEnabled(location, !enabled);
    }

    private static boolean isEnabled(final Location location) {
        return BlockStorageAPI.getBoolean(location, Keys.BS_POWERED);
    }
    private static void setEnabled(final Location location, final boolean enabled) {
        BlockStorageAPI.set(location, Keys.BS_POWERED, enabled);
    }
}
