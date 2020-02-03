package org.layz.hx.core.entity;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.annotation.HxSupperClass;

import java.util.Date;

@HxSupperClass
public class BaseJobEntity extends AutoLongBaseEntity {
    @HxColumn(sort = 1)
    private Long parentTaskId;
    @HxColumn(sort = 2)
    private String processNo;
    @HxColumn(sort = 3)
    private String scanTypeName;
    @HxColumn(sort = 4)
    private String taskService;
    /**
     * 0:待启动任务,1:待处理,2:处理中,3:处理失败,4:处理成功
     */
    @HxColumn(sort = 5)
    private Integer status;
    @HxColumn(sort = 6)
    private Integer failCount;
    @HxColumn(sort = 7)
    private Date beginRunTime;
    @HxColumn(sort = 8)
    private Date startRunTime;
    @HxColumn(sort = 9)
    private Date endRunTime;
    @HxColumn(sort = 10)
    private String handleResult;

    public Long getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(Long parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo;
    }

    public String getScanTypeName() {
        return scanTypeName;
    }

    public void setScanTypeName(String scanTypeName) {
        this.scanTypeName = scanTypeName;
    }

    public String getTaskService() {
        return taskService;
    }

    public void setTaskService(String taskService) {
        this.taskService = taskService;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public Date getBeginRunTime() {
        return beginRunTime;
    }

    public void setBeginRunTime(Date beginRunTime) {
        this.beginRunTime = beginRunTime;
    }

    public Date getStartRunTime() {
        return startRunTime;
    }

    public void setStartRunTime(Date startRunTime) {
        this.startRunTime = startRunTime;
    }

    public Date getEndRunTime() {
        return endRunTime;
    }

    public void setEndRunTime(Date endRunTime) {
        this.endRunTime = endRunTime;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }
}
