package v1.operational;

import lombok.Builder;
import lombok.Getter;
import java.util.EnumSet;
import v1.operational.enums.UserRole;

/** Access & approval policy for a document type. */
@Getter
@Builder
public class PermissionPolicy {
    private final EnumSet<UserRole> viewRoles;
    private final EnumSet<UserRole> editRoles;
    private final EnumSet<UserRole> reviewRoles;
    private final int minApprovers;

    public boolean canView(User u){ return u.roles().stream().anyMatch(viewRoles::contains); }
    public boolean canEdit(User u){ return u.roles().stream().anyMatch(editRoles::contains); }
    public boolean canReview(User u){ return u.roles().stream().anyMatch(reviewRoles::contains); }
}
