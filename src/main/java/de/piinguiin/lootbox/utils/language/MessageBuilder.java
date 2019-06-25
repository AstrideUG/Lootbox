package de.piinguiin.lootbox.utils.language;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.HoverEvent.Action;
import org.bukkit.entity.Player;

public class MessageBuilder {
    private ComponentBuilder cb;
    private HoverEvent hover;
    private ClickEvent click;

    public MessageBuilder(String message) {
        this.cb = new ComponentBuilder(message);
    }

    public MessageBuilder setHover(HoverEvent hover) {
        this.hover = hover;
        return this;
    }

    public MessageBuilder setHover(Action a, String value) {
        this.hover = new HoverEvent(a, (new ComponentBuilder(value)).create());
        return this;
    }

    public MessageBuilder setClick(net.md_5.bungee.api.chat.ClickEvent.Action a, String value) {
        this.click = new ClickEvent(a, value);
        return this;
    }

    public MessageBuilder setClick(ClickEvent click) {
        this.click = click;
        return this;
    }

    public TextComponent build() {
        TextComponent tx = new TextComponent(this.cb.create());
        if (this.hover != null) {
            tx.setHoverEvent(this.hover);
        }

        if (this.click != null) {
            tx.setClickEvent(this.click);
        }

        return tx;
    }

    public void sendTo(Player player) {
        player.spigot().sendMessage(this.build());
    }

    public void sendTo(Player... player) {
        Player[] var2 = player;
        int var3 = player.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Player all = var2[var4];
            all.spigot().sendMessage(this.build());
        }

    }
}
