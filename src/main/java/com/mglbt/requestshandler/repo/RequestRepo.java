package com.mglbt.requestshandler.repo;

import com.mglbt.requestshandler.model.AppRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestRepo extends JpaRepository<AppRequest, Long> {

}
