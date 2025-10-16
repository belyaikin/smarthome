package me.polyubomu.smarthome.device;

import jakarta.persistence.*;
import lombok.*;
import me.polyubomu.smarthome.room.entity.Room;

@Entity
@Table(name = "devices")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
public abstract class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="room")
    private Room room;

    public abstract String operate();
}
