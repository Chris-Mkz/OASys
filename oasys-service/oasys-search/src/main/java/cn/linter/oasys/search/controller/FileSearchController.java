package cn.linter.oasys.search.controller;

import cn.linter.oasys.common.entity.Page;
import cn.linter.oasys.common.entity.Result;
import cn.linter.oasys.common.entity.ResultStatus;
import cn.linter.oasys.search.entity.File;
import cn.linter.oasys.search.service.FileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文件搜索控制器
 * @author ChrisMo
 * @since 2023/1/10
 */
@RestController
@RequestMapping("searches/files")
public class FileSearchController {

    @Resource
    private FileSearchService fileSearchService;

    @PostMapping
    public void saveFile(@RequestBody File file) {
        fileSearchService.saveFile(file);
    }

    @DeleteMapping("{id}")
    public void deleteFileById(@PathVariable Long id) {
        fileSearchService.deleteFileById(id);
    }

    @GetMapping
    public Result<Page<File>> queryFile(@RequestParam String name, @RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "10") int pageSize) {
        org.springframework.data.domain.Page<File> files = fileSearchService.findAllByName(name, pageNumber, pageSize);
        return Result.of(ResultStatus.SUCCESS, Page.of(files.getContent(), files.getTotalElements()));
    }

}
