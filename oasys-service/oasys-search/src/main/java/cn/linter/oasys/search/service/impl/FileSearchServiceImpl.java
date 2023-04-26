package cn.linter.oasys.search.service.impl;

import cn.linter.oasys.search.entity.File;
import cn.linter.oasys.search.repository.FileSearchRepository;
import cn.linter.oasys.search.service.FileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 文件搜索服务实现类
 * @author ChrisMo
 * @since 2023/1/10
 */
@Service
public class FileSearchServiceImpl implements FileSearchService {

    @Resource
    private FileSearchRepository fileSearchRepository;

    @Override
    public void saveFile(File file) {
        fileSearchRepository.save(file);
    }

    @Override
    public void deleteFileById(Long id) {
        fileSearchRepository.deleteById(id);
    }

    @Override
    public Page<File> findAllByName(String name, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return fileSearchRepository.findAllByName(name, pageable);
    }

}
