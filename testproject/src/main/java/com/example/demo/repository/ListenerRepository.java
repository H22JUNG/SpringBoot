package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entity.ListenerEntity;

public interface ListenerRepository extends JpaRepository<ListenerEntity, Long>{

}
