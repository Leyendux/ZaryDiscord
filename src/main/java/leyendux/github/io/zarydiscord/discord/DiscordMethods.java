package leyendux.github.io.zarydiscord.discord;

import leyendux.github.io.zarydiscord.Main;
import leyendux.github.io.zarydiscord.util.ValuesUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

public class DiscordMethods {

    public static void sendTwitterEmbed(String text) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(new Color(0, 252, 241));
        embedBuilder.setAuthor("ZaryNetwork", null, "https://pbs.twimg.com/profile_images/1268209512185507840/aK26Ye0N_400x400.jpg");
        embedBuilder.addField("Twitter | @ZaryNetwork", text, false);

        sendMessage(ValuesUtil.NEWS_ID.getValue(), "@everyone");
        sendMessage(ValuesUtil.NEWS_ID.getValue(), embedBuilder.build());
    }

    public static void sendTwitterEmbed(String text, String imageUrl) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(new Color(0, 252, 241));
        embedBuilder.setAuthor("ZaryNetwork", null, "https://pbs.twimg.com/profile_images/1268209512185507840/aK26Ye0N_400x400.jpg");
        embedBuilder.addField("Twitter | @ZaryNetwork", text, false);
        embedBuilder.setImage(imageUrl);

        sendMessage(ValuesUtil.NEWS_ID.getValue(), "@everyone");
        sendMessage(ValuesUtil.NEWS_ID.getValue(), embedBuilder.build());
    }

    public static void sendMessage(String channelId, String message) {
        Main.getInstance().getDiscordBot().getJda().getTextChannelById(channelId).sendMessage(message).queue();
    }

    public static void sendMessage(String channelId, MessageEmbed messageEmbed) {
        Main.getInstance().getDiscordBot().getJda().getTextChannelById(channelId).sendMessage(messageEmbed).queue();
    }
}
