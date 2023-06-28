package org.metamechanists.quaptics.implementation.blocks.manipulators;

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
import org.metamechanists.quaptics.connections.points.ConnectionPoint;
import org.metamechanists.quaptics.connections.points.ConnectionPointInput;
import org.metamechanists.quaptics.connections.points.ConnectionPointOutput;
import org.metamechanists.quaptics.implementation.base.ConnectedBlock;
import org.metamechanists.quaptics.utils.Transformations;
import org.metamechanists.quaptics.utils.builders.BlockDisplayBuilder;
import org.metamechanists.quaptics.utils.id.ConnectionGroupID;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Combiner extends ConnectedBlock {
    private final int connections;
    private final Vector outputLocation = new Vector(0.0F, 0.0F, radius);
    private final Vector3f mainDisplaySize = new Vector3f(radius*1.8F, radius*1.8F, radius*1.8F);
    private final Vector3f mainDisplayRotation = new Vector3f((float)(Math.PI/4), (float)(Math.PI/4), 0);
    private final double powerLoss;

    public Combiner(ItemGroup group, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,
                    float radius, int connections, double maxPower, double powerLoss) {
        super(group, item, recipeType, recipe, radius, maxPower);
        this.connections = connections;
        this.powerLoss = powerLoss;
    }

    @Override
    protected void addDisplays(@NotNull DisplayGroup displayGroup, @NotNull Location location, Player player) {
        displayGroup.addDisplay("main", new BlockDisplayBuilder(location.clone().add(RELATIVE_CENTER))
                        .setMaterial(Material.GRAY_STAINED_GLASS)
                        .setTransformation(Transformations.rotateAndScale(mainDisplaySize, mainDisplayRotation))
                        .build());
    }

    @Override
    protected List<ConnectionPoint> generateConnectionPoints(ConnectionGroupID groupID, Player player, Location location) {
        final List<ConnectionPoint> points = new ArrayList<>();

        IntStream.range(0, connections).forEach(i -> {
            final String name = "input " + Objects.toString(i);
            final double angle = (-Math.PI / 8) + (Math.PI / 4) * ((double) (i) / connections);
            final Vector relativeLocation = new Vector(0.0F, 0.0F, -radius).rotateAroundY(angle);
            points.add(new ConnectionPointOutput(groupID, name, formatPointLocation(player, location, relativeLocation)));
        });

        points.add(new ConnectionPointOutput(groupID, "output", formatPointLocation(player, location, outputLocation)));
        return points;
    }

    @Override
    public void onInputLinkUpdated(@NotNull ConnectionGroup group) {
        final List<ConnectionPointInput> inputs = IntStream.range(0, connections)
                .mapToObj(i -> (ConnectionPointInput) group.getPoint("input " + Objects.toString(i)))
                .toList();
        final ConnectionPointOutput output = (ConnectionPointOutput) group.getPoint("output");

        inputs.forEach(input -> doBurnoutCheck(group, input));

        if (!output.hasLink()) {
            return;
        }

        final List<ConnectionPointInput> poweredInputs = inputs.stream()
                .filter(input -> input.hasLink() && input.getLink().isEnabled())
                .toList();
        if (poweredInputs.isEmpty()) {
            output.getLink().setEnabled(false);
            return;
        }

        final double inputPower = poweredInputs.stream()
                .mapToDouble(input -> input.getLink().getPower())
                .sum();

        output.getLink().setPower(powerLoss(inputPower, powerLoss));
        output.getLink().setEnabled(true);
    }

    @Override
    protected @NotNull Material getBaseMaterial() {
        return Material.STRUCTURE_VOID;
    }
}
