package net.lozangocomz.treephysicsnoshiftfeature.mixin;

import com.farcr.treephysics.event.CommonEvents;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CommonEvents.class)
public class CommonEventsMixin {

    @Redirect(
            method = "playerBreakBlock",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/player/Player;isShiftKeyDown()Z"
            )
    )
    private static boolean redirectShiftCheck(Player player) {
        return false;
    }
}