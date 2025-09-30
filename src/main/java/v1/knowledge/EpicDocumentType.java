package v1.knowledge;

/** Epic; child of Vision; parent of Features; holds Enhancement Requests */
public class EpicDocumentType implements ParentOfDocumentType<v1.knowledge.FeatureDocumentType>, ChildOfDocumentType<v1.knowledge.VisionDocumentType> {
    @Override public String getName() { return "Epic"; }
    @Override public String getDescription() { return "Epic; child of Vision; parent of Features; holds Enhancement Requests"; }
}
