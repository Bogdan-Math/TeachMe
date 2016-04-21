package ua.teachme.service;

import ua.teachme.model.Notation;

import java.time.LocalDateTime;
import java.util.List;

public interface NotationService extends Service<Notation> {

    List<Notation> getBetween(LocalDateTime start, LocalDateTime end);

}