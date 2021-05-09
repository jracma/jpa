package io.raute.jpa.repository;

import io.raute.jpa.domain.ResInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ResInfoRepository extends JpaRepository<ResInfo, Long>, JpaSpecificationExecutor<ResInfo> {

}