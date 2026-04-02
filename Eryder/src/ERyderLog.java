import java.time.LocalDateTime;

public class ERyderLog {
    private String log;
    private String event;
    private LocalDateTime timestamp;

    public ERyderLog(String log, String event, LocalDateTime timestamp) {
        this.log = log;
        this.event = event;
        this.timestamp = timestamp;
    }

    public String getLog() {
        return log;
    }

    public String getEvent() {
        return event;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ERyderLog" +
                "log='" + log + '\'' +
                ", event='" + event + '\'' +
                ", timestamp=" + timestamp;
    }

}
