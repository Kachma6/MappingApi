package com.Diplomado.MappingApi.web.rest;

import com.Diplomado.MappingApi.domain.entities.Folder;
import com.Diplomado.MappingApi.services.FolderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/folders")
public class FolderController {
    private final FolderService folderService;

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }
    @GetMapping
    public ResponseEntity<List<Folder>> getFolders(){
        return ResponseEntity.ok().body(folderService.getFolders());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Folder>> getFolderById(@PathVariable Integer id){
        return ResponseEntity.ok().body(folderService.getFolderById(id));
    }
    @PostMapping
    public ResponseEntity<Folder> save(@RequestBody Folder folder) throws URISyntaxException {
        if(folder.getFolderId() != null){
            throw new IllegalArgumentException("This folder shouldn't have id");
        }
        folder.setCreatedTs(LocalDateTime.now());
        folder.setProgress(0);
        Folder folderdb = folderService.save(folder);
        return ResponseEntity.created(new URI("/v1/folders/"+folderdb.getFolderId())).body(folderdb);
    }
}
