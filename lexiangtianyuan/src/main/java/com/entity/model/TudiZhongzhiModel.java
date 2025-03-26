package com.entity.model;

import com.entity.TudiZhongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 种植详情
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TudiZhongzhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 土地订单
     */
    private Integer tudiOrderId;


    /**
     * 用户
     */
    private Integer shangjiaId;


    /**
     * 标题
     */
    private String tudiZhongzhiName;


    /**
     * 照片
     */
    private String tudiZhongzhiPhoto;


    /**
     * 视频
     */
    private String tudiZhongzhiVideo;


    /**
     * 详情
     */
    private String tudiZhongzhiContent;


    /**
     * 添加时间
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
	 * 获取：土地订单
	 */
    public Integer getTudiOrderId() {
        return tudiOrderId;
    }


    /**
	 * 设置：土地订单
	 */
    public void setTudiOrderId(Integer tudiOrderId) {
        this.tudiOrderId = tudiOrderId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 设置：用户
	 */
    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 获取：标题
	 */
    public String getTudiZhongzhiName() {
        return tudiZhongzhiName;
    }


    /**
	 * 设置：标题
	 */
    public void setTudiZhongzhiName(String tudiZhongzhiName) {
        this.tudiZhongzhiName = tudiZhongzhiName;
    }
    /**
	 * 获取：照片
	 */
    public String getTudiZhongzhiPhoto() {
        return tudiZhongzhiPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setTudiZhongzhiPhoto(String tudiZhongzhiPhoto) {
        this.tudiZhongzhiPhoto = tudiZhongzhiPhoto;
    }
    /**
	 * 获取：视频
	 */
    public String getTudiZhongzhiVideo() {
        return tudiZhongzhiVideo;
    }


    /**
	 * 设置：视频
	 */
    public void setTudiZhongzhiVideo(String tudiZhongzhiVideo) {
        this.tudiZhongzhiVideo = tudiZhongzhiVideo;
    }
    /**
	 * 获取：详情
	 */
    public String getTudiZhongzhiContent() {
        return tudiZhongzhiContent;
    }


    /**
	 * 设置：详情
	 */
    public void setTudiZhongzhiContent(String tudiZhongzhiContent) {
        this.tudiZhongzhiContent = tudiZhongzhiContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
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
