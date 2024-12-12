package com.vantageCircle.User.Aggregate.Report.service;

import com.vantageCircle.User.Aggregate.Report.UserAggregateReportApplication;
import com.vantageCircle.User.Aggregate.Report.dto.UserAggregateReport;
import com.vantageCircle.User.Aggregate.Report.entity.User;
import com.vantageCircle.User.Aggregate.Report.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserAggregateReportService {

    private static final Logger logger = LoggerFactory.getLogger(UserAggregateReportService.class);

    @Autowired
    private UserRepository repository;

    public List<UserAggregateReport> generateReport(LocalDate startDate, LocalDate endDate) {
        //Filters data by given date range with the isWithinDateRange() as helper method
        List<User> stepsData = repository.findByUserIdAndStepsAtBetweenDates(startDate, endDate).stream()
                .filter(data -> isWithinDateRange(data.getStepsAt(), startDate, endDate))
                .collect(Collectors.toList());

        //Groups the filtered data by userId
        Map<Long, List<User>> userStepsData = stepsData.stream()
                .collect(Collectors.groupingBy(User::getUserId));

        //For each grouped data, generateUserReport will be called for aggregated report
        return userStepsData.entrySet().stream()
                .map(entry -> generateUserReport(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    //Filters data by given date range.
    private boolean isWithinDateRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }

    private UserAggregateReport generateUserReport(Long userId, List<User> stepsList) {

        // Calculating total days and league days
        int totalDays = stepsList.size();
        long goldDays = countDaysInLeague(stepsList, 8000, Integer.MAX_VALUE);
        long silverDays = countDaysInLeague(stepsList, 4000, 8000);
        long bronzeDays = countDaysInLeague(stepsList, 0, 4000);


        double goldPercentage = calculatePercentage(goldDays, totalDays);
        double silverPercentage = calculatePercentage(silverDays, totalDays);
        double bronzePercentage = calculatePercentage(bronzeDays, totalDays);


        String primaryLeague = determinePrimaryLeague(goldDays, silverDays, bronzeDays);


        logger.info("Report for userId: {} - Total Days: {}, Gold: {}, Silver: {}, Bronze: {}",
                userId, totalDays, goldDays, silverDays, bronzeDays);


        return new UserAggregateReport(userId, totalDays, goldDays, silverDays, bronzeDays,
                goldPercentage, silverPercentage, bronzePercentage, primaryLeague);
    }

    private long countDaysInLeague(List<User> stepsList, int minSteps, int maxSteps) {
        return stepsList.stream()
                .filter(user -> user.getStepsCount() >= minSteps && user.getStepsCount() <= maxSteps)
                .count();
    }

    private double calculatePercentage(long leagueDays, int totalDays) {
        return totalDays > 0 ? (leagueDays * 100.0) / totalDays : 0.0;
    }

    private String determinePrimaryLeague(long goldDays, long silverDays, long bronzeDays) {
        if (silverDays > goldDays && silverDays >= bronzeDays) {
            return "Silver";
        } else if (bronzeDays > goldDays && bronzeDays > silverDays) {
            return "Bronze";
        }
        return "Gold";
    }
}