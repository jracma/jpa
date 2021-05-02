package cn.wntime.jpa.initial;

import cn.wntime.jpa.common.Gender;
import cn.wntime.jpa.domain.*;
import cn.wntime.jpa.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ApplicationRunners implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunners.class);

    @Value("${project.init-data}")
    private Boolean initData;

    final
    DeptInfoRepository deptInfoRepository;

    final
    JobInfoRepository jobInfoRepository;

    final
    RoleInfoRepository roleInfoRepository;

    final
    UserInfoRepository userInfoRepository;

    final
    ResInfoRepository resInfoRepository;

    final
    JobRoleRefRepository jobRoleRefRepository;

    final
    RoleResRefRepository roleResRefRepository;

    final
    UserRoleRefRepository userRoleRefRepository;

    final
    DeptJobRefRepository deptJobRefRepository;

    public ApplicationRunners(DeptInfoRepository deptInfoRepository,
                              JobInfoRepository jobInfoRepository,
                              RoleInfoRepository roleInfoRepository,
                              UserInfoRepository userInfoRepository,
                              ResInfoRepository resInfoRepository,
                              JobRoleRefRepository jobRoleRefRepository,
                              RoleResRefRepository roleResRefRepository,
                              UserRoleRefRepository userRoleRefRepository,
                              DeptJobRefRepository deptJobRefRepository) {
        this.deptInfoRepository = deptInfoRepository;
        this.jobInfoRepository = jobInfoRepository;
        this.roleInfoRepository = roleInfoRepository;
        this.userInfoRepository = userInfoRepository;
        this.resInfoRepository = resInfoRepository;
        this.jobRoleRefRepository = jobRoleRefRepository;
        this.roleResRefRepository = roleResRefRepository;
        this.userRoleRefRepository = userRoleRefRepository;
        this.deptJobRefRepository = deptJobRefRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (initData && initial()) {
            logger.info("启动完成,初始化完成.");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    Boolean initial() throws Exception {
        try {

            logger.info("生成初始数据");
            DeptInfo deptInfo = new DeptInfo().setDeptSort(0).setEnabled(true).setName("国安总部").setPid(0L);
            deptInfoRepository.saveAndFlush(deptInfo);

            JobInfo jobInfo = new JobInfo().setName("国安总部中台管理员").setEnabled(true).setJobData(100).setJobSort(0L);
            jobInfoRepository.saveAndFlush(jobInfo);

            RoleInfo roleInfo = new RoleInfo().setRoleName("中台管理员").setRoleCode("MANAGER").setDescription("中台管理员,负责管理账号相关信息.");
            roleInfoRepository.saveAndFlush(roleInfo);

            UserInfo userInfo = new UserInfo().setEmail("manager@jpa.com").setGender(Gender.FMAIL).setJob(jobInfo).setLoginName("admin").setMobilePhone("13566666666")
                    .setNickName("管理员").setPassword("admin");
            userInfoRepository.save(userInfo);

            ResInfo resInfo = new ResInfo().setResCode("root").setResName("资源根节点").setResOrder(0L).setResParent(null)
                    .setResSort(0).setComponent("root").setHidden(false).setIcon("icon").setIFrame(false).setPath("/").setPermission("root").setTitle("根节点")
                    .setType(0);
            resInfoRepository.saveAndFlush(resInfo);

            JobRoleRef jobRoleRef = new JobRoleRef().setJob(jobInfo).setRole(roleInfo);
            jobRoleRefRepository.saveAndFlush(jobRoleRef);

            RoleResRef roleResRef = new RoleResRef().setRes(resInfo).setRole(roleInfo);
            roleResRefRepository.save(roleResRef);

            UserRoleRef userRoleRef = new UserRoleRef().setRole(roleInfo).setUser(userInfo);
            userRoleRefRepository.save(userRoleRef);

            DeptJobRef deptJobRef = new DeptJobRef().setDept(deptInfo).setJob(jobInfo);
            deptJobRefRepository.save(deptJobRef);

            return true;
        } catch (Exception e) {
            throw new Exception("初始数据失败:" + e.getLocalizedMessage());
        }

    }

}
