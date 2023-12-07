package com.Diplomado.MappingApi.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@Entity
@Table(name = "folders")
public class Folder {
    @Id
    @Column(name = "folder_id")
    @SequenceGenerator(name = "folder_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "folder_sequence")
    private Integer folderId;
    @Column(name = "folder_name")
    private String folderName;

    private String description;

    private Integer progress;
    @Column(name = "created_ts")
    private LocalDateTime createdTs;
    @Column(name = "update_ts")
    private LocalDateTime updateTs;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Folder(String folderName, String description, Integer progress, LocalDateTime createdTs, LocalDateTime updateTs, User user) {
        this.folderName = folderName;
        this.description = description;
        this.progress = progress;
        this.createdTs = createdTs;
        this.updateTs = updateTs;
        this.user = user;
    }
}
