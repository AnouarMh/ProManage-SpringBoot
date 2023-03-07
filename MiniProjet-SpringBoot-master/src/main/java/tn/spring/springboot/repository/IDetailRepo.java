package tn.spring.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.spring.springboot.entities.Detail;

public interface IDetailRepo extends JpaRepository<Detail, Long>{
    final String query = "" +
        "SELECT d " +
        "FROM Detail d " +
        "WHERE " +
        "(:name IS NULL OR d.name = :name) " +
        "AND (:detail IS NULL OR d.detail = :detail)";

    @Query(query)
    public List<Detail> findByArgs(
        @Param("name") String name,
        @Param("detail") String detail
    );

    @Query("SELECT d FROM Detail d ORDER BY d.name")
    public List<Detail> findAllSortName();

    @Query("SELECT d FROM Detail d ORDER BY d.name DESC")
    public List<Detail> findAllSortNameDESC();
}
