package com.github.soramame0256.meautoinserter;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = MeAutoInserter.MOD_ID,
        name = MeAutoInserter.MOD_NAME,
        version = MeAutoInserter.VERSION
)
public class MeAutoInserter {

    public static final String MOD_ID = "meautoinserter";
    public static final String MOD_NAME = "MeAutoInserter";
    public static final String VERSION = "1.0-SNAPSHOT";
    public static boolean toggle = false;

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static MeAutoInserter INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new Command());
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onChat(ClientChatEvent e){
        if (!e.getMessage().startsWith("/") && toggle){
            e.setMessage("/me " + e.getMessage());
        }
    }
}
