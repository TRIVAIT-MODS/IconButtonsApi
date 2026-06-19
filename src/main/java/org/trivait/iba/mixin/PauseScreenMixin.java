package org.trivait.iba.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.trivait.iba.api.IconButtons;

import java.util.List;

@Mixin(PauseScreen.class)
public abstract class PauseScreenMixin extends Screen {

    public PauseScreenMixin() {
        super(Component.empty());
    }

    @Definition(id = "integratedServer", local = @Local(type = IntegratedServer.class, name = "integratedServer"))
    @Expression("integratedServer = ?")
    @Inject(method = "createPauseMenu", at = @At("MIXINEXTRAS:EXPRESSION"))
    private void insertModMenuIconButton(CallbackInfo ci, @Local(name = "iconButtonRow") LinearLayout iconButtonRow) {
        List<AbstractWidget> widgets = IconButtons.getPauseScreenWidgets();

        for (AbstractWidget widget : widgets) {
            iconButtonRow.addChild(widget);
        }
    }
}
