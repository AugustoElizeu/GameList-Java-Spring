package com.application.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.gamelist.dto.GameMinDTO;
import com.application.gamelist.entities.Game;
import com.application.gamelist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gr;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gr.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
