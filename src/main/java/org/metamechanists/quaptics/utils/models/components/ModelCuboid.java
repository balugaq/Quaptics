package org.metamechanists.quaptics.utils.models.components;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.BlockDisplay;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.metamechanists.quaptics.utils.builders.BlockDisplayBuilder;
import org.metamechanists.quaptics.utils.transformations.TransformationMatrixBuilder;


@SuppressWarnings("unused")
public class ModelCuboid implements ModelComponent {
    private final BlockDisplayBuilder main = new BlockDisplayBuilder();

    private Vector3f location = new Vector3f();
    private Vector3f size = new Vector3f();
    private Vector3d rotation = new Vector3d();

    /**
     * @param location The center of the cuboid
     */
    public ModelCuboid location(@NotNull final Vector3f location) {
        this.location = location;
        return this;
    }
    /**
     * @param size The size of the cuboid (ie: the distance from one side to the other) on each axis
     */
    public ModelCuboid size(@NotNull final Vector3f size) {
        // TODO add sizes/rotations with x, y, z as parameter
        this.size = size;
        return this;
    }
    /**
     * @param size The size of the cuboid (ie: the distance from one side to the other) on all three axes - this forms a cube
     */
    public ModelCuboid size(final float size) {
        return size(new Vector3f(size));
    }
    /**
     * @param rotation The rotation of the cuboid in radians
     */
    public ModelCuboid rotation(@NotNull final Vector3d rotation) {
        this.rotation = rotation;
        return this;
    }
    /**
     * @param rotationY The rotation of the cuboid around the Y axis in radians
     */
    public ModelCuboid rotation(final double rotationY) {
        return rotation(new Vector3d(0, rotationY, 0));
    }

    public ModelCuboid material(@NotNull final Material material) {
        main.material(material);
        return this;
    }
    public ModelCuboid brightness(final int blockBrightness) {
        main.brightness(blockBrightness);
        return this;
    }
    public ModelCuboid glow(@NotNull final Color color) {
        main.glow(color);
        return this;
    }

    public Matrix4f getMatrix() {
        return new TransformationMatrixBuilder()
                .translate(location)
                .rotate(rotation)
                .scale(new Vector3f(size))
                .buildForBlockDisplay();
    }
    @Override
    public BlockDisplay build(@NotNull final Location origin) {
        return main.transformation(getMatrix()).build(origin);
    }
    @Override
    public BlockDisplay build(@NotNull final Block block) {
        return build(block.getLocation());
    }
}
