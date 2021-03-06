package com.chenyx.ssm.service.impl;

import com.chenyx.ssm.dao.ISysLogDao;
import com.chenyx.ssm.domain.Syslog;
import com.chenyx.ssm.service.ISysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void save(Syslog syslog) throws Exception {
        sysLogDao.save(syslog);
    }

    @Override
    public List<Syslog> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return sysLogDao.findAll();
    }
}
