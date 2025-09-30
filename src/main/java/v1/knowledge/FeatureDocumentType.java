package v1.knowledge;

/** Feature; child of Epic; parent of User Stories */
public class FeatureDocumentType implements ParentOfDocumentType<v1.knowledge.UserStoryDocumentType>, ChildOfDocumentType<v1.knowledge.EpicDocumentType> {
    @Override public String getName() { return "Feature"; }
    @Override public String getDescription() { return "Feature; child of Epic; parent of User Stories"; }
}
