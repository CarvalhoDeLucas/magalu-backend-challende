package com.carvalhodelucas.magalums.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "channels")
@NoArgsConstructor
@Getter
@Setter
public class Channel {

    @Id
    private Long channelId;
    private String description;

    public Channel(Long id, String description) {
        this.channelId = id;
        this.description = description;
    }

    @AllArgsConstructor
    public enum Values {
        EMAIL(1L, "email"),
        SMS(2L, "sms"),
        PUSH(3L, "push"),
        WHATSAPP(4L, "whatsapp");

        private Long id;
        private String description;

        public Channel toChannel() {
            return new Channel(id, description);
        }
    }

}
