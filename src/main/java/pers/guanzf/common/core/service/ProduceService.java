package pers.guanzf.common.core.service;

import java.util.List;

import org.eclipse.jdt.internal.compiler.apt.dispatch.ProcessorInfo;

import pers.guanzf.common.core.model.Comment;
import pers.guanzf.common.core.model.info.CommodityStructrueInfo;
import pers.guanzf.common.core.model.info.ProduceInfo;

public interface ProduceService {

	/**
	 * @return 全部商品信息
	 */
	public List<ProduceInfo> listProduce();
	
	/**
	 * @param produceId 主键
	 * @return 具体商品详细信息
	 */
	public ProduceInfo getProduceInfo(String produceId);
	
	/**
	 * @param produceId 主键
	 * @return 根据主键删除商品信息
	 */
	public int deleteProduceInfo(String produceId);
	
	/**
	 * 插入产品信息
	 */
	public int insertProduceInfo(ProduceInfo produce);
	
	public int updateProduceInfo(ProduceInfo produce);
	
	public List<ProduceInfo> listFriendRecommendData(String userId, String num);
	
	public List<CommodityStructrueInfo> listCommodityStructrueInfos(String commodityStructrueFartherId);
	
	List<CommodityStructrueInfo> listCommodityStructrueByFloor(String floor);
	
	List<ProduceInfo> listProduceInfoByUserId(String userId);
	
	List<ProduceInfo> listProduceAtTodayNum();
	
	List<Comment> listCommentInfo(String produceId);
	
	List<ProduceInfo> getProduceInfoByName(String produceName);
	
	List<ProduceInfo> getproduceInfoByFriend(String personId, String produceType);
	
	List<ProduceInfo> getGoods(String produceType);
	
	List<ProduceInfo> getShangJia(String produceType);
	
}
