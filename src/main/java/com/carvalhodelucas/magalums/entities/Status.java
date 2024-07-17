package com.carvalhodelucas.magalums.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "status")
@NoArgsConstructor
@Getter
@Setter
public class Status {

    @Id
    private Long statusId;
    private String description;

    public Status(Long id, String description) {
        this.statusId = id;
        this.description = description;
    }

    @AllArgsConstructor
    public enum Values {
        PENDING(1L, "pending"),
        SUCCESS(2L, "success"),
        ERROR(3L, "error"),
        CANCELED(4L, "canceled");

        private Long id;
        private String description;

        public Status toStatus() {
            return new Status(id, description);
        }
    }

}
