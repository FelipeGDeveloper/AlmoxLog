package com.felipegoncalves.almoxlog.entities.enums;

public enum EntidadeStatus {

	ATIVO(1), INATIVO(0);

	private int code;

	private EntidadeStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static EntidadeStatus valueOf(int code) {
		for (EntidadeStatus value : EntidadeStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}

		throw new IllegalArgumentException("Invalid OrderStatus code");
	}

}
