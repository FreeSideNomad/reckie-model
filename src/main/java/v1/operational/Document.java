package v1.operational;

import v1.knowledge.DocumentType;
import java.util.List;

/** Live document instance bound to a DocumentType. */
public interface Document<T extends DocumentType> {
    String getId();
    String getTitle();
    T getType();

    DocumentVersion getCurrentVersion();
    DocumentVersion getLatestApprovedVersion();
    List<DocumentVersion> getVersions();

    void addVersion(DocumentVersion version);
}
