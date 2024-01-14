package com.example.springbootmeasureexecutiontime.controller;

import com.example.springbootmeasureexecutiontime.service.BusinessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class Controller {

  private final BusinessService businessService;

  @GetMapping
  public void execute() throws InterruptedException {
    try {
      businessService.execute();
    } finally {
      log.info("Execution completed");
    }
  }

}
