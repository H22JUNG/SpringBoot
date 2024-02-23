package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.entity.ListenerEntity;
import com.example.demo.repository.ListenerRepository;
import com.example.demo.service.ListenerService;

@Service
public class ListenerServiceImpl implements ListenerService {
	
	@Autowired
	private ListenerRepository listenerRepository;

	@Override
	public ListenerEntity getEntity(Long id) {
		return listenerRepository.findById(id).get();
	}

	@Override
	public void saveEntity(ListenerEntity listenerEntity) {
		listenerRepository.save(listenerEntity);

	}

	@Override
	public void updateEntity(ListenerEntity listenerEntity) {
		ListenerEntity foundListener = listenerRepository.findById(listenerEntity.getId()).get();
		foundListener.setName(listenerEntity.getName());
		
		listenerRepository.save(foundListener);

	}

	@Override
	public void removeEntity(ListenerEntity listenerEntity) {
		listenerRepository.delete(listenerEntity);

	}

}
