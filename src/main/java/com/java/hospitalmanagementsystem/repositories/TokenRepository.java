package com.java.hospitalmanagementsystem.repositories;

import com.java.hospitalmanagementsystem.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for RoomType entities. Extends JpaRepository to facilitate database
 * operations for room types. Includes a custom query to find available room types based on room
 * occupancy and availability within a specified date range.
 */
public interface TokenRepository extends JpaRepository<Token, Integer> {
  @Query("SELECT t FROM Token t " + "join User u on t.user.id = u.id " + "WHERE u.id = :userId")
  List<Token> findAllValidTokensByUser(int userId);

  Optional<Token> findByToken(String token);
}
