package cn.wntime.jpa.initial;

import cn.wntime.jpa.domain.DeptInfo;
import cn.wntime.jpa.repository.DeptInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunners implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunners.class);

    @Autowired
    DeptInfoRepository deptInfoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("启动完成,生成初始数据");
        logger.info("生成部门数据");
        DeptInfo deptInfo = new DeptInfo().setDeptSort(0).setEnabled(true).setName("国安总部").setPid(0L);
        deptInfoRepository.save(deptInfo);

    }
}
