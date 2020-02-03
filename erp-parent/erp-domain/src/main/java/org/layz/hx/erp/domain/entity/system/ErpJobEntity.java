package org.layz.hx.erp.domain.entity.system;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.annotation.HxTable;
import org.layz.hx.core.entity.BaseJobEntity;
@HxTable("sys_job")
public class ErpJobEntity extends BaseJobEntity {
    @HxColumn(sort = 11)
    private String ext1;
    @HxColumn(sort = 12)
    private String ext2;
    @HxColumn(sort = 13)
    private String ext3;

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }
}
