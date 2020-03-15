package com.mglbt.requestshandler.service;

import com.mglbt.requestshandler.model.AppRequest;
import com.mglbt.requestshandler.repo.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RequestService {

    @Autowired
    RequestRepo requestRepo;

    public AppRequest findRequestById(Long id) {
        AppRequest appRequest = requestRepo.findById(id).get();
        if (appRequest == null) {
            // TODO custom handle error instead of this from .get()
            }
            return requestRepo.findById(id).get();
    }

    public AppRequest addOrUpdateRequest(AppRequest appRequest) {

            if (appRequest.getID() != null) {
            AppRequest currentAppRequest = findRequestById(appRequest.getID());
                return requestRepo.save(appRequest);
            }

        if (appRequest.getDue_date() == null) {
            LocalDate defaultDueDate = LocalDate.now().plusDays(7);
            appRequest.setDue_date(defaultDueDate);
        }
        return requestRepo.save(appRequest);
    }

    public AppRequest getRequest(Long id) {
        return findRequestById(id);
    }

    public List<AppRequest> getAllRequest() {
        return requestRepo.findAll();
    }

    public void deleteRequest(Long id) {
        requestRepo.delete(findRequestById(id));
    }

}
