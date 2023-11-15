package com.application.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.gamelist.dto.GameDTO;
import com.application.gamelist.dto.GameMinDTO;
import com.application.gamelist.entities.Game;
import com.application.gamelist.projections.GameMinProjection;
import com.application.gamelist.repositories.GameRepository;


@Service
public class GameService {
	
	@Autowired
	private GameRepository gr;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gr.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long gameId) {
		Game result = gr.findById(gameId).get();
		return new GameDTO(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gr.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
