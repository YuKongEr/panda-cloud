package com.yukong.panda.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.yukong.panda.common.base.controller.BaseController;
import com.yukong.panda.common.constants.CommonConstants;
import com.yukong.panda.common.enums.JobDataStatusEnum;
import com.yukong.panda.common.exception.PandaException;
import com.yukong.panda.common.util.UserUtil;
import com.yukong.panda.user.model.entity.SysQuartzJob;
import com.yukong.panda.user.model.query.SysQuartzJobQuery;
import com.yukong.panda.user.service.SysQuartzJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author yukong
 * @date 2019-05-08 09:52
 */
@RestController
@Slf4j
@RequestMapping("/quartz/job")
@Transactional(rollbackFor = Exception.class)
@Api(value = "定时任务controller", tags = {"定时任务操作接口"})
public class SysQuartzJobController extends BaseController<SysQuartzJobService, SysQuartzJobQuery, SysQuartzJob, Integer> {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private HttpServletRequest request;


    @PostMapping(value = "/add")
    @ApiOperation(value = "添加定时任务")
    public R addJob(@RequestBody SysQuartzJob job){

        if (StringUtils.isBlank(job.getJobClassName()) || StringUtils.isBlank(job.getCronExpression())) {
            return R.failed("参数不能为空！");
        }
        QueryWrapper<SysQuartzJob> quartzJobQueryWrapper = new QueryWrapper<>();
        quartzJobQueryWrapper.lambda().eq(SysQuartzJob::getJobClassName, job.getJobClassName());
        List<SysQuartzJob> res = baseService.list(quartzJobQueryWrapper);
        if(!CollectionUtils.isEmpty(res)) {
            return R.failed("当前任务已经存在！");
        }
        job.setStatus(JobDataStatusEnum.UP.getCode());
        job.setCreateBy(UserUtil.getUserName(request));
        job.setCreateTime(new Date());
        add(job.getJobClassName(),job.getCronExpression(),job.getParameter());
        baseService.save(job);
        return  R.ok(job);
    }

    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    @ApiOperation(value = "更新定时任务")
    public R editJob(@RequestBody SysQuartzJob job){

        delete(job.getJobClassName());
        add(job.getJobClassName(),job.getCronExpression(),job.getParameter());
        job.setStatus(JobDataStatusEnum.UP.getCode());
        job.setUpdateBy(UserUtil.getUserName(request));

        baseService.updateById(job);
        return R.ok("更新定时任务成功");
    }

    @RequestMapping(value = "/pause",method = RequestMethod.POST)
    @ApiOperation(value = "暂停定时任务")
    public R pauseJob(@RequestBody SysQuartzJob job){

        try {
            scheduler.pauseJob(JobKey.jobKey(job.getJobClassName()));
        } catch (SchedulerException e) {
            throw new PandaException("暂停定时任务失败");
        }
        job.setStatus(JobDataStatusEnum.STOP.getCode());
        job.setUpdateBy(UserUtil.getUserName(request));

        baseService.updateById(job);
        return R.ok("暂停定时任务成功");
    }

    @RequestMapping(value = "/resume",method = RequestMethod.POST)
    @ApiOperation(value = "恢复定时任务")
    public R resumeJob(@RequestBody SysQuartzJob job){
        job.setUpdateBy(UserUtil.getUserName(request));

        try {
            scheduler.resumeJob(JobKey.jobKey(job.getJobClassName()));
        } catch (SchedulerException e) {
            throw new PandaException("恢复定时任务失败");
        }
        job.setStatus(JobDataStatusEnum.UP.getCode());
        baseService.updateById(job);
        return  R.ok("恢复定时任务成功");
    }

    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除定时任务")
    public R deleteJob(@PathVariable Integer[] ids){

        for(Integer id:ids){
            SysQuartzJob job = baseService.getById(id);
            delete(job.getJobClassName());
            baseService.removeById(id);
        }
        return R.ok("删除定时任务成功");
    }

    /**
     * 添加定时任务
     * @param jobClassName
     * @param cronExpression
     * @param parameter
     */
    public void add(String jobClassName, String cronExpression, String parameter){

        try {
            // 启动调度器
            scheduler.start();

            //构建job信息
            JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass())
                    .withIdentity(jobClassName)
                    .usingJobData(CommonConstants.DEFAULT_PARAMTER_KEY,parameter)
                    .build();

            //表达式调度构建器(即任务执行的时间) 使用withMisfireHandlingInstructionDoNothing() 忽略掉调度暂停过程中没有执行的调度
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();

            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName)
                    .withSchedule(scheduleBuilder).build();

            scheduler.scheduleJob(jobDetail, trigger);
        } catch (PandaException e) {
            log.error(e.toString());
            throw new PandaException("创建定时任务失败");
        } catch (Exception e){
            throw new PandaException(e.getMessage());
        }
    }

    /**
     * 删除定时任务
     * @param jobClassName
     */
    public void delete(String jobClassName){

        try {
            scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName));
            scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName));
            scheduler.deleteJob(JobKey.jobKey(jobClassName));
        } catch (Exception e) {
            throw new PandaException("删除定时任务失败");
        }
    }

    public static Job getClass(String classname) throws Exception {
        Class<?> class1 = Class.forName(classname);
        return (Job)class1.newInstance();
    }


}
