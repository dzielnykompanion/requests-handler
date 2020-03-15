package com.mglbt.requestshandler.web;


import com.mglbt.requestshandler.model.AppRequest;
import com.mglbt.requestshandler.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {

    @Autowired
    RequestService requestService;

   @PostMapping("/add-request")
    public ResponseEntity<?> addOrUpdateRequest(@RequestBody AppRequest appRequest) {
       requestService.addOrUpdateRequest(appRequest);
       return new ResponseEntity<String>("Created: " + appRequest.toString(), HttpStatus.CREATED);
   }

   @GetMapping("/{id}")
   public AppRequest getRequest(@PathVariable Long id){

       return requestService.getRequest(id);
   }

   @GetMapping("/all")
    public List<AppRequest> getAllRequest() {
       return requestService.getAllRequest();
   }

   @DeleteMapping("/delete-request/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
       requestService.deleteRequest(id);
       return new ResponseEntity<String>("Deleted request: " + id, HttpStatus.OK);
   }
}
