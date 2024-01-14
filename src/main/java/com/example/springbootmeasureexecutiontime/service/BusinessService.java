package com.example.springbootmeasureexecutiontime.service;

import java.time.Duration;
import java.util.Random;
import com.example.springbootmeasureexecutiontime.aspect.MeasureExecutionTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BusinessService {

  private final Random random = new Random();

  @MeasureExecutionTime
  public void execute() throws InterruptedException {
    long sleepSeconds = random.nextInt(1, 10);
    log.info("Sleeping for {} seconds", sleepSeconds);
    Thread.sleep(Duration.ofSeconds(sleepSeconds));
  }

}
