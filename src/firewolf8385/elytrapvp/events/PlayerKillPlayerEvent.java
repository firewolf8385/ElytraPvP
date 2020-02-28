package firewolf8385.elytrapvp.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerKillPlayerEvent extends Event implements Cancellable
{
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;
    private Player player;
    private Player killer;

    /**
     * Creates a PlayerKilledByPlayerEvent
     * @param player Player
     * @param killer Killer
     */
    public PlayerKillPlayerEvent(Player player, Player killer)
    {
        this.player = player;
        this.killer = killer;
        this.isCancelled = false;
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
     * Get the killer.
     * @return Killer.
     */
    public Player getKiller()
    {
        return killer;
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
     * Get handlers.
     * @return Handlers.
     */
    public static HandlerList getHandlerList()
    {
        return HANDLERS_LIST;
    }

}