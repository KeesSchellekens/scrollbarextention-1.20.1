package keesschellekens.scrollbarextention.mixin.client;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(PlayerInventory.class)
public class HotbarClientMixin {
	@Inject(method = "scrollInHotbar(D)V", at = @At("HEAD"), locals = LocalCapture.CAPTURE_FAILSOFT)
	public void ìnject(double scrollAmount, CallbackInfo info) {
        PlayerInventory inv = ( PlayerInventory ) ( Object) this;
        int next = inv.selectedSlot - (int) scrollAmount;
        if (next < 0 || next > 8){
            for (int i = 0; i< 9; i++){
                ItemStack item = inv.main.get(i);
                inv.main.set(i, inv.main.get(i + 27));
                inv.main.set(i+27, item);
            }
        }
    }
}