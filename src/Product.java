public class Product {

	private String name, imagePath, description;
	private final float price;
	private float salesPrice;
	private boolean isSelect;

	public Product(String name, String imagePath, String description, int price) {
		this.name = name;
		this.imagePath = imagePath;
		this.description = description;
		this.price = price;
		this.salesPrice = this.price;
		this.isSelect = false;
	}

	/**
	 * method which apply a reduction in percent to the actual price of the product.
	 *
	 * @param reduction the reduction to apply.
	 * @return the new price of the product, the original price if the product is not selected for the reduction.
	 */
	public float updateReduction(float reduction) {
		if (this.isSelect)
			this.salesPrice = this.salesPrice * reduction;
		return this.salesPrice;
	}

	/**
	 * method which apply a reduction to the original price of the product
	 *
	 * @param reduction the reduction to apply
	 * @return the new price of the product, the original price if the product is not selected for the reduction.
	 */
	public float setReduction(float reduction) {
		if (this.isSelect)
			this.salesPrice = this.price * reduction;
		return this.salesPrice;
	}

	/**
	 * return if the product is already in sales or not
	 *
	 * @return if the product is already in sales or not
	 */
	public boolean isInSales() {
		return this.price != this.salesPrice;
	}

	public void reinitPrice() {
		this.salesPrice = this.price;
	}
}
