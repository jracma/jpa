package io.raute.jpa.repository;

import io.raute.jpa.domain.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JobInfoRepository extends JpaRepository<JobInfo, Long>, JpaSpecificationExecutor<JobInfo> {

}