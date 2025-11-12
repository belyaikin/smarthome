package me.polyubomu.smarthome.device;

import jakarta.persistence.*;
import me.polyubomu.smarthome.room.entity.Room;
import me.polyubomu.smarthome.device.visitor.DeviceVisitor;

@Entity
@Table(name = "devices")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="room")
    private Room room;

    public abstract String operate();
    public abstract void accept(DeviceVisitor visitor);

    public Device() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
