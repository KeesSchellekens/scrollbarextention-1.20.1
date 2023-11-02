package keesschellekens.scrollbarextention.mixin.client;

import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public class HotbarClientMixin {
	@Inject(at = @At("HEAD"), method = "scrollInHotbar(D)V")
	public void ìnject() {
        System.out.println("This line is printed by an example mod mixin!");
    }
}