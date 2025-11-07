package me.polyubomu.smarthome.device.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import me.polyubomu.smarthome.device.EnableableDevice;

@Entity
@Table(name = "music_players")
public class MusicPlayer extends EnableableDevice {
    @Column
    private String music;

    public MusicPlayer() {}

    @Override
    protected String getEnabledMessage() {
        if (music.isEmpty() || music.isBlank()) {
            return "Please specify a song!";
        }
        return "Playing " + music;
    }

    @Override
    protected String getDisabledMessage() {
        return "Stopped playing " + music;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }
}
