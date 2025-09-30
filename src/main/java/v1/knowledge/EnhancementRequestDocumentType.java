package v1.knowledge;

/** Enhancement Request; child of Epic */
public class EnhancementRequestDocumentType implements ChildOfDocumentType<v1.knowledge.EpicDocumentType> {
    @Override public String getName() { return "EnhancementRequest"; }
    @Override public String getDescription() { return "Enhancement Request; child of Epic"; }
}
