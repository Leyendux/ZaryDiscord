package leyendux.github.io.zarydiscord.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    private JDA jda;

    public DiscordBot(String token) {
        try {
            jda = new JDABuilder(token).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        jda.shutdown();
    }

    public JDA getJda() {
        return jda;
    }
}
