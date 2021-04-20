package cn.wntime.jpa.repository;

import cn.wntime.jpa.domain.DeptInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaInfoRepository extends JpaRepository<DeptInfo, Long>, JpaSpecificationExecutor<DeptInfo> {

}