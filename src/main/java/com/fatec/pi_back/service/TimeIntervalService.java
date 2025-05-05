package main.java.com.fatec.pi_back.service;

@Service
public class TimeIntervalService {

    public TimeInterval createTimeInterval(TimeIntervalDTO data) {
        TimeInterval timeInterval = new TimeInterval();
        timeInterval.setTimeInterval(data.timeInterval());
        return timeInterval;
    }
}
