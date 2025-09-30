package v1.operational;

import v1.knowledge.DocumentType;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

/** Base document implementation with version tracking. */
@Getter
public abstract class AbstractDocument<T extends DocumentType> implements Document<T> {
    private final String id;
    private final String title;
    private final T type;
    private final List<DocumentVersion> versions = new ArrayList<>();

    protected AbstractDocument(String id, String title, T type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    @Override
    public DocumentVersion getCurrentVersion() {
        return versions.isEmpty() ? null : versions.get(versions.size()-1);
    }

    @Override
    public DocumentVersion getLatestApprovedVersion() {
        DocumentVersion result = null;
        for (DocumentVersion v : versions) {
            if (v.getStatus() == DocumentStatus.APPROVED) result = v;
        }
        return result;
    }

    @Override
    public void addVersion(DocumentVersion version) {
        versions.add(version);
    }
}
