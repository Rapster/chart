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
package be.ceau.chart;

import be.ceau.chart.color.Color;
import be.ceau.chart.data.BarData;
import be.ceau.chart.data.Data;
import be.ceau.chart.dataset.BarDataset;
import be.ceau.chart.enums.*;
import be.ceau.chart.gson.GSON;
import be.ceau.chart.options.BarOptions;
import be.ceau.chart.options.Legend;
import be.ceau.chart.options.Options;
import be.ceau.chart.options.scales.XAxis;
import be.ceau.chart.options.scales.YAxis;
import be.ceau.chart.options.ticks.LinearTicks;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BarChart implements Chart {

	/**
	 * Static factory, constructs an {@link Data} implementation appropriate for
	 * a {@link BarChart}.
	 * 
	 * @return a new {@link BarData} instance
	 */
	public static BarData data() {
		return new BarData();
	}

	/**
	 * Static factory, constructs an {@link Options} implementation appropriate
	 * for a {@link BarChart}.
	 * 
	 * @return a new {@link BarOptions} instance
	 */
	public static BarOptions options() {
		return new BarOptions();
	}

	@Expose(serialize = false, deserialize = false)
	private boolean vertical = true;

	private BarData data;

	private BarOptions options;

	public BarChart() {
	}

	public BarChart(BarData data) {
		this.data = data;
	}

	public BarChart(BarData data, BarOptions options) {
		this.data = data;
		this.options = options;
	}

	public BarData getData() {
		return data;
	}

	public BarChart setData(BarData data) {
		this.data = data;
		return this;
	}

	public BarOptions getOptions() {
		return options;
	}

	public BarChart setOptions(BarOptions options) {
		this.options = options;
		return this;
	}

	/**
	 * <p>
	 * Draw this {@code BarChart} horizontally.
	 * </p>
	 * <p>
	 * Default is to draw a vertical {@code BarChart}.
	 * </p>
	 * 
	 * @return this {@link BarChart} for method chaining
	 * @see #setVertical()
	 */
	public BarChart setHorizontal() {
		vertical = false;
		return this;
	}

	/**
	 * @return true if this {@code BarChart} is set to be drawn horizontally
	 * @see #setHorizontal()
	 */
	public boolean isHorizontal() {
		return !vertical;
	}

	/**
	 * <p>
	 * Draw this {@code BarChart} vertically.
	 * </p>
	 * <p>
	 * Vertical drawing is the default for {@code BarChart}.
	 * </p>
	 * 
	 * @return this {@link BarChart} for method chaining
	 * @see #setHorizontal()
	 */
	public BarChart setVertical() {
		vertical = true;
		return this;
	}

	/**
	 * @return true if this {@code BarChart} is set to be drawn vertically
	 * @see #setVertical()
	 */
	public boolean isVertical() {
		return vertical;
	}

	@Override
	@SerializedName("type")
	public String getType() {
		return vertical ? "bar" : "horizontalBar";
	}

	@Override
	public String toJson() {
		return GSON.INSTANCE.toJson(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * A {@code BarChart} is drawable if:
	 * </p>
	 * <ul>
	 * <li>at least one dataset has at least one data point
	 * <li>an xAxis scale exists with the id of the xAxisID set on a dataset, if
	 * such an id set
	 * <li>a yAxis scale exists with the id of the yAxisID set on a dataset, if
	 * such an id is set
	 * <li>there is at least one label in the {@link BarData}
	 * </ul>
	 * 
	 * @return true if this {@link BarChart} is drawable in its current state
	 */
	@Override
	public boolean isDrawable() {
		if (data.getLabels().isEmpty()) {
			return false;
		}
		boolean sufficientData = false;
		for (BarDataset dataset : data.getDatasets()) {
			if (dataset.getXAxisID() != null && !hasXAxisWithId(dataset.getXAxisID())) {
				return false;
			}
			if (dataset.getYAxisID() != null && !hasYAxisWithId(dataset.getYAxisID())) {
				return false;
			}
			if (dataset.getData().size() > 0) {
				sufficientData = true;
			}
		}
		return sufficientData;
	}

	private boolean hasXAxisWithId(String id) {
		if (options != null && options.getScales() != null && options.getScales().getxAxes() != null) {
			for (XAxis<LinearTicks> xAxis : options.getScales().getxAxes()) {
				if (id.equals(xAxis.getId())) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean hasYAxisWithId(String id) {
		if (options != null && options.getScales() != null && options.getScales().getyAxes() != null) {
			for (YAxis<LinearTicks> yAxis : options.getScales().getyAxes()) {
				if (id.equals(yAxis.getId())) {
					return true;
				}
			}
		}
		return false;
	}

}
