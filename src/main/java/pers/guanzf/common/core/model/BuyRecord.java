package pers.guanzf.common.core.model;

public class BuyRecord {
	/*
	 * <th>商品名称</th> <th>商品类型</th> <th>商品价格</th> <th>购买时间</th>
	 */
	private String produceName;

	private String produceType;

	private String producePrice;

	private String buyTime;

	public String getProduceName() {
		return produceName;
	}

	public void setProduceName(String produceName) {
		this.produceName = produceName;
	}

	public String getProduceType() {
		return produceType;
	}

	public void setProduceType(String produceType) {
		this.produceType = produceType;
	}

	public String getProducePrice() {
		return producePrice;
	}

	public void setProducePrice(String producePrice) {
		this.producePrice = producePrice;
	}

	public String getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

}
