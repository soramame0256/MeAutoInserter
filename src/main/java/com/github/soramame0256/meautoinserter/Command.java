package com.github.soramame0256.meautoinserter;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

import static com.github.soramame0256.meautoinserter.MeAutoInserter.toggle;

public class Command extends CommandBase {

    @Override
    public String getName() {
        return "togglemai";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/togglemai";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        toggle = !toggle;
        sender.sendMessage(new TextComponentString("機能を切り替えました: " + toggle));
    }
}
