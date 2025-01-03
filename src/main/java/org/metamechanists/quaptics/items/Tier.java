package org.metamechanists.quaptics.items;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.metamechanists.quaptics.utils.Colors;

public enum Tier {
    PRIMITIVE(Colors.PRIMITIVE.getFormattedColor() + "原始级", Material.BROWN_CONCRETE, Material.BROWN_STAINED_GLASS, 10),
    BASIC(Colors.BASIC.getFormattedColor() + "初级", Material.GREEN_CONCRETE, Material.GREEN_STAINED_GLASS, 100),
    INTERMEDIATE(Colors.INTERMEDIATE.getFormattedColor() + "中级", Material.YELLOW_CONCRETE,
        Material.YELLOW_STAINED_GLASS, 1000),
    ADVANCED(Colors.ADVANCED.getFormattedColor() + "高级", Material.RED_CONCRETE, Material.RED_STAINED_GLASS, 10000),
    TESTING("&8测试", Material.RED_CONCRETE, Material.RED_STAINED_GLASS, 10);

    public final String name;
    public final Material concreteMaterial;
    public final Material glassMaterial;
    public final double maxPower;

    Tier(final String name, final Material concreteMaterial, final Material glassMaterial, final double maxPower) {
        this.name = name;
        this.concreteMaterial = concreteMaterial;
        this.glassMaterial = glassMaterial;
        this.maxPower = maxPower;
    }

    /**
     * @return t1 >= t2
     */
    public static boolean greaterOrEqual(final @NotNull Tier t1, final Tier t2) {
        // lol
        switch (t1) {
            case PRIMITIVE -> {
                return true;
            }
            case BASIC -> {
                return t2 == BASIC || t2 == INTERMEDIATE || t2 == ADVANCED;
            }
            case INTERMEDIATE -> {
                return t2 == INTERMEDIATE || t2 == ADVANCED;
            }
            case ADVANCED -> {
                return t2 == ADVANCED;
            }
            case TESTING -> {
                return false;
            }
        }
        return false;
    }
}
