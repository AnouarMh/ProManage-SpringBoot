package tn.spring.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.spring.springboot.entities.Team;

public interface ITeamRepo extends JpaRepository<Team, Long> {
    final String query = "" +
        "SELECT t " +
        "FROM Team t " +
        "WHERE " +
        "(:name IS NULL OR t.name = :name) " +
        "AND (:description IS NULL OR t.description = :description) " +
        "AND (:detail_id IS NULL OR t.detailId = :detail_id)";

    @Query(query)
    public List<Team> findByArgs(
        @Param("name") String name,
        @Param("description") String desc,
        @Param("detail_id") Long detail_id
    );

    @Query("SELECT t FROM Team t ORDER BY t.name")
    public List<Team> findAllSortName();

    @Query("SELECT t FROM Team t ORDER BY t.name DESC")
    public List<Team> findAllSortNameDESC();
}
