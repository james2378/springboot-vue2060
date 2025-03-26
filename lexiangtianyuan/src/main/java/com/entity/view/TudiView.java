package com.entity.view;

import com.entity.TudiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 土地
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("tudi")
public class TudiView extends TudiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 土地类型的值
		*/
		private String tudiValue;
		/**
		* 有无树的值
		*/
		private String tudiShumuValue;
		/**
		* 土地状态的值
		*/
		private String tudiHaohuaiValue;
		/**
		* 是否租赁的值
		*/
		private String tudiZulinValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



		//级联表 shangjia
			/**
			* 农民名称
			*/
			private String shangjiaName;
			/**
			* 联系方式
			*/
			private String shangjiaPhone;
			/**
			* 邮箱
			*/
			private String shangjiaEmail;
			/**
			* 头像
			*/
			private String shangjiaPhoto;
			/**
			* 农民信用类型
			*/
			private Integer shangjiaXingjiTypes;
				/**
				* 农民信用类型的值
				*/
				private String shangjiaXingjiValue;
			/**
			* 现有余额
			*/
			private Double newMoney;
			/**
			* 农民介绍
			*/
			private String shangjiaContent;
			/**
			* 逻辑删除
			*/
			private Integer shangjiaDelete;

	public TudiView() {

	}

	public TudiView(TudiEntity tudiEntity) {
		try {
			BeanUtils.copyProperties(this, tudiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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






				//级联表的get和set shangjia
					/**
					* 获取： 农民名称
					*/
					public String getShangjiaName() {
						return shangjiaName;
					}
					/**
					* 设置： 农民名称
					*/
					public void setShangjiaName(String shangjiaName) {
						this.shangjiaName = shangjiaName;
					}
					/**
					* 获取： 联系方式
					*/
					public String getShangjiaPhone() {
						return shangjiaPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setShangjiaPhone(String shangjiaPhone) {
						this.shangjiaPhone = shangjiaPhone;
					}
					/**
					* 获取： 邮箱
					*/
					public String getShangjiaEmail() {
						return shangjiaEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setShangjiaEmail(String shangjiaEmail) {
						this.shangjiaEmail = shangjiaEmail;
					}
					/**
					* 获取： 头像
					*/
					public String getShangjiaPhoto() {
						return shangjiaPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setShangjiaPhoto(String shangjiaPhoto) {
						this.shangjiaPhoto = shangjiaPhoto;
					}
					/**
					* 获取： 农民信用类型
					*/
					public Integer getShangjiaXingjiTypes() {
						return shangjiaXingjiTypes;
					}
					/**
					* 设置： 农民信用类型
					*/
					public void setShangjiaXingjiTypes(Integer shangjiaXingjiTypes) {
						this.shangjiaXingjiTypes = shangjiaXingjiTypes;
					}


						/**
						* 获取： 农民信用类型的值
						*/
						public String getShangjiaXingjiValue() {
							return shangjiaXingjiValue;
						}
						/**
						* 设置： 农民信用类型的值
						*/
						public void setShangjiaXingjiValue(String shangjiaXingjiValue) {
							this.shangjiaXingjiValue = shangjiaXingjiValue;
						}
					/**
					* 获取： 现有余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 现有余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 农民介绍
					*/
					public String getShangjiaContent() {
						return shangjiaContent;
					}
					/**
					* 设置： 农民介绍
					*/
					public void setShangjiaContent(String shangjiaContent) {
						this.shangjiaContent = shangjiaContent;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getShangjiaDelete() {
						return shangjiaDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShangjiaDelete(Integer shangjiaDelete) {
						this.shangjiaDelete = shangjiaDelete;
					}


















}
