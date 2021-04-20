package cn.wntime.jpa.repository;

import cn.wntime.jpa.domain.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;

@Repository
public interface OrgInfoRepository extends JpaRepository<JobInfo, Long>, JpaSpecificationExecutor<JobInfo> {

}