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
package be.ceau.chart.javascript;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class JavaScriptFunction {

	private final String function;

	public JavaScriptFunction(String function) {
		this.function = function;
	}

	public String getFunction() {
		return function;
	}

	public static class JavaScriptFunctionSerializer implements JsonSerializer<JavaScriptFunction> {

		@Override
		public JsonElement serialize(JavaScriptFunction src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(src.function);
		}
	}
}
