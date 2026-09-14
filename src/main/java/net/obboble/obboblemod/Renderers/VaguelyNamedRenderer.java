package net.obboble.obboblemod.Renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.obboble.obboblemod.Models.VaguelyNamedModel;
import net.obboble.obboblemod.ObbobleMod;
import net.obboble.obboblemod.RenderState.VaguelyNamedRenderState;
import net.obboble.obboblemod.entities.VaguelyNamed;

import static net.obboble.obboblemod.Models.VaguelyNamedModel.LAYER_LOCATION;

// The generic type in the superclass should be set to what entity you want to render.
// If you wanted to enable rendering for any entity, you'd use Entity, like we do here.
// You'd also use an EntityRenderState that fits your use case. More on this below.
public class VaguelyNamedRenderer extends HumanoidMobRenderer<VaguelyNamed, VaguelyNamedRenderState, VaguelyNamedModel<VaguelyNamedRenderState>> {
    public VaguelyNamedRenderer(EntityRendererProvider.Context context) {
        super(context, new VaguelyNamedModel(context.bakeLayer(VaguelyNamedModel.LAYER_LOCATION)), 0.5f);
    }
    // Tell the render engine how to create a new entity render state.
    @Override
    public VaguelyNamedRenderState createRenderState() {
        return new VaguelyNamedRenderState();
    }

    // Update the render state by copying the needed values from the passed entity to the passed state.
    // Both Entity and EntityRenderState may be replaced with more concrete types,
    // based on the generic types that have been passed to the supertype.
    @Override
    public void extractRenderState(VaguelyNamed entity, VaguelyNamedRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        // Extract and store any additional values in the state here.
    }

    // Actually submit the features of the entity to render.
    // The first parameter matches the render state's generic type.
    // Calling super will handle leash and name tag submission for you, if applicable.
    @Override
    public void submit(VaguelyNamedRenderState renderState, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraState) {
        super.submit(renderState, poseStack, collector, cameraState);
        // Do your own submission here
    }
    @Override
    public Identifier getTextureLocation(VaguelyNamedRenderState renderState) {
        return Identifier.fromNamespaceAndPath(ObbobleMod.MODID, "textures/entity/vaguelynamed.png");
    }

}