package com.qfedu.service.impl;

import com.qfedu.dao.SubjectMapper;
import com.qfedu.pojo.Subject;
import com.qfedu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/7/2.
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;
    public Subject selectSubjectById(int subjectId) {
        return subjectMapper.selectSubjectById(subjectId);
    }
}
