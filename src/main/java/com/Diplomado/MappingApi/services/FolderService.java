package com.Diplomado.MappingApi.services;

import com.Diplomado.MappingApi.domain.entities.Folder;

import java.util.List;
import java.util.Optional;

public interface FolderService {
    List<Folder> getFolders();
    Optional<Folder> getFolderById(Integer id);
    Folder save(Folder folder);
    void delete(Integer id);
}
