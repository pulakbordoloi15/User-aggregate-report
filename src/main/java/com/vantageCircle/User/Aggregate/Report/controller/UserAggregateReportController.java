package com.vantageCircle.User.Aggregate.Report.controller;

import com.vantageCircle.User.Aggregate.Report.dto.UserAggregateReport;
import com.vantageCircle.User.Aggregate.Report.service.UserAggregateReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class UserAggregateReportController {
    @Autowired
    UserAggregateReportService userAggregateReportService;


    @GetMapping("/user-aggregate")
    public List<UserAggregateReport> getUserAggregateReport(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return userAggregateReportService.generateReport(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
}
