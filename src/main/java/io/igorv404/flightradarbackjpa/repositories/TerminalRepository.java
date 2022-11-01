package io.igorv404.flightradarbackjpa.repositories;

import io.igorv404.flightradarbackjpa.models.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Integer> {}
