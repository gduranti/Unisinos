package br.unisinos.pf2.nltest.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.unisinos.pf2.nltest.executor.ExecutionContext;
import br.unisinos.pf2.nltest.model.Command;

public class FillInputFieldCommand extends Command {

	@Override
	public void execute(ExecutionContext ctx) {

		System.out.println("Executing command fill input.");

		String id = getParameterValue(0);
		WebElement field = ctx.getDriver().findElement(By.id(id));

		String keysToSend = getParameterValue(1);
		field.sendKeys(keysToSend);

	}

}
