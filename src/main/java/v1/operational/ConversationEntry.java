package v1.operational;

import java.time.Instant;

/** A single exchange in the conversation that produced a version. */
public record ConversationEntry(Role role, String message, Instant timestamp) {
    public enum Role { USER, SYSTEM, LLM }
}
