package io.raute.jpa.repository;

import io.raute.jpa.domain.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleInfoRepository extends JpaRepository<RoleInfo, Long>, JpaSpecificationExecutor<RoleInfo> {

}