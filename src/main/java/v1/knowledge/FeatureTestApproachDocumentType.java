package v1.knowledge;

/** Feature Test Approach; child of Feature or Epic */
public class FeatureTestApproachDocumentType implements ChildOfDocumentType<v1.knowledge.FeatureDocumentType> /* and Epic by convention */ {
    @Override public String getName() { return "Feature Test Approach"; }
    @Override public String getDescription() { return "Feature Test Approach; child of Feature or Epic"; }
}
