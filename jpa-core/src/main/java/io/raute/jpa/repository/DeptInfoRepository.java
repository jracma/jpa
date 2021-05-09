package io.raute.jpa.repository;

import io.raute.jpa.domain.DeptInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptInfoRepository extends JpaRepository<DeptInfo, Long>, JpaSpecificationExecutor<DeptInfo> {

}