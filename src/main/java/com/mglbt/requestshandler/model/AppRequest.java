package com.mglbt.requestshandler.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class AppRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank(message = "Request cannot be blank")
    private String request;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate due_date;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(updatable = false)
    private LocalDate created_At;


    public AppRequest() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public LocalDate getCreated_At() {
        return created_At;
    }

    public void setCreated_At(LocalDate created_At) {
        this.created_At = created_At;
    }

    public LocalDate getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }

    @PrePersist
    protected void onCreate(){
        this.created_At = LocalDate.now();
    }

    @Override
    public String toString() {
        return "AppRequest{" +
                "ID=" + ID +
                ", request='" + request + '\'' +
                ", due_date=" + due_date +
                ", created_At=" + created_At +
                '}';
    }
}
