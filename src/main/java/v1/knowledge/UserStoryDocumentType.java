package v1.knowledge;

/** User Story; child of Feature; leaf */
public class UserStoryDocumentType implements ChildOfDocumentType<v1.knowledge.FeatureDocumentType> {
    @Override public String getName() { return "UserStory"; }
    @Override public String getDescription() { return "User Story; child of Feature; leaf"; }
}
