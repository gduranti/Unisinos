package br.unisinos.pf2.nltest.core.model;

import java.util.ArrayList;
import java.util.List;

public class ParameterSetData implements Parseable {

	private List<String> values;

	@Override
	public void init(String baseScript, String[] args) {
		values = new ArrayList<>();
		for (String arg : args) {
			values.add(arg.trim());
		}
	}

	public int indexOf(String value) {
		return values.indexOf(value);
	}

	public String get(int index) {
		return values.get(index);
	}

	@Override
	public String toString() {
		return values.toString();
	}

}
