package me.polyubomu.smarthome.controller;

import me.polyubomu.smarthome.room.RoomFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public final class FacadeController {
    @Autowired
    private RoomFacade facade;

    @ShellMethod
    public String activateNightMode(@ShellOption Long roomId) {
        facade.activateNightMode(roomId);
        return "Activated night mode in room " + roomId;
    }

    @ShellMethod
    public String activateStandaloneMode() {
        facade.activateStandaloneMode();
        return "Activated standalone mode";
    }

    @ShellMethod
    public String activatePartyMode(@ShellOption Long roomId, @ShellOption String music) {
        facade.activatePartyMode(roomId, music);
        return "Activated party mode in room " + roomId;
    }
}
