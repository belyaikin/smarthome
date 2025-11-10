package me.polyubomu.smarthome.command.mode;

import me.polyubomu.smarthome.room.RoomFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.ShellOption;

@Command(command = "mode")
public final class ModeCommand {
    @Autowired
    private RoomFacade facade;

    @Command(command = "night")
    public String activateNightMode(@ShellOption Long roomId) {
        facade.activateNightMode(roomId);
        return "Activated night mode in room " + roomId;
    }

    @Command(command = "standalone")
    public String activateStandaloneMode() {
        facade.activateStandaloneMode();
        return "Activated standalone mode";
    }

    @Command(command = "party")
    public String activatePartyMode(@ShellOption Long roomId, @ShellOption String music) {
        facade.activatePartyMode(roomId, music);
        return "Activated party mode in room " + roomId;
    }
}
