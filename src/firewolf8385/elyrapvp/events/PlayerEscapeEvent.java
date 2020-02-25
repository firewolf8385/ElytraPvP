package firewolf8385.elytrapvp.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerEscapeEvent extends Event implements Cancellable
{
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;
    private Player player;

    public PlayerEscapeEvent(Player player)
    {
        this.player = player;
    }

    /**
     * Check if event is cancelled.
     * @return Whether event is cancelled.
     */
    @Override
    public boolean isCancelled()
    {
        return isCancelled;
    }

    /**
     * Get the Player
     * @return Player
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * Set of evemt should be cancelled.
     * @param cancelled Whether event should be cancelled.
     */
    @Override
    public void setCancelled(boolean cancelled)
    {
        this.isCancelled = cancelled;
    }

    /**
     * Get event handlers.
     * @return event handlers.
     */
    @Override
    public HandlerList getHandlers()
    {
        return HANDLERS_LIST;
    }

    /**
     * Get tbe handlers.
     * @return Handlers
     */
    public static HandlerList getHandlerList()
    {
        return HANDLERS_LIST;
    }
}
