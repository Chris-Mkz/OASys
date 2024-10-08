package cn.linter.oasys.attendance.controller;

import cn.linter.oasys.attendance.entity.Attendance;
import cn.linter.oasys.attendance.service.AttendanceService;
import cn.linter.oasys.common.entity.Result;
import cn.linter.oasys.common.entity.ResultStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 考勤控制器
 * @author ChirsMo
 * @since 2022/12/20
 */
@RestController
@RequestMapping("attendances")
public class AttendanceController {

    @Resource
    private AttendanceService attendanceService;

    /**
     * 出勤信息查询
     * @param userId
     * @param year
     * @param month
     * @param day
     * @return
     */
    @GetMapping
    public Result<List<Attendance>> listAttendance(@RequestParam Long userId, @RequestParam Integer year,
                                                   @RequestParam Integer month, Integer day) {
        return Result.of(ResultStatus.SUCCESS, attendanceService.listByUserIdAndClockDate(userId, year, month, day));
    }

    /**
     * 签到
     * @param userId
     * @return
     */
    @PostMapping
    public Result<Attendance> clockIn(@RequestParam Long userId) {
        return Result.of(ResultStatus.SUCCESS, attendanceService.create(userId));
    }

    /**
     * 签退
     * @param id
     * @return
     */
    @PutMapping
    public Result<Attendance> clockOut(@RequestParam Long id) {
        return Result.of(ResultStatus.SUCCESS, attendanceService.update(id));
    }

}