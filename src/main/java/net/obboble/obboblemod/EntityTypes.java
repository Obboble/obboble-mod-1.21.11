package net.obboble.obboblemod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.obboble.obboblemod.entities.VaguelyNamed;

import java.util.function.Supplier;

public class EntityTypes {
    public static final DeferredRegister.Entities ENTITY_TYPES =
            DeferredRegister.createEntities(ObbobleMod.MODID);



    public static final Supplier<EntityType<VaguelyNamed>> VAGUELY_NAMED = ENTITY_TYPES.register(
            "vaguely_named",
            () -> EntityType.Builder.of(
                            VaguelyNamed::new,
                            MobCategory.MISC
                    )
                    .sized(0.6f, 2.0f)
                    .eyeHeight(0.85f)
                    .immuneTo(Blocks.POWDER_SNOW)
                    .clientTrackingRange(8)
                    .updateInterval(2)
                    .build(ResourceKey.create(
                            Registries.ENTITY_TYPE,
                            Identifier.fromNamespaceAndPath("obboblemod", "vaguely_named")
                    ))
    );
}
