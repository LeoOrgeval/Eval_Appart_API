package com.eval.appart.shared.repository;

import com.eval.appart.shared.domain.Equipement;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@ApplicationScoped
@Slf4j
public class EquipementRepository implements PanacheRepository<Equipement>{
    public Equipement findById(UUID id) {
        return find("id", id).firstResult();
    }

    public void deleteById(UUID id) {
        delete("id", id);
    }
}
