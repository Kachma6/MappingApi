package com.Diplomado.MappingApi.services.implement;

import com.Diplomado.MappingApi.domain.entities.Folder;
import com.Diplomado.MappingApi.repositories.FolderRepository;
import com.Diplomado.MappingApi.services.FolderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FolderServiceImplement implements FolderService {
    private final FolderRepository folderRepository;

    public FolderServiceImplement(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }


    @Override
    public List<Folder> getFolders() {
        return folderRepository.findAll();
    }

    @Override
    public Optional<Folder> getFolderById(Integer id) {
        return folderRepository.findById(id);
    }

    @Override
    public Folder save(Folder folder) {
        return folderRepository.save(folder);
    }

    @Override
    public void delete(Integer id) {
        folderRepository.deleteById(id);
    }
}
