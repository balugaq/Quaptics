package org.metamechanists.quaptics.items.groups;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.metamechanists.quaptics.Quaptics;
import org.metamechanists.quaptics.items.Groups;
import org.metamechanists.quaptics.items.Lore;
import org.metamechanists.quaptics.utils.Colors;


@UtilityClass
public class Guide {
    private final SlimefunItemStack WHAT_IS_QUAPTICS = new SlimefunItemStack("QP_GUIDE_WHAT_IS_QUAPTICS", Material.WHITE_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "什么是量子光学（Quaptics）？",
            Lore.clickToOpen());
    private final SlimefunItemStack WHAT_IS_QUAPTICS_1 = new SlimefunItemStack("QP_GUIDE_WHAT_IS_QUAPTICS_1", Material.CYAN_CONCRETE,
            "&7你说的对，但是量子光学（Quaptics）是一款全新的Slimefun附属...",
            "&7量子光学允许你操控量子光束、射线",
            "&7并激活各种量子机器。");
    private final SlimefunItemStack WHAT_IS_QUAPTICS_2 = new SlimefunItemStack("QP_GUIDE_WHAT_IS_QUAPTICS_2", Material.CYAN_CONCRETE,
            "&7量子光束",
            "&7量子光束拥有能量、频率以及相位属性。",
            "&7部分量子机器需要量子光束",
            "&7达到一定的条件才能运行。");
    private final SlimefunItemStack WHAT_IS_QUAPTICS_3 = new SlimefunItemStack("QP_GUIDE_WHAT_IS_QUAPTICS_3", Material.CYAN_CONCRETE,
            "&7开始游玩",
            "&7从'入门'开始体验量子光学吧。");

    private final SlimefunItemStack GETTING_STARTED = new SlimefunItemStack("QP_GUIDE_GETTING_STARTED", Material.WHITE_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "入门",
            Lore.clickToOpen());
    private final SlimefunItemStack GETTING_STARTED_1 = new SlimefunItemStack("QP_GUIDE_GETTING_STARTED_1", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第一步",
            "&7制作以下物品：",
            "&7- &e太阳能聚能装置 I",
            "&7- &e棱镜 I",
            "&7- &e校准棒");
    private final SlimefunItemStack GETTING_STARTED_2 = new SlimefunItemStack("QP_GUIDE_GETTING_STARTED_2", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第二步",
            "&7相邻放置&e太阳能聚能装置 I",
            "&7与&e棱镜 I&7。");
    private final SlimefunItemStack GETTING_STARTED_3 = new SlimefunItemStack("QP_GUIDE_GETTING_STARTED_3", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第三步",
            "&7手持&e校准棒&7并右键点击",
            "&e太阳能聚能装置 I&7的&a输出口&7。");
    private final SlimefunItemStack GETTING_STARTED_4 = new SlimefunItemStack("QP_GUIDE_GETTING_STARTED_4", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第四步",
            "&7你已经选择了一个&a输出口。&7接下来",
            "&7右键点击&e棱镜 I&7的&c输入口。",
            "&7如果你不小心取消选择了&a输出口，",
            "&7你需要回到第三步。");
    private final SlimefunItemStack GETTING_STARTED_5 = new SlimefunItemStack("QP_GUIDE_GETTING_STARTED_5", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第五步",
            "&7现在，你成功创建了第一个量子光学连接！",
            "&7也许你要在白天才能看到效果，",
            "&7因为&e太阳能聚能装置 I",
            "&7只在白天工作。");

    private final SlimefunItemStack VIEWING_CONNECTION_INFORMATION = new SlimefunItemStack("QP_GUIDE_VIEWING_CONNECTION_INFORMATION", Material.WHITE_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "查询连接信息",
            Lore.clickToOpen());
    private final SlimefunItemStack VIEWING_CONNECTION_INFORMATION_1 = new SlimefunItemStack("QP_GUIDE_VIEWING_CONNECTION_INFORMATION_1", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第一步",
            "&7你可以空手右键点击",
            "&c输入口&7与&a输出口&7来打开信息面板。",
            "&7快去试试吧！");
    private final SlimefunItemStack VIEWING_CONNECTION_INFORMATION_2 = new SlimefunItemStack("QP_GUIDE_VIEWING_CONNECTION_INFORMATION_2", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第二步",
            "&7你也可以潜行+右键点击方块",
            "&7来切换所有接口的信息面板。");

