package menumaker.exception;

import java.time.LocalDate;


public class ExceptionResponse {

    private LocalDate date;
    private String message;
    private String detail;

    public ExceptionResponse(LocalDate date, String message, String detail) {
        this.date = date;
        this.message = message;
        this.detail = detail;
    }

    public LocalDate getDate() {
        return date;
    }

    public ExceptionResponse setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ExceptionResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public ExceptionResponse setDetail(String detail) {
        this.detail = detail;
        return this;
    }
}
