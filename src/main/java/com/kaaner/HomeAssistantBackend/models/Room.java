package com.kaaner.HomeAssistantBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "room_name")
    @NotEmpty(message = "Oda adı boş birakilamaz!")
    private String roomName;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "users_id",nullable = false)
    @JsonIgnore
    private User users;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore //Belirtilen alanın json'a çevrilmemesini sağlar
    private Set<Tool> tools;

}
