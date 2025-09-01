package design_patterns.creational.builder;

public class House {

	private String foundation;
	private String structure;
	private String roof;
	private boolean hasGarage;
	private boolean hasGarden;
	private boolean hasSwimmingPool;

	private House(HouseBuilder builder) {
		this.foundation = builder.foundation;
		this.structure = builder.structure;
		this.roof = builder.roof;
		this.hasGarage = builder.hasGarage;
		this.hasGarden = builder.hasGarden;
		this.hasSwimmingPool = builder.hasSwimmingPool;
	}

	@Override
	public String toString() {
		return "House [foundation=" + foundation + ", structure=" + structure + ", roof=" + roof + ", hasGarage="
				+ hasGarage + ", hasGarden=" + hasGarden + ", hasSwimmingPool=" + hasSwimmingPool + "]";
	}

	public static class HouseBuilder {
		private String foundation;
		private String structure;
		private String roof;
		private boolean hasGarage;
		private boolean hasGarden;
		private boolean hasSwimmingPool;

		public HouseBuilder(String foundation, String structure, String roof) {
			this.foundation = foundation;
			this.structure = structure;
			this.roof = roof;
		}

		public HouseBuilder setGarage(boolean hasGarage) {
			this.hasGarage = hasGarage;
			return this;
		}

		public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
			this.hasSwimmingPool = hasSwimmingPool;
			return this;
		}

		public HouseBuilder setGarden(boolean hasGarden) {
			this.hasGarden = hasGarden;
			return this;
		}

		public House build() {
			return new House(this);
		}
	}
}