    private final SlimefunItemStack USING_A_RAY_GUN = new SlimefunItemStack("QP_GUIDE_USING_A_RAY_GUN", Material.WHITE_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "使用射线枪",
            Lore.clickToOpen());
    private final SlimefunItemStack USING_A_RAY_GUN_1 = new SlimefunItemStack("QP_GUIDE_USING_A_RAY_GUN_1", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第一步",
            "&7制作以下物品：",
            "&7- &e射线枪 I",
            "&7- &e充能器 I");
    private final SlimefunItemStack USING_A_RAY_GUN_2 = new SlimefunItemStack("QP_GUIDE_USING_A_RAY_GUN_2", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第二步",
            "&7放置&e充能器I &7并将其",
            "&7连接至能量源。",
            "&7（已在'入门'中介绍）");
    private final SlimefunItemStack USING_A_RAY_GUN_3 = new SlimefunItemStack("QP_GUIDE_USING_A_RAY_GUN_3", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第三步",
            "&7手持&e射线枪 I &7并右键点击&e充能器 I&7。",
            "&e射线枪 I &7现在应该开始充能了。",
            "&7你可能需要等到白天",
            "&7才能让&e太阳能聚能装置 I &7运作。");
    private final SlimefunItemStack USING_A_RAY_GUN_4 = new SlimefunItemStack("QP_GUIDE_USING_A_RAY_GUN_4", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第四步",
            "&7当&e射线枪 I &7充能完毕后，",
            "&7右键点击将其从充能器中取出。",
            "&7手持&e射线枪 I &7并右键点击目标向其开火。");
    private final SlimefunItemStack USING_A_RAY_GUN_5 = new SlimefunItemStack("QP_GUIDE_USING_A_RAY_GUN_5", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第五步",
            "&7现在，去探索更多的组件吧！",
            "&7你也许想看看这些:",
            "&7- &e分离装置 I",
            "&7- &e汇聚装置 I",
            "&7- &e电容 I",
            "&7- &e炮塔 I");

    private final SlimefunItemStack BURNOUT = new SlimefunItemStack("QP_GUIDE_BURNOUT", Material.WHITE_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "组件熄火（以及如何预防）",
            Lore.clickToOpen());
    private final SlimefunItemStack BURNOUT_1 = new SlimefunItemStack("QP_GUIDE_BURNOUT_1", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第一步",
            "&7当你开始使用" + Colors.BASIC.getFormattedColor() + "初级&7组件时，",
            "&7你会开始遇到组件熄火的问题。");
    private final SlimefunItemStack BURNOUT_2 = new SlimefunItemStack("QP_GUIDE_BURNOUT_2", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第二步",
            "&7这通常在输入了过多的能量时出现，",
            "&7然后组件便会爆炸。");
    private final SlimefunItemStack BURNOUT_3 = new SlimefunItemStack("QP_GUIDE_BURNOUT_3", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第三步",
            "&7时常检查信息面板",
            "&7来避免能量输入超过",
            "&7组件的正常工作范围。");
    private final SlimefunItemStack BURNOUT_4 = new SlimefunItemStack("QP_GUIDE_BURNOUT_4", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第四步",
            "&7你也可以使用变压器来减少",
            "&7光束的能量之安全范围。");

    private final SlimefunItemStack INCREASING_FREQUENCY = new SlimefunItemStack("QP_GUIDE_INCREASING_FREQUENCY", Material.WHITE_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "增加频率",
            Lore.clickToOpen());
    private final SlimefunItemStack INCREASING_FREQUENCY_1 = new SlimefunItemStack("QP_GUIDE_INCREASING_FREQUENCY_1", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第一步",
            "&7更加强力的机器需要",
            "&7更高频率的量子光束。",
            "&7需要使用中继器来增加频率。");
    private final SlimefunItemStack INCREASING_FREQUENCY_2 = new SlimefunItemStack("QP_GUIDE_INCREASING_FREQUENCY_2", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第二步",
            "&7制作以下物品：",
            "&7- &e能量汇聚装置 I",
            "&7- &e中继器 I &7(x3)");
    private final SlimefunItemStack INCREASING_FREQUENCY_3 = new SlimefunItemStack("QP_GUIDE_INCREASING_FREQUENCY_3", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第三步",
            "&7放置组件，并将",
            "&e能量汇聚装置 I &7连接到中继器",
            "&7然后将中继器串联到一起");
    private final SlimefunItemStack INCREASING_FREQUENCY_4 = new SlimefunItemStack("QP_GUIDE_INCREASING_FREQUENCY_4", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第四步",
            "&7串联的最后一个中继器的输出",
            "&7应该足够让&e多方块结构点击器 I",
            "&7运作，快去试试吧！");
    private final SlimefunItemStack INCREASING_FREQUENCY_5 = new SlimefunItemStack("QP_GUIDE_INCREASING_FREQUENCY_5", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第五步",
            "&7你可能会需要更高级的中继器、",
            "&7散射器，或是更加后期的衍射光栅",
            "&7来增加光束的频率。");

