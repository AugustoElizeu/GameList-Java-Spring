package com.application.gamelist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.gamelist.entities.Game;
import com.application.gamelist.projections.GameMinProjection;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	@Query(nativeQuery = true, value = """
			SELECT games.id, games.title, games.game_year AS `year`, games.img_url AS imgUrl,
			games.short_description AS shortDescription, belongings.position
			FROM games
			INNER JOIN belongings ON games.id = belongings.game_id
			WHERE belongings.gamelist_id = :listId
			ORDER BY belongings.position;
				""")
	List<GameMinProjection> searchByList(Long listId);
}
