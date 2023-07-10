package org.metamechanists.quaptics.utils.models.components;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.metamechanists.quaptics.utils.builders.ItemDisplayBuilder;
import org.metamechanists.quaptics.utils.transformations.TransformationMatrixBuilder;


@SuppressWarnings("unused")
public class ModelItem implements ModelComponent {
    private final ItemDisplayBuilder main = new ItemDisplayBuilder();

    private Vector3f location = new Vector3f();
    private Vector3f size = new Vector3f();
    private Vector3d rotation = new Vector3d();

    /**
     * @param location The center of the cube containing the item
     */
    public ModelItem location(@NotNull final Vector3f location) {
        this.location = location;
        return this;
    }
    /**
     * @param size The size of the cube containing the item (ie: the distance from one side to the other) on all three axex
     */
    public ModelItem size(final float size) {
        this.size = new Vector3f(size);
        return this;
    }
    /**
     * @param rotation The rotation of the cube containing the item in radians
     */
    public ModelItem rotation(@NotNull final Vector3d rotation) {
        this.rotation = rotation;
        return this;
    }
    /**
     * Sets the rotation of the cube containing the item in radians
     */
    public ModelItem rotation(final double x, final double y, final double z) {
        return rotation(new Vector3d(x, y, z));
    }
    /**
     * @param rotationY The rotation of the cube containing the item around the Y axis in radians
     */
    public ModelItem rotation(final double rotationY) {
        return rotation(new Vector3d(0, rotationY, 0));
    }

    /**
     * Overrides material()
     */
    public ModelItem item(@NotNull final ItemStack itemStack) {
        main.itemStack(itemStack);
        return this;
    }
    public ModelItem material(@NotNull final Material material) {
        main.material(material);
        return this;
    }
    public ModelItem brightness(final int blockBrightness) {
        main.brightness(blockBrightness);
        return this;
    }
    public ModelItem glow(@NotNull final Color color) {
        main.glow(color);
        return this;
    }

    public Matrix4f getMatrix() {
        return new TransformationMatrixBuilder()
                .translate(location)
                .rotate(rotation)
                .scale(new Vector3f(size))
                .buildForItemDisplay();
    }
    @Override
    public ItemDisplay build(@NotNull final Location origin) {
        return main.transformation(getMatrix()).build(origin);
    }
    @Override
    public ItemDisplay build(@NotNull final Block block) {
        return build(block.getLocation());
    }
}