package net.obboble.obboblemod.EntityRenderersEvent;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.obboble.obboblemod.renderers.VaguelyNamedRenderer;

import static net.obboble.obboblemod.EntityTypes.VAGUELY_NAMED;

public class RegisterRenderers {
    @SubscribeEvent // on the mod event bus only on the physical client
public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
    event.registerEntityRenderer(VAGUELY_NAMED.get(), VaguelyNamedRenderer::new);
}
}
