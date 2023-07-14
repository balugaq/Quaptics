package org.metamechanists.quaptics.implementation.blocks.upgraders;

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
import org.metamechanists.quaptics.connections.ConnectionGroup;
import org.metamechanists.quaptics.connections.ConnectionPoint;
import org.metamechanists.quaptics.connections.ConnectionPointType;
import org.metamechanists.quaptics.connections.Link;
import org.metamechanists.quaptics.implementation.attachments.PowerAnimatedBlock;
import org.metamechanists.quaptics.implementation.attachments.PowerLossBlock;
import org.metamechanists.quaptics.implementation.base.ConnectedBlock;
import org.metamechanists.quaptics.implementation.blocks.Settings;
import org.metamechanists.quaptics.items.Lore;
import org.metamechanists.quaptics.items.Tier;
import org.metamechanists.quaptics.utils.Utils;
import org.metamechanists.quaptics.utils.id.complex.ConnectionGroupId;
import org.metamechanists.quaptics.utils.id.complex.ConnectionPointId;
import org.metamechanists.quaptics.utils.models.ModelBuilder;
import org.metamechanists.quaptics.utils.models.components.ModelCuboid;
import org.metamechanists.quaptics.utils.models.components.ModelDiamond;

import java.util.List;
import java.util.Optional;


public class DiffractionGrating extends ConnectedBlock implements PowerAnimatedBlock, PowerLossBlock {
    public static final Settings DIFFRACTION_GRATING_1_SETTINGS = Settings.builder()
            .tier(Tier.BASIC)
            .minPower(40)
            .powerLoss(0.05)
            .minFrequency(1.0)
            .maxFrequency(3.0)
            .frequencyMultiplier(2.0)
            .targetPhase(48)
            .targetPhaseSpread(10)
            .build();
    public static final SlimefunItemStack DIFFRACTION_GRATING_1 = new SlimefunItemStack(
            "QP_DIFFRACTION_GRATING_1",
            Material.ORANGE_STAINED_GLASS,
            "&cDiffraction Grating &4I",
            Lore.create(DIFFRACTION_GRATING_1_SETTINGS,
                    "&7● Increases the frequency of a quaptic ray",
                    "&7● The size of the increase depends on how close the",
                    "&7  auxiliary input is to the target phase"));

    private final Vector mainPointLocation = new Vector(0, 0, 0.5);
    private final Vector auxiliaryPointLocation = new Vector(0, 0, 0);
    private final Vector outputPointLocation = new Vector(0, 0, 0.5);

    public DiffractionGrating(final ItemGroup itemGroup, final SlimefunItemStack item, final RecipeType recipeType, final ItemStack[] recipe, final Settings settings) {
        super(itemGroup, item, recipeType, recipe, settings);
    }

    @Override
    protected float getConnectionRadius() {
        return 0;
    }
    @Override
    protected Optional<Location> calculatePointLocationSphere(@NotNull final ConnectionPointId from, @NotNull final ConnectionPointId to) {
        final Optional<ConnectionPoint> point = from.get();
        return point.isPresent() ? point.get().getLocation() : Optional.empty();
    }
    @Override
    protected DisplayGroup initModel(final @NotNull Location location, final @NotNull Player player) {
        return new ModelBuilder()
                .add("main", new ModelCuboid()
                        .material(Material.ORANGE_TERRACOTTA)
                        .facing(player.getFacing())
                        .size(0.2F, 0.2F, 0.5F))
                .add("auxiliary", new ModelCuboid()
                        .material(Material.GRAY_CONCRETE)
                        .size(0.15F, 0.4F, 0.15F)
                        .location(0, 0.2F, 0))
                .add("diamond", new ModelDiamond()
                        .material(settings.getTier().concreteMaterial)
                        .brightness(Utils.BRIGHTNESS_OFF)
                        .size(0.3F))
                .buildAtBlockCenter(location);
    }
    @Override
    protected List<ConnectionPoint> initConnectionPoints(final ConnectionGroupId groupId, final Player player, final Location location) {
        return List.of(
                new ConnectionPoint(ConnectionPointType.INPUT, groupId, "main", formatPointLocation(player, location, mainPointLocation)),
                new ConnectionPoint(ConnectionPointType.INPUT, groupId, "auxiliary", formatPointLocation(player, location, auxiliaryPointLocation)),
                new ConnectionPoint(ConnectionPointType.OUTPUT, groupId, "output", formatPointLocation(player, location, outputPointLocation)));
    }

    @Override
    public void onInputLinkUpdated(@NotNull final ConnectionGroup group, @NotNull final Location location) {
        if (doBurnoutCheck(group, "main") || doBurnoutCheck(group, "auxiliary")) {
            return;
        }

        final Optional<Link> mainLink = getLink(location, "main");
        final Optional<Link> auxiliaryLink = getLink(location, "auxiliary");
        final Optional<Link> outputLink = getLink(location, "output");
        final boolean powered = auxiliaryLink.isPresent() && mainLink.isPresent() && settings.isOperational(mainLink);
        onPoweredAnimation(location, powered);

        if (outputLink.isEmpty()) {
            return;
        }

        if (!powered) {
            outputLink.get().disable();
            return;
        }

        final double newFrequency = calculateFrequency(settings, mainLink.get().getFrequency(), auxiliaryLink.get().getPhase());
        if (Utils.equal(newFrequency, mainLink.get().getFrequency())) {
            outputLink.get().disable();
            onPoweredAnimation(location, false);
            return;
        }

        outputLink.get().setPowerFrequencyPhase(
                PowerLossBlock.calculatePowerLoss(settings, mainLink.get()),
                calculateFrequency(settings, mainLink.get().getFrequency(), auxiliaryLink.get().getPhase()),
                mainLink.get().getPhase());
    }
    @Override
    public void onPoweredAnimation(final Location location, final boolean powered) {
        brightnessAnimation(location, "diamond", powered);
    }

    private static double calculateFrequency(@NotNull final Settings settings, final double frequency, final int phase) {
        final int phaseDifference = Math.abs(phase - settings.getTargetPhase());
        final double targetPhaseDifference = Math.max(settings.getTargetPhaseSpread() - phaseDifference, 0);
        final double targetPhaseProportion = targetPhaseDifference / settings.getTargetPhaseSpread();
        return frequency * (1 + (targetPhaseProportion * (settings.getFrequencyMultiplier() - 1)));
    }
}
