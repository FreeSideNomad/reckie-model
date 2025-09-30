package v1.operational;

import lombok.Getter;
import lombok.AllArgsConstructor;
import java.time.Instant;

/** Exclusive edit lock with sliding expiration. */
@Getter
@AllArgsConstructor
public class DocumentLock {
    private final String documentId;
    private final User lockedBy;
    private Instant expiresAt;

    public boolean isExpired() { return Instant.now().isAfter(expiresAt); }
    public void renewSeconds(long seconds) { this.expiresAt = Instant.now().plusSeconds(seconds); }
}
