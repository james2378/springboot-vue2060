package com.entity.model;

import com.entity.ShangjiajianyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农民建议
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShangjiajianyiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 农民
     */
    private Integer shangjiaId;


    /**
     * 建议标题
     */
    private String shangjiajianyiName;


    /**
     * 建议详情
     */
    private String shangjiajianyiContent;


    /**
     * 建议时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：农民
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 设置：农民
	 */
    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 获取：建议标题
	 */
    public String getShangjiajianyiName() {
        return shangjiajianyiName;
    }


    /**
	 * 设置：建议标题
	 */
    public void setShangjiajianyiName(String shangjiajianyiName) {
        this.shangjiajianyiName = shangjiajianyiName;
    }
    /**
	 * 获取：建议详情
	 */
    public String getShangjiajianyiContent() {
        return shangjiajianyiContent;
    }


    /**
	 * 设置：建议详情
	 */
    public void setShangjiajianyiContent(String shangjiajianyiContent) {
        this.shangjiajianyiContent = shangjiajianyiContent;
    }
    /**
	 * 获取：建议时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：建议时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
