package org.midstr.enumeration;

public enum Notebook {

	IBM("intel") {
		@Override
		void printDetail() {
			System.out.println("This is ibm....");
		}
	},
	HP("amd") {
		@Override
		void printDetail() {
			System.out.println("This is hp....");
		}
	},
	LENEVO() {
		@Override
		void printDetail() {
			System.out.println("This is lenevo....");
		}
	},

	BNEQ() {
		@Override
		void printDetail() {
			throw new UnsupportedOperationException("not implement");
		}
	};

	private Notebook() {
	}

	private Notebook(String chip) {
		this.chip = chip;
	}

	private String chip;

	abstract void printDetail();

	public String getChip() {
		return chip;
	}
	
	public static void main(String[] args) {
		//Notebook.BNEQ.printDetail();
		System.out.println(Notebook.IBM.getChip());
	}

}
