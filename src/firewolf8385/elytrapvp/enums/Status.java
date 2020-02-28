package firewolf8385.elytrapvp.enums;

import java.util.HashMap;
import java.util.UUID;

public enum Status
{
    ARENA,
    LOBBY,
    SPECTATOR,
    OTHER;

    public static HashMap<UUID, Status> list = new HashMap<>();
}
