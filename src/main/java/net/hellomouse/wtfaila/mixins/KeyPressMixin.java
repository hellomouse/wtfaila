package net.hellomouse.wtfaila.mixins;

import net.hellomouse.wtfaila.Keybinds;
import net.minecraft.block.Block;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.sortme.ChatMessageType;
import net.minecraft.text.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.io.Console;
import java.util.List;
import java.util.stream.Stream;

@Mixin(Keyboard.class)
public class KeyPressMixin {
    @Shadow
    private MinecraftClient client;

    @Inject(method = "onKey", at = @At(value = "INVOKE", target = "onKeyPressed", shift = At.Shift.AFTER))
    protected void onKeyPress(CallbackInfo ci) {
        if (Keybinds.LOOK.isPressed()) {
            BlockHitResult blocktrace = (BlockHitResult) client.cameraEntity.rayTrace(20.0D, 0.0F, false);
            if (blocktrace != null && blocktrace.getType() == HitResult.Type.BLOCK) {
                Block seenblock = this.client.world.getBlockState(blocktrace.getBlockPos()).getBlock();
                client.inGameHud.addChatMessage(ChatMessageType.GAME_INFO, new StringTextComponent("You're looking at a fricking ").append(seenblock.getItem().getDefaultStack().getDisplayName()));
            }
        }
    }
}