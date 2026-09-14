package net.obboble.obboblemod.EntityRenderersEvent;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.obboble.obboblemod.Models.VaguelyNamedModel;
import net.obboble.obboblemod.ObbobleMod;
import net.obboble.obboblemod.Renderers.VaguelyNamedRenderer;

import static net.obboble.obboblemod.EntityTypes.VAGUELY_NAMED;
import static net.obboble.obboblemod.Models.VaguelyNamedModel.LAYER_LOCATION;
@EventBusSubscriber(modid = ObbobleMod.MODID)
public class RegisterLayerDefinitions {
    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // Add our layer here.
        event.registerLayerDefinition(LAYER_LOCATION, VaguelyNamedModel::createBodyLayer);
    }
    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(VAGUELY_NAMED.get(), VaguelyNamedRenderer::new);
    }
}
