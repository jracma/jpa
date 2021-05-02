package cn.wntime.jpa.repository;

import cn.wntime.jpa.domain.JobRoleRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRoleRefRepository extends JpaRepository<JobRoleRef, Long>, JpaSpecificationExecutor<JobRoleRef> {

}