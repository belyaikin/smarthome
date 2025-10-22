package me.polyubomu.smarthome.device.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.polyubomu.smarthome.device.EnableableDevice;

@Entity
@Table(name = "music_players")
@NoArgsConstructor
@Getter
@Setter
public class MusicPlayer extends EnableableDevice {
    @Column
    private String music;

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
}
