package v1.operational;

import lombok.Getter;
import java.util.LinkedHashMap;
import java.util.Map;

/** Review record for a specific DocumentVersion. */
@Getter
public class ReviewRequest {
    private final DocumentVersion version;
    private final int requiredApprovers;
    private final Map<User, Boolean> decisions = new LinkedHashMap<>(); // true=approve, false=reject

    public ReviewRequest(DocumentVersion version, int requiredApprovers) {
        this.version = version;
        this.requiredApprovers = requiredApprovers;
    }

    public void approve(User user) { decisions.put(user, Boolean.TRUE); }
    public void reject(User user) { decisions.put(user, Boolean.FALSE); }

    public boolean isApproved() {
        long ok = decisions.values().stream().filter(Boolean::booleanValue).count();
        return ok >= requiredApprovers;
    }

    public boolean isRejected() {
        return decisions.values().stream().anyMatch(b -> !b);
    }
}
