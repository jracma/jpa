package cn.wntime.jpa.repository;

import cn.wntime.jpa.domain.RoleResRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleResRefRepository extends JpaRepository<RoleResRef, Long>, JpaSpecificationExecutor<RoleResRef> {

}