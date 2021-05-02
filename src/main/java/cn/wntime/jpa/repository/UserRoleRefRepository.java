package cn.wntime.jpa.repository;

import cn.wntime.jpa.domain.UserRoleRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRefRepository extends JpaRepository<UserRoleRef, Long>, JpaSpecificationExecutor<UserRoleRef> {

}