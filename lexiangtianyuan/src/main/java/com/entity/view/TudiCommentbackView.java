package com.entity.view;

import com.entity.TudiCommentbackEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 土地评价
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("tudi_commentback")
public class TudiCommentbackView extends TudiCommentbackEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 tudi
			/**
			* 土地 的 农民
			*/
			private Integer tudiShangjiaId;
			/**
			* 土地名称
			*/
			private String tudiName;
			/**
			* 土地照片
			*/
			private String tudiPhoto;
			/**
			* 合同
			*/
			private String tudiFile;
			/**
			* 所在地址
			*/
			private String tudiAddress;
			/**
			* 土地类型
			*/
			private Integer tudiTypes;
				/**
				* 土地类型的值
				*/
				private String tudiValue;
			/**
			* 有无树
			*/
			private Integer tudiShumuTypes;
				/**
				* 有无树的值
				*/
				private String tudiShumuValue;
			/**
			* 土地状态
			*/
			private Integer tudiHaohuaiTypes;
				/**
				* 土地状态的值
				*/
				private String tudiHaohuaiValue;
			/**
			* 土地原价/月
			*/
			private Double tudiOldMoney;
			/**
			* 现价/月
			*/
			private Double tudiNewMoney;
			/**
			* 点击次数
			*/
			private Integer tudiClicknum;
			/**
			* 土地介绍
			*/
			private String tudiContent;
			/**
			* 是否租赁
			*/
			private Integer tudiZulinTypes;
				/**
				* 是否租赁的值
				*/
				private String tudiZulinValue;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer tudiDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;

	public TudiCommentbackView() {

	}

	public TudiCommentbackView(TudiCommentbackEntity tudiCommentbackEntity) {
		try {
			BeanUtils.copyProperties(this, tudiCommentbackEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
















				//级联表的get和set tudi
					/**
					* 获取：土地 的 农民
					*/
					public Integer getTudiShangjiaId() {
						return tudiShangjiaId;
					}
					/**
					* 设置：土地 的 农民
					*/
					public void setTudiShangjiaId(Integer tudiShangjiaId) {
						this.tudiShangjiaId = tudiShangjiaId;
					}

					/**
					* 获取： 土地名称
					*/
					public String getTudiName() {
						return tudiName;
					}
					/**
					* 设置： 土地名称
					*/
					public void setTudiName(String tudiName) {
						this.tudiName = tudiName;
					}
					/**
					* 获取： 土地照片
					*/
					public String getTudiPhoto() {
						return tudiPhoto;
					}
					/**
					* 设置： 土地照片
					*/
					public void setTudiPhoto(String tudiPhoto) {
						this.tudiPhoto = tudiPhoto;
					}
					/**
					* 获取： 合同
					*/
					public String getTudiFile() {
						return tudiFile;
					}
					/**
					* 设置： 合同
					*/
					public void setTudiFile(String tudiFile) {
						this.tudiFile = tudiFile;
					}
					/**
					* 获取： 所在地址
					*/
					public String getTudiAddress() {
						return tudiAddress;
					}
					/**
					* 设置： 所在地址
					*/
					public void setTudiAddress(String tudiAddress) {
						this.tudiAddress = tudiAddress;
					}
					/**
					* 获取： 土地类型
					*/
					public Integer getTudiTypes() {
						return tudiTypes;
					}
					/**
					* 设置： 土地类型
					*/
					public void setTudiTypes(Integer tudiTypes) {
						this.tudiTypes = tudiTypes;
					}


						/**
						* 获取： 土地类型的值
						*/
						public String getTudiValue() {
							return tudiValue;
						}
						/**
						* 设置： 土地类型的值
						*/
						public void setTudiValue(String tudiValue) {
							this.tudiValue = tudiValue;
						}
					/**
					* 获取： 有无树
					*/
					public Integer getTudiShumuTypes() {
						return tudiShumuTypes;
					}
					/**
					* 设置： 有无树
					*/
					public void setTudiShumuTypes(Integer tudiShumuTypes) {
						this.tudiShumuTypes = tudiShumuTypes;
					}


						/**
						* 获取： 有无树的值
						*/
						public String getTudiShumuValue() {
							return tudiShumuValue;
						}
						/**
						* 设置： 有无树的值
						*/
						public void setTudiShumuValue(String tudiShumuValue) {
							this.tudiShumuValue = tudiShumuValue;
						}
					/**
					* 获取： 土地状态
					*/
					public Integer getTudiHaohuaiTypes() {
						return tudiHaohuaiTypes;
					}
					/**
					* 设置： 土地状态
					*/
					public void setTudiHaohuaiTypes(Integer tudiHaohuaiTypes) {
						this.tudiHaohuaiTypes = tudiHaohuaiTypes;
					}


						/**
						* 获取： 土地状态的值
						*/
						public String getTudiHaohuaiValue() {
							return tudiHaohuaiValue;
						}
						/**
						* 设置： 土地状态的值
						*/
						public void setTudiHaohuaiValue(String tudiHaohuaiValue) {
							this.tudiHaohuaiValue = tudiHaohuaiValue;
						}
					/**
					* 获取： 土地原价/月
					*/
					public Double getTudiOldMoney() {
						return tudiOldMoney;
					}
					/**
					* 设置： 土地原价/月
					*/
					public void setTudiOldMoney(Double tudiOldMoney) {
						this.tudiOldMoney = tudiOldMoney;
					}
					/**
					* 获取： 现价/月
					*/
					public Double getTudiNewMoney() {
						return tudiNewMoney;
					}
					/**
					* 设置： 现价/月
					*/
					public void setTudiNewMoney(Double tudiNewMoney) {
						this.tudiNewMoney = tudiNewMoney;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getTudiClicknum() {
						return tudiClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setTudiClicknum(Integer tudiClicknum) {
						this.tudiClicknum = tudiClicknum;
					}
					/**
					* 获取： 土地介绍
					*/
					public String getTudiContent() {
						return tudiContent;
					}
					/**
					* 设置： 土地介绍
					*/
					public void setTudiContent(String tudiContent) {
						this.tudiContent = tudiContent;
					}
					/**
					* 获取： 是否租赁
					*/
					public Integer getTudiZulinTypes() {
						return tudiZulinTypes;
					}
					/**
					* 设置： 是否租赁
					*/
					public void setTudiZulinTypes(Integer tudiZulinTypes) {
						this.tudiZulinTypes = tudiZulinTypes;
					}


						/**
						* 获取： 是否租赁的值
						*/
						public String getTudiZulinValue() {
							return tudiZulinValue;
						}
						/**
						* 设置： 是否租赁的值
						*/
						public void setTudiZulinValue(String tudiZulinValue) {
							this.tudiZulinValue = tudiZulinValue;
						}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getTudiDelete() {
						return tudiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setTudiDelete(Integer tudiDelete) {
						this.tudiDelete = tudiDelete;
					}
















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}






}
