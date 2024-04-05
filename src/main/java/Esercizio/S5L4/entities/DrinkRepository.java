package Esercizio.S5L4.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    @Query("SELECT d FROM Drink d WHERE d.calories < :maxCalories")
    List<Drink> findDrinksWithCaloriesLessThan(@Param("maxCalories") int maxCalories);

}