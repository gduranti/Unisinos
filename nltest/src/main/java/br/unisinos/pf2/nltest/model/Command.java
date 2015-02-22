package br.unisinos.pf2.nltest.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.runner.Description;

public abstract class Command implements Executable {

	private Description description;
	private List<String> simpleParameters;
	private Map<String, String> parametersSetMap;

	@Override
	public void init(String... args) {
		description = Description.createTestDescription(getClass(), getClass().getCanonicalName() + " " + args);
		simpleParameters = Arrays.asList(args);
	}

	@Override
	public Description getDescription() {
		return description;
	}

	// TODO Lancar exception quando nao achar o parametro
	protected String getParameterValue(int index) {
		String value = simpleParameters.get(index);

		if (isVariableParameter(value)) {
			value = StringUtils.removeStart(value, "<");
			value = StringUtils.removeEnd(value, ">");
			value = parametersSetMap.get(value);
		}

		return value;
	}

	private boolean isVariableParameter(String value) {
		return value.startsWith("<") && value.endsWith(">");
	}

	public Command copyWith(ParameterSet parameterSet) {
		try {
			Command copiedCommand = this.getClass().newInstance();
			copiedCommand.simpleParameters = new ArrayList<>(this.simpleParameters);
			copiedCommand.parametersSetMap = parameterSet.toMap();
			return copiedCommand;
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO
			throw new RuntimeException("Erro ao copiar", e);
		}
	}

}
