package de.piinguiin.lootbox.utils.language;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.HoverEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class MessageBuilder {
    private final ComponentBuilder cb;
    private HoverEvent hover;
    private ClickEvent click;

    public MessageBuilder(final String message) {
        this.cb = new ComponentBuilder(message);
    }

    public MessageBuilder setHover(final HoverEvent hover) {
        this.hover = hover;
        return this;
    }

    public MessageBuilder setHover(final Action a, final String value) {
        this.hover = new HoverEvent(a, (new ComponentBuilder(value)).create());
        return this;
    }

    public MessageBuilder setClick(final net.md_5.bungee.api.chat.ClickEvent.Action a, final String value) {
        this.click = new ClickEvent(a, value);
        return this;
    }

    public MessageBuilder setClick(final ClickEvent click) {
        this.click = click;
        return this;
    }

    public TextComponent build() {
        final TextComponent tx = new TextComponent(this.cb.create());
        if (this.hover != null) {
            tx.setHoverEvent(this.hover);
        }

        if (this.click != null) {
            tx.setClickEvent(this.click);
        }

        return tx;
    }

    public void sendTo(final Player player) {
        player.spigot().sendMessage(this.build());
    }

    public void sendTo(final Player... player) {
        for (final Player all : player) all.spigot().sendMessage(this.build());
    }
}
