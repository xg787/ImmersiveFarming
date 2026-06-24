package net.etylop.immersivefarming.common.data;

import net.etylop.immersivefarming.ImmersiveFarming;
import net.etylop.immersivefarming.common.data.generators.IFBlockStateProvider;
import net.etylop.immersivefarming.common.data.generators.IFRecipes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ImmersiveFarming.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class IFDataProvider {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper exHelper = event.getExistingFileHelper();
        //StaticTemplateManager.EXISTING_HELPER = exHelper;

        ImmersiveFarming.log.info("-============ Immersive Farming Data Generation ============-");

        if(event.includeClient()){
            generator.addProvider(true, new IFBlockStateProvider(generator, exHelper));
            generator.addProvider(true, new IFRecipes(generator));
        }
    }
}

