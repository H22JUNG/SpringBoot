package com.example.demo.data.entity.listener;

import com.example.demo.data.entity.ListenerEntity;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomListener {
	
	@PostLoad
    public void postLoad(ListenerEntity entity) {
        log.info("[postLoad] called!!");
    }

    @PrePersist
    public void prePersist(ListenerEntity entity) {
        log.info("[prePersist] called!!");
    }

    @PostPersist
    public void postPersist(ListenerEntity entity) {
        log.info("[postPersist] called!!");
    }

    @PreUpdate
    public void preUpdate(ListenerEntity entity) {
        log.info("[preUpdate] called!!");
    }

    @PostUpdate
    public void postUpdate(ListenerEntity entity) {
        log.info("[postUpdate] called!!");
    }

    @PreRemove
    public void preRemove(ListenerEntity entity) {
        log.info("[preRemove] called!!");
    }

    @PostRemove
    public void postRemove(ListenerEntity entity) {
        log.info("[postRemove] called!!");
    }
	
}
