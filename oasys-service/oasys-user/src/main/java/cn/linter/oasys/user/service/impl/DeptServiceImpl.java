package cn.linter.oasys.user.service.impl;

import cn.linter.oasys.user.dao.DeptDao;
import cn.linter.oasys.user.entity.Dept;
import cn.linter.oasys.user.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 部门服务实现类
 * @author ChrisMo
 * @since 2023/01/14
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDao deptDao;

    @Override
    public Dept queryById(Integer id) {
        return deptDao.selectById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.list();
    }

    @Override
    public Dept create(Dept dept) {
        LocalDateTime now = LocalDateTime.now();
        dept.setCreateTime(now);
        dept.setUpdateTime(now);
        deptDao.insert(dept);
        return dept;
    }

    @Override
    public Dept update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptDao.update(dept);
        return queryById(dept.getId());
    }

    @Override
    public boolean delete(Integer id) {
        return deptDao.delete(id) > 0;
    }

}