/*
	Copyright 2017 Marceau Dewilde <m@ceau.be>

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package be.ceau.chart.options.scales;

import be.ceau.chart.options.ticks.Ticks;

import java.math.BigDecimal;

public class XAxis<T extends Ticks<T>> {

	/**
	 * @see #setTicks(T)
	 */
	private T ticks;

	/**
	 * Default {@code "Category"}
	 * 
	 * @see #setType(String type)
	 */
	private String type;

	/**
	 * Default {@code true}
	 * 
	 * @see #setDisplay(Boolean display)
	 */
	private Boolean display;

	/**
	 * Default {@code "x-axis-0"}
	 * 
	 * @see #setId(String id)
	 */
	private String id;

	/**
	 * Default {@code false}
	 * 
	 * @see #setStacked(Boolean stacked)
	 */
	private Boolean stacked;

	/**
	 * Default {@code 0.8}
	 * 
	 * @see #setCategoryPercentage(BigDecimal categoryPercentage)
	 */
	private BigDecimal categoryPercentage;

	/**
	 * Default {@code 0.9}
	 * 
	 * @see #setBarPercentage(BigDecimal barPercentage)
	 */
	private BigDecimal barPercentage;

	/**
	 * Default {@code offsetGridLines == true}
	 * 
	 * @see #setGridLines(GridLines gridLines)
	 */
	private GridLines gridLines;

	/**
//	 * @see #setTicks(T)
	 */
	public T getTicks() {
		return ticks;
	}

	/**
	 * Defines options for the tick marks that are generated by the axis
	 */
	public XAxis<T> setTicks(T ticks) {
		this.ticks = ticks;
		return this;
	}

	/**
	 * @see #setType(String type)
	 */
	public String getType() {
		return type;
	}

	/**
	 * As defined in Scales.
	 */
	public XAxis<T> setType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * @see #setDisplay(Boolean display)
	 */
	public Boolean getDisplay() {
		return display;
	}

	/**
	 * If true, show the scale.
	 */
	public XAxis<T> setDisplay(Boolean display) {
		this.display = display;
		return this;
	}

	/**
	 * @see #setId(String id)
	 */
	public String getId() {
		return id;
	}

	/**
	 * Id of the axis so that data can bind to it
	 */
	public XAxis<T> setId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * @see #setStacked(Boolean stacked)
	 */
	public Boolean getStacked() {
		return stacked;
	}

	/**
	 * If true, bars are stacked on the x-axis
	 */
	public XAxis<T> setStacked(Boolean stacked) {
		this.stacked = stacked;
		return this;
	}

	/**
	 * @see #setCategoryPercentage(BigDecimal categoryPercentage)
	 */
	public BigDecimal getCategoryPercentage() {
		return categoryPercentage;
	}

	/**
	 * Percent (0-1) of the available width (the space between the gridlines for
	 * small datasets) for each data-point to use for the bars. Read More
	 */
	public XAxis<T> setCategoryPercentage(BigDecimal categoryPercentage) {
		this.categoryPercentage = categoryPercentage;
		return this;
	}

	/**
	 * @see #setBarPercentage(BigDecimal barPercentage)
	 */
	public BigDecimal getBarPercentage() {
		return barPercentage;
	}

	/**
	 * Percent (0-1) of the available width each bar should be within the
	 * category percentage. 1.0 will take the whole category width and put the
	 * bars right next to each other. Read More
	 */
	public XAxis<T> setBarPercentage(BigDecimal barPercentage) {
		this.barPercentage = barPercentage;
		return this;
	}

	/**
	 * @see #setGridLines(GridLines gridLines)
	 */
	public GridLines getGridLines() {
		return gridLines;
	}

	/**
	 * 
	 */
	public XAxis<T> setGridLines(GridLines gridLines) {
		this.gridLines = gridLines;
		return this;
	}

}
