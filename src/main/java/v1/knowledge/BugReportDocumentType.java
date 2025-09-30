package v1.knowledge;

/** Bug Report; child of User Story */
public class BugReportDocumentType implements ChildOfDocumentType<v1.knowledge.UserStoryDocumentType> {
    @Override public String getName() { return "BugReport"; }
    @Override public String getDescription() { return "Bug Report; child of User Story"; }
}
