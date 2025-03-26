package com.entity.vo;

import com.entity.ShangjiajianyiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农民建议
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shangjiajianyi")
public class ShangjiajianyiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 农民
     */

    @TableField(value = "shangjia_id")
    private Integer shangjiaId;


    /**
     * 建议标题
     */

    @TableField(value = "shangjiajianyi_name")
    private String shangjiajianyiName;


    /**
     * 建议详情
     */

    @TableField(value = "shangjiajianyi_content")
    private String shangjiajianyiContent;


    /**
     * 建议时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：农民
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 获取：农民
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 设置：建议标题
	 */
    public String getShangjiajianyiName() {
        return shangjiajianyiName;
    }


    /**
	 * 获取：建议标题
	 */

    public void setShangjiajianyiName(String shangjiajianyiName) {
        this.shangjiajianyiName = shangjiajianyiName;
    }
    /**
	 * 设置：建议详情
	 */
    public String getShangjiajianyiContent() {
        return shangjiajianyiContent;
    }


    /**
	 * 获取：建议详情
	 */

    public void setShangjiajianyiContent(String shangjiajianyiContent) {
        this.shangjiajianyiContent = shangjiajianyiContent;
    }
    /**
	 * 设置：建议时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：建议时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
