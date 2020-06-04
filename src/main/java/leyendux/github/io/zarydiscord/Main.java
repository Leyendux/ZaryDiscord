package leyendux.github.io.zarydiscord;

import leyendux.github.io.zarydiscord.discord.DiscordBot;
import leyendux.github.io.zarydiscord.twitter.TwitterBot;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    private static Main instance;

    private DiscordBot discordBot;
    private TwitterBot twitterBot;

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        discordBot = new DiscordBot("NzE3NzU5ODgyNzIzNTkwMjM0.XtkqQg.O920OE8nxiHx7g9joI2dpBgBiRc");
        twitterBot = new TwitterBot("JxIU9ASjdx3EaqzSRIfoZVcMc",
                "cotaE9ZZOjnLQhEigQkfLYHBFwyRF63SLOj4rFmplTuoMuTsY4",
                "742902956-WT6fAAqTXr8XFC6ovFeIOIG3Z7IImevfYSRwGfow",
                "DMhsxgBsYrxH1Yk74L2XQ3J7tjI4QVY7Ahhzn2UTka6Ms");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        discordBot.shutdown();
    }

    public static Main getInstance() {
        return instance;
    }

    public DiscordBot getDiscordBot() {
        return discordBot;
    }
    public TwitterBot getTwitterBot() {
        return twitterBot;
    }
}
