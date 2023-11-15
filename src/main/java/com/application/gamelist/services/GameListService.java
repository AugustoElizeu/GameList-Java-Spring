package com.application.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.gamelist.dto.GameDTO;
import com.application.gamelist.dto.GameListDTO;
import com.application.gamelist.entities.Game;
import com.application.gamelist.entities.GameList;
import com.application.gamelist.repositories.GameListRepository;


@Service
public class GameListService {
	
	@Autowired
	private GameListRepository glr;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = glr.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
}
