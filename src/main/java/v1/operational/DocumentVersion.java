package v1.operational;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.Instant;
import java.util.List;

/** Immutable snapshot of a document at a point in time. */
@Getter
@AllArgsConstructor
public class DocumentVersion {
    private final int versionNumber;
    private final Instant timestamp;
    private final User author;
    private final String content;
    private final List<ConversationEntry> conversationLog;
    private final DocumentStatus status;
}
