package com.atassian.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class StopWatchTimerApplication {

    private long startTime = 0;
    private boolean isRunning = false;
    private long elapsedTime = 0;

    @GetMapping("/start")
    public ResponseEntity<String> startTimer() {

        if(!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
            return ResponseEntity.ok("Timer Started");
        } else {
            return ResponseEntity.ok("Timer is already running");
        }
    }

    @GetMapping("/stop")
    public ResponseEntity<String> stopTimer() {
        if (isRunning) {
            elapsedTime += System.currentTimeMillis() - startTime;
            isRunning = false;
            return ResponseEntity.ok("Timer stopped!");
        } else {
            return ResponseEntity.ok("Timer is not running!");
        }
    }

    @GetMapping("/reset")
    public ResponseEntity<String> resetTimer() {
        startTime = 0;
        isRunning = false;
        elapsedTime = 0;
        return ResponseEntity.ok("Timer reset!");
    }

    @GetMapping("/elapsed")
    public ResponseEntity<String> getElapsed() {
        if (isRunning) {
            return ResponseEntity.ok("Elapsed time: " + (elapsedTime + System.currentTimeMillis() - startTime) + " milliseconds");
        } else {
            return ResponseEntity.ok("Elapsed time: " + elapsedTime + " milliseconds");
        }
    }

    @GetMapping("/elapsedCalculated")
    public int getElapsedNew() {
        int timeInMilliseconds = 0;
//        if (isRunning) {
//            return ResponseEntity.ok("Elapsed time: " + (elapsedTime + System.currentTimeMillis() - startTime) + " milliseconds");
//        } else {
//            return ResponseEntity.ok("Elapsed time: " + elapsedTime + " milliseconds");
//        }
        return timeInMilliseconds;
    }




}
