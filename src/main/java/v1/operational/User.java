package v1.operational;

import java.util.List;
import v1.operational.enums.UserRole;
import v1.operational.enums.UserGroup;

/** Author/actor value object. */
public record User(String id, String name, List<UserRole> roles, List<UserGroup> groups) { }
