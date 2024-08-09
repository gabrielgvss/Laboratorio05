package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Table (name = "cliente")
@Entity
public @Data class Cliente extends PessoaFisica {
    @Column
    private String contato;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Frete> fretes = new HashSet<>();

}
