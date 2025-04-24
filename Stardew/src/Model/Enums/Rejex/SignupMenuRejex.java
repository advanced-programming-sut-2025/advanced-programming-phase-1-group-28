package Model.Enums.Rejex;

import java.util.regex.Pattern;

public enum SignupMenuRejex {
    Register(Pattern.compile("register\\s+-u\\s+(.+)\\s+-p\\s+(.+)\\s+(.+)\\s+-n\\s+(.+)\\s+-e\\s+(.+)\\s+-g\\s+(.+)")),
    ValidUser(Pattern.compile("^[a-zA-Z0-9-]+$")),
    ValidEmail(Pattern.compile("^(?![._-])[a-zA-Z0-9._-]+(?<![._-])@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*\\.(?:org|com|net)$"));
    public final Pattern Rejex;

    SignupMenuRejex(Pattern Rejex) {
        this.Rejex = Rejex;
    }
}
