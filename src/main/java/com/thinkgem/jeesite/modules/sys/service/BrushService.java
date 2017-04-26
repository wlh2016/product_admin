package com.thinkgem.jeesite.modules.sys.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.dao.BrushDao;
import com.thinkgem.jeesite.modules.sys.entity.Brush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tony_Wu
 * @date 2017-4-26
 */
@Service
@Transactional(readOnly = true)
public class BrushService extends CrudService<BrushDao, Brush> {

    @Autowired
    private BrushDao brushDao;

}
