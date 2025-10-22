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
        facade.activateNightMove(roomId);
        return "Activated night mode in room " + roomId;
    }
}
