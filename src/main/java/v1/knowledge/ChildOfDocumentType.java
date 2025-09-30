package v1.knowledge;

/** Marker for document types that have a parent of type P. */
public interface ChildOfDocumentType<P extends DocumentType> extends DocumentType { }
