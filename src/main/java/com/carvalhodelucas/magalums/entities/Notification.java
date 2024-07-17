package com.carvalhodelucas.magalums.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Notification {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateTime;
    private String destination;
    private String message;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

}
