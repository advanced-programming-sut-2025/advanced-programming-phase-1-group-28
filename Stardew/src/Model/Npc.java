package Model;

import Model.Enums.NPC;

public class Npc {
    private NPC npc;

    public Npc(NPC npc) {
        this.npc = npc;
    }

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }
}
