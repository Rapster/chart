package be.ceau.chart.tests;

import be.ceau.chart.BarChart;
import be.ceau.chart.gson.GSON;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

public class DeserializeTest {

	@Test
	public void deserialize() {
		try {

			Scanner scanner = new Scanner(getClass().getResource("/chart.json").openStream());
			String text = scanner.useDelimiter("\\A").next();
			scanner.close();


			BarChart barChart = GSON.INSTANCE.fromJson(text, BarChart.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
