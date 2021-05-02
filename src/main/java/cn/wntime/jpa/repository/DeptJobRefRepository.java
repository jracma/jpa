package cn.wntime.jpa.repository;

import cn.wntime.jpa.domain.DeptJobRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptJobRefRepository extends JpaRepository<DeptJobRef, Long>, JpaSpecificationExecutor<DeptJobRef> {

}