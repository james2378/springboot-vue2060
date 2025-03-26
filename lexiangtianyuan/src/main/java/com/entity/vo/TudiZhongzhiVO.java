package com.entity.vo;

import com.entity.TudiZhongzhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 种植详情
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tudi_zhongzhi")
public class TudiZhongzhiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 土地订单
     */

    @TableField(value = "tudi_order_id")
    private Integer tudiOrderId;


    /**
     * 用户
     */

    @TableField(value = "shangjia_id")
    private Integer shangjiaId;


    /**
     * 标题
     */

    @TableField(value = "tudi_zhongzhi_name")
    private String tudiZhongzhiName;


    /**
     * 照片
     */

    @TableField(value = "tudi_zhongzhi_photo")
    private String tudiZhongzhiPhoto;


    /**
     * 视频
     */

    @TableField(value = "tudi_zhongzhi_video")
    private String tudiZhongzhiVideo;


    /**
     * 详情
     */

    @TableField(value = "tudi_zhongzhi_content")
    private String tudiZhongzhiContent;


    /**
     * 添加时间
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
	 * 设置：土地订单
	 */
    public Integer getTudiOrderId() {
        return tudiOrderId;
    }


    /**
	 * 获取：土地订单
	 */

    public void setTudiOrderId(Integer tudiOrderId) {
        this.tudiOrderId = tudiOrderId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 获取：用户
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 设置：标题
	 */
    public String getTudiZhongzhiName() {
        return tudiZhongzhiName;
    }


    /**
	 * 获取：标题
	 */

    public void setTudiZhongzhiName(String tudiZhongzhiName) {
        this.tudiZhongzhiName = tudiZhongzhiName;
    }
    /**
	 * 设置：照片
	 */
    public String getTudiZhongzhiPhoto() {
        return tudiZhongzhiPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setTudiZhongzhiPhoto(String tudiZhongzhiPhoto) {
        this.tudiZhongzhiPhoto = tudiZhongzhiPhoto;
    }
    /**
	 * 设置：视频
	 */
    public String getTudiZhongzhiVideo() {
        return tudiZhongzhiVideo;
    }


    /**
	 * 获取：视频
	 */

    public void setTudiZhongzhiVideo(String tudiZhongzhiVideo) {
        this.tudiZhongzhiVideo = tudiZhongzhiVideo;
    }
    /**
	 * 设置：详情
	 */
    public String getTudiZhongzhiContent() {
        return tudiZhongzhiContent;
    }


    /**
	 * 获取：详情
	 */

    public void setTudiZhongzhiContent(String tudiZhongzhiContent) {
        this.tudiZhongzhiContent = tudiZhongzhiContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
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
