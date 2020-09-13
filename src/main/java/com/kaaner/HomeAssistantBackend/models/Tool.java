package com.kaaner.HomeAssistantBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tools")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tool_name")
    private String toolName;

    @Column(name = "statu")
    private String statu;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "room_id",nullable = false)
    @JsonIgnore
    private Room room;
}
