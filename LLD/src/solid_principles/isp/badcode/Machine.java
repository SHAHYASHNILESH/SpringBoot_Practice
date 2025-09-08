package solid_principles.isp.badcode;

//Monolithic Machine interface
interface Machine {
	void print(Document doc);

	void scan(Document doc);

	void copy(Document doc);
}