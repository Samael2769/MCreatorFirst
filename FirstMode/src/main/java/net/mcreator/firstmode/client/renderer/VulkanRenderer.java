
package net.mcreator.firstmode.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.firstmode.entity.VulkanEntity;
import net.mcreator.firstmode.client.model.ModelVulkan;

public class VulkanRenderer extends MobRenderer<VulkanEntity, ModelVulkan<VulkanEntity>> {
	public VulkanRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelVulkan(context.bakeLayer(ModelVulkan.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(VulkanEntity entity) {
		return new ResourceLocation("firstmode:textures/entities/material.png");
	}
}
