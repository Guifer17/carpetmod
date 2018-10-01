package carpet.commands;

import carpet.utils.Messenger;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;

import java.util.Random;

import static carpet.commands.arguments.TermArgumentType.getTerm;
import static carpet.commands.arguments.TermArgumentType.term;
import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.word;
import static net.minecraft.command.Commands.argument;
import static net.minecraft.command.Commands.literal;

public class TestCommand
{
    public static void register(CommandDispatcher<CommandSource> dispatcher)
    {
        dispatcher.register(literal("test").
                then(argument("other", word()).
                        executes( (c)-> test_dim(c, getString(c, "other")+" 2"))));
    }

    private static int test_dim(CommandContext<CommandSource> c, String term)
    {
        Messenger.m(c.getSource(),"w term is: ",term.substring(0,1)+"b "+term);
        return 1;
    }
}