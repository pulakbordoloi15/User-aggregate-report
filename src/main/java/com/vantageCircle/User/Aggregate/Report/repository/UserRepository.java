package com.vantageCircle.User.Aggregate.Report.repository;

import com.vantageCircle.User.Aggregate.Report.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.stepsAt BETWEEN :startDate AND :endDate")
    List<User> findByUserIdAndStepsAtBetweenDates(@Param("startDate") LocalDate startDate,
                                            @Param("endDate") LocalDate endDate);
}
