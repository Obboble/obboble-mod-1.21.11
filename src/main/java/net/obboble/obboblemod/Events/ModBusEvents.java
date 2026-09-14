package net.obboble.obboblemod.Events;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.obboble.obboblemod.ObbobleMod;

import static net.obboble.obboblemod.EntityTypes.VAGUELY_NAMED;


@EventBusSubscriber(modid = ObbobleMod.MODID)
public class ModBusEvents{
    @SubscribeEvent // on the mod event bus
    public static void createDefaultAttributes(net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent event) {
        event.put(
                // Your entity type.
                VAGUELY_NAMED.get(),
                // An AttributeSupplier. This is typically created by calling LivingEntity#createLivingAttributes,
                // setting your values on it, and calling #build. You can also create the AttributeSupplier from scratch
                // if you want, see the source of LivingEntity#createLivingAttributes for an example.
                LivingEntity.createLivingAttributes()
                        // Add an attribute with its default value.
                        .add(Attributes.MAX_HEALTH)
                        .add(Attributes.ARMOR)
                        .add(Attributes.ATTACK_DAMAGE)
                        .add(Attributes.FOLLOW_RANGE)
                        .add(Attributes.MOVEMENT_SPEED)
                        // Add an attribute with a non-default value.
//                        .add(Attributes.MAX_HEALTH, 50)
                        // Build the AttributeSupplier.
                        .build()
        );
    }
}
