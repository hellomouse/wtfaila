package net.hellomouse.wtfaila;

import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;

public class Keybinds {
    public static FabricKeyBinding LOOK;

    public static void init() {
        KeyBindingRegistry.INSTANCE.addCategory("fabric.mods.wtfaila");
        LOOK = registerKey("look", 33, "fabric.mods.wtfaila");
    }

    public static FabricKeyBinding registerKey(String name, Integer code, String category) {
        FabricKeyBinding key = FabricKeyBinding.Builder.create(new Identifier("wtfaila:" + name), InputUtil.Type.KEY_KEYBOARD, code, category).build();
        KeyBindingRegistry.INSTANCE.register(key);

        return key;

    }
}
