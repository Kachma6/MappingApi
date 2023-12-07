package com.Diplomado.MappingApi.repositories;

import com.Diplomado.MappingApi.domain.entities.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder,Integer> {
}
