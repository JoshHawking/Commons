package tc.oc.commons.bukkit.event;

import com.google.common.base.Preconditions;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

/**
 * Extension of Bukkit's {@link Cancellable} to allow for custom error messages to be specified when cancelling the
 * event.
 */
public abstract class ExtendedCancellable extends Event implements Cancellable {
    protected String cancellationMessage;

    /**
     * Gets the cancellation message specified when cancelling this event, or <code>null</code> if none (or not
     * cancelled).
     */
    public @Nullable String getCancellationMessage() {
        return this.cancellationMessage;
    }

    /**
     * Marks the event as cancelled with the specified error message.
     *
     * @param message The message. Expected not to be <code>null</code>. To cancel without a message, use {@link
     *                Cancellable#setCancelled(boolean)}
     */
    public void setCancelled(String message) {
        this.setCancelled(true);
        this.cancellationMessage = Preconditions.checkNotNull(message, "Message");
    }
}