    private final SlimefunItemStack BUILDING_MULTIBLOCKS = new SlimefunItemStack("QP_GUIDE_BUILDING_MULTIBLOCKS", Material.WHITE_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "建造多方块结构",
            Lore.clickToOpen());
    private final SlimefunItemStack BUILDING_MULTIBLOCKS_1 = new SlimefunItemStack("QP_GUIDE_BUILDING_MULTIBLOCKS_1", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第一步",
            "&7你需要建造的第一个多方块结构",
            "&7是注入器。");
    private final SlimefunItemStack BUILDING_MULTIBLOCKS_2 = new SlimefunItemStack("QP_GUIDE_BUILDING_MULTIBLOCKS_2", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第二步",
            "&7制作以下物品：",
            "&7- &e多方块棒",
            "&7- &e注入容器",
            "&7- &e注入柱 &7(x4)");
    private final SlimefunItemStack BUILDING_MULTIBLOCKS_3 = new SlimefunItemStack("QP_GUIDE_BUILDING_MULTIBLOCKS_3", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第三步",
            "&7放置&e注入容器&7并",
            "&7使用&e多方块棒&7右键点击。",
            "&7多方块结构会投影展示出。");
    private final SlimefunItemStack BUILDING_MULTIBLOCKS_4 = new SlimefunItemStack("QP_GUIDE_BUILDING_MULTIBLOCKS_4", Material.CYAN_CONCRETE,
            Colors.QUAPTICS.getFormattedColor() + "第四步",
            "&7右键点击每个投影的方块",
            "&7可以查看是什么，然后放置相应的方块即可。",
            "&7就是这么简单！");


    public void initialize() {
        final SlimefunAddon addon = Quaptics.getInstance();

        new SlimefunItem(Groups.GUIDE, WHAT_IS_QUAPTICS, RecipeType.NULL, new ItemStack[]{
                WHAT_IS_QUAPTICS_1, WHAT_IS_QUAPTICS_2, WHAT_IS_QUAPTICS_3,
                null, null, null,
                null, null, null
        }).register(addon);

        new SlimefunItem(Groups.GUIDE, GETTING_STARTED, RecipeType.NULL, new ItemStack[]{
                GETTING_STARTED_1, GETTING_STARTED_2, GETTING_STARTED_3,
                GETTING_STARTED_4, GETTING_STARTED_5, null,
                null, null, null
        }).register(addon);

        new SlimefunItem(Groups.GUIDE, VIEWING_CONNECTION_INFORMATION, RecipeType.NULL, new ItemStack[]{
                VIEWING_CONNECTION_INFORMATION_1, VIEWING_CONNECTION_INFORMATION_2, null,
                null, null, null,
                null, null, null
        }).register(addon);

        new SlimefunItem(Groups.GUIDE, USING_A_RAY_GUN, RecipeType.NULL, new ItemStack[]{
                USING_A_RAY_GUN_1, USING_A_RAY_GUN_2, USING_A_RAY_GUN_3,
                USING_A_RAY_GUN_4, USING_A_RAY_GUN_5, null,
                null, null, null
        }).register(addon);

        new SlimefunItem(Groups.GUIDE, BURNOUT, RecipeType.NULL, new ItemStack[]{
                BURNOUT_1, BURNOUT_2, BURNOUT_3,
                BURNOUT_4, null, null,
                null, null, null
        }).register(addon);

        new SlimefunItem(Groups.GUIDE, INCREASING_FREQUENCY, RecipeType.NULL, new ItemStack[]{
                INCREASING_FREQUENCY_1, INCREASING_FREQUENCY_2, INCREASING_FREQUENCY_3,
                INCREASING_FREQUENCY_4, INCREASING_FREQUENCY_5, null,
                null, null, null
        }).register(addon);

        new SlimefunItem(Groups.GUIDE, BUILDING_MULTIBLOCKS, RecipeType.NULL, new ItemStack[]{
                BUILDING_MULTIBLOCKS_1, BUILDING_MULTIBLOCKS_2, BUILDING_MULTIBLOCKS_3,
                BUILDING_MULTIBLOCKS_4, null, null,
                null, null, null
        }).register(addon);
    }
}
