package net.hellomouse.wtfaila.init;

import net.fabricmc.api.ClientModInitializer;
import net.hellomouse.wtfaila.Keybinds;


public final class BootstrapMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Keybinds.init();
    }
}
