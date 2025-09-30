package v1.knowledge;

/** Project-level Vision; parent of Epics */
public class VisionDocumentType implements ParentOfDocumentType<v1.knowledge.EpicDocumentType> {
    @Override public String getName() { return "Vision"; }
    @Override public String getDescription() { return "Project-level Vision; parent of Epics"; }
}
