package net.obboble.obboblemod.RenderLayers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.obboble.obboblemod.Models.VaguelyNamedModel;
import net.obboble.obboblemod.RenderState.VaguelyNamedRenderState;

import static net.obboble.obboblemod.Models.VaguelyNamedModel.LAYER_LOCATION;

// The generic parameters need the proper types you used everywhere else up to this point.
public class MyRenderLayer extends RenderLayer<VaguelyNamedRenderState, VaguelyNamedModel<VaguelyNamedRenderState>> {
    private final VaguelyNamedModel model;

    // Create the render layer. The renderer parameter is required for passing to super.
    // Other parameters can be added as needed. For example, we need the EntityModelSet for model baking.
    public MyRenderLayer(RenderLayerParent renderer, EntityModelSet entityModelSet) {
        super(renderer);
        // Bake and store our layer definition, using the ModelLayerLocation from back when we registered the layer definition.
        // If applicable, you can also store multiple models this way and use them below.
        this.model = new VaguelyNamedModel(entityModelSet.bakeLayer(LAYER_LOCATION));
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector collector, int lightCoords, VaguelyNamedRenderState renderState, float yRot, float xRot) {
        // Submit the features for the layer here. We have stored the entity model in a field, you probably want to use it in some way.
        collector
                .order(1); // We submit the feature on a later iteration so it renders on top of the entity

    }

}
