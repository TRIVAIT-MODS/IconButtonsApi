package org.trivait.iba.api;

import net.minecraft.client.gui.components.AbstractWidget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class IconButtons {
    private static Map<AbstractWidget, BooleanSupplier> titleScreenWidgets = new HashMap<>();
    private static Map<AbstractWidget, BooleanSupplier> pauseScreenWidgets = new HashMap<>();

    public static void addTitleScreenButton(AbstractWidget widget) {
        titleScreenWidgets.put(widget, () -> {
            return true;
        });
    }
    public static void addPauseScreenButton(AbstractWidget widget) {
        pauseScreenWidgets.put(widget, () -> {
            return true;
        });
    }

    public static void addTitleScreenButton(AbstractWidget widget, BooleanSupplier willShow) {
        titleScreenWidgets.put(widget, willShow);
    }
    public static void addPauseScreenButton(AbstractWidget widget, BooleanSupplier willShow) {
        pauseScreenWidgets.put(widget, willShow);
    }

    public static int getButtonWidthAndHeight() {
        return 20;
    }

    public static List<AbstractWidget> getTitleScreenWidgets() {
        List<AbstractWidget> widgets = new ArrayList<>();

        titleScreenWidgets.forEach((widget, willShow) -> {
            if (willShow.getAsBoolean()) widgets.add(widget);
        });

        return widgets;
    }
    public static List<AbstractWidget> getPauseScreenWidgets() {
        List<AbstractWidget> widgets = new ArrayList<>();

        pauseScreenWidgets.forEach((widget, willShow) -> {
            if (willShow.getAsBoolean()) widgets.add(widget);
        });

        return widgets;
    }
}
